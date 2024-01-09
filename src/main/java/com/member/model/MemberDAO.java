package com.member.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.member.jdbcUtil.JdbcUtil;

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
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		} 
		return result;
	}
	
	
	
	
	
}