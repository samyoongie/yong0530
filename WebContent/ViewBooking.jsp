<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<jsp:include page="adminnavigationbar.jsp" />
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
			<c:when test="${not empty overallitemlist}">
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<input type="text" id="booking" readonly class="form-control-plaintext"
								value="All Booking" />
						</div>
					</div>
					<div class="col-md-6">


						<div class="form-group">
							<div class="input-group date" id="datetimepicker11"
								data-target-input="nearest">
								<input id="myInput" type="text"
									class="form-control datetimepicker-input"
									data-target="#datetimepicker11"  />
								<div class="input-group-append" data-target="#datetimepicker11"
									data-toggle="datetimepicker">
									<div class="input-group-text">
										<i class="fa fa-calendar"></i>
									</div>
								</div>
							</div>
						</div>
					</div>
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
								<th>Agent Name</th>
								<th>Booking Time</th>
							</tr>
						</thead>
						<tbody>
							<c:set var="count" value="0" scope="page" />
							<c:forEach items="${overallitemlist}" var="item">
								<tr>
									<c:set var="count" value="${count + 1}" scope="page" />
									<td>${count}</td>
									<td>${item.item_name}</td>
									<td>${item.booking.schedule.route.route_Name}</td>
									<td><fmt:formatDate pattern="YYYY/MM/dd HH:mm:ss"
											value="${item.booking.schedule.schedule_departuretime}" /></td>
									<td>${item.booking.agent.name}</td>
									<td><fmt:formatDate pattern="YYYY/MM/dd HH:mm:ss"
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
	<script type="text/javascript">
		$(function() {
			$('#datetimepicker11').datetimepicker({
				viewMode : 'years',
				format : 'MMM YYYY'
			});

		});

		$('#myInput').blur(function() {
			if ($(this).val()) {
				myFunction();
			}
		});

		$("#myInput").keypress(function(e) {
			e.preventDefault();
		});
		$("#myInput").keydown(function(e) {
			e.preventDefault();
		});

		function myFunction() {
			var input, table, tr, td, i;
			input = document.getElementById("myInput").value;			
			table = document.getElementById("myTable");
			tr = table.getElementsByTagName("tr");
			for (i = 0; i < tr.length; i++) {				
				td = tr[i].getElementsByTagName("td")[5];	
				if (td) {	
					var a = moment(td.innerHTML).format('MMM YYYY');
					if (a === input) {
						tr[i].style.display = "";
					} else {
						tr[i].style.display = "none";
					}
				}
			}
			showmonth(input);
		}
		
		function showmonth(a){
			document.getElementById("booking").value = "Booking for Month ( " + a + " ) ";
		}
	</script>
</body>
<jsp:include page="Footer.jsp" />


</html>