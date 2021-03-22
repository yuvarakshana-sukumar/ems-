<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Entitlement Details</title>
<style>
<%@include file="/css/entitlementdetails.css"%>
</style>
</head>
<body>
	<c:set var="eId" value="${eId}" scope="session" />
	<div class="container">
		<form>
			<h3>Entitlement Details</h3>
			<table>

				<c:forEach items="${entitlement}" var="entitlement">
					<c:if test="${eId == entitlement.entitlementId}">
						<tr>
							<td>EntitlementId</td>
							<td><c:out value="${entitlement.entitlementId}" /></td>
						</tr>

						<tr>
							<td>ShippingID</td>
							<td><c:out value="${entitlement.shippingId}" /></td>
						</tr>

						<tr>
							<td>StartDate</td>
							<td><c:out value="${entitlement.getStartDate()}" /></td>
						</tr>

						<tr>
							<td>EndDate</td>
							<td><c:out value="${entitlement.getEndDate()}" /></td>
						</tr>

						<tr>
							<td>Source</td>
							<td><c:out value="${entitlement.source}" /></td>
						</tr>

						<tr>
							<td>OrderNumber</td>
							<td><c:out value="${entitlement.orderNumber}" /></td>
						</tr>

						<tr>
							<td>ContractNumber</td>
							<td><c:out value="${entitlement.contractNumber}" /></td>
						</tr>

						<tr>
							<td>OrderCloseDate</td>
							<td><c:out value="${entitlement.orderClosedDate}" /></td>
						</tr>

						<tr>
							<td>PurchaseOrder</td>
							<td><c:out value="${entitlement.purchaseOrder}" /></td>
						</tr>

						<tr>
							<td>activateSAAS</td>
							<td><c:out value="${entitlement.activateSAAS}" /></td>
						</tr>

						<tr>
							<td>EntitlementState</td>
							<td><c:out value="${entitlement.entitlementState}" /></td>
						</tr>
					</c:if>
				</c:forEach>
			</table>
			<table style="padding: 15px;">
				<tr>
					<td>LineItems:</td>
					<td><div class="line" id="line">view line-items</div></td>
				</tr>
			</table>
			<br> <a href="/activation?entitlementId=${eId}"
				style="color: white; background-color: #33cc33;" class="button">View
				Activations</a>
		</form>
		<div id="myModal" class="modal">
			<div class="modal-content">
				<span class="close">&times;</span>
				<table>
					<thead>
						<tr class="tr">
							<th class="th">LineitemId</th>
							<th class="th">start date</th>
							<th class="th">end date</th>
							<th class="th">TotalQuantity</th>
							<th class="th">AvailableQuantity</th>
							<th class="th">Action</th>
						</tr>
					</thead>
					<c:forEach items="${entitlement}" var="entitlement">
						<c:if test="${eId == entitlement.entitlementId}">
							<c:forEach items="${entitlement.lineItems}" var="lineitem">
								<form action="lineitemdetails">
									<table>
										<tbody>
											<tr class="tr">
												<td class="td">${lineitem.lineItemId}</td>
												<td class="td">${lineitem.getStartDate()}</td>
												<td class="td">${lineitem.getEndDate()}</td>
												<td class="td">${lineitem.totalQuantity}</td>
												<td class="td">${lineitem.availableQuantity}</td>
												<td class="td"><a
													href="/lineitemdetails?lineitemId=${lineitem.lineItemId}"
													class="line">View details</a></td>
											</tr>
										</tbody>
									</table>
								</form>
							</c:forEach>
						</c:if>
					</c:forEach>
				</table>
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