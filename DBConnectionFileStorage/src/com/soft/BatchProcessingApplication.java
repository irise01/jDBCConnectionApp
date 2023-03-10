package com.soft;

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BatchProcessingApplication {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Scanner sc = new Scanner(System.in);
		System.out.println("EmpId");
		int id = sc.nextInt();
		System.out.println("EmpName");
		String empName = sc.next();
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
		
		PreparedStatement ps = con.prepareStatement("insert into emp values(?,?)");
		ps.setInt(1, id);
		ps.setString(2, empName);
		ps.addBatch();
		
		ps.executeBatch();
		
		PreparedStatement ps1 = con.prepareStatement("insert into emp1 values(?,?)");
		ps1.setInt(1, id);
		ps1.setString(2, empName);
		ps1.addBatch();
		ps1.executeBatch();
		
	}

}
