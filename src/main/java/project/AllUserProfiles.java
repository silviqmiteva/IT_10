package project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/users")
public class AllUserProfiles extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		String profileId = request.getParameter("profileId");
	    if (profileId == null || profileId.trim().isEmpty()) {
	    	CollectionExample coll = new CollectionExample();
	    	List<User> users = new ArrayList<User>();
	    	users = coll.getUsers();
	    	request.setAttribute("list", users);
	    	RequestDispatcher rd = request.getRequestDispatcher("users.jsp");  
	    	rd.forward(request, response);
	    }else {
	    	CollectionExample coll = new CollectionExample();
	    	User user = coll.getUserInfo(Integer.parseInt(profileId));
	    	HttpSession session = request.getSession();
	    	session.setAttribute("onlyViewProfile", "true");
	    	session.setAttribute("user",user);
	    	String baseUrl = request.getContextPath() + "/profile?id=" + profileId;
		    String encodedUrl = response.encodeRedirectURL(baseUrl);
		    response.sendRedirect(encodedUrl);
	    }
	}
}
