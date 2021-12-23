package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.BLManager;
import com.pojo.ClassInfo;

/**
 * Servlet implementation class EditClasses
 */
@WebServlet("/EditClasses")
public class EditClasses extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BLManager bl = new BLManager();
	ClassInfo classInfo = new ClassInfo();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int classId = Integer.parseInt(request.getParameter("classId"));
		HttpSession session = request.getSession();
		classInfo = bl.searchByClassId(classId);
		session.setAttribute("classInfo", classInfo);
		RequestDispatcher rd = request.getRequestDispatcher("EditClasses.jsp");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter p = response.getWriter();
		int classId = Integer.parseInt(request.getParameter("ID"));
		String Name = request.getParameter("Name");
		classInfo = bl.searchByClassId(classId);
		classInfo.setName(Name);
		
		bl.update(classInfo);

		p.println("<script type=\"text/javascript\">");
		p.println("alert('Edited successfully...');");
		p.println("location='ViewAllClasses.jsp';");
		p.println("</script>");
		doGet(request, response);
	}

}
