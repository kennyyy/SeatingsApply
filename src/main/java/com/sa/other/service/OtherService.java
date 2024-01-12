package com.sa.other.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sa.other.model.OtherVO;

public interface OtherService {

	public ArrayList<OtherVO> getList(HttpServletRequest request, HttpServletResponse response);
	
	public void regist(HttpServletRequest request, HttpServletResponse response);
	
	public OtherVO getContent(HttpServletRequest request, HttpServletResponse response);
	
	public int update(HttpServletRequest request, HttpServletResponse response);
	
	public void delete(HttpServletRequest request, HttpServletResponse response);
	
	public void hitUpdate(HttpServletRequest request, HttpServletResponse response);
}