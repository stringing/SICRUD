package indiviudual.form;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class StudentForm {
	static{
		
	}
	private String ID;
	private String name;
	private String sex;
	private String classnumber;
	private String gpa;
	public String getID() {
		return ID;
	}
	public void setID(String ID) {
		this.ID = ID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getClassnumber() {
		return classnumber;
	}
	public void setClassnumber(String classnumber) {
		this.classnumber = classnumber;
	}
	public String getgpa() {
		return gpa;
	}
	public void setgpa(String gpa) {
		this.gpa = gpa;
	}
	public Map<String, String> getErrors() {
		return errors;
	}
	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}
	private Map<String, String> errors = new HashMap();
	
	public Connection init() throws ClassNotFoundException, SQLException{
		String driverClassName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/STUDENT?useSSL=false";
		String user = "root";
		String password = "root";
		Class.forName(driverClassName);
		Connection con = DriverManager.getConnection(url, user, password);
		return con;
	}
	
	public boolean validate4Create() throws ClassNotFoundException, SQLException{
		boolean flag = true;
		Connection con = init();
		String sql = "SELECT * FROM INFO";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()){
			String id = rs.getString("ID");
			System.out.println(this.ID+"dedaode:"+id);
			if(this.ID.equals(id)){
				flag=false;
				errors.put("message", "该学生信息已存在！");
				break;
			}
		}
		stmt.close();
		con.close();
		return flag;
	}
	
	public boolean validate4DUR() throws ClassNotFoundException, SQLException{
		boolean flag = false;
		Connection con = init();
		String sql = "SELECT * FROM INFO";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		errors.put("message", "该学生信息不存在！");
		while(rs.next()){
			String id = rs.getString("ID");
			if(ID.equals(id)){
				flag=true;
				errors.remove("message");
				break;
			}
		}
		return flag;
	}
}
