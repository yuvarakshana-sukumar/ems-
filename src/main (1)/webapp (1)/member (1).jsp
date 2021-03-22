<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Members</title>
<style>
<%@include file="/css/member.css"%>

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
			<c:forEach begin="1" end="${totalPages}" var="page">
				<a href="members?trn=${trn}&page=${page}">${page}</a>
			</c:forEach>
		</div>
	</footer>
</body>
</html>