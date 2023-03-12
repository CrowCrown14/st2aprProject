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
<h1>Bienvenue sur l'application GIFT</h1>
${ messageError }
${ createdAccountMessage }
<form name ='myForm' action='login' method="post">
    <label>Username : <input type='text' name='loginField' id="idLoginField" required="required"></label><br/>
    <label>Password : <input type='password' name='pwdField' id="idPwdField" required="required"></label> <br/>
    <input type='submit' name='action' value='Login'>
</form>

<a href="register"><button>Register</button></a>
</body>
</html>

