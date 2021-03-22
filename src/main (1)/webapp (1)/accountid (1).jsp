<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="ISO-8859-1">
<title>Account</title>
<style>
<%@include file="/css/accountid.css"%>
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
	<footer>


		<div class="pagination">

			<c:forEach begin="1" end="${totalPages}" var="page">
				<a
					href="account?customerid=${customerid}&acctype=${acctype}&page=${page}">${page}</a>
			</c:forEach>

		</div>
	</footer>
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