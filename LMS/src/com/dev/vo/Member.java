package com.dev.vo;

public class Member {
	private String id;
	private String pwd;
	private String name;
	private String member;
	private String subjectNum;
	private String subjectName;
	private int studentNum;
	private int totalStud;
	public Member(String tSubjectNum, String tSubjectName, int tStudentNum, int tTotalStud) {
		this.subjectNum = tSubjectNum;
		this.subjectName = tSubjectName;
		this.studentNum = 0;
		this.totalStud = 0;
	}
	public Member() {}
	public String getId() {
		return id;
	}
	public void setId(String tId) {
		this.id = tId;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String tPwd) {
		this.pwd = tPwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String tName) {
		this.name = tName;
	}
	public String getMember() {
		return member;
	}
	public void setMember(String tMember) {
		this.member = tMember;
	}
	public String getSubjectNum() {
		return subjectNum;
	}
	public void setSubjectNum(String tSubjectNum) {
		this.subjectNum = tSubjectNum;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String tSubjectName) {
		this.subjectName = tSubjectName;
	}
	public int getStudentNum() {
		return studentNum;
	}
	public void setStudentNum(int tStudentNum) {
		this.studentNum = tStudentNum;
	}
	public int getTotalStud() {
		return totalStud;
	}
	public void setTotalStud(int tTotalStud) {
		this.totalStud = tTotalStud;
	}
}
