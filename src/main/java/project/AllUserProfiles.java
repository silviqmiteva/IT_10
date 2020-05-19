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

@WebServlet("/users")
public class AllUserProfiles extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		CollectionExample coll = new CollectionExample();
		List<User> users = new ArrayList<User>();
		users = coll.getUsers();
		request.setAttribute("list", users);
		RequestDispatcher rd = request.getRequestDispatcher("users.jsp");  
		rd.forward(request, response);
	}
}
