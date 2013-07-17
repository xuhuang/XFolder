package com.videostore.test.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.videostore.factory.DBPool;

public class ConnectionTest {
	
	public static void test() throws Exception {
		
		DBPool pool = new DBPool();
		Connection conn = pool.getObject();
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT 1");
			while (rs.next()){
				System.out.println(rs.getString("1"));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.returnObject(conn);
			conn = null;
		}
		
	}

}
