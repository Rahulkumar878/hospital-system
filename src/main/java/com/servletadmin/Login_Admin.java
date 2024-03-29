package com.servletadmin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.user;

public class Login_Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Login_Admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			HttpSession session=request.getSession();
			if("rahulkumar012.hitit2020@gmail.com".equals(email)&&"Rahulkumar@123".equals(password)||"Rahulkumar012.hitit2020@gmail.com".equals(email)&&"Rahulkumar@123".equals(password))
			{
				session.setAttribute("adminobj",new user());
				response.sendRedirect("admin/index.jsp");
				
			}
			else
			{
				session.setAttribute("error","Invalid email or password");
				response.sendRedirect("admin_login.jsp");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			}

}
