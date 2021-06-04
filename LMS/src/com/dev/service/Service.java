package com.dev.service;

import java.util.ArrayList;

import com.dev.dao.LmsDao;
import com.dev.vo.Member;

public class Service {
	private static Service service = new Service();
	private Service() {}
	private LmsDao dao = LmsDao.getInstance();
	public static Service getInstance() {
		return service;
	}
	public void profEnroll(String subjectNum, String subjectName, int studentNum, String id) {
		// TODO Auto-generated method stub
		dao.profEnroll(subjectNum, subjectName, studentNum, id);
	}
	public ArrayList<Member> profList(String id) {
		// TODO Auto-generated method stub
		ArrayList<Member> list = dao.profList(id);
		return list;
	}
	public void login(String id, String pwd, String[] member) {
		// TODO Auto-generated method stub
		dao.login(id, pwd, member);
		
	}
	public Member studSearch(String subjectNum) {
		// TODO Auto-generated method stub
		Member member = dao.studSearch(subjectNum);
		return member;
	}
	public void studEnroll(Member member) {
		// TODO Auto-generated method stub
		dao.studEnroll(member);
	}
	public ArrayList<Member> studList(String id) {
		// TODO Auto-generated method stub
		ArrayList<Member> list1 = dao.studList(id);
		return list1;
	}
}
