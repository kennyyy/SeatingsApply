package com.sa.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.sa.apply.model.ApplyVO;
import com.sa.apply.model.OptionVO;
import com.sa.apply.model.SeatVO;
import com.sa.apply.service.ApplyService;
import com.sa.apply.service.ApplyServiceImpl;

/**
 * Servlet implementation class ApplyController
 */
@WebServlet("*.apply")
public class ApplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ApplyService service = new ApplyServiceImpl();
	
    public ApplyController() {
        super();
        


    }
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");	
		
		String uri = request.getRequestURI();
		String path = uri.substring(request.getContextPath().length());
		
		
		System.out.println(path);
		if(path.equals("/apply/list.apply")) {
			//////////////////////////유저세션 테스트용
			HttpSession session = request.getSession();
			session.setAttribute("user_id", "USER6");
			//////////////////////////////////////
			
			ArrayList<OptionVO> ovo = service.getOption(request, response);
			
			
			ArrayList<Integer> nowUserRoomsNum = ((ApplyServiceImpl) service).getUserRoomsNum(request, response);
			
			
			request.setAttribute("nowUserRoomsNum", nowUserRoomsNum);
			request.setAttribute("ovo", ovo);
			request.setAttribute("nowUser", service.getRoomNumApply(request, response).size());
			request.getRequestDispatcher("apply_list.jsp").forward(request, response);
			
			
			
			
		}else if(path.equals("/apply/join.apply")) {
			System.out.println("입장");
			 HttpSession session = request.getSession();
			 String userid = (String)session.getAttribute("user_id");
			 
			ArrayList<String> applyUesr = service.getRoomNumApply(request, response);
			boolean isNotApplyUser = false;
			for(String s : applyUesr ) {
				if(s.equals(userid)) {
					//response.sendRedirect("apply_waittingRoom.jsp?roomnumber="+request.getParameter("roomnumber"));
					isNotApplyUser = true;
					//if iswin == y이면 버튼생김(테스트용)
					 ArrayList<ApplyVO> iswinList = service.getIsWin(request, response);
					 request.setAttribute("iswinList", iswinList);
					 request.getRequestDispatcher("apply_waittingRoom.jsp").forward(request, response);
				}
				
				
			}
			if(isNotApplyUser) {
				response.setContentType("text/html; charset=UTF-8");
				 PrintWriter out = response.getWriter();
				 out.println("<script>");
				 out.println("alert('이방 신청자 아님');");
				 out.println("location.href='list.apply'; ");
				 out.println("</script>");
			}
			//유저가 꽉차면
			if(service.getRoomNumApply(request, response).size() >= service.getNumCount(request, response)) {
				int result = service.allUserUpdateWin(request, response);
				System.out.println(result + "업데이트완료");
			}
			
			
		}
		
		else if( path.equals("/apply/applyUser.apply")) {
			System.out.println("wattingRoom.apply 도착완료");
			//신청정보 get
			 ArrayList<ApplyVO> getApplyList = service.getApply(request, response);
			 
			 //세션있어야한다.
			 HttpSession session = request.getSession();
			 String userid = (String)session.getAttribute("user_id");
			 
			 
			 
			 System.out.println(userid);
			 System.out.println(service.getRoomNumApply(request, response).size());
			 System.out.println(service.getNumCount(request, response));
			 //방인원 꽉차면 못들어가게(신청못하게)
			 if((service.getRoomNumApply(request, response).size()) >= service.getNumCount(request, response)) {
				 response.setContentType("text/html; charset=UTF-8");
				 PrintWriter out = response.getWriter();
				 out.println("<script>");
				 out.println("alert('신청자가 꽉 찼습니다.');");
				 out.println("location.href='list.apply'; ");
				 out.println("</script>");
			
			 }
			 

				
			 //이미 유저가 있으면 경고창 없으면, 신청
			 boolean isUser = false;
			 for(ApplyVO a :getApplyList) {
				 if(a.getUserid().equals(userid)) {
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<script>");
					out.println("alert('이미 신청한 방입니다.');");
					out.println("location.href='list.apply'; ");
					out.println("</script>");
					isUser = true;
				 } 
			 }
			 if(!isUser) {
				 service.insertApply(request, response);
			 }
			
		


			 //방인원 꽉차면 첫번째 참가자 랜덤로직 실행
			 //일단 보류
			 //System.out.println(service.getNumCount(request, response));
			// System.out.println(userid.equals("USER6"));
			// if( service.getNumCount(request, response) == 5 && userid.equals("USER6")) {
			//	 service.startRandomSeat(request, response);
			// } 
			
			
		}else if(path.equals("/apply/selectseat.apply")) {
		
			 
			 
			ArrayList<String> closeSeat = service.getSeat(request, response);
			ArrayList<String> seatWH = service.getOptionWH(request, response);
			
			
			request.setAttribute("closeSeat", closeSeat);
			request.setAttribute("seatWH", seatWH);
			
			request.getRequestDispatcher("apply_selectSeat.jsp").forward(request, response);
		
		}else if(path.equals("/apply/seatApply.apply")){
			
			//유저를 기준으로 조회해서 없으면
			int userSelectSeat = service.getUserSelectSeat(request, response);
			int userSeat = service.getUserSeat(request, response);
			System.out.println(userSelectSeat);
			System.out.println(userSeat);
			
			//seat테이블 좌석이랑 apply테이블 유저가 선택한 자석이 없으면 
			//좌석 선태가능
			if(userSelectSeat == 0 && userSeat == 0) {
				service.seatInsert(request, response);
				service.applySeatUpdate(request, response);
				response.sendRedirect("resultPage.apply?roomnumber="+request.getParameter("roomnumber"));
			}else {
								
				request.setAttribute("msg", "이미 신청한 좌석입니다.");
				request.getRequestDispatcher("selectseat.apply").forward(request, response);
				
				
			}
			
		} else if(path.equals("/apply/resultPage.apply")){
			ArrayList<String> closeSeat = service.getSeat(request, response);
			ArrayList<String> seatWH = service.getOptionWH(request, response);
			ArrayList<ApplyVO> allApplyUser = service.getAllApply(request, response);
			
			HashMap<String, String> selectUser = new HashMap<String, String>();
			
			for(ApplyVO a : allApplyUser) {
				selectUser.put(a.getSelectseat(), a.getUserid());
				System.out.println(a.getSelectseat());
				System.out.println(a.getUserid());
			}
			
			System.out.println(selectUser.get("3"));
			
			request.setAttribute("selectUser", selectUser);
			request.setAttribute("closeSeat", closeSeat);
			request.setAttribute("seatWH", seatWH);
			request.getRequestDispatcher("apply_resultPage.jsp").forward(request, response);
		}
		
		
	}

}
