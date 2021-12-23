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
import com.pojo.Student;
import com.pojo.Teacher;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BLManager bl = new BLManager();
	Student s = new Student();
	ClassInfo c = new ClassInfo();
	Teacher t = new Teacher();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter p = response.getWriter();
		
		String StudentName = request.getParameter("StudentName");
		String RegisterNo = request.getParameter("RegisterNumber");
		String className = request.getParameter("className");
		int teacherId = Integer.parseInt(request.getParameter("teacherId"));
		c = bl.searchByClassName(className);
		t = bl.searchByTeacherId(teacherId);
		s.setRegNo(RegisterNo);
		s.setClassInfo(c);
		s.setTeacher(t);
		s.setStudent(StudentName);
		bl.save(s);

		p.println("<script type=\"text/javascript\">");
		p.println("alert('Added successfully...');");
		p.println("location='Student.jsp';");
		p.println("</script>");
	}

}
