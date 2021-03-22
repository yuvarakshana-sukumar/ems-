<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Activation</title>
<style>
body {
	background-color: #99e699;
}

#line {
	cursor: pointer;
}

table {
	margin-top: 80px;
	align-items: center;
	margin-left: auto;
	margin-right: auto;
	width: 75%;
	color: black;
	border-collapse: collapse;
}

th {
	background-color: #33cc33;
	padding: 20px;
}

td {
	padding: 20px;
	background-color: #99e699;
	border: 1px solid #33cc33;
}

a {
	text-decoration: none;
}

.line {
	border: 1px solid black;
	width: 150px;
	height: 30px;
	text-align: center;
	padding: 5px;
	background-color: black;
	color: white;
	pointer: cursor;
}

.pagination {
	display: inline-block;
	margin-left: auto;
	margin-right: auto;
}

.pagination a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
}

.pagination a.active {
	background-color: #4CAF50;
	color: white;
}

.pagination a:hover:not(.active) {
	background-color: #ddd;
}
</style>
<script>
    function myfunc() {
    	  var input, filter, table, tr, td, i, txtValue;
    	  input = document.getElementById("myInput");
    	  filter = input.value.toUpperCase();
    	  table = document.getElementById("myTable");
    	  tr = table.getElementsByTagName("tr");
    	  for (i = 0; i < tr.length; i++) {
    	    td = tr[i].getElementsByTagName("td")[0];
    	    if (td) {
    	      txtValue = td.textContent || td.innerText;
    	      if (txtValue.toUpperCase().indexOf(filter) > -1) {
    	        tr[i].style.display = "";
    	      } else {
    	        tr[i].style.display = "none";
    	      }
    	    }       
    	  }
    	}
      </script>
</head>
<body>
	<c:set var="activation" value="${activation}" scope="session" />
	<table>
		<tr>
			<th>ActivationId</th>
			<th>ActivationTRN</th>
			<th>ActivationDate</th>
			<th>ExpiryDate</th>
			<th>view details</th>
		</tr>

		<c:forEach items="${activation}" var="activation">
			<tr>
				<td><c:out value="${activation.activationId}" /></td>
				<td><c:out value="${activation.getActivation().trn}" /></td>
				<td><c:out
						value="${activation.getActivation().getActivationDate()}" /></td>
				<td><c:out
						value="${activation.getActivation().getExpiryDate()}" /></td>

				<td><a
					href="/activationdetails?activationId=${activation.activationId}&trn=${activation.getActivation().trn}">View
						details</a></td>

			</tr>
		</c:forEach>
	</table>

	<footer>

		<div class="pagination">
			<a href="#">&laquo;</a>
			<c:forEach begin="1" end="${totalPages}" var="page">
				<a href="activations?entitlementId=${eid}&page=${page}">${page}</a>
			</c:forEach>
			<a href="#">&raquo;</a>


		</div>
	</footer>
</body>
</html>