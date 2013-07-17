package com.videostore.factory;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DBConnectionFactory {
	
	private final static String connectionURL = "jdbc:mysql://localhost:3306/videostore";
	private final static String default_user = "root";
	private final static String default_pwd = "imhuangxu";
	private final static String njit_user = "xh92";
	private final static String njit_pwd = "3XzJoOQx";
	private final static String connectionURL_NJIT = "jdbc:mysql://sql.njit.edu/videostore";
	
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(String host){
		Connection conn = null;
			try {
				if("NJIT".equals(host)){
						conn =  (Connection) DriverManager.getConnection(connectionURL_NJIT, default_user,default_pwd);
				} else {//default host
					conn =  (Connection) DriverManager.getConnection(connectionURL, default_user, default_pwd);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return conn;
	}

}
