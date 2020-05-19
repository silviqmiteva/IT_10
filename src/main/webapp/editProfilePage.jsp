<%@page import="project.User"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<style type="text/css">
  		<%@include file="profileFormStyle.css" %>
	</style>
</head>
<body class="margin-none">
    <div>
    <form method="post" action="profile">
        <div class="height-100px bg-blue">
        <header><a href="index.jsp" class="link">Изход</a></header>
        </div>
        <div class="bg-gray height-967px text-align-center">
            <div class="width-75per display-inline-block">
                <div class="display-inline">
                    <img src="woman.svg" class="width-30per margin-top-20px bg-orange margin-right-20px" />
                </div>
                <div class="text-align-left color-blue display-inline-block color-blue width-60per">
       
                    <div class="margin-bottom-20px">
                       <div><h2>Профилна информация</h2>
                        	<labеl>Име: <% User user = (User)session.getAttribute("user"); %></labеl>
                        	<input type="text" name="username" value="<% out.print(user.getName()); %>"></div> 
                        	<input type="hidden" name="id" value="<% out.print(user.getId()); %>">
                     <div class="float-right"><input type="submit" class="styleButton" value="Запази"></div>
                    </div>
                    <div class="margin-bottom-20px">
                   </div>
                    <div class="margin-bottom-20px"><label>Работа:</label><input type="text" name="work" value="<% out.print(user.getWork()); %>"></div>
                    <div class="margin-bottom-20px">
                        <p>Описание: Известен факт е,че читателя обръща внимание на съдържанието, което чете, а не на
                            оформлението му. Свойството на Lorem Ipsum e, че до голяма степен има нормално разпределение
                            на буквите и се чете
                            по-лесно, за разлика от нормален текст на английски език като "Това е съдържание, това е
                            съдържание". </p>
                    </div>
                </div>
            </div>
            <div class="color-blue">
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
                                    <input type="text" name="address" value="<% out.print(user.getAdress());  %>">
                                </div>
                                <div class="margin-top-20px margin-left-50px margin-bottom-20px">
                                    <label>Телефон</label>
                                </div>
                                <div class="margin-top-20px margin-left-50px margin-bottom-20px color-orange text-underline">
                                   <input type="text" name="phone" value="<% out.print(user.getPhone());  %>">
                                </div>
                            </div>
                            <div class="float-left width-50per text-align-left">
                                <div class="margin-top-20px margin-left-20px margin-bottom-20px">
                                    <label>Град</label>
                                </div>
                                <div class="margin-top-20px margin-left-20px margin-bottom-20px color-orange text-underline">
                                    <input type="text" name="town" value="<% out.print(user.getTown());  %>">
                                </div>
                                <div class="margin-top-20px margin-left-20px margin-bottom-20px">
                                    <label>Улица</label>
                                </div>
                                <div class="margin-top-20px margin-left-20px margin-bottom-20px color-orange text-underline">
                                   <input type="text" name="street" value="<% out.print(user.getStreet());  %>">
                                </div>
                            </div>
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </form>
        <div class="height-150px bg-blue"></div>
    </div>
</body>

</html>