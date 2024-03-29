package com.doctor.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.appointmentdao;
import com.util.dbconnection;

/**
 * Servlet implementation class updatestatus
 */
public class updatestatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatestatus() {
        super();
        // TODO Auto-generated constructor stub
    }

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       try {
	    	   int id=Integer.parseInt(request.getParameter("id"));
	    	   int did=Integer.parseInt(request.getParameter("did"));
	    	   String comm=request.getParameter("comm");
	    	   appointmentdao dao=new appointmentdao(dbconnection.getcon());
	    	   HttpSession session=request.getSession();
	    	   if(dao.updatecommentstatus(id, did, comm))
	    	   {
	    		   session.setAttribute("succMsg", "Comment Updated");
	    		   response.sendRedirect("doctor/patient.jsp");
	    	   }
	    	   else {
	    		   session.setAttribute("errorMsg", "Somthing Wrong on Server");
	    		   response.sendRedirect("doctor/patient.jsp");
	    	   }
	    	   }
	       catch(Exception e)
	       {
	    	   e.printStackTrace();
	       }
	}

}
