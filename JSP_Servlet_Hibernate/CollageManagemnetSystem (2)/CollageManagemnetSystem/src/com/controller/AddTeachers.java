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
import com.pojo.Department;
import com.pojo.Teacher;

/**
 * Servlet implementation class AddTeachers
 */
@WebServlet("/AddTeachers")
public class AddTeachers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BLManager bl = new BLManager();
	Teacher t = new Teacher();
	Department d = new Department();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter p = response.getWriter();

		String Name = request.getParameter("Name");
		String Address = request.getParameter("Address");
		String Gender = request.getParameter("Gender");
		String Salary = request.getParameter("Salary");
		String departmentName = request.getParameter("departmentName");

		d = bl.searchByDepartmentName(departmentName);

		t.setAddress(Address);
		t.setName(Name);
		t.setGender(Gender);
		t.setSalary(Salary);
		t.setDepartment(d);
		bl.save(t);

		p.println("<script type=\"text/javascript\">");
		p.println("alert('Added successfully...');");
		p.println("location='Teachers.jsp';");
		p.println("</script>");
	}

}
