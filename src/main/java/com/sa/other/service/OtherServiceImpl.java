package com.sa.other.service;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sa.other.model.OtherDAO;
import com.sa.other.model.OtherVO;

public class OtherServiceImpl implements OtherService{
	
	private OtherDAO dao = OtherDAO.getInstance();
	
	@Override
	public ArrayList<OtherVO> getList(HttpServletRequest request, HttpServletResponse response) {

		ArrayList<OtherVO> list = dao.getList();
		
		return list;
	}
	
	@Override
	public void regist(HttpServletRequest request, HttpServletResponse response) {
		
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		dao.insert(writer, title, content);
	}
	
	@Override
	public OtherVO getContent(HttpServletRequest request, HttpServletResponse response) {
		
		String bno = request.getParameter("bno");
		OtherVO vo = dao.getContent(bno);
		
		return vo;
	}
	
	@Override
	public int update(HttpServletRequest request, HttpServletResponse response) {
		
		String bno = request.getParameter("bno");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		int result = dao.update(bno, title, content);
		
		return result;
	}
	
	public void delete(HttpServletRequest request, HttpServletResponse response) {
		
		String bno = request.getParameter("bno");
		dao.delete(bno);
		
	}
	
	@Override
	public void hitUpdate(HttpServletRequest request, HttpServletResponse response) {
		
		String bno = request.getParameter("bno");
		
		String cooValue = "";
		boolean flag = true;
		Cookie[] arr = request.getCookies();
		if(arr != null) {
			for(Cookie c : arr) {
				if(c.getName().equals("hit")) {
					cooValue = c.getValue();
					if(c.getValue().contains(bno)) {
						System.out.println(true);
						flag = false;
					}
				}
			}
		}
		if(flag) {
			dao.hitUpdate(bno);
			cooValue += bno + "-";
		}
		
		Cookie coo = new Cookie("hit", cooValue);
		coo.setMaxAge(30);
		response.addCookie(coo);;
	}
	
	
	
}