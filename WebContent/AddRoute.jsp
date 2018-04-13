<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <jsp:include page="adminnavigationbar.jsp" />

<title>Insert title here</title>
</head>
<body>
        <section>
            <div id="register"class="container"  >
                <c:if test="${not empty message}">
                    <div class="alert alert-success">
                        <strong>${message}</strong> 
                    </div>
                </c:if>
                <div  class="card card-register mx-auto mt-5">
                    <div class="card-header">Add a Route</div>
                    <div class="card-body">
                        <form  action="AddRouteServlet" method="POST" >
                        	<div class="row">
                        	<div class="col-md-6">
                            <div class="form-group">
                                <label for="departurelabel">Departure Destination</label>
                                <input class="form-control" id="departure" type="text" name ="departure" placeholder="Enter Departure Destination" required>
                            </div>  
                            </div>
                            <div class="col-md-6">                        
                            <div class="form-group">
                                <label for="arrivallabel">Arrival Destination</label>
                                <input class="form-control" id="arrival" name="arrival" type="text" placeholder="Enter Departure Destination" required>
                            </div>
                            </div>                                               
                            </div>
							<div class="row">
							<div class="col-md-6"> 
                            <input type = "submit" value = "Add" class="btn btn-primary btn-block" >
                            </div>
                            <div class="col-md-6">
                            <a  style=color:white class="btn btn-primary btn-block" href="AdminPortal.jsp" >Cancel</a>
                            </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>
        <jsp:include page="Footer.jsp" />

</body>
</html>