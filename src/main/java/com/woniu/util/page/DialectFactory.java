package com.woniu.util.page;

import ch.qos.logback.core.db.dialect.OracleDialect;

public class DialectFactory {
	public static Dialect getInstance(String type) {
		Dialect dialect = null;
		if("mysql".equalsIgnoreCase(type)) {
			dialect = new MysqlDialect();
		}else if("oracle".equalsIgnoreCase(type)) {
			dialect = (Dialect) new OracleDialect();
		}
		return dialect;
	}
}
