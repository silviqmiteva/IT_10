package project;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/users")
public class LogFilter implements Filter {

    public LogFilter() {
      
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
	    HttpSession session = req.getSession();
		String isLoggedUser = (String)session.getAttribute("isLogUser"); 
		if(isLoggedUser.equals("no")) {
			res.sendRedirect("login.jsp");
		}else if(isLoggedUser.equals("null")) { 
			session.setAttribute("loggedUser", null);
			chain.doFilter(req, res);
		}else if (isLoggedUser.equals("yes")) {
			chain.doFilter(req, res);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	
	}

}
