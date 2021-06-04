package com.dev.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet{
	HashMap<String, Controller> list = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		list = new HashMap<String, Controller>();
		list.put("/login.do", new LoginController());
		list.put("/profEnroll.do", new ProfEnrollController());
		list.put("/profList.do", new ProfListController());
		list.put("/studSearch.do", new StudSearchController());
		list.put("/studEnroll.do", new StudEnrollController());
		list.put("/studList.do", new StudListController());
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String contextP = req.getContextPath();
		String url = req.getRequestURI();
		String path = url.substring(contextP.length());
		Controller subController = list.get(path);
		subController.execute(req, resp);
	}
}
