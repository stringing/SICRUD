package individual.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import indiviudual.domain.Student;
import indiviudual.form.StudentForm;

public class DAO{
	public static void create(Student student) throws ClassNotFoundException, SQLException{
		Connection con = new StudentForm().init();
		String sql = 
				"INSERT INTO INFO VALUES("+"'"+student.getID()+"',"+"'"+student.getName()+
				"',"+"'"+student.getSex()+"',"+"'"+student.getClassnumber()+"',"+student.getgpa()+")";
		Statement stmt = con.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
		con.close();
	}
	public static void delete(String id) throws ClassNotFoundException, SQLException{
		Connection con = new StudentForm().init();
		String sql = "DELETE FROM INFO WHERE ID='"+id+"'";
		Statement stmt = con.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
		con.close();
	}
	public static void update(Student student) throws ClassNotFoundException, SQLException{
		Connection con = new StudentForm().init();
		String sql = "UPDATE INFO SET NAME='"+student.getName()+"' WHERE ID='"+student.getID()+"'";
		String sql2 = "UPDATE INFO SET GENDER='"+student.getSex()+"' WHERE ID='"+student.getID()+"'";
		String sql3 = "UPDATE INFO SET CLASS='"+student.getClassnumber()+"' WHERE ID='"+student.getID()+"'";
		String sql4 = "UPDATE INFO SET GPA='"+student.getgpa()+"' WHERE ID='"+student.getID()+"'";
		Statement stmt = con.createStatement();
		stmt.executeUpdate(sql);
		stmt.executeUpdate(sql2);
		stmt.executeUpdate(sql3);
		stmt.executeUpdate(sql4);
		stmt.close();
		con.close();
	}
	public static Student retrieve(String id) throws ClassNotFoundException, SQLException{
		Connection con = new StudentForm().init();
		Student student = new Student();
		String sql = "SELECT * FROM INFO";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()){
			if(rs.getString("ID").equals(id)){
				student.setID(id);
				student.setName(rs.getString("NAME"));
				student.setSex(rs.getString("GENDER"));
				student.setClassnumber(rs.getString("CLASS"));
				student.setgpa(rs.getString("GPA"));
				break;
			}
		}
		rs.close();
		stmt.close();
		con.close();
		return student;
	}

}
