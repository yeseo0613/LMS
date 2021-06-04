package com.dev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dev.service.Service;
import com.dev.vo.Member;

public class StudSearchController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String subjectNum = request.getParameter("subjectNum");
		String job = request.getParameter("job");
		String path = null;
		
		if(job.equals("subjectSearch"))
			path = "/studEnroll.jsp";
		
		Service s = Service.getInstance();
		Member member = s.studSearch(subjectNum);
		
		if(member == null) request.setAttribute("result", "해당 과목이 존재하지 않습니다.");
		request.setAttribute("member", member);
		HttpUtil.forward(request, response, path);
	}

}
