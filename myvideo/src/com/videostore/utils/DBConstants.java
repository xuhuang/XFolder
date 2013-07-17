package com.videostore.utils;

public class DBConstants {
	
	public final static String GET_ALL_USER = "select * from member";
	public final static String GET_ALL_MOVIE = "select * from movie";
	public final static String GET_ONE_MOVIE = "select * from movie where ObjectId = ?";
	public final static String GET_MATCHED_MOVIE = "select * from movie where Category = ?";
	public final static String GET_TITLED_MOVIE = "select * from movie where Title like ?";
	public final static String GET_AVAILABLE_COPY = "select CopyNo from copy where ObjectId = ? and CopyNo not in(select CopyNo from involves where ObjectId = ?)";
	public final static String GET_ONE_COPY = "select m.Title Title, m.Charge Charge, m.Poster Poster, c.CopyNo CopyNo" +
			" from movie m, copy c" +
			" where m.ObjectId=c.ObjectId and c.ObjectId = ? and c.CopyNo = ?";
	
	
	//user for generating reports:
	public final static String REPORT_ONE = "select StoreId, date_format(DateTime,'%M') as Month, count(CopyNo) as BorrowedCopies from transaction_history group by StoreId, month(DateTime)";
	public final static String REPORT_THREE = "select m.Title, count(*) as number from transaction_history th, movie m" +
			" where th.ObjectId = m.ObjectId and year(th.DateTime) = (year(curdate()) -1)" +
			" group by th.ObjectId order by number desc limit 10";
	
	//insert query:
	public final static String INSERT_TRANSACTION = "INSERT INTO transactions (transacid, datetime, amount, type, memberid ) VALUES  ( ?, ?, ?, 0, ? )";
	public final static String INSERT_COPY = "INSERT INTO involves (transid, objectid, copyno ) VALUES  ( ?, ?, ?)";
}
