<%--
  Created by: mkhrun
  Date: 1/29/16
  Time: 11:16
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="pageContext.jsp"/>

<html>
<head>
    <title>purchases of selected list</title>
    <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.12.0.min.js"></script>
    
    <link rel="stylesheet" href="${app}/style/style.css">
    
    <script src="/Kupybaton/js/crossProductByLine.js"></script>
</head>
<body>
    <div class="container">
        <h1 class="aligh-center">
            Purchase for list "${productList.name}" created on ${productList.dateCreated}
        </h1>

        <c:if test="${not empty warningMessage}">
            <p class="alert-danger">${warningMessage}</p>
        </c:if>

        <table class="table" id = "NotChoosedProducts">
            <thead>
            <tr>
                <th>Name</th>
                <th>Unit</th>
                <th>Quantity</th>
                <th>Product choosed</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${purchaseList}" var="purchase">
                <tr>
                    <td class="first">${purchase.product.name}</td>
                    <td class="second">${purchase.product.unit.name}</td>
                    <td class="third">${purchase.quantity}</td>
                    <td class="fourth aligh-center">
                        <input type="checkbox"
                               <c:if test="${purchase.flag}">checked</c:if>
                        >
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <br>
        
    </div>

	<form method="post" action="${app}/CreateNewPurchase.do">
		<select name="productId" id="mySelect" class="select">
			<c:forEach items="${allProducts}" var="oneProduct">
				<option value="${oneProduct.id}">${oneProduct.name}</option>
			</c:forEach>
		</select>
	
		<input type="hidden" name="productlistId" value="${productList.id}" />
		<input type = text name="quantity" placeholder="quantity" class = "quantitySelect">
		<input type="submit" value="Add product">
	</form>
	
	<a href="${app}/CreateNewProduct.do?productlistId=${productList.id}" >
    	<button class = "createSmth">
        	Create New Product
    	</button>
    </a>
	
</body>
</html>
