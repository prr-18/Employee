package Emloyee.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Emloyee.dao.EmployeeDao;
import Emloyee.dto.Employee;
@WebServlet("/signup")
public class SignupServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name=req.getParameter("name");
		String address=req.getParameter("address");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		long phone=Long.parseLong(req.getParameter("phone"));
		ServletContext context=getServletContext();
		double salary=Double.parseDouble(context.getInitParameter("salary"));
		
		Employee employee=new Employee();
		employee.setAddress(address);
		employee.setEmail(email);
		
		employee.setName(name);
		employee.setPassword(password);
		employee.setPhone(phone);
		employee.setSalary(salary);
		
		EmployeeDao employeeDao=new EmployeeDao();
		List<Employee> list=employeeDao.getAllEmployees();

		boolean value=true;
		for(Employee emp:list) {
			if(name.equals(emp.getName())) {
				value=false;
				break;
			}
		}
		
		if(value) {

			employeeDao.saveEmployee(employee);
			req.setAttribute("message", "SignedUp Successfully please Login");
			RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
			dispatcher.forward(req, resp);
		}else {
			req.setAttribute("message", "name already exist!!!!");
			RequestDispatcher dispatcher=req.getRequestDispatcher("signup.jsp");
			dispatcher.include(req, resp);
		}
		
		
		
		
		
		
	}
	
	
	
}
