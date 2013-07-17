package com.videostore.utils;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DataManager {

	private String connectionURL = "jdbc:mysql://localhost:3306/videostore";  
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet rs = null;
	
	public static DataManager instance = null;
	protected DataManager() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = (Connection) DriverManager.getConnection(connectionURL, "root","imhuangxu");
		    this.statement = (Statement) connection.createStatement();
		    ResultSet srr = this.statement.executeQuery("select * from movie");
//		    System.out.println("++++++++ "+srr.getRow());
//		    System.out.println("++++++++ "+this.connection);
//		    System.out.println("++++++++ "+this.statement);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static DataManager getInstance() {
		if(instance == null) {
			instance =  new DataManager();
		}
		return instance;
	}
	public ResultSet query(String sql) {
		
	    try {
			this.rs = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return this.rs;
	}
	   
}
