<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Activation details</title>
<style>
<%@include file="/WEB-INF/css/activationdetails.css"%>
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