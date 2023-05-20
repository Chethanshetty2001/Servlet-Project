package controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import dao.studentdao;
import dto.student;

@WebServlet("/fetchbyid")
public class fetch extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(req.getParameter("id"));
		studentdao dao = new studentdao();
		student std = dao.find(id);
		
		if(std == null){
			res.getWriter().print("<h1>no data found with id"+id+"</h1>");
		}
		else{
			res.getWriter().print("<html><body>"
					+"<table border='1'>"
					+"<tr>"
					+"<th>ID</th>"
					+"<th>Name</th>"
					+"<th>Mobile</th>"
					+"<th>Email</th>"
					+"<th>Gender</th>"
					+"<th>Address</th>"
					+"<th>Country</th>"
					+"<th>Dob</th>"
					+"<th>skills</th>"
					+"</tr>"
					);
			res.getWriter().print("<tr>"
					+"<th>"+std.getId()+"</th>"
					+"<th>"+std.getName()+"</th>"
					+"<th>"+std.getMobileNo()+"</th>"
					+"<th>"+std.getEmail()+"</th>"
					+"<th>"+std.getGender()+"</th>"
					+"<th>"+std.getAddress()+"</th>"
					+"<th>"+std.getCountry()+"</th>"
					+"<th>"+std.getDOB()+"</th>"
					+"<th>"+Arrays.toString(std.getSkills())+"</th>"
					+"</tr>"
					);
		res.getWriter().print("</table>"
		+"</body></html>");
		}
	}

}
