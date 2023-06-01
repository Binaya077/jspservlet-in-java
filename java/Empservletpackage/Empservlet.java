package Empservletpackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Empservlet
 */
@WebServlet("/Empservlet")
public class Empservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Empservlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//Connection conn;
		String name=request.getParameter("username");
		
		String address=request.getParameter("address");
		
		String age=request.getParameter("age");
		
		String gender=request.getParameter("gender");
		
		PrintWriter out = response.getWriter();
        out.println("<html><body><b>Successfully Inserted"
                    + "</b></body></html>");
        out.println(name);
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/employeedb","root","");
		
			PreparedStatement stat=conn.prepareStatement("insert into employee values(?,?,?,?)"); 			     
		      stat.setString(1,name);//1 specifies the first parameter in the query  
		      stat.setString(2,address);
		      stat.setString(3,age);
		      stat.setString(4,gender);
			  stat.executeUpdate();
				 
		}
		 catch (Exception e) {
	            e.printStackTrace();
	        }
		
		RequestDispatcher rd=request.getRequestDispatcher("home.html");
		rd.include(request, response);
		
		
	}
	}


