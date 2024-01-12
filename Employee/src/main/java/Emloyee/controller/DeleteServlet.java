package Emloyee.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Emloyee.dao.EmployeeDao;
import Emloyee.dto.Employee;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));

		EmployeeDao dao=new EmployeeDao();
		dao.deleteEmployee(id);
		
		
		req.setAttribute("list", dao.getAllEmployees());
		RequestDispatcher dispatcher=req.getRequestDispatcher("display.jsp");
		dispatcher.forward(req, resp);
	}
}
