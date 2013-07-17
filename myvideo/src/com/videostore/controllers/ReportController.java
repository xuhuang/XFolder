package com.videostore.controllers;


import java.sql.ResultSet;
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
import com.videostore.logic.ReportLogic;
import com.videostore.logic.UserLogic;
import com.videostore.utils.DBConstants;

@Controller
public class ReportController extends AbstractController {
	
	private VideoStoreDAO videoStoreDAO = new VideoStoreDAOImpl();
	
   	@RequestMapping("/report")
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response){
   		
    	String reportId = request.getParameter("reportId");
    	Map<String, Object> map = new HashMap();
		map.put("tab", "3");
    	if(reportId != null) {
    		String sql = DBConstants.REPORT_ONE;
    		if("2".equals(reportId)) {
//    			sql = DBConstants.REPORT_TWO;
    		}
    		else if("3".equals(reportId)) {
    			sql = DBConstants.REPORT_THREE;
    		}
    		
    		ResultSet rs = videoStoreDAO.getReport(sql);
    		String reportTable = ReportLogic.getReportTable(rs, reportId);
    		map.put("table", reportTable);
        	return new ModelAndView("admin", "result", map);
    	}
    	return new ModelAndView("failed");
    }
}