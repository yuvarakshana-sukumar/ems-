<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Activation</title>
<style>
<%@include file="/WEB-INF/css/activation.css"%>
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

			<c:forEach begin="1" end="${totalPages}" var="page">
				<a href="activations?entitlementId=${eid}&page=${page}">${page}</a>
			</c:forEach>

		</div>
	</footer>
</body>
</html>