package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	CollectionExample coll;
	public void init() throws ServletException{
		coll = CollectionExample.getInstance();
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String repeatedPass = request.getParameter("repeatPassword");
		PrintWriter out = response.getWriter();
    	if(name.length() == 0) {
    		out.println(String.format("Please input name."));
    	}
    	if(password.length()<8 || repeatedPass.length()<8) {
    		out.println(String.format("Please enter password at least 8 characters."));
    	}
    	if(name.length()>0 && password.length()>=8 && repeatedPass.length()>=8 && checkIfPasswordsAreEquals(password,repeatedPass)==true) {
    		int userId = generateRandomID();
    		User person = new User(userId,name,password);
    		CollectionExample coll = new CollectionExample();
    		if(coll.checkIfUserExists(person)==false) {
    			coll.addUser(person);
    			//--------------
    			coll.update(person);	
    			//---------
    			response.sendRedirect("login.jsp");
    			out.close();
    		}else {
    			out.println("There is such a user.");	
    		}
    	}else {
    			out.println("Passwords did not match. Please try again.");
    	}
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user"); 
		int receivedID = user.getId();
		if(receivedID > 0) {
			String baseUrl = request.getContextPath() + "/profile?id=" + receivedID;
			String encodedUrl = response.encodeRedirectURL(baseUrl);
			response.sendRedirect(encodedUrl);
		}else {
			 response.sendRedirect("index.jsp");
		}
	}
	
	public boolean checkIfPasswordsAreEquals(String pass1, String pass2) {
		if(pass1.equals(pass2)) {
			return true;
		}else return false;
	}
	
	public int generateRandomID() {
		Random rand = new Random(); 
		int id = rand.nextInt(1000);
		return id;
	}
}
