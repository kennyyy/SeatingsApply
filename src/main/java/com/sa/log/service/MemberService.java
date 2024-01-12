package com.sa.log.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sa.log.model.MemberVO;

public interface MemberService {

	public int join(HttpServletRequest request, HttpServletResponse response);
	
	public MemberVO login(HttpServletRequest request, HttpServletResponse response);
	
	public MemberVO getMemberInfo(HttpServletRequest request, HttpServletResponse response);
	
	public int update(HttpServletRequest request, HttpServletResponse response);
	
	public int delete(HttpServletRequest request, HttpServletResponse response);
}