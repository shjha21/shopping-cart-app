<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<jsp:include page="head.jsp" />
<body>
    <h2>User Registration</h2>

    <div class="form-container">
        <form:form action="/user/register" method="POST" modelAttribute="userObj">
            <div class="form-group">
                Username:<br>
                <form:input path="username" />
                <form:errors path="username" />
            </div>

            <div class="form-group">
                Password:<br>
                <form:input path="userpass" />
            </div>

            <input type="submit" value="Submit" />
        </form:form>

        <form action="/user/login" method="get">
            <input type="submit" value="Back to Login" />
        </form>
    </div>
</body>
</html>
