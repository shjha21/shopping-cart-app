<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<jsp:include page="head.jsp" />
<body>
    <h2>You have entered Gold Shop!</h2>
<form:form action="/shop/3" method="post">
    <div class="checkbox-group">
        <input type="checkbox" id="c4" name="c4" value="Necklace" />
        <label for="c4">Necklace</label>

        <input type="checkbox" id="c5" name="c5" value="Bracelet" />
        <label for="c5">Bracelet</label>

        <input type="checkbox" id="c6" name="c6" value="Ring" />
        <label for="c6">Ring</label>
    </div>
    <input type="submit" value="Next Shop" />
</form:form>

</body>
</html>
