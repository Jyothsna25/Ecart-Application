package com.sathya.servlet;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao1 {
	public int save(Product product)
	{
       Connection connection=null;
       PreparedStatement preparedstatement=null;
       int res=0;
       try
       {
    	   connection=DBConnection.createconnection();
    	   preparedstatement=connection.prepareStatement("insert into product_data values(?,?,?,?,?,?,?,?,?,?)");
    	   preparedstatement.setString(1,product.getPid());
    	   preparedstatement.setString(2,product.getProname());
    	   preparedstatement.setDouble(3,product.getProprice());
    	   preparedstatement.setString(4,product.getProbrand());
    	   preparedstatement.setString(5,product.getPromadein());
    	   preparedstatement.setDate(6,product.getPromnfdate());
    	   preparedstatement.setDate(7,product.getProexpdate());
    	   preparedstatement.setBytes(8,product.getProImage());
    	   preparedstatement.setBytes(9,product.getProaudio());
    	   preparedstatement.setBytes(10,product.getProvideo());
    	   res=preparedstatement.executeUpdate();
    	   
       }
       catch(SQLException e)
       {
    	   e.printStackTrace();
       }
       finally
       {
    	   if(connection!=null)
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	   if(preparedstatement!=null)
			try {
				preparedstatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
       }
	return res;
       
	}
	public List<Product> findAll() 
	{
		List<Product> prd=new ArrayList<Product>();
		try(Connection connection=DBConnection.createconnection();Statement statement=connection.createStatement())
				{
					ResultSet resultset=statement.executeQuery("select * from product_data");
					while(resultset.next())
					{
						Product product=new Product();
						product.setPid(resultset.getString(1));
						product.setProname(resultset.getString(2));
						product.setProprice(resultset.getDouble(3));
						product.setProbrand(resultset.getString(4));
						product.setPromadein(resultset.getString(5));
						product.setPromnfdate(resultset.getDate(6));
						product.setProexpdate(resultset.getDate(7));
						product.setProImage(resultset.getBytes(8));
						product.setProaudio(resultset.getBytes(9));
						product.setProvideo(resultset.getBytes(10));

						prd.add(product);
					}
				}
		     catch(SQLException s)
		{
		    	 s.printStackTrace();
		}
		return prd;
	}
	 public int deleteBYId(String pid)
	 {
		 int count=0;
		 try(Connection connection=DBConnection.createconnection();PreparedStatement preparestatement=connection.prepareStatement("delete from product_data where propid=?");)
			{
			 preparestatement.setString(1,pid);
			 count=preparestatement.executeUpdate();
			}
		 catch(SQLException a)
		 {
			 a.printStackTrace();
		 }
		 return count;
	 }
	 public Product findById(String pid) 
	 {
			Connection connection=null;
			PreparedStatement preparestatement=null;
			Product product=null;
			try
			{
				connection=DBConnection.createconnection();
				 preparestatement=connection.prepareStatement("select * from product_data where propid=?");
				 preparestatement.setString(1,pid);
				 ResultSet resultset=preparestatement.executeQuery();
				 while(resultset.next())
				 {
					 product=new Product();
					 product.setPid(resultset.getString(1));
						product.setProname(resultset.getString(2));
						product.setProprice(resultset.getDouble(3));
						product.setProbrand(resultset.getString(4));
						product.setPromadein(resultset.getString(5));
						product.setPromnfdate(resultset.getDate(6));
						product.setProexpdate(resultset.getDate(7));
						product.setProImage(resultset.getBytes(8));
						
				 }
				 
			 }
				 catch(SQLException e)
				 {
					 e.printStackTrace();
				 }
			finally
			{
				if(connection!=null)
					try {
						connection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				if(preparestatement!=null)
					try {
						preparestatement.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			 return product;
		}
	 public int UpdateById(Product product) 
		{
			int count=0;
			try(Connection connection=DBConnection.createconnection();
					PreparedStatement preparestatement=connection.prepareStatement("update product_data set proname=?,proprice=?,probrand=?,promadein=?,promnfdate=?,proexpdate=?,proimage=?,proaudio=?,provideo=?, where propid=?"))
			{
				
				preparestatement.setString(1,product.getProname());
		    	   preparestatement.setDouble(2,product.getProprice());
		    	   preparestatement.setString(3,product.getProbrand());
		    	   preparestatement.setString(4,product.getPromadein());
		    	   preparestatement.setDate(5,product.getPromnfdate());
		    	   preparestatement.setDate(6,product.getProexpdate());
		    	   preparestatement.setBytes(7,product.getProImage());
		    	   preparestatement.setBytes(8,product.getProaudio());
		    	   preparestatement.setBytes(9,product.getProvideo());
		    	   preparestatement.setString(10, product.getPid());
		    	 
					count=preparestatement.executeUpdate();
		} 
			catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			 return count;
	}
}
}
