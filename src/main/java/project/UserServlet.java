package project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/profile")
public class UserServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException  {
		String userID = request.getParameter("id");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(30*60);
		
		Cookie cookies[] = request.getCookies();
		boolean isCookieAvailable = false;
		if(cookies != null ) {
	       for(Cookie c : cookies) {
	    	   if(c.getName().equals("userCookie") && c.getValue().equals(userID)) {
	    		   session.removeAttribute("cookie");
	    		   session.setAttribute("cookie", "exists");
	    		   isCookieAvailable = true;
	    	   }
	       }
	      }
		if(isCookieAvailable==false){
	    	  session.removeAttribute("cookie");
	    	  session.setAttribute("cookie", "notExist");
	      }
		
		if(userID!=null) {
//			CollectionExample coll = new CollectionExample();
//			User user = coll.getUserInfo(Integer.parseInt(userID));
//			user.setId(Integer.parseInt(userID));
//			session.setAttribute("user",user);	
			
			RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
			rd.forward(request, response);	
			}else {
				response.sendRedirect("login.jsp");
		}
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException  {
		String userID = request.getParameter("id");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		if (!request.getParameterMap().containsKey("id"))
		{
			userID = String.valueOf(session.getAttribute("id"));
			Cookie cookie = new Cookie("userCookie",userID);
			cookie.setMaxAge(60*60*24);
			response.addCookie(cookie);  
			session.setAttribute("cookie", "exists");
		}else {
		String username = request.getParameter("username");
		String work = request.getParameter("work");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String town = request.getParameter("town");
		String street = request.getParameter("street");

		CollectionExample coll = new CollectionExample();
		coll.updateUserInfo(Integer.parseInt(userID),username,phone,street,town,work,address);
		
		RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");  
		rd.forward(request, response);
		}
		
	}
}
