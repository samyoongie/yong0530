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
            <c:choose>
        <c:when test="${not empty customerlist}">     
                <c:if test="${not empty message}">
                    <div class="alert alert-success">
                        <strong>${message}</strong> 
                    </div>
                </c:if>
                <div  class="card card-register mx-auto mt-5">
                    <div class="card-header">Add a Item</div>
                    <div class="card-body">
                        <form  action="AddItemServlet" method="POST" > 
                        <div class="form-group">
                                        <label for="customerlabel">Please Select A Customer</label>
                                        <select id="customerselection" class="form-control" name="customerselection">
                                            <c:forEach items="${customerlist}" var="customer">
                                                <option value="${customer.cust_name}">${customer.cust_name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>       
                            <div class="form-group">
                                <label for="itemnamelabel">Item Name</label>
                                <input class="form-control" id="itemname" name="itemname" type="text" placeholder="Enter Item Name" required>
                            </div>
                             <div class="form-group">
                                <label for="itemdescriptionlabel">Item Description</label>
                                <textarea rows="3" class="form-control" id="itemdescription" name="itemdescription" type="text"  placeholder="Enter Item Description" required></textarea>
                            </div>
                            <div class="form-group">
                                <label for="itemquantitylabel">Item Quantity</label>
                                <input class="form-control" id="itemquantity" name="itemquantity" min=1 type="number" placeholder="Enter Item Quantity" required>
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
                </c:when>
            <c:otherwise>
            <div class="alert alert-success">
                        <strong>No customer found! Please try again!</strong> 
                    </div>
            </c:otherwise>
            </c:choose>
            </div>
            
            
        </section>
        <jsp:include page="Footer.jsp" />

</body>
</html>