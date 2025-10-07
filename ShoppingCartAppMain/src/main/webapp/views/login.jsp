<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<jsp:include page="head.jsp" />
<body>
    <h2>User Login</h2>

    <div class="form-container">
        <form:form method="post" modelAttribute="userObj" action="/user/login">
            <div class="form-group">
                Username:<br>
                <form:input path="username" />
                <form:errors path="username" />
            </div>

            <div class="form-group">
                Password:<br>
                <form:password path="userpass" />
                <form:errors path="userpass" />
            </div>

            <input type="submit" value="Login" />
        </form:form>

        <form action="/user/register" method="get">
            <input type="submit" value="New User" />
        </form>
    </div>
</body>
</html>
