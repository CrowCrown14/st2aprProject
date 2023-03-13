<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="header/header.jsp" />
<body>
<div class="mainDiv">
<h1>Bienvenue sur l'application GIFT</h1>
    <p class="error">${ messageError }</p>
    <p class="error">${ createdAccountMessage }</p>
<form name ='myForm' action='login' method="post">
    <label>Username : <input type='text' name='loginField' id="idLoginField" required="required"></label><br/>
    <label>Password : <input type='password' name='pwdField' id="idPwdField" required="required"></label> <br/>
    <input type='submit' name='action' value='Login'>
</form>
    <a href="register"><button>Register</button></a>
</div>
</body>
</html>

<style>
    <%@include file="/styles/style.css"%>
</style>