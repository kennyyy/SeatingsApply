package com.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.service.MemberService;
import com.member.service.MemberServiceImpl;

@WebServlet("*.member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberController() {
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
		
		MemberService service = new MemberServiceImpl();
		
		if(path.equals("/member/join.member")) { //Join
			
			request.getRequestDispatcher("member_join.jsp").forward(request, response);
		}
	
		else if(path.equals("/member/joinMem.member")) {
			
			
			
		}
		
		
		
		
		
		
		
		else if(path.equals("/member/loginMem.member")) { //Log In
			
			request.getRequestDispatcher("member_login.jsp").forward(request, response);
		}
		
		
		
		
	
	
	}
}