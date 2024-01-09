package com.member.service;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.model.MemberDAO;
import com.member.model.MemberVO;

public class MemberServiceImpl implements MemberService {
	
	private MemberDAO dao = MemberDAO.getInstance();
	
	@Override
	public int join(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		int age = request.getParameter("age");
		String gender = request.getParameter("gender");
		Timestamp regdate = request.getParameter("regdate");
		String master = request.getParameter("master");
		
		int result = dao.idCheck(id);
		
		if(result == 1) {
			return 1;
		} else {
			MemberVO vo = new MemberVO(id, pw, name, email, address, age, gender, regdate, null, null);
			dao.insertUser(vo);		
			return 0;
		}
		
		
		return 0;
	}
	

}
