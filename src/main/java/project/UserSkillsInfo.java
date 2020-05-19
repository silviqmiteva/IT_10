package project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
@WebServlet("/userSkillsInfo")
public class UserSkillsInfo extends HttpServlet {
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		request.setCharacterEncoding("UTF-8");
		
		String str;
		StringBuilder sb = new StringBuilder();
		while((str=request.getReader().readLine())!=null) {
			sb.append(str);
		}
		
		Gson gson = new Gson();
		User newUser = (User) gson.fromJson(sb.toString(), User.class);

		CollectionExample coll = new CollectionExample();
		coll.updateUserInfo(newUser.getId(),"","","","","","","",newUser.getJava(),newUser.getHtml());
		User user = coll.getUserInfo(newUser.getId());
		
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(gson.toJson(user)); 
		out.flush();
	}
}
