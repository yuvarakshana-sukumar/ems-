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
.box {
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	background-color: white;
}

.login {
	display: flex;
	text-align: center;
	padding: 10px;
	width: 100%;
	align-items: center;
	justify-content: center;
	font-size: 30px;
	border-right: 0.5px solid gray;
}

.container {
	display: flex;
	padding: 20px 20px;
	width: 40%;
	height: 400px;
	background-color: azure;
	box-shadow: 5px 10px 8px #888888;
}

.account {
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
	padding: 20px;
	width: 100%;
}

form {
	width: 100%;
}

input[type=text], #acctype {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

.btn {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	background-color: #39C2E4;
	border: 1px solid #ccc;
	border-radius: 20px;
	box-sizing: border-box;
	cursor: pointer;
}

label {
	font-size: 20px;
}
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