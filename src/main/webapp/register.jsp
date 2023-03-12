<%--
  Created by IntelliJ IDEA.
  User: CrowCrown
  Date: 12/03/2023
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GIFT Project</title>
</head>
<body>
<h1>Register</h1>

${ messageError }
<form name ='myForm' action='register' method="post">
    <label>Username : <input type='text' name='loginField' id="idLoginField" required="required"></label><br/>
    <label>Password : <input type='password' name='pwdField' id="idPwdField" required="required"></label> <br/>
    <label>Password confirmation : <input type='password' name='pwdValidateField' id="idPwdValidateField" required="required"></label> <br/>
    <label>First Name : <input type='text' name='firstNameField' id="idfirstNameField" required="required"></label> <br/>
    <label>Last Name : <input type='text' name='lastNameField' id="idlastNameField" required="required"></label> <br/>

    <input type='submit' name='action' value='Register'>
</form>
<a href="login"><button>Login</button></a>
</body>
</html>
