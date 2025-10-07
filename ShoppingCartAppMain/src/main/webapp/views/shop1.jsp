<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<jsp:include page="head.jsp" />
<body>
    <h2>You have entered Clothes Shop!</h2>
<form:form action="/shop/2" method="post">
    <div class="checkbox-group">
        <input type="checkbox" id="c1" name="c1" value="Shirt" />
        <label for="c1">Shirt</label>

        <input type="checkbox" id="c2" name="c2" value="Pant" />
        <label for="c2">Pant</label>

        <input type="checkbox" id="c3" name="c3" value="Suit" />
        <label for="c3">Suit</label>
    </div>
    <input type="submit" value="Next Shop" />
</form:form>

</body>
</html>
