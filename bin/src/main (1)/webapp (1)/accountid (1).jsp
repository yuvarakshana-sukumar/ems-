<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="ISO-8859-1">
<title>Account</title>
<style>
* {
	box-sizing: border-box;
}

body, html {
	height: 100%;
	margin: 0;
	font-family: Arial;
}

.tabs {
	background-color: #555;
	width: 100%;
	padding: 50px 16px;
}

.tablink {
	background-color: #555;
	color: white;
	float: left;
	border: none;
	outline: none;
	cursor: pointer;
	padding: 14px 16px;
	font-size: 17px;
	width: 15%;
	border-radius: 10px 10px 0 0;
}

.tablink:hover {
	background-color: #777;
}

.tabcontent {
	color: white;
	display: none;
	padding: 50px 20px;
	height: 100%;
}

#Entitlement {
	background-color: #ADD8E6;
}

#pools {
	background-color: #DDA0DD;;
}

.search {
	float: right;
	font-size: 17px;
}

button {
	padding: 10px;
	border: none;
}

.text {
	padding: 10px 15px;
	border: none;
	width: 100%;
}

table {
	margin-top: 80px;
	align-items: center;
	margin-left: auto;
	margin-right: auto;
	width: 100%;
	color: black;
	border-collapse: collapse;
}

.myTable th {
	background-color: #1ca9c9;
	padding: 20px;
}

.myTable td {
	padding: 20px;
	background-color: #ADD8E6;
	border: 1px solid #1ca9c9;
}

.pooltable th {
	background-color: #FF69B4;
	padding: 20px;
}

.pooltable td {
	padding: 20px;
	background-color: #DDA0DD;;
	border: 1px solid #FF69B4;
}

a {
	text-decoration: none;
	color: black;
}

a, a:link, a:visited, a:hover, a:active {
	cursor: pointer;
	text-decoration: none;
	color: black;
}
</style>
</head>
<body>
	<c:set var="entitlement" value="${entitlement}" scope="session" />
	<c:set var="customerid" value="${customerid}" scope="session" />
	<c:set var="acctype" value="${acctype}" scope="session" />
	<div class="tabs">
		<button class="tablink"
			onclick="openPage('Entitlement', this, '#1ca9c9')" id="defaultOpen">Entitlement</button>
		<button class="tablink" onclick="openPage('pools', this, '#FF69B4')">Pools</button>
	</div>
	<div id="Entitlement" class="tabcontent">
		<form class="search">
			<input class="text" id="myInput" onkeyup="Filter()" type="text"
				placeholder="Search.." name="search">
		</form>

		<table id="myTable" class="myTable">

			<tr>
				<th>EntitlementId</th>
				<th>StartDate</th>
				<th>End Date</th>
				<th>ProductIDs</th>
				<th>Action</th>
			</tr>

			<c:forEach items="${entitlement}" var="entitlement">
				<tr>
					<td><c:out value="${entitlement.entitlementId}" /></td>
					<td><c:out value="${entitlement.getStartDate()}" /></td>
					<td><c:out value="${entitlement.getEndDate()}" /></td>
					<td><c:forEach items="${entitlement.lineItems}" var="lineitem">
                         ${lineitem.getProduct().productId}
                        </c:forEach></td>
					<td><a
						href="/entitlementdetails?entitlementId=${entitlement.entitlementId}"
						class="line">View details</a></td>
				</tr>
			</c:forEach>
		</table>

	</div>
	<div id="pools" class="tabcontent">
		<form class="search">
			<input class="text" type="text" placeholder="Search.." name="search">
		</form>
		<table class="pooltable">
			<tr>
				<th>Pool ID</th>
				<th>End Date</th>
			</tr>
			<c:set var="entitlement" value="${entitlement}" scope="session" />
			<c:forEach items="${entitlement}" var="entitlement">
				<tr>
					<td><c:out value="${entitlement.entitlementId}" /></td>
					<td><c:out value="${entitlement.getEndDate()}" /></td>
				</tr>

			</c:forEach>
		</table>
	</div>

	<script>
function openPage(pageName,elmnt,color) {
  var i, tabcontent, tablinks;
  tabcontent = document.getElementsByClassName("tabcontent");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablink");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].style.backgroundColor = "";
  }
  document.getElementById(pageName).style.display = "block";
  elmnt.style.backgroundColor = color;
}
document.getElementById("defaultOpen").click();

function Filter(){
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("myInput");
    filter = input.value.toUpperCase();
    table = document.getElementById("myTable");
    tr = table.getElementsByTagName("tr");
    for (i = 0; i < tr.length; i++) 
    {
        td = tr[i].getElementsByTagName("td")[0];
        if (td) 
        {
            txtValue = td.textContent || td.innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1) 
            {
                tr[i].style.display = "";
            } 
            else 
            {
            tr[i].style.display = "none";
            }
        }
    }
}
</script>
</body>
</html>