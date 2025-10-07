<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<jsp:include page="head.jsp" />
<body>
    <h2>User Already Logged In</h2>
    <p>You are already logged in from another session or device.</p>

    <form:form action="/user/logout" method="post" modelAttribute="userObj">
        <input type="submit" value="Logout Current Session" />
    </form:form>

    <a href="/user/login" class="link">Back to Login</a>
</body>
</html>
