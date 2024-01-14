package com.sa.apply.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sa.apply.model.ApplyVO;
import com.sa.apply.model.OptionVO;
import com.sa.apply.model.SeatVO;

public interface ApplyService {
	public ArrayList<ApplyVO> getApply (HttpServletRequest request, HttpServletResponse response);
	public ArrayList<ApplyVO> getAllApply (HttpServletRequest request, HttpServletResponse response);
	public int insertApply(HttpServletRequest request, HttpServletResponse response);
	public ArrayList<String> getRoomNumApply(HttpServletRequest request, HttpServletResponse response);
	public int allUserUpdateWin(HttpServletRequest request, HttpServletResponse response);
	
	public ArrayList<OptionVO> getOption (HttpServletRequest request, HttpServletResponse response);
	public ArrayList<String> getOptionWH(HttpServletRequest request, HttpServletResponse response);
	public int getNumCount(HttpServletRequest request, HttpServletResponse response);
	public int getUserSelectSeat(HttpServletRequest request, HttpServletResponse response);
	public ArrayList<String> getSeat (HttpServletRequest request, HttpServletResponse response);
	public ArrayList<ApplyVO> getIsWin (HttpServletRequest request, HttpServletResponse response);
	public int seatInsert(HttpServletRequest request, HttpServletResponse response);
	
	public int applySeatUpdate(HttpServletRequest request, HttpServletResponse response);
	public int getUserSeat(HttpServletRequest request, HttpServletResponse response);
	public ArrayList<ApplyVO> getRoomAllApply(HttpServletRequest request, HttpServletResponse response);
	public ArrayList<Integer> getUserRoomsNum(HttpServletRequest request, HttpServletResponse response);
	
}
