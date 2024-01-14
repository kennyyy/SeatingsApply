package com.sa.log.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sa.util.JdbcUtil;

public class MemberDAO {

	private static MemberDAO instance = new MemberDAO();
	
	private MemberDAO() {
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public static MemberDAO getInstance() {
		
		return instance;
	}
	
	private String url = JdbcUtil.url;
	private String uid = JdbcUtil.uid;;
	private String upw = JdbcUtil.upw;;			
	
	public int idCheck(String id) {
		
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from members where id = ?";
		
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = 1;
			}
			else {
				result = 0;
			}
			
		}catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			JdbcUtil.close(conn, pstmt, rs);
		} 
		return result;
	}
	
	//Join(회원가입)
	public void insertMember(MemberVO vo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into members(id, pw, name, email, address, age, gender, regdate, master, limitroom)"
				   + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			
			conn = DriverManager.getConnection(url, uid, upw);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getAddress());
			pstmt.setString(6, vo.getAge());
			pstmt.setString(7, vo.getGender());
			pstmt.setString(8, vo.getRegdate());
			pstmt.setString(9, vo.getMaster());
			pstmt.setString(10, vo.getLimitroom());
			
			pstmt.executeUpdate();
			
		}catch (Exception e) {
			
			e.printStackTrace();
			
		}finally{
			
			JdbcUtil.close(conn, pstmt, null);
		}
	}
	
	//Log In(로그인)
	public MemberVO login(String id, String pw) {
		
		MemberVO vo = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from members where id = ? and pw = ?";
		
		try {
			
			conn = DriverManager.getConnection(url, uid, upw);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				vo = new MemberVO();
				vo.setId(id);
				vo.setName(rs.getString("name"));
				vo.setMaster(rs.getString("master"));
			};
			
		}catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			JdbcUtil.close(conn, pstmt, rs);
		}
		return vo;
	}
	
	//getInstance(정보조회)
	public MemberVO getMemberInfo(String id) {
		
		MemberVO vo = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from members where id = ?";
		
		try {
			
			conn = DriverManager.getConnection(url, uid, upw);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				String name = rs.getString("name");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String age = rs.getString("age"); 
				String gender = rs.getString("gender");
				String regdate = rs.getString("regdate");
				String master = rs.getString("master");
				String limitroom = rs.getString("limitroom");
				
				vo = new MemberVO(id, null, name, email, address, age, gender, regdate, master, limitroom);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			JdbcUtil.close(conn, pstmt, rs);
		}
		return vo;
	}
	
	//회원정보수정
	public int update(MemberVO vo) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "update members set pw = ?, name = ?, email = ?, address = ?, age = ?, gender = ?, master = ?, limitroom = ? where id = ?";  
		
		try {
			
			conn = DriverManager.getConnection(url, uid, upw);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPw());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getAddress());
			pstmt.setString(5, vo.getAge());
			pstmt.setString(6, vo.getGender());
			pstmt.setString(7, vo.getMaster());
			pstmt.setString(8, vo.getLimitroom());
			pstmt.setString(9, vo.getId());
			
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			JdbcUtil.close(conn, pstmt, null);
		}
		return result;
	}

	// 회원정보삭제
	public void delete(String id) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "delete from members where id = ?";
		
		try {
			
			conn = DriverManager.getConnection(url, uid, upw);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
			
		}catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			JdbcUtil.close(conn, pstmt, null);
		}
		
		
		
		
	}
}