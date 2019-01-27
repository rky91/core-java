package com.corejava.bt.demo.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 * Author : Rakesh Jena
 * Email : rakeshkumar.jena91@yahoo.com
 * 
 * 
 * **/

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ResultSet rsObj = null;
		Connection connObj = null;
		PreparedStatement pstmtObj = null;
		//ConnectionPool jdbcObj = new ConnectionPool();
		
		try {

			// Performing Database Operation!
			System.out.println("\n=====Making A New Connection Object For Db Transaction=====\n");
			connObj = DataSourceUtil.getInstance().getPoolDataSource().getConnection();
			DataSourceUtil.getInstance().printDbStatus();
			
			pstmtObj = connObj.prepareStatement("select * from cube_dev.price");
			rsObj = pstmtObj.executeQuery();
			while (rsObj.next()) {
				System.out.println("Price: " + rsObj.getString("price"));
			}
			System.out.println("\n=====Releasing Connection Object To Pool=====\n");
			DataSourceUtil.getInstance().printDbStatus();
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// Closing ResultSet Object
				if(rsObj != null) {
					rsObj.close();
				}
				// Closing PreparedStatement Object
				if(pstmtObj != null) {
					pstmtObj.close();
				}
				// Closing Connection Object
				if(connObj != null) {
					connObj.close();
				}
			} catch(Exception sqlException) {
				sqlException.printStackTrace();
			}
		}
		DataSourceUtil.getInstance().printDbStatus();

	}

}
