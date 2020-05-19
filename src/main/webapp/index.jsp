<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<style type="text/css">
  		<%@include file="style.css" %>
	</style>
</head>
<body class="bg-gray">
<div class="mainDiv" >
	<a href="login.jsp">Вход</a>   
	<div class="labelStyle"><label class="title">Създаване на профил</label></div>
    <div class="formStyle">
	<form method="POST" action="register">
    	<label>Потребителско име:</label>
    	<input type="text" id="adress" name="name" class="inputType" placeholder="Въведете имейл адрес" />
    	<label>Парола:</label>
        <input type="password" minlength="8" class="inputType" name="password" placeholder="Въведете парола с поне 8 символа"/>
    	<label>Повторете паролата</label>
        <input type="password" minlength="8" class="inputType" name="repeatPassword" placeholder="Въведете парола с поне 8 символа" />
    	<input type="submit" value="Регистрация" class="btnSubmit" />
    </form>
    </div>
</div>
</body>
</html>