<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="header/header.jsp" />
<body>
<div class="mainDiv">
<h1>Register</h1>

<p class="error">${ messageError }</p>
<form name ='myForm' action='register' method="post">
    <label>Username : <input type='text' name='loginField' id="idLoginField" required="required"></label><br/>
    <label>Password : <input type='password' name='pwdField' id="idPwdField" required="required"></label> <br/>
    <label>Password confirmation : <input type='password' name='pwdValidateField' id="idPwdValidateField" required="required"></label> <br/>
    <label>First Name : <input type='text' name='firstNameField' id="idfirstNameField" required="required"></label> <br/>
    <label>Last Name : <input type='text' name='lastNameField' id="idlastNameField" required="required"></label> <br/>

    <input type='submit' name='action' value='Register'>
</form>
<a href="login"><button>Login</button></a>
</div>
</body>
</html>

<style>
    <%@include file="/styles/style.css"%>
</style>