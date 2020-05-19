<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<style type="text/css">
  		<%@include file="style.css" %>
	</style>
</head>
<body class="bg-gray">
<div class="mainDiv" >
<a href="index.jsp">Регистрация</a>
<form action="users" method="post"><input type="submit" class="color-white" value="Потребители"></form>
	<div class="labelStyle"><label class="title">Влезте в системата</label></div>
    <div class="formStyle">
	<form method="POST" action="login">
    	<label>Потребителско име:</label>
    	<input type="text" id="adress" name="name" class="inputType" placeholder="Въведете имейл адрес"/>
    	<label>Парола:</label>
        <input type="password" minlength="8" class="inputType" name="password" placeholder="Въведете парола с поне 8 символа"/>
    	<input type="submit" value="Вход" class="btnSubmit">
    </form>
    </div>
</div>
</body>
</html>