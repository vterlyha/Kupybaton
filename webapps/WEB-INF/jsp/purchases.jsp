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

    <script src="${app}/js/purchases.js"></script>

    <script>
        var productVsUnit = {
            <c:forEach items="${allProducts}" var="product" varStatus="loop">
                '<c:out value="${product.id}"/>': '<c:out value="${product.unit.name}"/>'<c:if test="${!loop.last}">,</c:if>
            </c:forEach>
        }
    </script>

</head>
<body>
    <div class="container">
		<ul>
			<li class="dropdown"><a href="#" onclick="showDropdown()" class="changeSmth">Change</a>
				<div id="myDropdown" class="dropdown-content">
					<form method="get" action="${app}/purchases.html">
					<input type="hidden" name="changeListName" value="true"/>
					<input type="hidden" name="productlistId" value="${productList.id}"/>
					<input type="submit" value ="Rename list" >
					</form>

					<form method="post" action="${app}/deleteList.del">
					<input type="hidden" name="productlistId" value="${productList.id}"/>
					<input type="submit" value ="Delete list" >
					</form>

				</div>
			</li>
		</ul>



		<h1 class="aligh-center">

			Purchase for list
			<c:choose>
				<c:when test="${changeListNameBoolean}">
				<form method="post" action="${app}/purchases.post">
					<input type=text name="listName" placeholder="${productList.name}"	class="listNameSelect">
					<input type="hidden" name="productlistId" value="${productList.id}"/>
					<input type="hidden" name="productlistDateCreated" value="${productList.dateCreated}"/>
					<input type="submit" value ="Rename" class="listRenameButton">
				</form>
				</c:when>
				<c:otherwise>
       				"${productList.name}"
				</c:otherwise>
			</c:choose>
			created on ${productList.dateCreated}
		</h1>
		<br>

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
                        <input type="checkbox" class ="productChooser"
                               <c:if test="${purchase.flag}">checked</c:if>
                        >
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

		<table class="table" id="ChoosedProducts">
			<tbody>
			<tr>
			</tr>
			</tbody>
		</table>

		<br>

        <p id="demo"></p>

		<form method="post" action="${app}/CreateNewPurchase.post">
			<select name="productId" id="mySelect" class="select">
                <option>-----</option>
				<c:forEach items="${allProducts}" var="oneProduct">
					<option id="prod" value="${oneProduct.id}">${oneProduct.name}</option>
				</c:forEach>
			</select>

			<input type=text name="quantity" placeholder="quantity"	class="quantitySelect">
            <span id="productUnit">--</span>
			<input type="submit" value="Add product">
		</form>

		<a href="${app}/createNewProduct.html?productlistId=${productList.id}">
			<button class="createSmth">Create New Product</button>
		</a>
	</div>
</body>
</html>
