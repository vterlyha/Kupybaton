<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:include page="pageContext.jsp"/>

<html>
<head>
    <link rel="stylesheet" href="${app}/style/style.css">
</head>
<body>
	<div class="container">
		<h1 class="aligh-center">Create new list</h1>
		<c:if test="${not empty warningMessage}">
			<p class="alert-danger">${warningMessage}</p>
		</c:if>

		<form method="post" action="addNewList.do">
			<input type="text" name="listName" placeholder="type name of the list" class="textfield"> Name of the list 
			<input type="SUBMIT" class="button display-block" value="Save">
		</form>

	</div>
</body>
</html>
