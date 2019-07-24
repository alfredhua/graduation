package com.test.service.Impl;

import com.test.service.ExportDailyService;
import com.test.service.base.BaseService;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

@Service("exportDailyService")
public class ExportDailyServiceImpl  extends BaseService implements ExportDailyService{

	@Override
	public void downExcel(List<Map<String, Object>> list,String path) {
		// 第一步，创建一个webbook，对应一个Excel文件  
        HSSFWorkbook wb = new HSSFWorkbook();  
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
        HSSFSheet sheet = wb.createSheet("日报");  
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short  
        HSSFRow row = sheet.createRow((int) 0);  
        // 第四步，创建单元格，并设置值表头 设置表头居中  
        HSSFCellStyle style = wb.createCellStyle();  
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式  
        
        HSSFCell cell = row.createCell((short)0);
        cell.setCellValue("日报时间");  
        cell.setCellStyle(style);  
        
        cell = row.createCell((short) 1);  
        cell.setCellValue("工作内容");  
        cell.setCellStyle(style);  
        
        cell = row.createCell((short) 2);  
        cell.setCellValue("工作地点");  
        cell.setCellStyle(style);  
        
        cell = row.createCell((short) 3);  
        cell.setCellValue("工作时长");  
        cell.setCellStyle(style);
        
        cell = row.createCell((short) 4);  
        cell.setCellValue("加班内容");  
        cell.setCellStyle(style); 
        
        cell = row.createCell((short) 5);  
        cell.setCellValue("加班时长");  
        cell.setCellStyle(style); 
        // 第五步，写入实体数据 实际应用中这些数据从数据库得到，   
        for (int i = 0; i < list.size(); i++)  
        {  
            row = sheet.createRow((int) i + 1);  
            Map<String, Object> map = list.get(i);  
            // 第四步，创建单元格，并设置值  
            cell = row.createCell((short) 0);  
            cell.setCellValue(map.get("workDate").toString());  
            row.createCell((short) 1).setCellValue(map.get("dailyContext").toString());  
            String workSite = map.get("workSite").toString();
            if("1".equals(workSite)){
            	workSite="公司办公";
            } 
            if("2".equals(workSite)){
            	workSite="本地驻场";
            }
            if("3".equals(workSite)){
            	workSite="出差驻场";
            }
            row.createCell((short) 2).setCellValue(workSite);  
            row.createCell((short) 3).setCellValue(map.get("workTime").toString());  
            row.createCell((short) 4).setCellValue(map.get("overWorkContext").toString());  
            row.createCell((short) 5).setCellValue(map.get("overTime").toString()); 
         
        }  
        // 第六步，将文件存到指定位置  
        try  
        {  
            FileOutputStream fout = new FileOutputStream(path);  
            wb.write(fout);  
            fout.close();  
        }  
        catch (Exception e)  
        {  
            e.printStackTrace();  
        }  
    }  
}
