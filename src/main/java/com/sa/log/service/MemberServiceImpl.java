package com.sa.log.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sa.log.model.MemberDAO;
import com.sa.log.model.MemberVO;

public class MemberServiceImpl implements MemberService {
	
	private MemberDAO dao = MemberDAO.getInstance();
	
	//회원가입
	@Override
	public int join(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String age = request.getParameter("age");
		String gender = request.getParameter("gender");
		String regdate = request.getParameter("regdate");
		String master = request.getParameter("master");
		String limitroom = request.getParameter("limitroom");
		
		int result = dao.idCheck(id);
		
		if(result == 1) {
			
			return 1;
			
		} else {
			
			MemberVO vo = new MemberVO(id, pw, name, email, address, age, gender, regdate, master, limitroom);
			dao.insertMember(vo);	
			
			return 0;
		}
	}
	
	//Log In
	@Override
	public MemberVO login(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MemberVO vo = dao.login(id, pw);
		System.out.println(vo.getMaster());
		return vo;
	}
	
	//Update 조회
	
	//MemberInfo
	@Override
	public MemberVO getMemberInfo(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("user_id");
		
		MemberVO vo = dao.getMemberInfo(id);
		
		return vo;
	}
	
	//Update
	@Override
	public int update(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String age = request.getParameter("age");
		String gender = request.getParameter("gender");
		String regdate = request.getParameter("regdate");
		String master = request.getParameter("master");
		String limitroom = request.getParameter("limitroom");
		
		MemberVO vo = new MemberVO(id, pw, name, email, address, age, gender, regdate, master, limitroom);
		int result = dao.update(vo);
		
		if(result == 1) {
			
			HttpSession session = request.getSession();
			session.setAttribute("user_name",  name);
		}
		
		return result;
	}
	
	//Delete
	@Override
	public int delete(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("user_id");
		String pw = request.getParameter("pw");
		
		MemberVO vo = dao.login(id, pw);
		
		if(vo != null) {
			
			dao.delete(id);
			
			return 1;
		}
		else {
			
			return 0;
		}
	}
	
	
	

}