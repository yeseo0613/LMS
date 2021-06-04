package com.dev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dev.service.Service;
import com.dev.vo.Member;

public class ProfEnrollController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String subjectNum = request.getParameter("subjectNum");
		String subjectName = request.getParameter("subjectName");
		int studentNum = Integer.parseInt(request.getParameter("studentNum"));
		
		HttpSession session = request.getSession();
		String id = (String)request.getSession().getAttribute("id");
		
		Member member = new Member();
		
		Service s = Service.getInstance();
		s.profEnroll(subjectNum, subjectName, studentNum, id);
		
		HttpUtil.forward(request, response, "/profMenu.jsp");
		
		
	}

}
