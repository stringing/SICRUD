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

public class DeleteServletD extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudentForm sf = WebUtil.request2Form(request, StudentForm.class);
		Student student = new Student();
		WebUtil.copyBean(sf, student);
		try {
			boolean flag = sf.validate4DUR();
			if(!flag){
				request.setAttribute("message", sf.getErrors().get("message"));
				request.getRequestDispatcher("/WEB-INF/jsp/delete.jsp").forward(request, response);
				return;
			}
			DAO.delete(student.getID());
			System.out.print(student.getID());
			request.setAttribute("message", "学生信息删除成功！");
			request.getRequestDispatcher("/WEB-INF/jsp/delete.jsp").forward(request, response);
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
