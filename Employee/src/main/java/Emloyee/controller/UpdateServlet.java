package Emloyee.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Emloyee.dao.EmployeeDao;
import Emloyee.dto.Employee;
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		int id=Integer.parseInt(req.getParameter("id"));
		
		EmployeeDao dao=new EmployeeDao();
		Employee employee=dao.findEmployeeById(id);
		
		
		req.setAttribute("employee", employee);
		PrintWriter printWriter=resp.getWriter();
		printWriter.print("Updated");
		
		
		
	}
	}

