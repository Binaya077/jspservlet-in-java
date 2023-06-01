package Empservletpackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Viewservlet
 */
@WebServlet("/Viewservlet")
public class Viewservlet extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException 
	{
	
		PrintWriter pw=response.getWriter();	
		pw.println("<h1>Display Table From Servlet</h1>");
	
		 pw.println ("<table width=50% border='1'><tr style=\"background-color:lightcoral\"><th>Name</th><th>Address</th><th>Age</th><th>Gender</th></tr>");
		
		 
		 try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/employeedb","root","");
			
				String query="Select* From employee"; 			     
				Statement stat=conn.createStatement();
		          ResultSet rs= stat.executeQuery(query);
				 while(rs.next())
				{
					 pw.print("<tr><td style=\"background-color:lightgray\">");
					 pw.print(rs.getString("name"));
					 pw.print("</td >");
					 pw.print("<td style=\"background-color:lightgray\">");
					 pw.print(rs.getString("address"));
					 pw.print("</td>");
					 pw.print("<td style=\"background-color:lightgray\">");
					 pw.print(rs.getString("age"));
					 pw.print("</td>");
					 pw.print("<td style=\"background-color:lightgray\">");
					 pw.print(rs.getString("gender"));
					 pw.print("</td>");
					 pw.print("</tr>");
				}
				 pw.print("</table>");
					 
			}
			 catch (Exception e) {
		            e.printStackTrace();
		        }
	              
		       pw.print("<br><br>");
		       pw.println("<a href='home.html'><button>Perform Action</button></a>");
		
		
	}
	
	
	
	
    public Viewservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
