package com.dev.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dev.service.Service;
import com.dev.vo.Member;

public class ProfListController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String id = (String)request.getSession().getAttribute("id");
		
		Service s = Service.getInstance();
		ArrayList<Member> list = s.profList(id);
		
		request.setAttribute("list", list);
		HttpUtil.forward(request, response, "/profList.jsp");
	}

}
