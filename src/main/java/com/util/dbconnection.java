package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbconnection {
private static Connection con;
public  static Connection getcon()
{
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ hotelmanagment","root","Rahulkumar@123");
	}
	catch(Exception e)
	{
		e.printStackTrace();
		}
	return con;
}
}
