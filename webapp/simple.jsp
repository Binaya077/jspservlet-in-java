<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%="<h1>Printing name 5 times in Loop <br>" %>

<%

            for(int i=1;i<=5;i++)
            {
            
            	 
                out.println("binaya<br>");
            }
            
     %>
     
     <%="<h1>Finding sum<br>" %>
     
     
        <%
        int a=5;
        int b=6;
        int sum=a+b;
        out.println("<h4>");
        out.println(sum);
        
        %>
        
        
        
</body>
</html>