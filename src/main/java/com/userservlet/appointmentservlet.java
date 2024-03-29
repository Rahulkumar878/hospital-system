package com.userservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.appointmentdao;
import com.entity.appointment;
import com.util.dbconnection;

/**
 * Servlet implementation class appointmentservlet
 */
public class appointmentservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public appointmentservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int userId = Integer.parseInt(req.getParameter("userid"));
		String fullname = req.getParameter("fullname");
		String gender = req.getParameter("gender");
		String age = req.getParameter("age");
		String appoint_date = req.getParameter("appoint_date");
		String email = req.getParameter("email");
		String phno = req.getParameter("phno");
		String diseases = req.getParameter("diseases");
		int doctor_id = Integer.parseInt(req.getParameter("doct"));
		String address = req.getParameter("address");

		appointment ap = new appointment(userId, fullname, gender, age, appoint_date, email, phno, diseases, doctor_id,
				address, "Pending");

		appointmentdao dao = new appointmentdao(dbconnection.getcon());
		HttpSession session = req.getSession();

		if (dao.addAppointment(ap)) {
			session.setAttribute("succ", "Appointment Sucessfully");
			resp.sendRedirect("userappointment.jsp");
		} else {
			session.setAttribute("err", "Something wrong on server");
			resp.sendRedirect("userappointment.jsp");
		}

	}
	}


