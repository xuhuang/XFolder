package com.videostore.test.dao;

import com.videostore.bean.Movie;
import com.videostore.bean.User;
import com.videostore.dao.VideoStoreDAO;
import com.videostore.dao.VideoStoreDAOImpl;

public class VideoStoreDAOTest {
	
	private static VideoStoreDAO dao = new VideoStoreDAOImpl();
	
	public static void test() {
		User[] users = dao.getAllUsers();
		for(User user : users) {
			System.out.println(user.toString());
		}
	}
	
	public static void testMovie() {
//		Movie[] movies = dao.getAllMovies();
		Movie[] movies = dao.getMoviesByTitle("ti");
		for(Movie movie : movies) {
			System.out.println(movie.toString());
		}
	}
	
	public static void testMaxxx() {
		System.out.println(dao.getMaxTransId());
	}

}
