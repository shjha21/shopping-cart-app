<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<jsp:include page="head.jsp" />
<body>
    <h2>You have entered Car Shop!</h2>
<form:form action="/shop/invoice" method="post">
    <div class="checkbox-group">
        <input type="checkbox" id="c7" name="c7" value="Ferrari" />
        <label for="c7">Ferrari</label>

        <input type="checkbox" id="c8" name="c8" value="Lamborghini" />
        <label for="c8">Lamborghini</label>

        <input type="checkbox" id="c9" name="c9" value="Mercedes" />
        <label for="c9">Mercedes</label>
    </div>
    <input type="submit" value="Get Invoice" />
</form:form>

</body>
</html>
