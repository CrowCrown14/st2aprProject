<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<jsp:include page="header/header.jsp" />
<body>
<div class="mainDiv">
<%--    <h1>Bienvenue ${ firstName } ${ lastName } sur l'application GIFT</h1>--%>

<%--    <form name ='myForm' action='logout' method="post">--%>
<%--        <input type='submit' name='action' value='Log Out'>--%>
<%--    </form> <br>--%>
    <jsp:include page="header/topPageWelcome.jsp"/>
    <jsp:include page="component/excelIntern.jsp" />
</div>
</body>
</html>

<style>
    <%@include file="/styles/style.css"%>
</style>