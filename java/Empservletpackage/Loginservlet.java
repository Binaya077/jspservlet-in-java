package Empservletpackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Loginservlet
 */
@WebServlet("/Loginservlet")
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loginservlet() {
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
		
		//Set Cookie
		
		PrintWriter pw=response.getWriter();	
		String name=request.getParameter("username");
		pw.println("<h1>Name="+name);
		
		Cookie ck=new Cookie("username",name);//creating cookie object (name,value)
		ck.setMaxAge(60*60*24);
		response.addCookie(ck);//adding cookie
		
		String address=request.getParameter("address");
		pw.println("<h1>Address="+address);
		Cookie ck1=new Cookie("address",address);//creating cookie object
		ck1.setMaxAge(60*60*24);
		response.addCookie(ck1);//adding cookie
		
		//creating submit button for reading cookie
		pw.println("<br><br>");
		pw.println("<form action=\"Readservlet\" method=\"post\">");
		pw.println("<input type=\"submit\" id=\"submit\" value=\"Readcookie\">");
		pw.println("</form>");
	
		
	}

}
