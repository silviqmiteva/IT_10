package project;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogFilter implements Filter {

    public LogFilter() { }
	public void destroy() {}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse) response;
		System.out.println("in filtera smee");
		
		String userId=req.getParameter("id"); 
		HttpSession session = req.getSession();
		if(session == null || session.getAttribute("user") == null) { // not found
			res.sendRedirect("login.jsp");
		}else{
			User u = (User)session.getAttribute("user");
				System.out.println("lognat e  "+ u);
			    chain.doFilter(req, res);
		}
		
		//kontrolira dostupa za profile servlet pri klik na user name v users.jsp page
		//ako e lognat tekushtiq open profile user page
		//if not redirect to login.jsp
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
