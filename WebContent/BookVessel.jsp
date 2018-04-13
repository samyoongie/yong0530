<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="agentnavigationbar.jsp" />
<title>Insert title here</title>
</head>
<body>
	<section>
	<div id="register" class="container">
		<c:if test="${not empty message}">
			<div class="alert alert-success">
				<strong>${message}</strong>
			</div>
		</c:if>
		<div class="card card-register mx-auto mt-5">
			<div class="card-header">Book Vessel</div>
			<div class="card-body">
				<form name="frm" action="BookVesselServlet" method="POST">
					<div class="form-group">
						<label for="routelabel">Please Select A Route</label> <select
							id="routeselection" class="form-control" name="routeselection"
							onchange="callservlet()">
							<c:forEach items="${routelist}" var="route">
								<option value="${route.route_Name}">${route.route_Name}</option>
							</c:forEach>
						</select>
						<c:if test="${not empty selectedroute}">
							<input id="selectedroute" type="hidden" value="${selectedroute}">
						</c:if>

					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label for="departurelabel">Please Select Departure Date</label>
								<select id="dateselection" class="form-control"
									name="dateselection" onchange="showarrivaltime()">
									<c:if test="${empty newschedulelist}">
										<option>No schedule available for this route.</option>
									</c:if>
									<c:forEach items="${newschedulelist}" var="schedule">
										<option
											value="${schedule.schedule_departuretime}#${schedule.schedule_arrivaldatetime}#${schedule.ship.ship_Name}"><fmt:formatDate
												value="${schedule.schedule_departuretime}"
												pattern="yyyy-MM-dd HH:mm:ss" /></option>
									</c:forEach>
								</select>
								<c:if test="${not empty selecteddate}">
									<input id="selecteddate" type="hidden" value="${selecteddate}">
								</c:if>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="arrivallabel">Estimated Arrival Date</label> <input
									class="form-control" id="arrival" name="arrival" type="text"
									readOnly>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="shiplabel">Ship Name</label> <input
							class="form-control" id="shipname" name="shipname" type="text"
							readOnly>
					</div>
					<div class="form-group">
						<label for="customerlabel">Please Select Customer</label> <select
							id="customerselection" class="form-control"
							name="customerselection" onchange="callitemservlet()">
							<c:forEach items="${customerlist}" var="customer">
								<option value="${customer.cust_name}">${customer.cust_name}</option>
							</c:forEach>
						</select>
						<c:if test="${not empty selectedcustomer}">
							<input id="selectedcustomer" type="hidden"
								value="${selectedcustomer}">
						</c:if>
					</div>

					<c:if test="${not empty customeritemlist}">
						<div class="form-group">
							<label for="itemlabel">Item Name</label>
							<div class="row" style="padding-top: 5px">
								<c:forEach items="${customeritemlist}" var="item">
									<div class="col-md-4" style="padding-bottom: 20px">
										<div class="checkbox">
											<label> <input type="checkbox" onchange="showprice()"
												id="checkvalue" name="checkedvalue"
												value="${item.item_name}"> ${item.item_name}
											</label>
										</div>
									</div>
								</c:forEach>
							</div>
						</div>
					</c:if>
					<div class="form-group">
						<label for="pricelabel">Total Price</label> <input
							class="form-control" id="price" name="price" value=0 type="text"
							readOnly>
					</div>

					<div class="row">
						<div class="col-md-6">
							<c:if
								test="${not empty newschedulelist && not empty customeritemlist}">
								<input type="submit" value="Add"
									class="btn btn-primary btn-block">
							</c:if>

						</div>
						<div class="col-md-6">
							<a style="color: white" class="btn btn-primary btn-block"
								href="AgentPortal.jsp">Cancel</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	</section>
	<script>
		jQuery(function() {
			var date = document.getElementById("selecteddate").value;
			if (date != null) {
				document.getElementById("dateselection").value = date;
			}

		});

		jQuery(function() {
			var route = document.getElementById("selectedroute").value;
			if (route != null) {
				document.getElementById("routeselection").value = route;
			}

		});

		jQuery(function() {
			showarrivaltime();

		});

		jQuery(function() {
			var customer = document.getElementById("selectedcustomer").value;
			if (customer != null) {
				document.getElementById("customerselection").value = customer;
			}

		});

		function showarrivaltime() {

			var selectedoption = document.getElementById('dateselection');
			var selectedValue = selectedoption.options[selectedoption.selectedIndex].value;
			var deparrdate = selectedValue.split("#");
			var departuredate = deparrdate[0];
			var arrivaldate = deparrdate[1].replace('.0', '');
			var shipname = deparrdate[2];
			if (arrivaldate == null && shipname == null) {
				arrivaldate = "";
				shipname = "";
			}
			document.getElementById("arrival").value = arrivaldate;
			document.getElementById("shipname").value = shipname;
		}

		function callservlet() {
			document.frm.action = "RetrieveScheduleAgain";
			document.frm.submit();
		}

		function callitemservlet() {
			document.frm.action = "RetrieveItemAgain";
			document.frm.submit();
		}

		function showprice() {
			var a = document.frm["checkvalue"];
			count = 0;
			
				for (var i = 0; i < a.length; i++) {
					if (a[i].checked == true) {
						count++;
					}
				}
			if(a.length === undefined){
				count = 1;
			}
			var price;
			price = 100 * count;
			document.getElementById("price").value = price;
		}
	</script>
	<jsp:include page="Footer.jsp" />

</body>
</html>