<%@page import="Emloyee.dto.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%List<Employee> list=(List)request.getAttribute("list"); %>
<table border="2px">
<tr>
<th>ID</th>
<th>Name</th>
<th>Address</th>
<th>Email</th>
<th>Password</th>
<th>Phone</th>
<th>Salary</th>
<th>Delete</th>
<th>Update</th>
</tr>
<%for(Employee employee:list){ %>
<tr>
<td><%=employee.getId() %></td>
<td><%=employee.getName()%></td>
<td><%=employee.getAddress()%></td>
<td><%=employee.getEmail() %></td>
<td><%=employee.getPassword()%></td>
<td><%=employee.getPhone() %></td>
<td><%=employee.getSalary() %> </td>

<td><a href="delete?id=<%=employee.getId() %>">delete</a></td>
<td><a href="update?id=<%=employee.getId() %>">update</a></td>
</tr>
<%} %>

</table>
</body>
</html>