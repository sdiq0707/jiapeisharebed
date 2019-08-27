package com.woniu.entity;

public class PageBean {


	private Integer offset;//从哪里开始
	private Integer limit=10;//取几条数据
	private Integer pageNow=1;//当前页
	private Integer count;//总记录数
	private Integer pageCount;//总页数
	//用来支持easyui分页
	private Integer page;
	private Integer rows;
	
	
	
	public final Integer getPage() {
		return pageNow;
	}
	public final void setPage(Integer page) {
		this.pageNow = page;
	}
	public final Integer getRows() {
		return limit;
	}
	public final void setRows(Integer rows) {
		this.limit = rows;
	}
	
	
	public Integer getOffset() {
		return (pageNow-1)*limit;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public Integer getPageNow() {
		return pageNow;
	}
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Integer getPageCount() {
		return (count+limit-1)/limit;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
}
