<%@page import="project.User" %>
<%@page import="project.CollectionExample" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<style type="text/css">
  		<%@include file="profileFormStyle.css" %>
	</style>
	
</head>
<body class="margin-none">
    <div>
        <div class="height-100px bg-blue">
        <header class="display-flex">
        <div><a href="index.jsp" class="link">Изход</a></div>
        <div class="margin-left-50px"><a href="index.jsp" class="color-white">Регистрация</a></div>
        <div class="margin-left-50px"><form action="users" method="post"><input type="submit" class="color-white submitBtn" value="Потребители"></form></div>
        </header>
        </div>
        <div class="bg-gray height-967px text-align-center">
  
            <div class="width-75per display-inline-block">
           		<div>
           	  <%
           	  User user = (User)session.getAttribute("user"); ;
           	  String seeProfile = (String)session.getAttribute("onlyVisitProfile");
           	  if(seeProfile.equals("no")){
           		String cookie = (String)session.getAttribute("cookie");
  		 		 if(cookie.equals("notExist")){
  		  			session.setAttribute("id", user.getId());
  		  			out.print("<h3>Добре дошли </h3>"+
  		  			"<form action='profile' method='post'/> <input type='submit' name='setCookie' value='Изключи' /></form>");       
           	  }
  		 	 }
           	
           %>
        		</div>
                <div class="display-inline">
                    <img src="woman.svg" class="width-30per margin-top-20px bg-orange margin-right-20px" />
                </div>
                <div class="text-align-left color-blue display-inline-block color-blue width-60per">
       
                    <div class="margin-bottom-20px">
                       <div><h2>Профилна информация</h2>
                        	<labеl>Име: <% out.print(user.getName()); %></labеl></div> 
                     <div class="float-right">
           
                     </div>
                    </div>
                    <div class="margin-bottom-20px">
                   </div>
                    <div class="margin-bottom-20px"><label>Работа: <% out.print(user.getWork()); %></label></div>
                    <div class="margin-bottom-20px">
                    <label>Описание :</label>
                        <p ><% out.print(user.getDescription()); %> </p>
                    </div>
                </div>
            </div>
            <div class="color-blue">
                <div class="margin-bottom-20px margin-top-0">
                    <h2 class="margin-top-0">Умения</h2>
                </div>
                <div class="bg-white width-75per display-inline-block border-radius-10px" style="height: 334px;">
                    <div>
                        <div class="display-flex text-align-left">
                            <div class="float-left width-50per">
                                <div class="margin-top-40px margin-left-50px margin-bottom-20px">
                                    <h3>Професионални</h3>
                                </div>
                               
                                <div class="margin-left-50px margin-bottom-20px"><label>Java</label></div>
                                <div class="margin-left-50px ">
                                      <input type="range" min="0" max="100" value="<%out.print(user.getJava()); %>" class="width-100per" id="java" >
                                </div>
                                <div class="margin-left-50px margin-bottom-20px"><label>HTML</label></div>
                                <div class="margin-left-50px">
                                      <input type="range" min="0" max="100" value="<% out.print(user.getHtml()); %>" class="width-100per"  >
                                </div>
          

                                <div class="margin-left-50px margin-bottom-20px"><label>CSS</label></div>
                                <div class="display-flex margin-bottom-20px">
                                    <div class="margin-left-50px height-5px bg-blue width-75per"></div>
                                    <div class="height-5px bg-orange width-30per"></div>
                                </div>
                                <div class="margin-left-50px margin-bottom-20px"><label>JavaScript</label></div>
                                <div class="display-flex margin-bottom-20px">
                                    <div class="margin-left-50px height-5px bg-blue width-10per"></div>
                                    <div class="height-5px bg-orange width-100per"></div>
                                </div>
                            </div>
                            <div class="float-left width-50per text-align-left">
                                <div class="margin-top-40px margin-left-20px margin-bottom-20px">
                                    <h3>Личностни</h3>
                                </div>
                                <div class="margin-left-20px margin-bottom-20px"><label>Комуникативност</label></div>
                                <div class="display-flex margin-bottom-20px margin-left-20px margin-right-20px">
                                    <div class="height-5px bg-blue width-5per"></div>
                                    <div class="height-5px bg-orange width-100per"></div>
                                </div>
                                <div class="margin-left-20px margin-bottom-20px"><label>Екипна работа</label></div>
                                <div class="display-flex margin-bottom-20px margin-left-20px margin-right-20px">
                                    <div class="height-5px bg-blue width-30per"></div>
                                    <div class="height-5px bg-orange width-100per"></div>
                                </div>
                                <div class="margin-left-20px margin-bottom-20px"><label>Креативност</label></div>
                                <div class="display-flex margin-bottom-20px margin-left-20px margin-right-20px">
                                    <div class="height-5px bg-blue width-15per"></div>
                                    <div class="height-5px bg-orange width-100per"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="margin-bottom-20px margin-top-20px">
                    <h2>Контакти</h2>
                </div>
                <div class="bg-white width-75per display-inline-block border-radius-10px margin-bottom-20px" style="height: 172px;">
                    <div>
                        <div class="display-flex text-align-left">
                            <div class="float-left width-50per">
                                <div class="margin-top-20px margin-left-50px margin-bottom-20px">
                                    <label>Имейл</label>
                                </div>
                                <div class="margin-top-20px margin-left-50px margin-bottom-20px color-orange text-underline">
                                    <label><% out.print(user.getAdress());  %></label>
                                </div>
                                <div class="margin-top-20px margin-left-50px margin-bottom-20px">
                                    <label>Телефон</label>
                                </div>
                                <div class="margin-top-20px margin-left-50px margin-bottom-20px color-orange text-underline">
                                    <label><% out.print(user.getPhone());  %></label>
                                </div>
                            </div>
                            <div class="float-left width-50per text-align-left">
                                <div class="margin-top-20px margin-left-20px margin-bottom-20px">
                                    <label>Град</label>
                                </div>
                                <div class="margin-top-20px margin-left-20px margin-bottom-20px color-orange text-underline">
                                    <label><% out.print(user.getTown()); %></label>
                                </div>
                                <div class="margin-top-20px margin-left-20px margin-bottom-20px">
                                    <label>Улица</label>
                                </div>
                                <div class="margin-top-20px margin-left-20px margin-bottom-20px color-orange text-underline">
                                    <label><% out.print(user.getStreet());  %></label>
                                </div>
                            </div>
                            
                        </div>
                    </div>
                  
                </div>
                  
            </div>
           
        </div>
        <div class="height-150px bg-blue"></div>
    </div>
</body>

</html>