package com.dev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dev.service.Service;
import com.dev.vo.Member;

public class StudEnrollController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String id = (String)request.getSession().getAttribute("id");
		String subjectNum = request.getParameter("subjectNum");
		String subjectName = request.getParameter("subjectName");
		
		Member member = new Member();
		member.setId(id);
		member.setSubjectNum(subjectNum);
		member.setSubjectName(subjectName);
		
		Service s = Service.getInstance();
		s.studEnroll(member);
		
		HttpUtil.forward(request, response, "/studMenu.jsp");
		
	}

}
