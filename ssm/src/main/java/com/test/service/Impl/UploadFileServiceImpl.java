package com.test.service.Impl;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;
import javax.imageio.ImageIO;

import com.test.service.base.BaseService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.test.bean.PersonInfoBean;
import com.test.service.PersonInfoService;
import com.test.service.UploadFileService;

@Service("uplaodFileService")
public class UploadFileServiceImpl extends BaseService implements UploadFileService {

	@Resource
	private PersonInfoService personInfoService;
	
	@SuppressWarnings("resource")
	@Override
	public int uploadImagFile(PersonInfoBean personInfo, String fileName, String savePath) {
		MultipartFile file=personInfo.getFile();
		String message = "";// 返回的消息
		String existType = "";// 已经存在的文件的类型
		Long newName;
		String newName1 = "";
		if (file != null||(!"".equals(file))) {
			if (fileName != null || (!"".equals(fileName))) {
				long size = file.getSize();
				if (size > (1024 * 1024)) {		
					message = "只运行上传1M之内的图片";
					return 1;
				}
				if (fileName.lastIndexOf(".") >= 0) {
					existType = fileName.substring(fileName.lastIndexOf("."));
				}
				if (!getFileType().contains(existType.toLowerCase())) {
					message = "只允许上传jpg,jpeg,gif,png格式的图片";
					return 2;
				}
				DateFormat dateF = new SimpleDateFormat("yyyy-MM-dd");
				Calendar calendar = Calendar.getInstance();
				newName1=dateF.format(calendar.getTime());
				newName = calendar.getTimeInMillis();
				File newFile = new File(savePath+File.separator+newName1);
				if (!newFile.exists()) {
					newFile.mkdirs();
				}
				try {
					InputStream is = file.getInputStream();
					OutputStream os = new FileOutputStream(savePath+File.separator+newName1+File.separator+newName+existType);
				
					BufferedInputStream bis=new BufferedInputStream(is);  
					BufferedOutputStream bos = new BufferedOutputStream(os);
					int ch = 0;
					while ((ch = bis.read()) != -1) // 通过字节流的缓冲区完成复制
					{
						bos.write(ch);
					} 	
					if(is!=null){
						is.close();
					}
					if(os!=null){
						os.close();
					}
					if(bis!=null){
						bis.close();
					}
					if(bos!=null){
						bos.close();
					}
					System.out.println("上传成功");
					message="上传成功";
					personInfo.setHead("static"+File.separator+"upload"+File.separator+"Img"+File.separator+newName1+File.separator+newName+existType);
					personInfoService.updatepersonHead(personInfo);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return 3;
	}

	@Override
	public void imgCut(String srcImageFile, int x, int y, int desWidth, int desHeight) {
		try {
			Image img;
			ImageFilter cropFilter;
			BufferedImage bi = ImageIO.read(new File(srcImageFile + "_src.jpg"));
			int srcWidth = bi.getWidth();
			int srcHeight = bi.getHeight();
			if (srcWidth >= desWidth && srcHeight >= desHeight) {
				Image image = bi.getScaledInstance(srcWidth, srcHeight, Image.SCALE_DEFAULT);
				cropFilter = new CropImageFilter(x, y, desWidth, desHeight);
				img = Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(image.getSource(), cropFilter));
				BufferedImage tag = new BufferedImage(desWidth, desHeight, BufferedImage.TYPE_INT_RGB);
				Graphics g = tag.getGraphics();
				g.drawImage(img, 0, 0, null);
				g.dispose();
				// 输出文件
				ImageIO.write(tag, "JPEG", new File(srcImageFile + "_cut.jpg"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private List<String> getFileType() {
		List<String> fileType = new ArrayList<String>();
		fileType.add(".jpg");
		fileType.add(".jpeg");
		fileType.add(".gif");
		fileType.add(".png");
		return fileType;
	}

}
