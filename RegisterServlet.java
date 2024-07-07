package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet(urlPatterns="/test",loadOnStartup = 1)
public class RegisterServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	static 
	{
		System.out.println("servlet loading.....");
	}
	public RegisterServlet() 
	{
		// TODO Auto-generated constructor stub
		System.out.println("servlet instantiation...");
	}
	@Override
	public void init() throws ServletException 
	{
		// TODO Auto-generated method stub
		System.out.println("servlet initialisation...");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		System.out.println("request processing for post type method");
		
		System.out.println("Request  object implementation class is :: " + request.getClass().getName());
		System.out.println("Response object implementation class is :: " + response.getClass().getName());
		System.out.println();
		System.out.println("Request  object hashcode value is       :: " + request.hashCode());
		System.out.println("Response object hashcode value is       :: " + response.hashCode());
		System.out.println("Thread request object hashcode value is :: " + Thread.currentThread().hashCode());
		
		//we know that whatever data is entered through html page is stored under request object
		//so we have to fetch this data
		//whatever we have supplied in name attribute in html page is known as parameter.
		
		//getting the parameter from the client using html page name attribute
		String username=request.getParameter("username");
		String contactnumber=request.getParameter("contactnumber");
		String emailid =request.getParameter("emailid");
		//getting MULTIPLE parameter from the client using html page name attribute
		String[] courses=request.getParameterValues("course");
		
		//for gtting response on webpage
		//1.set content type
		response.setContentType("text/html");
		//2.get printWiter object
		PrintWriter out=response.getWriter();
		
		out.println("<html><head><title>OUTPUT PAGE</title></head>");
		out.println("<body bgcolor='cyan' align='center'>");
		out.println("<h1 align='center'>Course Details of the Student is :: </h1>");
		out.println("<table border='1' align ='center'>");
		out.println("<tr><th>NAME    </th><td>" + username + "</td></tr>");
		out.println("<tr><th>NUMBER  </th><td>" + contactnumber + "</td></tr>");
		out.println("<tr><th>EMAILID </th><td>" + emailid + "</td></tr>");

		out.println("<tr>");
		out.println("<th>Course Selected</th>");
		out.println("<td>");
		for (String course : courses) 
		{
			out.println(course + "<br/>");
		}
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr><th>Request Object id:: </th><td>" + request.hashCode() + "</td></tr>");
		out.println("<tr><th>Response Object id:: </th><td>" + response.hashCode() + "</td></tr>");
		out.println("<tr><th>Thread Object id:: </th><td>" + Thread.currentThread().hashCode() + "</td></tr>");
		out.println("</table>");

		out.println("</body>");
		out.println("</html>");

		try 
		{
			Thread.sleep(30000);// 30sec
		}
		catch(InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		//3.close the response object
		out.close();
		
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("servlet de-instantiation");
	}

}
