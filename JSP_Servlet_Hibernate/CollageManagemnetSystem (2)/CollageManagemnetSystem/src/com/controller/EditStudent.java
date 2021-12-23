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
import com.pojo.Student;
import com.pojo.Teacher;

/**
 * Servlet implementation class EditStudent
 */
@WebServlet("/EditStudent")
public class EditStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BLManager bl = new BLManager();
	Student student = null;
	ClassInfo c = new ClassInfo();
	Teacher t = new Teacher();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int stdId = Integer.parseInt(request.getParameter("stdId"));
		HttpSession session = request.getSession();
		student = bl.searchByStudentId(stdId);
		session.setAttribute("student", student);
		RequestDispatcher rd = request.getRequestDispatcher("EditStudent.jsp");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter p = response.getWriter();
		int studId = Integer.parseInt(request.getParameter("ID"));
		String StudentName = request.getParameter("StudentName");
		String RegisterNumber = request.getParameter("RegisterNumber");
		String className = request.getParameter("className");
		int teacherId = Integer.parseInt(request.getParameter("teacherId"));
		student = bl.searchByStudentId(studId);
		c = bl.searchByClassName(className);
		t = bl.searchByTeacherId(teacherId);

		student.setRegNo(RegisterNumber);
		student.setClassInfo(c);
		student.setTeacher(t);
		student.setStudent(StudentName);
		
		bl.update(student);

		p.println("<script type=\"text/javascript\">");
		p.println("alert('Edited successfully...');");
		p.println("location='ViewAllStudent.jsp';");
		p.println("</script>");
		doGet(request, response);
	}

}
