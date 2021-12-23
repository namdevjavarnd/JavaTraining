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
 * Servlet implementation class AddClasses
 */
@WebServlet("/AddClasses")
public class AddClasses extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BLManager bl = new BLManager();
	ClassInfo c = new ClassInfo();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter p = response.getWriter();

		String Name = request.getParameter("Name");

		c.setName(Name);
		bl.save(c);

		p.println("<script type=\"text/javascript\">");
		p.println("alert('Added successfully...');");
		p.println("location='Classes.jsp';");
		p.println("</script>");
	}

}
