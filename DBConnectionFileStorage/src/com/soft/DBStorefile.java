package com.soft;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DBStorefile {

	public static void main(String[] args)throws ClassNotFoundException,SQLException {
		
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the Id::");
			int id = sc.nextInt();
			System.out.println("Enter the file path::");
		
			String filepath1 = "C:\\Users\\dell\\Documents\\storefile\\user_icon.png";
			
			File file = new File(sc.next());
			
			//System.out.println(file.getName());
			
			FileInputStream fis = new FileInputStream(file);
			
			//System.out.println(fis.toString());
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
			
			PreparedStatement ps = con.prepareStatement("insert into bank.file_store_db values(?,?)");
			ps.setInt(1, id);
			ps.setBinaryStream(2, fis,(int)file.length());
			
			int k = ps.executeUpdate();
			
			if(k>0) {
				System.out.println("file stored sucessfully...");
			}else {
				System.out.println("file not stored sucessfully...");
			}
			
		} catch (Exception e) {
			
		}

	}

}
