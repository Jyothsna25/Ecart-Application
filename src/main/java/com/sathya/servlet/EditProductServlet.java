package com.sathya.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EditProductServlet")
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid=request.getParameter("pid");
		ProductDao1 dao=new ProductDao1();
		 Product existingproduct=dao.findById(pid);
		   //sending the existingproduct to edit-form send the existingproduct object to request object
		 request.setAttribute("existingobject", existingproduct);
		 //display the existing product details in edit-form.jsp
		 RequestDispatcher dispatcher=request.getRequestDispatcher("edit-form.jsp");
		  dispatcher.forward(request, response);
	}

	}

	
	
