<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="adminnavigationbar.jsp" />
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.21.0/moment.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.0-alpha18/js/tempusdominus-bootstrap-4.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.0-alpha18/css/tempusdominus-bootstrap-4.min.css" />

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
			<div class="card-header">Create Schedule</div>
			<div class="card-body">
				<form action="AddScheduleServlet" method="POST">
					<div class="form-group">
						<label for="shiplabel">Please Select A Ship</label> <select
							id="shipselection" class="form-control" name="shipselection">
							<c:forEach items="${shiplist}" var="ship">
								<option value="${ship.ship_Name}">${ship.ship_Name}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label for="routelabel">Please Select A Route</label> <select
							id="routeselection" class="form-control" name="routeselection">
							<c:forEach items="${routelist}" var="route">
								<option value="${route.route_Name}">${route.route_Name}</option>
							</c:forEach>
						</select>
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label for="departurelabel">Please Select Departure Date
									& Time</label>
								<div class="input-group date" id="datetimepicker7"
									data-target-input="nearest">
									<input type="text" name="departuredatetime" class="form-control datetimepicker-input"
										data-target="#datetimepicker7" readonly required/>
									<div class="input-group-append" data-target="#datetimepicker7"
										data-toggle="datetimepicker">
										<div class="input-group-text">
											<i class="fa fa-calendar"></i>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="arrivallabel">Please Select Arrival Date &
									Time</label>
								<div class="input-group date" id="datetimepicker8"
									data-target-input="nearest">
									<input type="text" name="arrivaldatetime" class="form-control datetimepicker-input"
										data-target="#datetimepicker8" readonly required/>
									<div class="input-group-append" data-target="#datetimepicker8"
										data-toggle="datetimepicker">
										<div class="input-group-text">
											<i class="fa fa-calendar"></i>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<input type="submit" value="Add"
								class="btn btn-primary btn-block">
						</div>
						<div class="col-md-6">
							<a style="color: white" class="btn btn-primary btn-block"
								href="AdminPortal.jsp">Cancel</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	</section>
	<jsp:include page="Footer.jsp" />
	<script type="text/javascript">
    $(function () {
        $('#datetimepicker7').datetimepicker();
        $('#datetimepicker8').datetimepicker({
            useCurrent: false
        });
        $("#datetimepicker7").on("change.datetimepicker", function (e) {
            $('#datetimepicker8').datetimepicker('minDate', e.date);
        });
        $("#datetimepicker8").on("change.datetimepicker", function (e) {
            $('#datetimepicker7').datetimepicker('maxDate', e.date);
        });
        $('#datetimepicker7').datetimepicker('ignoreReadonly',true);
        $('#datetimepicker8').datetimepicker('ignoreReadonly',true);
        $('#datetimepicker7').datetimepicker('format','DD/MM/YYYY HH:mm:ss');
        $('#datetimepicker8').datetimepicker('format','DD/MM/YYYY HH:mm:ss');
    });
</script>
</body>
</html>