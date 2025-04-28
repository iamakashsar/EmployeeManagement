package com.EmployeeDataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseDriver {

	private static String url="jdbc:postgresql://localhost:5432/employeeservice?user=postgres&password=Akash";
	private static Connection con;
	static {
		try {
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection(url);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int insert(Employee e) throws SQLException {
		String sql="insert into employee values(?,?,?,?,?,?,?)";
		PreparedStatement s=con.prepareStatement(sql);
		
		s.setInt(1, e.getId());
		s.setString(2, e.getName());
		s.setInt(3, e.getAge());
		s.setString(4, e.getGender());
		s.setString(5, e.getEmail());
		s.setString(6, e.getPhno());
		s.setDouble(7, e.getSalary());
		
		return s.executeUpdate();
		
	}
	public int delete(int id) throws SQLException {
		String sql="delete from employee where id=?";
		PreparedStatement pt = con.prepareStatement(sql);
		
		
		pt.setInt(1,id);
		int i= pt.executeUpdate();
		
		return i;
	}
	public int update(int id , String name,int age,String gender, String email,String phno ,double salary) throws SQLException {
		
		String sql="update employee set name=?,age=?,gender=?,email=?,phno=?,salary=? where id=?";
		PreparedStatement pt = con.prepareStatement(sql);
		
		
		pt.setString(1, name);
		pt.setInt(2,age);
		pt.setString(3, gender);
		pt.setString(4, email);
		pt.setString(5, phno);
		pt.setDouble(6, salary);
		pt.setInt(7, id);
		
		return pt.executeUpdate();
	}
		
		
}
