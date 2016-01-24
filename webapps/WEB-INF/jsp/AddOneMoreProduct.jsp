<<<<<<< HEAD
<%@ page import="com.kupybaton.model.Product"%>
<%@ page import="java.util.List"%>
<%@ page import="com.kupybaton.model.ProductList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
<link rel="stylesheet" href="/Kupybaton/style/Style.css">
</head>
<body>
	<form method="post" action="AddOneMoreProduct.do">
	<h1 >
		<c:forEach items="${productlist}" var="list">
			<c:set var="listId" scope="request" value="${list.getId()}"/>
			<c:out value="${list.getName()}" />
			<input type="hidden" name="oneproductlist" value="${listId}" />
		</c:forEach>
	</h1>
	
	<p>
		<c:forEach items="${chosenProducts}" var="product">
		<c:set var="chosenProductId" scope="request" value="${product.getId()}"/>
			<c:out value="${product.getName()}" />
		</c:forEach>
	</p>
				
	<select name="productName">
		<c:forEach items="${products}" var="oneProduct">
			<option value="${oneProduct}" selected>${oneProduct.getName()}</option>
			<c:set var="productId" scope="request" value="${oneProduct.getId()}"/>
		</c:forEach>
	</select>
	
	<input type="hidden" name="product" value="${productId}" />
	<input type="hidden" name="chosenProduct" value="${chosenProductId}" />
	<input type="hidden" name="product" value="${chosenProductId}" />
	<input type="SUBMIT" class="b2" value="Save">
	</form>


</body>
</html>
=======
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
    <link rel="stylesheet" href="/Kupybaton/style/Style.css">
</head>

<body>
	<form method="post" action="AddOneMoreProduct.do">
        <h1>
            <c:forEach items="${productlist}" var="list">
                <c:set var="listId" scope="request" value="${list.getId()}"/>
                <c:out value="${list.getName()}" />
                <input type="hidden" name="oneproductlist" value="${listId}" />
            </c:forEach>
        </h1>

        <p>
            <c:forEach items="${chosenProducts}" var="product">
            <c:set var="chosenProductId" scope="request" value="${product.getId()}"/>
                <c:out value="${product.getName()}" />
            </c:forEach>
        </p>

        <select name="productName">
            <c:forEach items="${products}" var="oneProduct">
                <option value="${oneProduct}" selected>${oneProduct.getName()}</option>
                <c:set var="productId" scope="request" value="${oneProduct.getId()}"/>
            </c:forEach>
        </select>

        <input type="hidden" name="product" value="${productId}" />
        <input type="hidden" name="chosenProduct" value="${chosenProductId}" />
        <input type="hidden" name="product" value="${chosenProductId}" />

        <input type="submit" class="b2" value="Save">
    </form>
</body>
</html>
>>>>>>> 8df456e5d132335dfd9edce5c54280765d4351f1
