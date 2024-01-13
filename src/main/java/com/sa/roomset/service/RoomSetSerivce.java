package com.sa.roomset.service;

import com.sa.roomset.model.RoomSetDAO;
import com.sa.roomset.model.RoomSetVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RoomSetSerivce implements RoomSetServiceIf {

    private RoomSetDAO RDAO = RoomSetDAO.getInstance();

//    public String getRoomNumber(HttpServletRequest request, HttpServletResponse response) {
//        return RDAO.getRoomNumber();
//    }


    @Override
    public RoomSetVO createRoom(HttpServletRequest request, HttpServletResponse response) {
        String mid = request.getParameter("mid");
        String numCount = request.getParameter("numCount");
        String deadLine = request.getParameter("deadLine");
        String closingTime = request.getParameter("closingTime");
        String width = request.getParameter("width");
        String height = request.getParameter("height");

        System.out.println(mid + " " + numCount + " " + deadLine + " " + closingTime + " " + width + " " + height);

        RoomSetVO RVO = new RoomSetVO("", mid, numCount, deadLine, closingTime, width, height);

        return RVO;
    }

    @Override
    public RoomSetVO insertRoom(RoomSetVO RVO) {

        // 데이터 저장.
        RDAO.insertRoom(RVO);

        return RVO;
    }

    @Override
    public void insertSeat(HttpServletRequest request, HttpServletResponse response) {

        String[] seat = request.getParameterValues("seat");
        HttpSession session = request.getSession();
        RoomSetVO RVO = (RoomSetVO) session.getAttribute("RVO");


        for (String s : seat) {
            String a = RDAO.getRoomNuber(RVO.getMid());
            System.out.println(s);
            System.out.println(a);
            RDAO.insertSeat(s, a);
        }



    }
}


