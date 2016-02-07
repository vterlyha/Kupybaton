<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:include page="pageContext.jsp"/>
<html>
<head>
<link rel="stylesheet" href="/Kupybaton/style/style.css">
</head>
<body>
	<h1>
		New Unit
	</h1>
	
	<c:if test="${not empty warningMessage}">
            <p class="alert-danger">${warningMessage}</p>
    </c:if>

	<form method="post" action="CreateNewUnit.do">
		<p>
			<input type="text" name="unitName" placeholder="name of the unit" class = "textfield">
			Name of the unit
		</p>
		
		<input type="hidden" name="productlistId" value="${productList.id}" />
		<input type="SUBMIT" class="b1" value="Create new Unit">
	</form>

</body>
</html>
