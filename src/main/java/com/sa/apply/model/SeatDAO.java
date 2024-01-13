package com.sa.apply.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.sa.util.JdbcUtil;

public class SeatDAO {
	private static SeatDAO instance = new SeatDAO();
	private DataSource dataSource;
	
	private SeatDAO() {
		try {
			InitialContext init = new InitialContext();
			dataSource = (DataSource)init.lookup("java:comp/env/jdbc/oracle");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SeatDAO getInstance() {
		return instance;
	}
	
	//자리테이블 전체 조회
	public ArrayList<SeatVO> getSeat(String roomnumber) {
		
		ArrayList<SeatVO> list = new ArrayList<SeatVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from seat where roomnumber = ?";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, roomnumber);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				SeatVO svo = new SeatVO();
				
				svo.setSeat(rs.getString("seat"));
				svo.setRoomnumber(rs.getString("roomnumber"));

				list.add(svo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		
		return list;
	}
	
	public int getUserSeat(String selectseat, String roomnumber) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from seat where seat = ? and roomnumber = ?";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, selectseat);
			pstmt.setString(2, roomnumber);
			
			result = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, null);
		}
		
		return result;
	}
	

	
	public int selectSeatInSert(String selectseat, String roomnumber) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		
		String sql = "insert into seat values (?,?)";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, selectseat);
			pstmt.setString(2, roomnumber);
			
			result = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, null);
		}
		
		return result;
	}
	
	
}
