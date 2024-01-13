package com.sa.apply.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sa.apply.model.ApplyDAO;
import com.sa.apply.model.ApplyVO;
import com.sa.apply.model.OptionDAO;
import com.sa.apply.model.OptionVO;
import com.sa.apply.model.SeatDAO;
import com.sa.apply.model.SeatVO;

public class ApplyServiceImpl implements ApplyService {

	private ApplyDAO adao = ApplyDAO.getInstance();
	private OptionDAO odao = OptionDAO.getInstance();
	private SeatDAO sdao = SeatDAO.getInstance();

	@Override
	public ArrayList<ApplyVO> getApply(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<ApplyVO> list = adao.getApply();

		return list;
	}
	@Override
	public ArrayList<String> getRoomNumApply(HttpServletRequest request, HttpServletResponse response) {
		String roomnumber = request.getParameter("roomnumber");
		ArrayList<String> RoomNumApply = adao.getApply(roomnumber);
		
		return RoomNumApply;
	}
	@Override
	public int getUserSelectSeat(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("user_id");
		String roomnumber = request.getParameter("roomnumber");
		
		int result = adao.getApplySelectSeat(userid, roomnumber);

		return result;
	}
	public ArrayList<Integer> getUserRoomsNum(HttpServletRequest request, HttpServletResponse response) {

		ArrayList<Integer> nowUserRoomsNum = adao.getUserRoomsNum();

		return nowUserRoomsNum;
	}
	// 유저 신청 삽입
	@Override
	public int insertApply(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("user_id");
		String roomnumber = request.getParameter("roomnumber");

		int result = adao.insertUser(userid, roomnumber);
		return result;
	}
	@Override
	public int allUserUpdateWin(HttpServletRequest request, HttpServletResponse response) {
		int result = 0;
		String roomnumber = request.getParameter("roomnumber");
		result = adao.allUserUpdateWin(roomnumber);
		return result;
	}


	@Override
	public ArrayList<OptionVO> getOption(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<OptionVO> list = odao.getOption();

		return list;
	}

	// 방의 가로 세로 데이터를 가져옴
	@Override
	public ArrayList<String> getOptionWH(HttpServletRequest request, HttpServletResponse response) {
		String roomnumber = request.getParameter("roomnumber");
		ArrayList<String> seatWH = odao.getOptionWH(roomnumber);

		return seatWH;
	}



	@Override
	public ArrayList<String> getSeat(HttpServletRequest request, HttpServletResponse response) {
		String roomnumber = request.getParameter("roomnumber");
		ArrayList<SeatVO> list = sdao.getSeat(roomnumber);

		ArrayList<String> isCloseSeat = new ArrayList<String>();

		for (SeatVO s : list) {
			isCloseSeat.add(s.getSeat());
			System.out.println(s.getSeat());
		}
		request.setAttribute("roomnumber", roomnumber);
		return isCloseSeat;
	}
	
	public int getUserSeat(HttpServletRequest request, HttpServletResponse response) {
		int result = 0;
		String roomnumber = request.getParameter("roomnumber");
		String selectseat = request.getParameter("selectseat");
		
		result = sdao.getUserSeat(selectseat, roomnumber);
		
		
		return result;
	}
	

	@Override
	public ArrayList<ApplyVO> getIsWin(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("hi?");
		String roomnumber = request.getParameter("roomnumber");
		System.out.println(roomnumber);
		ArrayList<ApplyVO> iswin = adao.getIsWin(roomnumber);
		System.out.println(iswin);
		return iswin;
	}

	@Override
	public int getNumCount(HttpServletRequest request, HttpServletResponse response) {
		String roomnumber = request.getParameter("roomnumber");
		
		int numCount = odao.getNumCount(roomnumber);

		return numCount;
	}
	
	@Override
	public int seatInsert(HttpServletRequest request, HttpServletResponse response) {
		String selectseat = request.getParameter("selectseat");
		String roomnumber = request.getParameter("roomnumber");
		
		int result = sdao.selectSeatInSert(selectseat, roomnumber);
		
		
		return result;
	}
	public int applySeatUpdate(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String userid = (String)session.getAttribute("user_id");
		String roomnumber = request.getParameter("roomnumber");
		String selectseat = request.getParameter("selectseat");
	
		int result = adao.applySeatUpdate(userid, roomnumber, selectseat);
		
		return result;
	}

	@Override
	public void startRandomSeat(HttpServletRequest request, HttpServletResponse response) {
		String roomnumber = request.getParameter("roomnumber");
		int winningNum = 3;
		ArrayList<String> applyUserList = adao.getApply(roomnumber);
		Set<String> winningUser = new HashSet<>();
		Random random = new Random();

		while(applyUserList.size() >= winningNum) {
			while(winningUser.size() != winningNum) {
				winningUser.add(applyUserList.get(random.nextInt(applyUserList.size())));
			}
			 
	 		applyUserList.removeAll(winningUser); 
	 		winningUser.clear();
	 		System.out.println(applyUserList); 
	 		System.out.println(winningUser); 
		
			 
		}
		
		System.out.println(applyUserList); 
 		 

	}
	@Override
	public ArrayList<ApplyVO> getAllApply(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<ApplyVO> user = adao.getAllApply();
		return user;
	}

}
