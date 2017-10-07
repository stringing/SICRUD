package indiviudal.controller;

import individuail.utils.WebUtil;
import individual.dao.DAO;
import indiviudual.domain.Student;
import indiviudual.form.StudentForm;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RetrieveServletD extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudentForm sf = WebUtil.request2Form(request, StudentForm.class);
		Student student = new Student();
		WebUtil.copyBean(sf, student);
		try {
			boolean flag = sf.validate4DUR();
			if(!flag){
				request.setAttribute("message", sf.getErrors().get("message"));
				request.getRequestDispatcher("/WEB-INF/jsp/retrieve.jsp").forward(request, response);
				return;
			}
			Student student2 = DAO.retrieve(student.getID());
			request.setAttribute("id", "学号："+student2.getID());
			request.setAttribute("name", "姓名："+student2.getName());
			request.setAttribute("sex", "性别："+student2.getSex());
			request.setAttribute("classnumber", "班级："+student2.getClassnumber());
			request.setAttribute("gpa", "绩点："+student2.getgpa());
			request.getRequestDispatcher("/WEB-INF/jsp/retrieve.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
