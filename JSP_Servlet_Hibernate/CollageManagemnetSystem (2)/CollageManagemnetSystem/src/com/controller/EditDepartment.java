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
import com.pojo.Department;

/**
 * Servlet implementation class EditDepartment
 */
@WebServlet("/EditDepartment")
public class EditDepartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BLManager bl = new BLManager();
	Department department = null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int deptId = Integer.parseInt(request.getParameter("deptId"));
		HttpSession session = request.getSession();
		department = bl.searchByDepartmentId(deptId);
		session.setAttribute("department", department);
		RequestDispatcher rd = request.getRequestDispatcher("EditDepartment.jsp");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter p = response.getWriter();
		int deptId = Integer.parseInt(request.getParameter("ID"));
		String Name = request.getParameter("Name");
		String HOD = request.getParameter("HOD");
		String Location = request.getParameter("Location");
		department = bl.searchByDepartmentId(deptId);
		department.setName(Name);
		department.setHod(HOD);
		department.setLocation(Location);
		
		bl.update(department);

		p.println("<script type=\"text/javascript\">");
		p.println("alert('Edited successfully...');");
		p.println("location='ViewAllDepartment.jsp';");
		p.println("</script>");
		doGet(request, response);
	}

}
