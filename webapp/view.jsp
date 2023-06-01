<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>jsp page</title>
</head>
<body>
<h1>Display Table From JSP</h1>
<table border='1' width=50%>
<tr style="background-color:orange">
<th>Name</th>
<th>Address</th>
<th>AGE</th>
<th>Gender</th>
</tr>
<%
try
{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/employeedb","root","");

   String query="Select* From employee"; 			     
   Statement stat=conn.createStatement();
    ResultSet rs= stat.executeQuery(query);
    while(rs.next())
	{
	%>
    	<tr>
    	<td style="background-color:azure"> <%=rs.getString("name") %> </td>
    	<td style="background-color:azure"> <%=rs.getString("address") %> </td>
    	<td style="background-color:azure"> <%=rs.getString("age") %> </td>
    	<td style="background-color:azure"> <%=rs.getString("gender") %> </td>
    	</tr>
    	<% 
    	}
	}catch(Exception ex){
		
	}
%>
</table>
<br>
<a href='home.html'><button>Perform Action</button></a>
</body>
</html>