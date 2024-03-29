package com.servletadmin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.specialistdao;
import com.util.dbconnection;

/**
 * Servlet implementation class addspecialist
 */
public class addspecialist extends HttpServlet {
	private static final long serialVersionUID = 1L;
      public addspecialist() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String specname=request.getParameter("specname");
	specialistdao dao=new specialistdao(dbconnection.getcon());
	boolean f=dao.addspecialist(specname);
	HttpSession session=request.getSession();
	if(f)
	{
		session.setAttribute("succMsg","Specialist Added");
		response.sendRedirect("admin/index.jsp");
	}
	else {
		session.setAttribute("errorMsg","Somthing Wrong");
		response.sendRedirect("admin/index.jsp");
	}
	}

}
