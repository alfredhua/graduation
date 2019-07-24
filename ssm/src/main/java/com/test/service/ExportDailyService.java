package com.test.service;

import java.util.List;
import java.util.Map;

public interface ExportDailyService {

	public void downExcel(List<Map<String, Object>> list,String path);
	
}
