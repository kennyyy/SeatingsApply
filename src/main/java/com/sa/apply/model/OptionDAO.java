package com.sa.apply.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sa.util.JdbcUtil;

public class OptionDAO {
	private static OptionDAO instance = new OptionDAO();
	private DataSource dataSource;
	
	private OptionDAO() {
		try {
			InitialContext init = new InitialContext();
			dataSource = (DataSource)init.lookup("java:comp/env/jdbc/oracle");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static OptionDAO getInstance() {
		return instance;
	}
	//방 옵션 테이블 전체 조회
	public ArrayList<OptionVO> getOption() {
		
		ArrayList<OptionVO> list = new ArrayList<OptionVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from options order by roomnumber";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				OptionVO ovo = new OptionVO();
					
				ovo.setRoomnumber(rs.getString("roomnumber"));
				ovo.setNumcount(rs.getString("numcount"));
				ovo.setDeadline(rs.getString("deadline"));
				ovo.setWidth(rs.getString("width"));
				ovo.setHeight(rs.getString("height"));
				ovo.setMid(rs.getString("mid"));
				Timestamp ts = rs.getTimestamp("nowdate");
				SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
				ovo.setNowdate(sdf.format(ts));
				list.add(ovo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		
		return list;
	}
	
	public ArrayList<String> getOptionWH(String roomnumber){
		ArrayList<String> seatWH = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select width, height from options where roomnumber = ?";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, roomnumber);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				seatWH.add(rs.getString("width"));
				seatWH.add(rs.getString("height"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		
		return seatWH;
	}
	
	public int getNumCount(String roomnumber) {
			
		int numCount = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select numcount from options where roomnumber = ?";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, roomnumber);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				numCount = rs.getInt("numcount");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		
		return numCount;
	
	}
}
