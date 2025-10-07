<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<jsp:include page="head.jsp" />
<body>
    <h2>Welcome!</h2>
    <p>You have successfully logged in.</p>

    <form:form action="/user/logout" method="post" modelAttribute="userObj">
        <input type="submit" value="Logout" />
    </form:form>

    <form:form action="/shop/1" method="post" modelAttribute="userObj">
        <input type="submit" value="Go to Shop 1.." />
    </form:form>
</body>
</html>
