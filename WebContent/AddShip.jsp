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
                    <div class="card-header">Add a Ship</div>
                    <div class="card-body">
                        <form  action="AddShipServlet" method="POST" >
                            <div class="form-group">
                                <label for="shipnamelabel">Ship Name</label>
                                <input class="form-control" id="shipname" type="text" name ="shipname" placeholder="Enter Ship Name" required>
                            </div>                           
                            <div class="form-group">
                                <label for="baylabel">Number of Bay</label>
                                <input class="form-control" min=1 id="bayquantity" name="bayquantity" type="number" placeholder="Enter Number of Bay" required>
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