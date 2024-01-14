package com.sa.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sa.log.model.MemberVO;

@WebFilter({"*.roomSet"})
public class RoomSettingFilter implements Filter{
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
	HttpServletRequest req = (HttpServletRequest)request;
	HttpServletResponse res = (HttpServletResponse)response;
	
	HttpSession session = req.getSession();
	String user_id = (String)session.getAttribute("user_id");
	String user_master = (String)session.getAttribute("user_master");
	
	MemberVO vo = new MemberVO();
	
	if(user_id == null || user_master.equals("U")) {
		res.setContentType("text/html; charset=UTF-8;");
		PrintWriter out = res.getWriter();
		out.println("<script>");
		out.println("alert('권한이 없습니다.');");
		out.println("location.href='../index.jsp';");
		out.println("</script>");
		return;
	}
	chain.doFilter(request, response);
}

	
	
	

}