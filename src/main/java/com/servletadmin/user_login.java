package com.servletadmin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.userdao;
import com.entity.user;
import com.util.dbconnection;

/**
 * Servlet implementation class user_login
 */
public class user_login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public user_login() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			HttpSession session=request.getSession();
			userdao dao=new userdao(dbconnection.getcon());
			user user=dao.login(email, password);
			if(user!=null)
			{
				session.setAttribute("userobj",user);
				response.sendRedirect("index.jsp");
				
			}
			else
			{
				session.setAttribute("error","Invalid email or password");
				response.sendRedirect("user_login.jsp");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
