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

public class ApplyDAO {
	private static ApplyDAO instance = new ApplyDAO();
	private DataSource dataSource;
	
	private ApplyDAO() {
		try {
			InitialContext init = new InitialContext();
			dataSource = (DataSource)init.lookup("java:comp/env/jdbc/oracle");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ApplyDAO getInstance() {
		return instance;
	}
	
	public ArrayList<ApplyVO> getApply() {
		
		ArrayList<ApplyVO> list = new ArrayList<ApplyVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select userid, roomnumber, iswin ,m.master, m.limitroom  from apply a\r\n"
				+ "left join members m on a.userid = m.id";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ApplyVO avo = new ApplyVO();
				
				avo.setUserid(rs.getString("userid"));
				avo.setRoomnumber(rs.getString("roomnumber"));
				avo.setIswin(rs.getString("iswin"));
				avo.setMaster(rs.getString("master"));
				avo.setLimitroom(rs.getString("limitroom"));
				
				list.add(avo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		
		return list;
	}
	public ArrayList<ApplyVO> getAllApply() {
		ArrayList<ApplyVO> user = new ArrayList<ApplyVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from apply";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ApplyVO avo = new ApplyVO();
				
				avo.setUserid(rs.getString("userid"));
				avo.setRoomnumber(rs.getString("roomnumber"));
				avo.setIswin(rs.getString("iswin"));
				avo.setSelectseat(rs.getString("selectseat"));
		
				user.add(avo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return user;
	}
	
	//유저가 선택한 좌석이 있는지 조회
	public int getApplySelectSeat(String userid, String roomnumber) {
		
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select selectseat from apply where selectseat is not null and userid = ? and roomnumber = ?";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, roomnumber);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = 1;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		
		return result;
	}
	
	public ArrayList<String> getApply(String roomnumber) {
		
		ArrayList<String> applyUserList = new ArrayList<String>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select userid from apply where roomnumber = ?";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, roomnumber);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {		
				applyUserList.add(rs.getString("userid"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		
		return applyUserList;
	}
	public int allUserUpdateWin(String roomnumber) {
		int result = 0;
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "update apply set iswin = 'Y' where roomnumber = ?";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, roomnumber);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, null);
		}
		
		return result;
	}
	
	public ArrayList<ApplyVO> getIsWin(String roomnumber) {
		ArrayList<ApplyVO> list = new ArrayList<ApplyVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select userid, roomnumber from apply where iswin = 'Y' and roomnumber = ?";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, roomnumber);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ApplyVO avo = new ApplyVO();
				
				avo.setUserid(rs.getString("userid"));
				avo.setRoomnumber(rs.getString("roomnumber"));	
				list.add(avo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		
		return list;
	}
	
	public int insertUser(String userid, String roomnumber) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;

		
		String sql = "insert into apply values (?, ?, ?, null)";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, roomnumber);
			pstmt.setString(3, "N");
			
			result = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, null);
		}
		
		return result;
	}
	
	public int applySeatUpdate(String userid, String roomnumber, String selectseat ) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "update apply set selectseat = ? where roomnumber = ? and userid = ?";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, selectseat);
			pstmt.setString(2, roomnumber);
			pstmt.setString(3, userid);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, null);
		}
		
		return result;
	}
	public ArrayList<Integer> getUserRoomsNum(){
		ArrayList<Integer> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select count(*) from apply group by roomnumber order by roomnumber";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(rs.getInt("count(*)"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return list;
	}
		
	
	
	
	
	
	
}
