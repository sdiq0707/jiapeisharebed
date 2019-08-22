package com.woniu.util.page;

public class MysqlDialect implements Dialect{

	@Override
	public String getLimitString(String sql, int offset, int limit) {
		// TODO Auto-generated method stub
		String pageSql = sql +" limit "+offset+","+limit;
		return pageSql;
	}

}
