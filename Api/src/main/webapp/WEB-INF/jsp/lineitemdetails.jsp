<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lineitem Details</title>
<style>
<%@include file="/css/lineitemdetails.css"%>
</style>
</head>
<body>
	<c:set var="lId" value="${lId}" scope="session" />
	<div class="container">
		<form action="/activation?eId=${eId}">
			<h3>LineItem Details</h3>
			<table>
				<c:forEach items="${entitlement}" var="entitlement">
					<c:if test="${eId == entitlement.entitlementId}">
						<c:forEach items="${entitlement.lineItems}" var="lineitem">
							<c:if test="${lId == lineitem.lineItemId}">
								<tr>
									<td>lineItemID</td>
									<td>${lineitem.lineItemId}</td>
								</tr>

								<tr>
									<td>StartDate</td>
									<td>${lineitem.getStartDate()}</td>
								</tr>

								<tr>
									<td>EndDate</td>
									<td>${lineitem.getEndDate()}</td>
								</tr>

								<tr>
									<td>TotalQuantity</td>
									<td>${lineitem.totalQuantity}</td>
								</tr>

								<tr>
									<td>AvailableQuantity</td>
									<td>${lineitem.availableQuantity}</td>
								</tr>

								<tr>
									<td>ProductIds</td>
									<td>${lineitem.getProduct().productId}</td>
								</tr>
							</c:if>
						</c:forEach>
					</c:if>
				</c:forEach>
			</table>
			<table style="padding: 15px;">
				<tr>
					<td>Products:</td>
					<td><div class="line" id="line">view products</div></td>
				</tr>
			</table>
			<a href="/activation?entitlementId=${eId}" class="btn1">View
				Activations</a>
		</form>
		<div id="myModal" class="modal">
			<div class="modal-content">
				<span class="close">&times;</span>
				<table>
					<tr>
						<th>Name</th>
						<th>desc</th>
						<th>ProductId</th>
						<th>sku</th>
						<th>featureid</th>

					</tr>
					<c:forEach items="${entitlement}" var="entitlement">
						<c:if test="${eId == entitlement.entitlementId}">
							<c:forEach items="${entitlement.lineItems}" var="lineitem">
								<c:if test="${lId == lineitem.lineItemId}">
									<tr>

										<td>${lineitem.getProduct().name}</td>
										<td>${lineitem.getProduct().desc}</td>
										<td>${lineitem.getProduct().productId}</td>
										<td>${lineitem.getProduct().sku}</td>
										<td><c:forEach
												items="${lineitem.getProduct().getFeatures()}" var="feature">
                         ${feature.featureId},
                        </c:forEach></td>

									</tr>
								</c:if>
							</c:forEach>
						</c:if>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
	<script>
 var modal = document.getElementById("myModal");
            var span = document.getElementsByClassName("close")[0];
            var line=document.getElementById("line");
            line.addEventListener('click',function(){
                modal.style.display = "block";
               
            });
             span.onclick = function() {
                   modal.style.display = "none";
                 }
             window.onclick = function(event) {
           if (event.target == modal) {
            modal.style.display = "none";
             }
          }
</script>
</body>
</html>