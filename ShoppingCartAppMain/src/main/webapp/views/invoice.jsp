<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<jsp:include page="head.jsp" />
<body>

<h2>Invoice</h2>

<c:if test="${not empty billSummary}">
    <p><strong>Bill No:</strong> ${billSummary.billno}</p>
    <p><strong>Bill Date:</strong> ${billSummary.billDate}</p>
    <p><strong>Customer:</strong> ${billSummary.username}</p>

    <h3>Items</h3>
    <table>
        <tr>
            <th>Description</th>
            <th>Price</th>
        </tr>
        <c:forEach var="i" begin="0" end="${fn:length(billSummary.itemdesc)-1}">
            <tr>
                <td>${billSummary.itemdesc[i]}</td>
                <td>₹${billSummary.itemprice[i]}</td>
            </tr>
        </c:forEach>
    </table>

    <p style="margin-top: 20px;">
        <strong>Total:</strong> ₹
        <c:set var="total" value="0" />
        <c:forEach var="price" items="${billSummary.itemprice}">
            <c:set var="total" value="${total + price}" />
        </c:forEach>
        ${total}
    </p>
</c:if>

<c:if test="${empty billSummary}">
    <p>No bill data available.</p>
</c:if>

</body>
</html>
