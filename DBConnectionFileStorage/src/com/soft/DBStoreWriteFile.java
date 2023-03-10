package com.soft;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DBStoreWriteFile {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Id::");
		int id = sc.nextInt();
		System.out.println("Enter the file Destionation::");
		File  file = new File(sc.next());
		
		FileOutputStream fos = new FileOutputStream(file);
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
		
		PreparedStatement ps = con.prepareStatement("select * from bank.file_store_db where id=?");
		ps.setInt(1, id);
		
		ResultSet rs= ps.executeQuery();
		
		if(rs.next()) {
			Blob b = rs.getBlob(2);
			byte [] byete = b.getBytes(1, (int)b.length());
			fos.write(byete);
			System.out.println("file write sucessfuly..");
		}else {
			System.out.println("file couldnt write sucessfully..");
		}
		
	}

}
