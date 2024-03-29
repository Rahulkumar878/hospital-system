package com.userservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.userdao;
import com.entity.user;
import com.util.dbconnection;

public class userregister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public userregister() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String fullname=request.getParameter("fullname");
			String email=request.getParameter("email");
			String password=request.getParameter("password");
          user u=new user(fullname,email,password);
          userdao dao=new userdao(dbconnection.getcon());
          HttpSession session=request.getSession();
            boolean f=   dao.userregister(u);
            if(f)
            {
            	session.setAttribute("sucmsg","Register Sucessfully");
            	response.sendRedirect("signup.jsp");
            }
            else
            {
            	session.setAttribute("errormsg", "something wrong");
            	//System.out.println("something wrong on server");
            	response.sendRedirect("signup.jsp");
            }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
