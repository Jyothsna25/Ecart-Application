package com.sathya.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.IOUtils;


@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Read the data
		String proId=request.getParameter("proId");
		String proName=request.getParameter("proName");
		float proPrice=Float.parseFloat(request.getParameter("proPrice"));
		String proBrand=request.getParameter("proBrand");
		String proMadeIn=request.getParameter("proMadeIn");
		Date proMfgDate=Date.valueOf(request.getParameter("proMfgDate"));
		Date proExpDate=Date.valueOf(request.getParameter("proExpDate"));
		
		Part part=request.getPart("proImage");
		InputStream inputStream=part.getInputStream();
		
		//conversion of InputStream to byteArray
		byte[] proImage=IOUtils.toByte
				Array(inputStream);
		
		//Using above details create the product Object
		Product product=new Product();
		product.setPid(proId);
		product.setProname(proName);
		product.setProprice(proPrice);
		product.setProbrand(proBrand);
		product.setPromadein(proMadeIn);
		product.setPromnfagdate(proMfgDate);
		product.setProexpdate(proExpDate);
		product.setProImage(proImage);
		
		
		//Giving the product Object to DAO layer
		ProductDao1 productDao=new ProductDao1();
		int result=productDao.save(product);
		
		if(result==1) {
			request.setAttribute("saveResult", result);
			RequestDispatcher dispatcher=request.getRequestDispatcher("productlist.jsp");
			dispatcher.forward(request, response);
		}
		else {
		PrintWriter writer =response.getWriter();
		writer.println("Data Insertion fail...."+result);
		RequestDispatcher dispatcher=request.getRequestDispatcher("add-product.html");
		dispatcher.include(request, response);
		
		}
	}
		

}
	
	
    
	
	