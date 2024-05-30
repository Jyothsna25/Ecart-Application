package com.sathya.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid=request.getParameter("pid");
		ProductDao1 productdao=new ProductDao1();
		 int result=productdao.deleteBYId(pid);
		 if(result==1)
		 {
			  request.setAttribute("DeleteResult",result);
			 RequestDispatcher dispatcher=request.getRequestDispatcher("productlist.jsp");
			  dispatcher.forward(request, response);
		 }
		 else
		 {
			  request.setAttribute("DeleteResult",result);
			 RequestDispatcher dispatcher=request.getRequestDispatcher("productlist.jsp");
			  dispatcher.forward(request, response);
		 }
		}

	
}
