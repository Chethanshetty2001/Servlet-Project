package controller;

import java.io.IOException;
import java.util.Arrays;
import java.sql.*;
import javax.security.auth.message.callback.SecretKeyCallback.Request;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import dao.studentdao;
import dto.student;

@WebServlet("/print")
public class print extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String name = req.getParameter("name");
//		long MobileNo = Long.parseLong(req.getParameter("mobile"));
//		String Email = req.getParameter("mail");
//		String Gender = req.getParameter("gender");
//		Date DOB = Date.valueOf(req.getParameter("dob"));
//		String country = req.getParameter("country");
//		String[] skills = req.getParameterValues("skills");
//		String SQL = (req.getParameter("SQL")!=null?"sql":"");
//		String JDBC = (req.getParameter("JDBC")!=null?"JDBC":"");
//		String Hibernate =( req.getParameter("Hibernate")!=null?"hibernate":"");
//		String Address = req.getParameter("address");
//		res.getWriter().print("<h1>"+"Name:"+name
//				+"<br> MobileNo:"+MobileNo
//				+"<br> Email:"+Email
//				+"<br> Gender:"+Gender
//				+"<br> DOB:"+DOB
//				+"<br> Country:"+country
//				+"<br> Skills:"+Arrays.toString(skills)
//				+"<br> Address:"+Address+"</h1>");
		
		student std = new student();
		std.setAddress(req.getParameter("address"));
		std.setCountry(req.getParameter("country"));
		std.setDOB(Date.valueOf(req.getParameter("dob")));
		std.setEmail(req.getParameter("mail"));
		std.setGender( req.getParameter("gender"));
//		std.setId(id);
		std.setMobileNo(Long.parseLong(req.getParameter("mobile")));
		std.setName(req.getParameter("name"));
		std.setSkills(req.getParameterValues("skills"));
		
		studentdao std2 = new studentdao();
		std2.save(std);
		
	}
}
