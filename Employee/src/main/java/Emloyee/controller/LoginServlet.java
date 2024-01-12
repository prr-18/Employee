package Emloyee.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Emloyee.dao.EmployeeDao;
import Emloyee.dto.Employee;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name=req.getParameter("name");
		String password=req.getParameter("password");

		
		EmployeeDao employeeDao=new EmployeeDao();
		List<Employee> list=employeeDao.getAllEmployees();
		
		boolean value=false;
		String employeePassword=null;
		
	
		for(Employee employee:list) {
			if(name.equals(employee.getName())) {
				value=true;

				employeePassword=employee.getPassword();
				
				break;
			}
			
		}
		
		
		if(value) {
			if(password.equals(employeePassword)) {
				req.setAttribute("list",list);
				RequestDispatcher  dispatcher=req.getRequestDispatcher("display.jsp");
				dispatcher.forward(req, resp);
			}else {
		
				req.setAttribute("message", "Invalid Password");
				RequestDispatcher  dispatcher=req.getRequestDispatcher("login.jsp");
				dispatcher.include(req, resp);
			}
		}else {
			req.setAttribute("message", "Invalid name");
			RequestDispatcher  dispatcher=req.getRequestDispatcher("login.jsp");
			dispatcher.include(req, resp);
		}
		
		
		
		
		
		
		
		
		
	}
	
}
