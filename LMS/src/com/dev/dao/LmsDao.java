package com.dev.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.dev.vo.Member;

public class LmsDao {
	private static LmsDao dao = new LmsDao();
	private LmsDao() {}
	public static LmsDao getInstance() {
		return dao;
	}
	public Connection connect() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "537200218");
		} catch (Exception e) {
			System.out.print("MDAO:connect"+e);
		} 
		return conn;
		
	}
	public void close(Connection conn, PreparedStatement pstmt) {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch(Exception e) {
				System.out.print("Pstmt close error"+e);
			}
		if(conn != null) {
			try {
				conn.close();
			} catch(Exception e) {
				System.out.print("Conn close error"+e);
			}
		}
			
		}
	}
	public void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				System.out.print("rs close error"+e);
			}
		}
		close(conn,pstmt);
	}
	public void login(String id, String pwd, String[] member) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		if(member[0].equals("prof")) {
			try {
				conn = connect();
				pstmt = conn.prepareStatement("select * from prof where id = ? and pwd = ?;");
				//pstmt.setString(1, member[0]);
				pstmt.setString(1, id);
				pstmt.setString(2,  pwd);
				rs = pstmt.executeQuery();
			} catch(Exception e) {
				System.out.print("login error p\n" +e);
			} finally {
				close(conn,pstmt,rs);
			}
		} else {
			try {
				conn = connect();
				pstmt = conn.prepareStatement("select * from student where id = ? and pwd = ?;");
				//pstmt.setString(1, member[0]);
				pstmt.setString(1, id);
				pstmt.setString(2,  pwd);
				
				rs = pstmt.executeQuery();
			} catch(Exception e) {
				System.out.print("login error s\n" +e);
			} finally {
				close(conn,pstmt,rs);
			}
		}
		
	}
	public void profEnroll(String subjectNum, String subjectName, int studentNum, String id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt =  conn.prepareStatement("insert into subject values(?,?,?,?,?);");
			pstmt.setString(1, subjectNum);
			pstmt.setString(2, subjectName);
			pstmt.setInt(3, studentNum);
			pstmt.setString(4, id);
			pstmt.setInt(5, 0);
			pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.print("profEnroll error"+e);
		} finally {
			close(conn,pstmt);
		}
	}
	public ArrayList<Member> profList(String id) {
		// TODO Auto-generated method stub
		ArrayList<Member> list = new ArrayList<Member>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select * from subject where prof=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				member = new Member();
				member.setSubjectNum(rs.getString(1));
				member.setSubjectName(rs.getString(2));
				member.setStudentNum(rs.getInt(3));
				member.setTotalStud(0);
				list.add(member);
			}
		} catch (Exception e) {
			System.out.print("profList error"+e);
		} finally {
			close(conn,pstmt,rs);
		}
	return list;
	}
	public Member studSearch(String subjectNum) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select * from subject where id = ?");
			pstmt.setString(1, subjectNum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member = new Member();
				member.setSubjectNum(rs.getString(1));
				member.setSubjectName(rs.getString(2));
			} 
		} catch (Exception e) {
			System.out.print("studSearch error" +e);
		} finally {
			close(conn,pstmt,rs);
		}
		return member;
	}
	public void studEnroll(Member member) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("insert into enroll values(?,?,?);");
			pstmt.setString(1, member.getSubjectNum());
			pstmt.setString(2, member.getSubjectName());
			pstmt.setString(3, member.getId());
			pstmt.executeUpdate();
		}catch (Exception e) {
			System.out.println("studEnroll error" +e);
		}
		try {
			conn = connect();
			pstmt = conn.prepareStatement("update subject set total_stud = total_stud + 1 where name = ? ;");
			pstmt.setString(1, member.getSubjectName());
			pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.print("studEnroll 2 error" +e);
		} finally {
			close(conn,pstmt);
		}
	}
	public ArrayList<Member> studList(String id) {
		// TODO Auto-generated method stub
		ArrayList<Member> list1 = new ArrayList<Member>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select * from enroll where student=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				member = new Member();
				member.setSubjectNum(rs.getString(1));
				member.setSubjectName(rs.getString(2));
				list1.add(member);
			}
		} catch (Exception e) {
			System.out.print("profList error"+e);
		} finally {
			close(conn,pstmt,rs);
		}
	return list1;
	}
	
}
