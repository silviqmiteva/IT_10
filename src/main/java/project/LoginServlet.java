package project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	User person;
	int userID;
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();
		person = new User(name,password);
		CollectionExample users = new CollectionExample();
		 if(users.checkIfUserExists(person)==true) {
			 	userID = users.getUserID(person);
			 	
				HttpSession session = request.getSession();
				session.setMaxInactiveInterval(30*60);
				User user = users.getUserInfo(userID);
				user.setId(userID);
				session.removeAttribute("user");
				session.setAttribute("user",user);	
				
			 	String baseUrl = request.getContextPath() + "/profile?id=" + userID;
			    String encodedUrl = response.encodeRedirectURL(baseUrl);
			    response.sendRedirect(encodedUrl);
			     
	        }else {
	           	out.println(String.format("There is no such a user."));
	         }
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		HttpSession session=request.getSession();
		if(session != null) {
			String sessionID = session.getId();
			User user = (User)session.getAttribute("user"); 
			int receivedID = user.getId();
			String baseUrl = request.getContextPath() + "/profile?id=" + receivedID;
			String encodedUrl = response.encodeRedirectURL(baseUrl);
			response.sendRedirect(encodedUrl);
		}else {
			response.sendRedirect("index.jsp");
		}
	}
	
}
