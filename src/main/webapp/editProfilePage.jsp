<%@page import="project.User"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<style type="text/css">
  		<%@include file="profileFormStyle.css" %>
	</style>
	<script type="text/javascript" src="./js/mainFile.js"></script>
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
                <div class="display-inline">
                    <img src="woman.svg" class="width-30per margin-top-20px bg-orange margin-right-20px" />
                </div>
                <div class="text-align-left color-blue display-inline-block color-blue width-60per">
           			<div> <input type="button" class="styleButton" value="Преглед" onclick="window.location='profile.jsp'"></div>
       				<form>
                    <div class="margin-bottom-20px">
                       <div><h2>Профилна информация</h2>
                        	<labеl>Име: <%
                        	User user = (User)session.getAttribute("user"); 
                        	%></labеl>
                        	<input type="text" name="username" id="name" value="<% out.print(user.getName()); %>">
                        	<input type="hidden" name="id" id="userId" value="<% out.print(user.getId()); %>">
                     </div> 
                     <div class="float-right">
                    </div>
                    <div class="margin-bottom-20px">
                   </div>
                    <div class="margin-bottom-20px"><label>Работа:</label><input type="text" id="work" name="work" value="<% out.print(user.getWork()); %>"></div>
                    <div class="margin-bottom-20px">
                        <label>Описание</label>
                        <textarea name="description" id="description"> <% out.print(user.getDescription()); %> </textarea>
                    	<input type="button" class="styleButton" value="Запази" onClick="sendProfileInfoToServlet()">
                    </div>
                    </div>
                    </form>
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
                                <div class="margin-left-50px margin-bottom-20px">
                                      <input type="range" min="0" max="100" value="0" class="width-100per" id="java" >
                                </div>
                                <div class="margin-left-50px margin-bottom-20px"><label>HTML</label></div>
                                <div class="margin-left-50px margin-bottom-20px">
                                      <input type="range" min="0" max="100" value="0" class="width-100per" id="html" >
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
                            <div><input type="button" onClick="sendSkillsToServlet()" class="styleButton" value="Запази" ></div>
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
                                    <input type="text" id="address" name="address" value="<% out.print(user.getAdress());  %>">
                                </div>
                                <div class="margin-top-20px margin-left-50px margin-bottom-20px">
                                    <label>Телефон</label>
                                </div>
                                <div class="margin-top-20px margin-left-50px margin-bottom-20px color-orange text-underline">
                                   <input type="text" name="phone" id="phone" value="<% out.print(user.getPhone());  %>">
                                </div>
                            </div>
                            <div class="float-left width-50per text-align-left">
                                <div class="margin-top-20px margin-left-20px margin-bottom-20px">
                                    <label>Град</label>
                                </div>
                                <div class="margin-top-20px margin-left-20px margin-bottom-20px color-orange text-underline">
                                    <input type="text" name="town" id="town" value="<% out.print(user.getTown());  %>">
                                </div>
                                <div class="margin-top-20px margin-left-20px margin-bottom-20px">
                                    <label>Улица</label>
                                </div>
                                <div class="margin-top-20px margin-left-20px margin-bottom-20px color-orange text-underline">
                                   <input type="text" name="street" id="street" value="<% out.print(user.getStreet());  %>">
                                </div>
                            </div>
                            <div><input type="button" onClick="sendContactsToServlet()" class="styleButton" value="Запази" ></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="height-150px bg-blue"></div>
    </div>
</body>

</html>