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
          <div class="bg-orange height-40px text-align-left display-flex">
        	<div style="width:20%">Потребител</div>
        	<div style="width:20%">Работа</div>
        	<div style="width:20%">Информация</div>
        	<div style="width:10%">Имейл</div>
        	</div>
        	<div class="text-align-left">
        	<%  List<User> list = new ArrayList<User>();
        	String isLoggedUser = (String)session.getAttribute("isLogUser"); 
    		if(isLoggedUser.equals("null")) {
    			session.setAttribute("isLogUser","no");
    		}
        	list = (List<User>)request.getAttribute("list");
        	for(User u : list) {
        	    out.println("<div><form method='post' action='users' class='display-flex'><div style='width:20%'><input type='submit' class='submitBtn blue' value='"+u.getName()+"'></div>");
        	    out.println("<input type='hidden' name='profileId' value='"+u.getId()+"'>");
        	    out.println("<div style='width:20%'>"+u.getWork()+"</div>");
        	    out.println("<div style='width:20%'>"+u.getDescription()+"</div>");
        	    out.println("<div style='width:10%'>"+u.getAdress()+"</div></div></form>");
        	}
        	 
        	%>
        	</div>
        </div>
     </div>

</body>
</html>