package com.sa.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		String uri = request.getRequestURI();
		String path = uri.substring(request.getContextPath().length());

		System.out.println(path);
		if (path.equals("/apply/list.apply")) {
	
			HttpSession session = request.getSession(); 
			session.getAttribute("user_id");
			
			ArrayList<OptionVO> ovo = service.getOption(request, response);
			ArrayList<Integer> nowUserRoomsNum = service.getUserRoomsNum(request, response);

			request.setAttribute("nowUserRoomsNum", nowUserRoomsNum);
			request.setAttribute("ovo", ovo);
			request.setAttribute("nowUser", service.getRoomNumApply(request, response).size());
			request.getRequestDispatcher("apply_list.jsp").forward(request, response);

		} else if (path.equals("/apply/join.apply")) {
			HttpSession session = request.getSession();	
			String userid = (String) session.getAttribute("user_id");
			System.out.println(userid);
			
			ArrayList<String> applyUesr = service.getRoomNumApply(request, response);
			int numCount = service.getNumCount(request, response);
			
			boolean isNotApplyUser = false;
			for (String s : applyUesr) {
				if (s.equals(userid)) {
					isNotApplyUser = true;
				}

			}
			if(userid == null) {
				System.out.println("유저 정보없음");
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('입장 불가능한 유저(로그인 안한듯?)');");
				out.println("location.href='list.apply'; ");
				out.println("</script>");
				out.flush();
			}else if(!isNotApplyUser) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('이방 신청자 아님');");
				out.println("location.href='list.apply'; ");
				out.println("</script>");
				out.flush();
			}
		

			
			
			// 유저가 꽉차면
			if (applyUesr.size() >= numCount) {
				int result = service.allUserUpdateWin(request, response);
				System.out.println(result + "개 : 업데이트완료");
			}
			
			
			ArrayList<ApplyVO> iswinList = service.getIsWin(request, response);
			request.setAttribute("applyUesr", applyUesr.size());
			request.setAttribute("numCount", numCount);
			request.setAttribute("iswinList", iswinList); 
			request.getRequestDispatcher("apply_waittingRoom.jsp").forward(request, response);

		}

		else if (path.equals("/apply/applyUser.apply")) {
			System.out.println("wattingRoom.apply 도착완료");
			// 신청정보 get
			// 주의
			ArrayList<String> getApplyList = service.getRoomNumApply(request, response);

			// 세션있어야한다.
			HttpSession session = request.getSession();
			String userid = (String) session.getAttribute("user_id");

			System.out.println(userid);
			System.out.println(service.getRoomNumApply(request, response).size());
			System.out.println(service.getNumCount(request, response));
			
			boolean isFull = false;
			// 방인원 꽉차면 못들어가게(신청못하게)
			if ((service.getRoomNumApply(request, response).size()) >= service.getNumCount(request, response)) {
				isFull = true;
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('신청자가 꽉 찼습니다.');");
				out.println("location.href='list.apply'; ");
				out.println("</script>");
				out.flush();

			}

			// 이미 유저가 있으면 경고창 없으면, 신청
	
			for (String a : getApplyList) {
				if (a.equals(userid)) {
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<script>");
					out.println("alert('이미 신청한 방입니다.');");
					out.println("location.href='list.apply'; ");
					out.println("</script>");
					out.flush();
				}
			}
			
			if (userid != null && !isFull) {
				service.insertApply(request, response);
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('신청 완료.');");
				out.println("location.href='list.apply'; ");
				out.println("</script>");
				out.flush();
			}
			if( userid == null) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('신청 불가능한 유저(로그인 안한듯?)');");
				out.println("location.href='list.apply'; ");
				out.println("</script>");
				out.flush();
			}

		

		} else if (path.equals("/apply/selectseat.apply")) {

			ArrayList<String> closeSeat = service.getSeat(request, response);
			ArrayList<String> seatWH = service.getOptionWH(request, response);

			request.setAttribute("closeSeat", closeSeat);
			request.setAttribute("seatWH", seatWH);

			request.getRequestDispatcher("apply_selectSeat.jsp").forward(request, response);

		} else if (path.equals("/apply/seatApply.apply")) {

			// 유저를 기준으로 조회해서 없으면
			int userSelectSeat = service.getUserSelectSeat(request, response);
			int userSeat = service.getUserSeat(request, response);
			System.out.println(userSelectSeat);
			System.out.println(userSeat);

			// seat테이블 좌석이랑 apply테이블 유저가 선택한 자석이 없으면
			// 좌석 선태가능
			if (userSelectSeat == 0 && userSeat == 0) {
				service.seatInsert(request, response);
				service.applySeatUpdate(request, response);
				response.sendRedirect("resultPage.apply?roomnumber=" + request.getParameter("roomnumber"));
			} else {

				request.setAttribute("msg", "당신은 이미 신청했거나, 누군가 먼저 선택된 좌석입니다.");
				request.getRequestDispatcher("selectseat.apply?roomnumber=" + request.getParameter("roomnumber")).forward(request, response);

			}

		} else if (path.equals("/apply/resultPage.apply")) {
			ArrayList<String> closeSeat = service.getSeat(request, response);
			ArrayList<String> seatWH = service.getOptionWH(request, response);
			ArrayList<ApplyVO> allApplyUser = service.getRoomAllApply(request, response);

			HashMap<String, String> selectUser = new HashMap<String, String>();

			for (ApplyVO a : allApplyUser) {
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
		
		else if(path.equals("/apply/roomSetting.apply")) {
	
			String users = request.getParameter("users");
			ArrayList<String> userList = new ArrayList<>();
			if(users != null) {
				String[] user_arr = users.split(" ");
				
				for(String s : user_arr) {
					userList.add(s);
				}
			}
			Deque<String> remainUser = new ArrayDeque<>();
			int winNum = Integer.parseInt(request.getParameter("winNum")); //당첨인원
		    int width = Integer.parseInt(request.getParameter("width")); //가로
		    int height = Integer.parseInt(request.getParameter("height")); //세로
		    
		    HttpSession session = request.getSession();
		    session.setAttribute("width", width);
		    session.setAttribute("height", height);
		    session.setAttribute("winNum", winNum);
		    session.setAttribute("userList", userList);
		    session.setAttribute("remainUser", remainUser);
		    
			
			request.getRequestDispatcher("room_settingTable.jsp").forward(request, response);
		}
		
		else if(path.equals("/apply/random.apply")) {
			HttpSession session = request.getSession();
			ArrayList<String> userList = (ArrayList<String>)session.getAttribute("userList");
			Deque<String> remainUser = (Deque<String>)session.getAttribute("remainUser");
			int winningNum = (int)session.getAttribute("winNum");
			
			Set<String> winningUser = new HashSet<>();
			Random random = new Random();
			

			System.out.println(userList); 
			System.out.println(remainUser);
	 		System.out.println(winningUser);
	 		System.out.println(winningNum);
			
	
			if(userList.isEmpty()) {
				request.setAttribute("msg", "[더 이상 뽑을 유저가 없습니다.]");
				
			}else {
				if(userList.size() < winningNum) {
					winningUser.addAll(userList);
				}else {
					while(winningUser.size() != winningNum) {
						winningUser.add(userList.get(random.nextInt(userList.size())));
					}
				}
				
				userList.removeAll(winningUser); 
				for(String s : winningUser) {
					remainUser.addFirst(s);
				}
				
				System.out.println(userList); 
				System.out.println(remainUser);
		 		System.out.println(winningUser);
		 		System.out.println(winningNum);
		 		winningUser.clear();
				session.setAttribute("userList", userList);	
				session.setAttribute("remainUser", remainUser);
			
				
			}	
			request.getRequestDispatcher("room_settingTable.jsp").forward(request, response);
	 		
		}
		else if(path.equals("/apply/result.apply")) {
			
			request.getRequestDispatcher("room_result.jsp").forward(request, response);
		}

	}

}
