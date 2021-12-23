package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.BLManager;
import com.pojo.Department;

/**
 * Servlet implementation class AddDepartment
 */
@WebServlet("/AddDepartment")
public class AddDepartment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Department d = new Department();
	BLManager bl = new BLManager();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter p = response.getWriter();

		String Name = request.getParameter("Name");
		String HOD = request.getParameter("HOD");
		String Location = request.getParameter("Location");

		d.setName(Name);
		d.setHod(HOD);
		d.setLocation(Location);
		bl.save(d);

		p.println("<script type=\"text/javascript\">");
		p.println("alert('Added successfully...');");
		p.println("location='Department.jsp';");
		p.println("</script>");
	}

}
