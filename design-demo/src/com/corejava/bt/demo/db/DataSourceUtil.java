package com.corejava.bt.demo.db;

import javax.sql.DataSource;


/**
 * Author : Rakesh Jena
 * Email : rakeshkumar.jena91@yahoo.com
 * 
 * 
 * **/

public class DataSourceUtil {
	
	private static DataSourceUtil dataSourceUtilobj = null;
	private ConnectionPool jdbcObj = new ConnectionPool();
	
	public static DataSourceUtil getInstance() {
		if(dataSourceUtilobj != null) {
			return dataSourceUtilobj;
		} else {
			return new DataSourceUtil();
		}
	}
	
	//setup the connection pool
	public DataSource getPoolDataSource() {
		DataSource dataSource = null;
		try {
			dataSource = jdbcObj.setUpPool();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataSource;
	}
	
	//print DB status
	public void printDbStatus() {
		jdbcObj.printDbStatus();
	}
	
	
}
