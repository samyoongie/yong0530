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
                    <div class="card-header">Agent Profile</div>
                    <div class="card-body">
                        <form  action="UpdateAgentProfile" method="POST" >
                            <div class="form-group">
                                <label for="usernamelabel">Username</label>
                                <input class="form-control" id="username" type="text" value="${agentprofile.username}" name ="username"  disabled>
                            </div>
                            <div class="form-group">
                                <div class="form-row">
                                    <div class="col-md-6">
                                        <label for="passwordlabel">Password</label>
                                        <input class="form-control" id="password" name="password" type="password" value="${agentprofile.password }" required>
                                    </div>
                                    <div class="col-md-6">
                                        <label for="confirmpasswordlabel">Confirm Password</label>
                                        <input class="form-control" id="ConfirmPassword" name = "confirmpassword" type="password" value="${agentprofile.password}" required>
                                    </div>
                                </div>
                            </div> 
                            <div class="form-group">
                                <label for="namelabel">Name</label>
                                <input class="form-control" id="name" name="name" type="text" value="${agentprofile.name}" disabled>
                            </div>
                            
                            <div class="form-group">
                                <label for="genderlabel">Gender</label> 
                                <input class="form-control" id="gender" name="gender" type="text" value="${agentprofile.gender}" disabled>
                            </div>                      
                            <div class="form-group">
                                <label for="emaillabel">Email address</label>
                                <input class="form-control" id="email" name="emailaddress" type="email" aria-describedby="emailHelp" value="${agentprofile.emailaddress}" required>
                            </div>
                                                        <div class="form-group">
                                        <label for="contactlabel">Contact Number</label>
                                        <input class="form-control"  name="contact" type="number" required value="${agentprofile.contactnumber}">
                                    </div>
                            <div class="form-group">
                                <label for="companynamelabel">Company name</label>
                                <input class="form-control" id="companyname" name="companyname" type="text"  value="${agentprofile.companyname}" required>
                            </div>
 
                            
                            <div class="form-group">
                                <label for="companyaddresslabel">Company address</label>
                                <textarea rows="3" class="form-control" id="companyaddress" name="companyaddress" type="text" required>${agentprofile.companyaddress}</textarea>
                            </div>
                            <div class="form-group">
                                <label for="remaininglabel">Remaining Credit</label>
                                <input class="form-control" id="credit" name="credit" type="text" value="${agentprofile.credit}" disabled> 
                            </div>                            
							<div class="row">
							<div class="col-md-6">
                            <input type = "submit" value = "Update Profile" class="btn btn-primary btn-block" >
                            </div>
                            <div class="col-md-6">
                            <a  style=color:white class="btn btn-primary btn-block" href="AdminPortal.jsp" >Cancel</a>
                            </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div  class="card card-register mx-auto mt-5">
                    <div class="card-header">Top Up Credit</div>
                    <div class="card-body">
                                            <form method="POST" action="TopupCredit">                                            
                        <div class="form-group">
                                <label for="topupcreditlabel">Top Up Credit</label>
                                <div class="row">
                                            <div class="col-md-6">
                                <input class="form-control" id="topupcredit" name="topupcredit" type="number" min=1 required> 
                            </div>
                            <div class="col-md-6">
                            <input type = "submit" value = "Top Up" class="btn btn-primary btn-block" >
                            </div>                                                        
                            </div>
                            </div>
                        </form>
                    </div>
                    </div>
                    </div>
            </div>
        </section>
        <jsp:include page="Footer.jsp" />
</body>
</html>