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
    <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.12.0.min.js" type="text/javascript"></script>
	    
    <link rel="stylesheet" href="${app}/style/style.css">

    <script src="${app}/js/purchases.js"></script>


</head>
<body>
    <div class="container">
    
    <h1 class="aligh-center"> Purchase for list
			<c:choose>
			
				<c:when test="${changeListNameBoolean}">
				<form method="post" action="${app}/changeListName.post">
					<input type="hidden" name="productlistId" value="${productList.id}" />
					<input type=text name="listName" placeholder="${productList.name}"	class="listNameSelect">
					<input type="submit" value ="Rename" class="listRenameButton">
				</form>
				</c:when>
				
				<c:otherwise>
       				"${productList.name}"
				</c:otherwise>
			</c:choose>
			created on ${productList.dateCreated}
		</h1>
		
		<ul>
			<li class="dropdown"><a href="#" class="changeSmth">Change</a>
				<div id="myDropdown" class="dropdown-content">
					
					<form method="get" action="${app}/purchases.html">
						<input type="hidden" name="productlistId" value="${productList.id}" />
						<input type="hidden" name="changeListName" value="true"/>
						<input type="submit" value ="Rename list" >
					</form>

					<form method="post" action="${app}/deleteList.del?productlistId=${productList.id}">
						<input type="submit" value ="Delete list" >
					</form>

				</div>
			</li>
		</ul>
		<br>

		<c:if test="${not empty warningMessage}">
            <p class="alert-danger">${warningMessage}</p>
        </c:if>

        <table class="table" id = "NotChoosedProducts">
			<colgroup>
				<col class="first">
				<col class="second">
				<col class="third">
				<col class="fourth">
			</colgroup>
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
                    <td>${purchase.product.name}</td>
                    <td>${purchase.product.unit.name}</td>
                    <td class="third">${purchase.quantity}</td>
                    <td class="fourth">
                        <input type="checkbox" class ="productChooser"
                               <c:if test="${purchase.flag}">checked</c:if>
                        >
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

		<table class="table" id="ChoosedProducts">
			<colgroup>
				<col class="first">
				<col class="second">
				<col class="third">
				<col class="fourth">
			</colgroup>
			<tbody>
			</tbody>
		</table>

		<br>

        <p id="demo"></p>

		<form method="post" action="${app}/CreateNewPurchase.post?productlistId=${productList.id}">
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
