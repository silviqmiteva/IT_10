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

@WebFilter("/profile")
public class ProfileFilter implements Filter {

    public ProfileFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("vuv profile filter sme ");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
	    HttpSession session = req.getSession();
	    
		 User user = new User();
		 String onlyVisitProfile = "";
      	  String onlyViewProfile = session.getAttribute("onlyViewProfile").toString();
      	  if (onlyViewProfile.equals("null")) {
      			 user = (User)session.getAttribute("user");
      			 onlyVisitProfile="no";
      	  }else{
      			user = (User)session.getAttribute("user"); 
      			String isLoggedUser = (String)session.getAttribute("isLogUser"); 
      			if(isLoggedUser.equals("yes")) {
      				User logged = (User)session.getAttribute("loggedUser"); 
      				if(logged.getId()==user.getId()){
      						onlyVisitProfile = "no"; 	
            		  }else{
            				onlyVisitProfile = "yes";
              				session.setAttribute("onlyViewProfile","null");
              			}
      				}else{
          				onlyVisitProfile = "yes";
          				session.setAttribute("onlyViewProfile","null");
          			}
      			}
      	  session.setAttribute("onlyVisitProfile", onlyVisitProfile);
		chain.doFilter(request, response);
	}


	public void init(FilterConfig fConfig) throws ServletException {

	}

}
