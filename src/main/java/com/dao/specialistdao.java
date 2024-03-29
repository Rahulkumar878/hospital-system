package com.dao;
import com.entity.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class specialistdao {
	private Connection conn;

	public specialistdao(Connection conn) {
		super();
		this.conn = conn;
	}
	public boolean addspecialist(String spec)
	{
		boolean f=false;
				try {
			String sql="insert into specialist(spec_name)values(?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, spec);
			int i=ps.executeUpdate();
			if(i==1)
			{
				f=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				return f;
	}
 public List<specialist> getAllspecialList()
 {
	 List<specialist>list=new ArrayList<specialist>();
	 specialist s=null;
	 try {
		String query="select *from specialist" ;
		PreparedStatement ps=conn.prepareStatement(query);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			s=new specialist();
			s.setId(rs.getInt(1));
			s.setSpecialistname(rs.getString(2));
			list.add(s);
			
		}
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	 return list;
 }
}
