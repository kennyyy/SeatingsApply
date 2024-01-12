package com.sa.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sa.other.model.OtherVO;
import com.sa.other.service.OtherService;
import com.sa.other.service.OtherServiceImpl;

@WebServlet("*.other")
public class OtherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OtherController() {
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
		
		System.out.println(path);
		
		OtherService service = new OtherServiceImpl();
		
		//목록
		if(path.equals("/list.other")) {
			ArrayList<OtherVO> list = service.getList(request, response);
			request.setAttribute("list",  list);
			request.getRequestDispatcher("/other/other_list.jsp").forward(request, response);
		}
		
		//글작성 화면
		else if(path.equals("/write.other")) {
			request.getRequestDispatcher("/other/other_write.jsp").forward(request, response);
		}
		
		//글등록
		else if(path.equals("/registOth.other")) {
			
			service.regist(request, response);
			
			response.sendRedirect("/list.other");
			
		}
		
		//조회수
		else if(path.equals("/content.other")) {
			
			service.hitUpdate(request, response);
			OtherVO vo = service.getContent(request, response);
			request.setAttribute("vo", vo);
			
			request.getRequestDispatcher("/other/other_content.jsp").forward(request, response);
		}
		
		//수정
		else if(path.equals("/modify.other")) {
			
			OtherVO vo = service.getContent(request, response);
			request.setAttribute("vo", vo);
			request.getRequestDispatcher("/other/other_modify.jsp").forward(request, response);
		}
		
		else if(path.equals("/update.other")) {
			
			int result = service.update(request, response);
			System.out.println(result);
			if(result == 1 ) {
				response.sendRedirect("content.other?bno=" + request.getParameter("bno"));
			}
			else {
				response.sendRedirect("modify.other?bno=" + request.getParameter("bno"));
			}
		}
			
		else if(path.equals("/delete.other")) {
			
			service.delete(request, response);
			response.sendRedirect("/list.other");
			
		}
		
		
		
		
			
		}	
	}