package com.woniu.util.page;

public interface Dialect {
	public String getLimitString(String sql,int offset,int limit);
}
