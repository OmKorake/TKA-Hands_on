package com.jdbcex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Customer {
	
	public void createTable() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch204","root","root");
		Statement s= c.createStatement();
		s.execute("create table customer(c_id int,c_name varchar(25),c_age int,c_mail varchar(40),c_city varchar(50))");
		System.out.println("Table Customer is created Successfully....");
		c.close();
		
	}

	public void insertData() throws Exception {

		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/batch204","root","root");
		Statement s = c.createStatement();
		s.executeUpdate("insert into customer (c_id ,c_name ,c_age ,c_mail,c_city) values(1031,'Arjun Mane',45,'arjun34@gmail.com','Pune'),"
				+ "(1032,'Mahesh Shinde',54,'mahesh23@gmail.com','Mumbai'),"
				+ "(1033,'Ranjeet Mane',33,'ranjeet54@gmail.com','Solapur'),"
				+ "(1034,'Arun Bhide',43,'arun76@gmail.com','Dharashiv'),"
				+ "(1035,'Satish Patil',40,'satish223@gmail.com','Nashik')");
		System.out.println("Data inserted Successfully....");
		c.close();
		
	}

	public void updateData() throws Exception {
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch204","root","root");
	Statement s = c.createStatement();
	s.executeUpdate("update customer set c_name='Manoj Kumar' where c_id=1035");
	s.executeUpdate("update customer set c_city='Solapur' where c_name='Mahesh Shinde'");
	System.out.println("Table Customer data is updated Successfully.....");
	c.close();
	
    }
	
public void deleteData() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch204","root","root");
		Statement s = c.createStatement();
		s.executeUpdate("delete from customer where c_city= 'Solapur'");
		System.out.println("Mentioned data is deleted Successfully...!!!");
		c.close();
		
	}
	
	public void getallData() throws Exception{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch204","root","root");
		Statement s =c.createStatement();
		ResultSet rs = s.executeQuery("Select * from customer");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"   "+rs.getInt(3)+"   "+rs.getString(4)+rs.getString(5));
		}
		
	}

	public static void main(String[] args) throws Exception {
		
		Customer c1= new Customer();
//		c1.createTable();
//		c1.insertData();
//		c1.updateData();
//		c1.deleteData();
		c1.getallData();
		


	}

}
