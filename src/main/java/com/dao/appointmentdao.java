package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.appointment;
import com.mysql.cj.protocol.Resultset;

public class appointmentdao {
	private Connection conn;

	public appointmentdao(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addAppointment(appointment ap) {
		boolean f = false;

		try {

			String sql = "insert into appointment_table(userid,fullname,gender,age,appoindate,email,phone,diseases,doctorid,address,status) values(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ap.getUserId());
			ps.setString(2, ap.getFullName());
			ps.setString(3, ap.getGender());
			ps.setString(4, ap.getAge());
			ps.setString(5, ap.getAppoinDate());
			ps.setString(6, ap.getEmail());
			ps.setString(7, ap.getPhNo());
			ps.setString(8, ap.getDiseases());
			ps.setInt(9, ap.getDoctorId());
			ps.setString(10, ap.getAddress());
			ps.setString(11, ap.getStatus());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public List<appointment> getAllAppointmentByLoginUser(int userId)
	{ 
		List<appointment>list=new ArrayList<appointment>();
		appointment ap=null;
		try {
			String sql="select *from appointment_table where userid=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1,userId);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				ap = new appointment();

				ap.setId(rs.getInt(1));

				ap.setUserId(rs.getInt(2));

				ap.setFullName(rs.getString(3));

				ap.setGender(rs.getString(4));
				ap.setAge(rs.getString(5));

				ap.setEmail(rs.getString(7));
				ap.setPhNo(rs.getString(8));

				ap.setAppoinDate(rs.getString(6));
				ap.setDiseases (rs.getString(9));
				ap.setDoctorId(rs.getInt(10));
				ap.setAddress(rs.getString(11));
				ap.setStatus(rs.getString(12));

				list.add(ap);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	
	public List<appointment> getAllAppointmentByDoctorLogin(int doctorId)
	{ 
		List<appointment>list=new ArrayList<appointment>();
		appointment ap=null;
		try {
			String sql="select *from appointment_table where doctorid=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1,doctorId);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				ap = new appointment();

				ap.setId(rs.getInt(1));

				ap.setUserId(rs.getInt(2));

				ap.setFullName(rs.getString(3));

				ap.setGender(rs.getString(4));
				ap.setAge(rs.getString(5));

				ap.setEmail(rs.getString(7));
				ap.setPhNo(rs.getString(8));

				ap.setAppoinDate(rs.getString(6));
				ap.setDiseases (rs.getString(9));
				ap.setDoctorId(rs.getInt(10));
				ap.setAddress(rs.getString(11));
				ap.setStatus(rs.getString(12));

				list.add(ap);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	public appointment getAllAppointmentById(int id)
	{ 
		List<appointment>list=new ArrayList<appointment>();
		appointment ap=null;
		try {
			String sql="select *from appointment_table where id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				ap = new appointment();

				ap.setId(rs.getInt(1));

				ap.setUserId(rs.getInt(2));

				ap.setFullName(rs.getString(3));

				ap.setGender(rs.getString(4));
				ap.setAge(rs.getString(5));

				ap.setEmail(rs.getString(7));
				ap.setPhNo(rs.getString(8));

				ap.setAppoinDate(rs.getString(6));
				ap.setDiseases (rs.getString(9));
				ap.setDoctorId(rs.getInt(10));
				ap.setAddress(rs.getString(11));
				ap.setStatus(rs.getString(12));

				list.add(ap);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ap;
	}
	public boolean updatecommentstatus(int id,int doctid,String comm)
	{
		boolean f=false;
		try {
			String sql="update appointment_table set status=? where id=? and doctorid=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, comm);
			ps.setInt(2, id);
			ps.setInt(3, doctid);
			int i=ps.executeUpdate();
			System.out.print(doctid);
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
}
