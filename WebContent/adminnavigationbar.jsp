<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Container Management System</title>


        <!-- Bootstrap core CSS -->
        <link href="css/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts for this template -->
        <link href="css/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
        <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>


        <!-- Custom styles for this template -->
        <link href="css/agency.css" rel="stylesheet">
        <link href="css/sb-admin.css" rel="stylesheet">
        <link href="css/customedcss.css" rel="stylesheet">

</head>
<body>

        <nav class="navbar navbar-expand-lg navbar-dark fixed-top navbar-shrink" id="mainNav">
            <div class="container">
                <a class="navbar-brand js-scroll-trigger" href="RetrieveBookingList" >Maersk's Container Management System</a>
                <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fa fa-bars"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav text-uppercase ml-auto">  
                        <li class="nav-item dropdown">
                            <a class="nav-link js-scroll-trigger dropdown-toggle" data-toggle="dropdown">Agent
                                <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a  class="nav-link js-scroll-trigger" style="color: black;" href="RetrieveAgentList">View Agent </a></li>
                                <li><a class="nav-link js-scroll-trigger" style="color: black;" href="AddAgent.jsp">Add Agent</a></li>
                            </ul>                        
                        </li>
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="ViewBooking.jsp">View Booking</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link js-scroll-trigger dropdown-toggle" data-toggle="dropdown">Schedule
                                <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a  class="nav-link js-scroll-trigger" style="color: black;" href="AddShip.jsp">Add Ship </a></li>
                                <li><a class="nav-link js-scroll-trigger" style="color: black;" href="AddRoute.jsp">Add Route</a></li>
                                <li><a class="nav-link js-scroll-trigger" style="color: black;" href="RetrieveShipRouteList">Create Schedule</a></li>
                            </ul>                        
                        </li>
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="LogoutServlet">Logout</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <!-- Bootstrap core JavaScript -->
        <script src="css/vendor/jquery/jquery.js"></script>
        <script src="css/vendor/bootstrap/js/bootstrap.bundle.js"></script>

        <!-- Plugin JavaScript -->
        <script src="css/vendor/jquery-easing/jquery.easing.js"></script>

</body>
</html>