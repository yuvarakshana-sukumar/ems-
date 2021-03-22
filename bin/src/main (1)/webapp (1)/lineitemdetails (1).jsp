<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lineitem Details</title>
<style>
body {
	background-color: #FCA130;
}

* {
	box-sizing: border-box;
}

body {
	display: flex;
	align-items: center;
	justify-content: center;
	min-height: 100vh;
	margin: 0;
}

.container {
	background-color: #FBF1E6;
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

button {
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

button span {
	cursor: pointer;
	display: inline-block;
	position: relative;
	transition: 0.5s;
}

button span:after {
	content: '\00bb';
	position: absolute;
	opacity: 0;
	top: 0;
	right: -20px;
	transition: 0.5s;
}

button:hover span {
	padding-right: 25px;
}

button:hover span:after {
	opacity: 1;
	right: 0;
}

table, th, td {
	padding: 15px;
	border: none;
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
	background-color: #FBF1E6;
	margin: auto;
	padding: 20px;
	border-radius: 6px;
	height: 40%;
	border: 1px solid #888;
	width: 60%;
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
	border: 1px solid black;
	width: 150px;
	height: 30px;
	text-align: center;
	padding: 5px;
	background-color: black;
	color: white;
	cursor: pointer;
}

.btn1 {
	background-color: #33cc33;
	padding: 10px 20px;
	border-radius: 6px;
}
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