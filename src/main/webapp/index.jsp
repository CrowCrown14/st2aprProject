<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<jsp:include page="header.jsp" />
<body>
<h1>Bienvenue ${ firstName } ${ lastName } sur l'application GIFT</h1>

<form name ='myForm' action='logout' method="post">
    <input type='submit' name='action' value='Log Out'>
</form> <br>
<jsp:include page="excelIntern.jsp" />
</body>
</html>