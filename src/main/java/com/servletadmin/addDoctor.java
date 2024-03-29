package com.servletadmin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.doctordao;
import com.entity.doctor;
import com.util.dbconnection;

/**
 * Servlet implementation class addDoctor
 */
public class addDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addDoctor() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	try {
		String fullName = req.getParameter("fullname");
		String dob = req.getParameter("dob");
		String qualification = req.getParameter("qualification");

		String spec = req.getParameter("spec");

		String email = req.getParameter("email");
		String mobno = req.getParameter("mobno");
		String password = req.getParameter("password");
		doctor d = new doctor(fullName, dob, qualification, spec, email, mobno, password);
		doctordao dao = new doctordao(dbconnection.getcon());
		HttpSession session = req.getSession();

		if (dao.registerdoctor(d)) {
			session.setAttribute("succMsg", "Doctor Added Sucessfully..");
			resp.sendRedirect("admin/doctor.jsp");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
			resp.sendRedirect("admin/doctor.jsp");
		}

	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}

}
