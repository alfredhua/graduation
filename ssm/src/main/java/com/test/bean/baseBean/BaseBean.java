package com.test.bean.baseBean;

public class BaseBean {
	

	private String message;//返回的消息
	private Integer pageNo;//页面的
	private Integer pageSize;//页面大小
	private Integer pageRecordCount;
	private Integer total;//分页的总条数
	
	private Integer currentPage;//当前页
	
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageRecordCount() {
		return pageRecordCount;
	}
	public void setPageRecordCount(Integer pageRecordCount) {
		this.pageRecordCount = pageRecordCount;
	}
	
	
}
