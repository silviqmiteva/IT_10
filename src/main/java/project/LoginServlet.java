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
	CollectionExample users;
	
	public void init()throws ServletException{
		users= CollectionExample.getInstance();
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{

			String name = request.getParameter("name");
			String password = request.getParameter("password");
			PrintWriter out = response.getWriter();
			person = new User(name,password);
			if(users.checkIfUserExists(person)==true) {
			 	userID = users.getUserID(person);
			 	
			 	HttpSession session = request.getSession();
			 	person.setId(userID);
			 	session.setAttribute("loggedUser",person);	
				session.setAttribute("isLogUser", "yes");
				session.setAttribute("onlyViewProfile", "null");
				
			 	String baseUrl = request.getContextPath() + "/profile?id="+userID;
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
