<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!DOCTYPE html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Home</title>
<style>
<%@include file="/WEB-INF/css/index.css"%>
</style>
</head>
<body>
	<div class="box">
		<div class="container">
			<div class="login">Search</div>
			<div class="account">
				<form id=frm action="accountid" method="GET">
					<label for="accountid">Search by AccountId</label><br> <input
						type="text" name="accid" id="accid"
						placeholder="Enter Your AccountId"><br> <select
						name="acctype" id="acctype">
						<option value="CUSTOMER">CUSTOMER</option>
						<option value="PARTNER">PARTNER</option>
					</select>
					<button type="submit" class="btn">Search</button>
				</form>
				<p style="text-align: center;">OR</p>
				<form action="entitlementdetail" method="GET">
					<label for="entitlementid">Search by EntitlementId</label><br>
					<input type="text" name="eid"
						placeholder="Enter Your EntitlementId">
					<button type="submit" class="btn">Search</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>