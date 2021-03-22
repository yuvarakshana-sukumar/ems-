<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Members</title>
<style>
body {
	background-color: #FBF1E6;
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
	background-color: #FCA130;
	padding: 20px;
}

td {
	padding: 20px;
	background-color: #FBF1E6;
	border: 1px solid #FCA130;
}

.pagination {
	display: inline-block;
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
</head>
<body>
	<table>
		<tr>
			<th>MemberId</th>
			<th>Type</th>
			<th>Member Since</th>
		</tr>
		<c:forEach items="${member}" var="member">
			<tr>
				<td><c:out value="${member.memberId}" /></td>
				<td><c:out value="${member.type}" /></td>
				<td><c:out value="${member.getMemberSince()}" /></td>
			</tr>
		</c:forEach>
	</table>

	<footer>
		<div class="pagination">
			<a href="#">&laquo;</a>
			<c:forEach begin="1" end="${totalPages}" var="page">
				<a href="members?trn=${trn}&page=${page}">${page}</a>
			</c:forEach>
			<a href="#">&raquo;</a>
		</div>
	</footer>
</body>
</html>