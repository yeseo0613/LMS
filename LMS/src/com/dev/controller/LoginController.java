package com.dev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dev.service.Service;

public class LoginController implements Controller {

	private static final String prof = null;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String[] member = request.getParameterValues("member");
		
		Service s = Service.getInstance();
		s.login(id, pwd, member);
		
		String path = null;
		
		if(member[0].equals("prof")) {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			path = "/profMenu.jsp";
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			path = "/studMenu.jsp";
			
		}
		HttpUtil.forward(request, response, path);
	}

}
