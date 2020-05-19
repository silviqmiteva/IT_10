<%@page import="project.User" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<style type="text/css">
  		<%@include file="profileFormStyle.css" %>
	</style>
	
</head>
<body>
 <div>
        <div class="height-100px bg-blue">
        <header>
        <a href="login.jsp" class="link">Вход</a>
        <a href="index.jsp" class="color-white">Регистрация</a>
        </header>
        </div>
        <div class="bg-gray height-967px text-align-center">
          <div class="bg-orange height-40px text-align-left">
        	<label>Потребител</label>
        	<label>Работа</label>
        	<label>Информация</label>
        	</div>
        	<div class="text-align-left">
        	<%  List<User> list = new ArrayList<User>();
        	// show all records from collection 
        	list = (List<User>)request.getAttribute("list");
        	for(User u : list) {
        	    out.println("<div><form method='post' action='profile'><input type='submit' class='width:10%' value='"+u.getName()+"'>");
        	    out.println("<input type='hidden' name='id' value='"+u.getId()+"'>");
        	    out.println("<label class='width:10%'>"+u.getWork()+"</label>");
        	    out.println("<label class='width:80%'>"+u.getStreet()+"</label></div></form>");
        	}
        	
        	//if user is logged in show names as link to their profiles
        	//if user is not logged and want click on user name redirect to login page. 
        	%>
        	</div>
        </div>
     </div>

</body>
</html>