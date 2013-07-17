package com.videostore.logic;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReportLogic {
	
	public static String getReportTable(ResultSet rs, String id) {
		StringBuffer sb = new StringBuffer("");
		try {
			if("1".equals(id)){
				sb.append("<table><tr><th>StoreId</th><th>Month</th><th>BorrowedCopies</th></tr>");
				while(rs.next()) {
					sb.append("<tr>");
					sb.append("<td>"+rs.getString("StoreId")+"</td>");
					sb.append("<td>"+rs.getString("Month")+"</td>");
					sb.append("<td>"+rs.getString("BorrowedCopies")+"</td>");
					sb.append("</tr>");
				}
				sb.append("</table>");
			} else if("3".equals(id)) {
				sb.append("<table><tr><th>Title</th><th>Total NO.</th></tr>");
				while(rs.next()) {
					sb.append("<tr>");
					sb.append("<td>"+rs.getString("Title")+"</td>");
					sb.append("<td>"+rs.getString("number")+"</td>");
					sb.append("</tr>");
				}
				sb.append("</table>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}
}
