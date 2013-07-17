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

import com.videostore.bean.Movie;
import com.videostore.bean.User;
import com.videostore.dao.VideoStoreDAO;
import com.videostore.dao.VideoStoreDAOImpl;
import com.videostore.logic.MovieLogic;
import com.videostore.logic.UserLogic;

@Controller
public class AdminController {

	private VideoStoreDAO videoStoreDAO = new VideoStoreDAOImpl();
	
	@RequestMapping("/administration")
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response){
   		String tab = "0";
   		String currTab = request.getParameter("tab");
   		String opration = request.getParameter("opt");
   		String keyword = request.getParameter("keyword");
   		System.out.println("tab:"+currTab);
   		System.out.println("opt:"+opration);
   		System.out.println("key:"+keyword);
   		if(!"".equals(currTab) && currTab != null) {
   			tab = currTab;
   		}
		Map<String, Object> map = new HashMap();
		map.put("tab", tab);
   		if("0".equals(tab) && !"".equals(keyword) && keyword != null) {
    		Movie[] movies = videoStoreDAO.getMoviesByTitle(keyword);
    		ArrayList list = (ArrayList) MovieLogic.getMovieList(movies);
    		map.put("movies", list);

        	return new ModelAndView("admin", "result", map);
   		}
   		if("1".equals(tab) && !"".equals(keyword) && keyword != null) {
   			// for getting members
   		}
   		if("3".equals(tab) && !"".equals(keyword) && keyword != null) {
   			// for getting transactions
   			
   		}
   		return new ModelAndView("admin", "result", map);
    }
}
