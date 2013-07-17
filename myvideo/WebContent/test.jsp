<%@page language="java" import="java.sql.*"%>
<%

String connectionURL = "jdbc:mysql://localhost:3306/videostore";  
Statement statement = null;
ResultSet rs = null;

Class.forName("com.mysql.jdbc.Driver").newInstance();
Connection connection = DriverManager.getConnection(connectionURL, "root","imhuangxu");
statement = connection.createStatement();
String sql = "select * from member";
rs = statement.executeQuery(sql);
while(rs.next()){
	out.print(rs.getString("MemberId")+"====" +rs.getRow());
}
out.print("=============");
%>