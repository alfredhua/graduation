package com.test.service;

import com.test.bean.PersonInfoBean;

public interface UploadFileService {

	public int uploadImagFile(PersonInfoBean personInf,String name,String path);
	
	public  void imgCut(String srcImageFile, int x, int y, int desWidth, int desHeight); 
}
