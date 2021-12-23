package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.BLManager;
import com.pojo.ClassInfo;

/**
 * Servlet implementation class DeleteClasses
 */
@WebServlet("/DeleteClasses")
public class DeleteClasses extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BLManager bl = new BLManager();
	ClassInfo c = new ClassInfo();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter p = response.getWriter();
		int classId = Integer.parseInt(request.getParameter("classId"));
		c = bl.searchByClassId(classId);
		bl.delete(c);
		p.println("<script type=\"text/javascript\">");
		p.println("alert('deleted Successfully');");
		p.println("location='ViewAllClasses.jsp';");
		p.println("</script>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
