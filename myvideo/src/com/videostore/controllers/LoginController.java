package com.videostore.controllers;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.videostore.bean.Movie;
import com.videostore.bean.User;
import com.videostore.dao.VideoStoreDAO;
import com.videostore.dao.VideoStoreDAOImpl;
import com.videostore.logic.MovieLogic;
import com.videostore.logic.UserLogic;

@Controller
public class LoginController extends AbstractController {
	
	private VideoStoreDAO videoStoreDAO = new VideoStoreDAOImpl();
	
   	@RequestMapping("/logincontrol")
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response){
   		HttpSession session = request.getSession();
    	String userId = request.getParameter("userid");
    	String password = request.getParameter("password");
   		String errMsg = "";
   		
    	if(userId != null && password != null) {
    		
    		User[] users = videoStoreDAO.getAllUsers();
    		Movie[] movies = videoStoreDAO.getAllMovies();
    		ArrayList list = (ArrayList) MovieLogic.getMovieList(movies);
    		if(UserLogic.isUserAuthenticated(users,userId, password)) {
    			session.setAttribute("userId", userId);
    			session.setAttribute("username", UserLogic.getUserNameById(users, userId));
    			return new ModelAndView("home", "movies", list);
    		}
    	}
    	return new ModelAndView("failed","errMsg", errMsg);
    }
}