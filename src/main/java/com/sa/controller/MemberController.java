package com.sa.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sa.log.model.MemberVO;
import com.sa.log.service.MemberService;
import com.sa.log.service.MemberServiceImpl;

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
		
		//Join 화면
		if(path.equals("/member/join.member")) { 
			
			request.getRequestDispatcher("member_join.jsp").forward(request, response);
		}
		
		//회원가입
		else if(path.equals("/member/joinMem.member")) { 
			
			int result = service.join(request, response);
			
			if(result == 1) {
				request.setAttribute("msg", "아이디 중복입니다");
				request.getRequestDispatcher("member_join.jsp").forward(request, response);
			}
			else {
				response.sendRedirect("login.member");
			}
			System.out.println("실행결과 : " + result);
		}
		
		//Log In 화면
		else if(path.equals("/member/login.member")) {
			
			request.getRequestDispatcher("member_login.jsp").forward(request, response);
		}
		
		// Log In
		else if(path.equals("/member/loginMem.member")) { 
			
			MemberVO vo = service.login(request, response);
			
			if(vo != null) {
				
				HttpSession session = request.getSession();
				session.setAttribute("user_id", vo.getId());
				session.setAttribute("user_name", vo.getName());
				
				response.sendRedirect(request.getContextPath());
			}
			else {
				
				request.setAttribute("msg", "ID/PW를 확인하세요");
				request.getRequestDispatcher("member_login.jsp").forward(request, response);
			}
		}
		
		// Log Out
		else if(path.equals("/member/logout.member")) {
			
			HttpSession session = request.getSession();
			session.invalidate();
			
			response.sendRedirect(request.getContextPath());
		}
		
		//MYPAGE
		else if(path.equals("/member/mypage.member")) {
			
			request.getRequestDispatcher("member_mypage.jsp").forward(request, response);
		}
		
		//Update 조회
		else if(path.equals("/member/update.member")) {
			
			MemberVO vo = service.getMemberInfo(request, response);
			request.setAttribute("vo", vo);
			request.getRequestDispatcher("member_update.jsp").forward(request, response);
		}
		
		//Update 수정
		else if(path.equals("/member/updateMem.member")) {
			
			int result = service.update(request, response);
			
			if(result == 1) {
				
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('업데이트 성공')");
				out.println("location.href='mypage.member';");
				out.println("</script>");
			}
			else {
				
				response.sendRedirect("mypage.member");
			}
		}
		
		//Delete 화면
		else if(path.equals("/member/delete.member")) {
			
			request.getRequestDispatcher("member_delete.jsp").forward(request, response);
		}
		
		//Delete 요청
		else if(path.equals("/member/deleteMem.member")) {
			
			int result = service.delete(request, response);
			
			if(result == 1) {
				
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('삭제완료')");
				out.println("location.href='logout.member';");
				out.println("</script>");
			}
			else {
				
				request.setAttribute("msg", "비밀번호 재입력");
				request.getRequestDispatcher("member_delete.jsp").forward(request, response);
			}
		}
	
	}
}