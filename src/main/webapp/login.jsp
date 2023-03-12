<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="header.jsp" />
<body>
<div class="formulaire">
<h1>Bienvenue sur l'application GIFT</h1>
${ messageError }
${ createdAccountMessage }
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