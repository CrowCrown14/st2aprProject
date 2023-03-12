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

<style>
form {
  display: flex;
  flex-direction: column;
  width: 100vw;
  height: 100vh;
  justify-content: center;
  align-items: center;
  z-index: 1;
}

input,
button {
  margin-top: 1rem;
}

.backgroud {
  position: absolute;
  top: 0;
  left: 0;
  width: 100vw;
  height: 100vh;
  background-image: url('./assets/bg-point.svg');
  background-size: 40px 40px;
  background-repeat: repeat;
  z-index: 0;
}

.gradient-1,
.gradient-2,
.gradient-3 {
  position: absolute;
  width: 150vw;
  height: 150vh;
  background-repeat: no-repeat;
}

.gradient-1 {
  background-image: radial-gradient(circle farthest-corner at 50% 50%,rgba(185, 91, 72, 0.9),rgba(33, 33, 33, 0) 60%);
  transform: translate(-60vw, 25vh) scale(1.25, 1.5) rotateX(0deg) rotateY(0deg) skew(-20deg, 0deg);
}

.gradient-2 {
  background-image: radial-gradient(circle farthest-corner at 50% 50%,rgba(0, 108, 255, 0.9),rgba(33, 33, 33, 0) 68%);
  transform: translate(-60vw, 30vh) scale(1.25, 1.5) rotateX(0deg) rotateY(0deg) skew(-20deg, 0deg);
}

.gradient-3 {
  background-image: radial-gradient(circle farthest-corner at 50% 50%,rgba(0, 106, 255, 0.9),rgba(33, 33, 33, 0) 70%);
  transform: translate(-110vw, 10vh) scale(0.9, 1.5) rotateX(0deg) rotateY(0deg) skew(-20deg, 0deg);
}
</style>