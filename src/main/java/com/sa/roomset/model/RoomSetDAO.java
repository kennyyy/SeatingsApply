package com.sa.roomset.model;


import com.sa.roomset.util.JdbcUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RoomSetDAO {

    private static RoomSetDAO instance = new RoomSetDAO();

    private RoomSetDAO() {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static RoomSetDAO getInstance() { return instance; }

    private String url = JdbcUtil.url;
    private String uid = JdbcUtil.uid;
    private String upw = JdbcUtil.upw;


    // DB OPTIONS 테이블에 값넣기 메소드
    public void insertRoom (RoomSetVO RVO) {

        System.out.println("룸셋팅 폼에서 값 받아서 DB OPTIONS 테이블에 값 넣기 실행");

        Connection conn = null;
        PreparedStatement pstmt = null;

        String sql = "insert into OPTIONS (roomNumber, mid, numCount, deadLine, closingTime, width, height) "
                    +"values(options22_seq.nextval, ?, ?, ?, ?, ?, ?)";

        System.out.println(RVO.toString());

        try {

            conn = DriverManager.getConnection(url, uid, upw);

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, RVO.getMid() );
            pstmt.setString(2, RVO.getNumCount() );
            pstmt.setString(3, RVO.getDeadLine() );
            pstmt.setString(4, RVO.getClosingTime() );
            pstmt.setString(5, RVO.getWidth() );
            pstmt.setString(6, RVO.getHeight() );

            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(conn, pstmt, null);
        }

        System.out.println("옵션 테이블에 데이터 넣었음! 확인 바람~~~");
    }

    public void insertSeat (String s, String a) {


        Connection conn = null;
        PreparedStatement pstmt = null;

        String sql = "insert into SEAT values(?, ?)";


        try {

            conn = DriverManager.getConnection(url, uid, upw);

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, s);
            pstmt.setString(2, a);

            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(conn, pstmt, null);
        }

    }

    public String getRoomNuber (String getMid) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "SELECT max(ROOMNUMBER) FROM OPTIONS where mid = ?";

        String result = "";

        try {

            conn = DriverManager.getConnection(url, uid, upw);

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, getMid);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                result = String.valueOf(rs.getInt("max(ROOMNUMBER)"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(conn, pstmt, rs);
        }

        return result;
    }

}
