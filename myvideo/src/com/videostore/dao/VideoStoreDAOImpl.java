package com.videostore.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;
import com.videostore.bean.Copy;
import com.videostore.bean.Movie;
import com.videostore.bean.Transaction;
import com.videostore.bean.User;
import com.videostore.extractor.AuthenticationExtractor;
import com.videostore.factory.DBConnectionFactory;
import static com.videostore.utils.DBConstants.GET_ALL_USER;
import static com.videostore.utils.DBConstants.GET_ALL_MOVIE;
import static com.videostore.utils.DBConstants.GET_ONE_MOVIE;
import static com.videostore.utils.DBConstants.GET_ONE_COPY;
import static com.videostore.utils.DBConstants.GET_MATCHED_MOVIE;
import static com.videostore.utils.DBConstants.GET_AVAILABLE_COPY;
import static com.videostore.utils.DBConstants.GET_TITLED_MOVIE;
import static com.videostore.utils.DBConstants.INSERT_TRANSACTION;
import static com.videostore.utils.DBConstants.INSERT_COPY;



public class VideoStoreDAOImpl implements VideoStoreDAO{
	
	private final static Connection conn = DBConnectionFactory.getConnection("");
	
	public User[] getAllUsers() {
		User[] result = null;
		try {
    		PreparedStatement statement = (PreparedStatement) conn.prepareStatement(GET_ALL_USER);
//    		Statement statement = (Statement) connection.createStatement();
    		ResultSet rs = statement.executeQuery();
    		result = AuthenticationExtractor.extract(rs);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public Movie[] getAllMovies() {
		Movie[] result = null;
		try {
    		PreparedStatement statement = (PreparedStatement) conn.prepareStatement(GET_ALL_MOVIE);
    		ResultSet rs = statement.executeQuery();
    		result = AuthenticationExtractor.extractMovie(rs);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public Movie[] getMoviesByCategory(String category) {
		Movie[] movies = null;
		try {
    		PreparedStatement statement = (PreparedStatement) conn.prepareStatement(GET_MATCHED_MOVIE);
    		statement.setString(1, category);
    		ResultSet rs = statement.executeQuery();
    		movies = AuthenticationExtractor.extractMovie(rs);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return movies;
	}
	
	public Integer[] getMovieCopies(String movieId) {
		Integer[] copies = null;
		try {
    		PreparedStatement statement = (PreparedStatement) conn.prepareStatement(GET_AVAILABLE_COPY);
    		statement.setString(1, movieId);
    		statement.setString(2, movieId);
    		ResultSet rs = statement.executeQuery();
    		copies = AuthenticationExtractor.extractCopy(rs);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return copies;
	}
	
	/**
	 * @deprecated?
	 */
	public Movie getMovieById(String id) {
		Movie movie = new Movie();
		try {
    		PreparedStatement statement = (PreparedStatement) conn.prepareStatement(GET_ONE_MOVIE);
    		ResultSet rs = statement.executeQuery();
    		while(rs.next()){
        		movie.setTitle(rs.getString("Title"));
        		movie.setCharge(rs.getString("Charge"));
        		movie.setPoster(rs.getString("Poster"));
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return movie;
	}
	
	public Movie[] getMoviesByTitle(String title) {
		Movie[] movies = null;
		try {
    		PreparedStatement statement = (PreparedStatement) conn.prepareStatement(GET_TITLED_MOVIE);
    		statement.setString(1, "%"+title+"%");
    		ResultSet rs = statement.executeQuery();
    		movies = AuthenticationExtractor.extractMovie(rs);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return movies;
	}
	
	public Copy getCopyById(String ObjectId, String CopyNo) {
		Copy copy = new Copy();
		try {
    		PreparedStatement statement = (PreparedStatement) conn.prepareStatement(GET_ONE_COPY);
    		statement.setString(1, ObjectId);
    		statement.setString(2, CopyNo);
    		ResultSet rs = statement.executeQuery();
    		while(rs.next()){
    			copy.setObjectId(ObjectId);
        		copy.setTitle(rs.getString("Title"));
        		copy.setCharge(rs.getString("Charge"));
        		copy.setPoster(rs.getString("Poster"));
        		copy.setCopyNo(rs.getString("CopyNo"));
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return copy;
	}
	
	public ResultSet getReport(String reportSql) {
		ResultSet rs = null;
		try {
    		PreparedStatement statement = (PreparedStatement) conn.prepareStatement(reportSql);
    		rs = statement.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public int getMaxTransId() {
		int result = 0;
		ResultSet rs = null;
		try {
    		PreparedStatement statement = (PreparedStatement) conn.prepareStatement("select max(TransacId) from Transactions");
    		rs = statement.executeQuery();
    		while(rs.next()){
        		result =  Integer.parseInt(rs.getString(1));
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public void insertTransaction(int tranId, String date, String amount, String memberId) {
		try {
    		PreparedStatement statement = (PreparedStatement) conn.prepareStatement(INSERT_TRANSACTION);
    		statement.setString(1, String.valueOf(tranId));
    		statement.setString(2, String.valueOf(date));
    		statement.setString(3, String.valueOf(amount));
    		statement.setString(4, String.valueOf(memberId));
    		statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertCopy(ArrayList copyList, String transId) {
		try {
    		PreparedStatement statement = (PreparedStatement) conn.prepareStatement(INSERT_COPY);
    		for(int i=0;i<copyList.size();i++) {
    			Copy copy = (Copy)copyList.get(i);
    			System.out.println("transId:: "+transId);
    			System.out.println("copy.getObjectId():: "+copy.getObjectId());
    			System.out.println("copy.getCopyNo():: "+copy.getCopyNo());
    			statement.setString(1, transId);
    			statement.setString(2, copy.getObjectId());
    			statement.setString(3, copy.getCopyNo());
    			statement.addBatch();
    		}
    		statement.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	public Transaction getTransactionList(String userId){
//		Transaction[] Transaction = null;
//		try {
//    		PreparedStatement statement = (PreparedStatement) conn.prepareStatement(GET_MATCHED_MOVIE);
//    		statement.setString(1, userId);
//    		ResultSet rs = statement.executeQuery();
//    		Transaction = AuthenticationExtractor.extractMovie(rs);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return Transaction;
//	}
}
