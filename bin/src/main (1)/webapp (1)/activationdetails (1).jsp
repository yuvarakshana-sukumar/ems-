<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Activation details</title>
<style>
* {
	box-sizing: border-box;
}

body {
	background-color: #f9fafb;
	display: flex;
	align-items: center;
	justify-content: center;
	min-height: 100vh;
	margin: 0;
}

.container {
	background-color: #99e699;;
	box-sizing: border-box;
	box-shadow: 0px 2px 10px #888888;
	width: 600px;
	justify-content: center;
	padding: 20px;
}

input {
	width: 500px;
	height: 30px;
	border: 0.3px solid lightgray;
}

.button {
	border-radius: 4px;
	background-color: #696969;
	border: none;
	color: white;
	text-align: center;
	font-size: 20px;
	padding: 20px;
	width: 300px;
	transition: all 0.5s;
	cursor: pointer;
	margin: 5px;
}

.button span {
	cursor: pointer;
	display: inline-block;
	position: relative;
	transition: 0.5s;
}

.button span:after {
	content: '\00bb';
	position: absolute;
	opacity: 0;
	top: 0;
	right: -20px;
	transition: 0.5s;
}

.button:hover span {
	padding-right: 25px;
}

.button:hover span:after {
	opacity: 1;
	right: 0;
}

table, th, td {
	padding: 15px;
	border: none;
}

a {
	text-decoration: none;
}
</style>

</head>
<body>
	<c:set var="aId" value="${aId}" scope="session" />

	<div class="container">
		<form>
			<h3>Activation Details</h3>
			<table>
				<c:forEach items="${activation}" var="activation">
					<c:if test="${aId == activation.activationId}">
						<tr>
							<td>ActivationID</td>
							<td><c:out value="${activation.activationId}" /></td>
						</tr>

						<tr>
							<td>LineItemID</td>
							<td><c:out value="${activation.getActivation().lineItemId}" /></td>
						</tr>
						<tr>
							<td>EntitlementID</td>
							<td><c:out
									value="${activation.getActivation().entitlementId}" /></td>
						</tr>
						<tr>
							<td>ActivatorID</td>
							<td><c:out value="${activation.getActivation().activatorId}" /></td>
						</tr>
						<tr>
						<tr>
							<td>Quantity</td>
							<td><c:out value="${activation.quantity}" /></td>
						</tr>
						<tr>
							<td>Product Name</td>
							<td><c:out value="${activation.productName}" /></td>
						</tr>
						<tr>
							<td>ActivationTRN</td>
							<td><c:out value="${activation.getActivation().trn}" /></td>
						</tr>
						<tr>
							<td>ActivationDate</td>
							<td><c:out
									value="${activation.getActivation().getActivationDate()}" /></td>
						</tr>
						<tr>
							<td>ExpiryDate</td>
							<td><c:out
									value="${activation.getActivation().getExpiryDate()}" /></td>
						</tr>
						<tr>
							<td>CurrentState</td>
							<td><c:out
									value="${activation.getActivation().currentState}" /></td>
						</tr>
						<tr>
							<td>isActive</td>
							<td><c:out value="${activation.getActivation().isActive()}" /></td>
						</tr>
					</c:if>
				</c:forEach>
			</table>

			<a href="/member?trn=${trn}"
				style="color: white; background-color: #FCA130;" class="button">View
				Members</a>

		</form>
	</div>
</body>
</html>