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

public class CreateServletD extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudentForm sf = WebUtil.request2Form(request, StudentForm.class);
		Student student = new Student();
		WebUtil.copyBean(sf, student);
		System.out.println(student.getID());
		System.out.println(student.getName());
		System.out.println(student.getSex());
		System.out.println(student.getClassnumber());
		System.out.println(student.getgpa());
		try {
			boolean flag = sf.validate4Create();
			System.out.println(flag);
			if(!flag){
				System.out.print("laile!");
				request.setAttribute("message", sf.getErrors().get("message"));
				request.getRequestDispatcher("/WEB-INF/jsp/create.jsp").forward(request, response);
				return;
			}
			DAO.create(student);
			request.setAttribute("message", "学生信息添加成功！");
			request.getRequestDispatcher("/WEB-INF/jsp/create.jsp").forward(request, response);
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
