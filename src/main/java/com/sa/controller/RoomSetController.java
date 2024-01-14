package com.sa.controller;

import com.sa.roomset.model.RoomSetVO;
import com.sa.roomset.service.RoomSetSerivce;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "*.roomSet")
public class RoomSetController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RoomSetController () {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doAction(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doAction(request, response);
    }

    protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String path = request.getRequestURI();
        System.out.println(path);

        RoomSetSerivce roomSetSerivce = new RoomSetSerivce();

        if (path.equals("/room/roomSet.roomSet")) { // 룸셋팅 화면

            // 1. request pull 후 원준이 형이 만든 세션 값 받아옴
            // 2. 마스터 계정인지 조건 확인
            // 3. 조건 충족 시 이동하며, 해당 마스터 id 데이터 가지고 이동.

            // 일단 임시로 이동.
            request.getRequestDispatcher("room_setting.jsp").forward(request, response);
            System.out.println("룸셋팅 새로고침");

        } else if (path.equals("/room/roomForm.roomSet")) { // 설정 완료시 테이블로 이동

            RoomSetVO RVO = roomSetSerivce.createRoom(request, response);
            HttpSession session = request.getSession();
            session.setAttribute("RVO", RVO);

            request.getRequestDispatcher("room_settingTable.jsp").forward(request, response);


        } else if (path.equals("/room/roomTableForm.roomSet")) { // 테이블 셋팅 폼


            HttpSession session = request.getSession();
            RoomSetVO RVO = (RoomSetVO) session.getAttribute("RVO");
            System.out.println(RVO.getMid());
            roomSetSerivce.insertRoom(RVO);
            roomSetSerivce.insertSeat(request, response);

    

            // request pull 후 경연이 형이 만든 대기실 페이지로 이동
            response.sendRedirect("/apply/list.apply");


        }



    }
}