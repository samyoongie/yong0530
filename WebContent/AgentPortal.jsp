<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<jsp:include page="agentnavigationbar.jsp" />
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/moment-with-locales.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
<script type="text/javascript"
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="https://rawgit.com/tempusdominus/bootstrap-4/master/build/js/tempusdominus-bootstrap-4.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="https://rawgit.com/tempusdominus/bootstrap-4/master/build/css/tempusdominus-bootstrap-4.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
<title>JSP Page</title>
</head>
<body>
	<section>
	<div class="container">
		<c:choose>
			<c:when test="${not empty allitemlist}">
				<div class="form-group">
					<input type="text" readonly class="form-control-plaintext"
						value="Today's Booking ( <fmt:formatDate pattern="YYYY/MM/dd"
											value="${currentdate}" /> )" />
				</div>

				<c:if test="${not empty message}">
					<div class="alert alert-success">
						<strong>${message}</strong>
					</div>
				</c:if>

				<div class="table-responsive">
					<table class="table" id="myTable">
						<thead>
							<tr>
								<th>#</th>
								<th>Item</th>
								<th>Route</th>
								<th>Departure Date</th>
								<th>Booking Time</th>
							</tr>
						</thead>
						<tbody>
							<c:set var="count" value="0" scope="page" />
							<c:forEach items="${allitemlist}" var="item">
								<tr>
									<c:set var="count" value="${count + 1}" scope="page" />
									<td>${count}</td>
									<td>${item.item_name}</td>
									<td>${item.booking.schedule.route.route_Name}</td>
									<td><fmt:formatDate pattern="YYYY/MM/dd HH:mm:ss"
											value="${item.booking.schedule.schedule_departuretime}" /></td>
									<td><fmt:formatDate pattern="HH:mm:ss"
											value="${item.booking.booking_Date}" /></td>
								<tr />
							</c:forEach>

						</tbody>
					</table>
				</div>
			</c:when>
			<c:otherwise>
				<div class="col-md-12">
					<div class="alert alert-success">
						<strong>No item found! Please try again!</strong>
					</div>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
	</section>
</body>
<jsp:include page="Footer.jsp" />


</html>