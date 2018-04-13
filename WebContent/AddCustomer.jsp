<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <jsp:include page="agentnavigationbar.jsp" />

<title></title>
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
                    <div class="card-header">Add a Customer</div>
                    <div class="card-body">
                        <form  action="AddCustomerServlet" method="POST" > 
                            <div class="form-group">
                                <label for="namelabel">Name</label>
                                <input class="form-control" id="name" name="name" type="text" placeholder="Enter Name" required>
                            </div>
                            <div class="form-group">
                                <label for="namelabel">IC / Passport</label>
                                <input class="form-control" id="icpassport" name="icpassport" type="text" placeholder="Enter IC / Passport" required>
                            </div>
                            <label for="genderlabel">Gender</label> 
                            <div class="form-group">
                                <div class="form-row">
                                    <div class="col-md-6">
                                        <input type ="radio" name = "gender" value = "Male" required> Male 
                                    </div>
                                    <div class="col-md-6">
                                        <input type ="radio" name = "gender" value = "Female"> Female 
                                    </div>
                                </div>
                            </div>                      
                            <div class="form-group">
                                <label for="emaillabel">Email address</label>
                                <input class="form-control" id="email" name="emailaddress" type="email" aria-describedby="emailHelp" placeholder="Enter Email" required>
                            </div>
                                                        <div class="form-group">
                                        <label for="contactlabel">Contact Number</label>
                                        <input class="form-control"  name="contact" type="number" required placeholder="Enter Contact Number">
                                    </div>
                                    <div class="form-group">
                                <label for="companyaddresslabel">Address</label>
                                <textarea rows="3" class="form-control" id="address" name="address" type="text"  placeholder="Enter Adress" required></textarea>
                            </div>
							<div class="row">
							<div class="col-md-6"> 
                            <input type = "submit" value = "Add" class="btn btn-primary btn-block" >
                            </div>
                            <div class="col-md-6">
                            <a  style=color:white class="btn btn-primary btn-block" href="AgentPortal.jsp" >Cancel</a>
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