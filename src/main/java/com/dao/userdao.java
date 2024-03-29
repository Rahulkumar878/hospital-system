package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.user;

public class userdao {
private Connection conn;

public userdao(Connection conn) {
	super();
	this.conn = conn;
}

public boolean userregister(user u)
{
	boolean f=false;
	try {
		String query="insert into details(fullname,email,password)values(?,?,?) ";
		PreparedStatement ps=conn.prepareStatement(query);
		ps.setString(1,u.getFullname());
		ps.setString(2, u.getEmail());
		ps.setString(3, u.getPassword());
	int i=ps.executeUpdate();
	if(i==1)
	{
		f=true;
	}
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return f;
}
public user login(String email,String password)
{
	user u=null;
	try {
		String query="select *from details where email=? and password=?";
		PreparedStatement st=conn.prepareStatement(query);
		st.setString(1, email);
		st.setString(2, password);
		ResultSet rs=st.executeQuery();	
		while(rs.next())
		{
			u=new user();
			u.setId(rs.getInt(1));
			u.setFullname(rs.getString(2));
			u.setEmail(rs.getString(3));
			u.setPassword(rs.getString(4));
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return u;
}
}
