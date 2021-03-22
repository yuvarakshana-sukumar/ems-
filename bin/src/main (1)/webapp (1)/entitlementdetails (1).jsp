<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Entitlement Details</title>
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

body {
	background-color: #1ca9c9;
}

.container {
	background-color: #ADD8E6;
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
	width: 400px;
	transition: all 0.5s;
	cursor: pointer;
	margin: 5px;
}

a {
	padding: 20px;
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

thead {
	display: table-header-group;
}

.tr.th {
	width: 10%;
}

.tr.td {
	width: 10%;
}

.modal {
	display: none;
	position: fixed;
	z-index: 1;
	padding-top: 100px;
	left: 0;
	top: 0;
	width: 100%;
	height: 100%;
	overflow: auto;
	background-color: rgb(0, 0, 0);
	background-color: rgba(0, 0, 0, 0.4);
}

.modal-content {
	background-color: #ADD8E6;
	margin: auto;
	padding: 20px;
	border-radius: 6px;
	height: 60%;
	border: 1px solid #888;
	width: 80%;
	max-height: calc(100vh - 210px);
	overflow-y: auto;
}

.close {
	color: #aaaaaa;
	float: right;
	font-size: 28px;
	font-weight: bold;
	cursor: pointer;
}

a {
	text-decoration: none;
	color: black;
}

.line {
	border: 1px solid #1ca9c9;
	width: 150px;
	height: 30px;
	text-align: center;
	padding: 5px;
	background-color: #1ca9c9;
	color: white;
	cursor: pointer;
}
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