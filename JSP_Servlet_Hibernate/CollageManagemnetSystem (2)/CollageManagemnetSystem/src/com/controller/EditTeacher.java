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
import com.pojo.Department;
import com.pojo.Teacher;

/**
 * Servlet implementation class EditTeacher
 */
@WebServlet("/EditTeacher")
public class EditTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BLManager bl = new BLManager();
	Teacher teacher = null;
	ClassInfo c = new ClassInfo();
	Department d = new Department();
	Teacher t = new Teacher();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int techId = Integer.parseInt(request.getParameter("techId"));
		HttpSession session = request.getSession();
		teacher = bl.searchByTeacherId(techId);
		session.setAttribute("teacher", teacher);
		RequestDispatcher rd = request.getRequestDispatcher("EditTeacher.jsp");
		rd.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter p = response.getWriter();
		int techId = Integer.parseInt(request.getParameter("ID"));
		String Name = request.getParameter("Name");
		String Address = request.getParameter("Address");
		String Gender = request.getParameter("Gender");
		String Salary = request.getParameter("Salary");
		String departmentName = request.getParameter("departmentName");

		d = bl.searchByDepartmentName(departmentName);
		t= bl.searchByTeacherId(techId);
		
		t.setAddress(Address);
		t.setName(Name);
		t.setGender(Gender);
		t.setSalary(Salary);
		t.setDepartment(d);
		bl.update(t);

		p.println("<script type=\"text/javascript\">");
		p.println("alert('Edited successfully...');");
		p.println("location='ViewAllTeachers.jsp';");
		p.println("</script>");
	}

}
