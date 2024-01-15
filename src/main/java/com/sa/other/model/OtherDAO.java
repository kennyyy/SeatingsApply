package com.sa.other.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sa.util.JdbcUtil;

public class OtherDAO {

	private static OtherDAO instance = new OtherDAO();
	
	private OtherDAO(){
		
		try {
			InitialContext init = new InitialContext();
			dataSource = (DataSource)init.lookup("java:comp/env/jdbc/oracle");
		}catch (Exception e) {
		}
	}
	
	public static OtherDAO getInstance() {
		return instance;
	}
	
	private DataSource dataSource;
	
	//목록조회
	public ArrayList<OtherVO> getList(){
		
		ArrayList<OtherVO> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from other order by bno desc";
		
		try {
			conn = dataSource.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				int bno = rs.getInt("bno");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				int hit = rs.getInt("hit");
				Timestamp regdate = rs.getTimestamp("regdate");
				
				OtherVO vo = new OtherVO(bno, writer, title, content, hit, regdate);
				list.add(vo);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return list;
	}
	
	//글등록
	public void insert(String writer, String title, String content) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into other(bno, writer, title, content)"
				   + " values(OTHER_seq.nextval, ?, ?, ?)";
		
		try {
			
			conn = dataSource.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writer);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			
			pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, null);
		}
	}
	
	//글조회
	public OtherVO getContent(String bno) {
		
		OtherVO vo = new OtherVO();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from other where bno = ?";
		
		try {
			
			conn = dataSource.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  bno);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				int bno2 = rs.getInt("bno");
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String content = rs.getString("content");
				int hit = rs.getInt("hit");
				Timestamp regdate = rs.getTimestamp("regdate");
				
				vo.setBno(bno2);
				vo.setWriter(writer);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setHit(hit);
				vo.setRegdate(regdate);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return vo;
	}
	
	public int update(String bno, String title, String content) {
		
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "update other set title = ?, content = ? where bno = ?";
		
		try {
			
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);;
			pstmt.setString(2, content);;
			pstmt.setString(3, bno);;
			
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, null);
		}
		return result;
	}
	
	public void delete(String bno) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "delete from other where bno = ?";
		
		try {
			
			conn = dataSource.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  bno);
			
			pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, null);
		}
	}
	
	public void hitUpdate(String bno) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "update other set hit = hit + 1 where bno = ?";
		
		try {
			
			conn = dataSource.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bno);
			
			pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, null);
		}
	}
	
	
	
	
	
}