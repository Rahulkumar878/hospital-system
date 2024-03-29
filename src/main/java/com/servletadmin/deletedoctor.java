package com.servletadmin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.doctordao;
import com.util.dbconnection;

/**
 * Servlet implementation class deletedoctor
 */
public class deletedoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deletedoctor() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		doctordao dao = new doctordao(dbconnection.getcon());
		HttpSession session = req.getSession();

		if (dao.deleteDoctor(id)) {
			session.setAttribute("succMsg", "Doctor Delete Sucessfully..");
			resp.sendRedirect("admin/view_doctor.jsp");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
			resp.sendRedirect("admin/view_doctor.jsp");
		}
	}

	

}
