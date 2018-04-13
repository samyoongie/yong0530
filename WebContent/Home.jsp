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
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
</head>
<body id="page-top">

        <!-- Navigation -->
        <nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
            <div class="container">
                <a class="navbar-brand js-scroll-trigger" href="#page-top">Maersk's Container Management System</a>
                <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fa fa-bars"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav text-uppercase ml-auto">  
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="#about">About</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" id="test"
                               onclick="document.getElementById('login').style.display = 'block'" style="width:auto;">Login</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <!-- Header -->
        <header class="masthead">
            <div class="container">
                <div class="intro-text">
                    <div class="intro-lead-in">Welcome To Maersk's Container Management System!</div>
                    <div class="intro-heading text-uppercase">It's Nice To Meet You</div>
                    <a class="btn btn-primary btn-xl text-uppercase js-scroll-trigger"   onclick="document.getElementById('login').style.display = 'block'" style="width:auto;">Login</a>
                </div>
            </div>
        </header>
        
       
        <div id="login" class="modal" >
            <div class="card card-login mx-auto mt-5">
                <div class="card-header">Login</div>
                <div class="card-body">
                    <c:if test="${not empty message}">
                        <div id="message" class="alert alert-success">
                            <strong>${message} </strong> 
                        </div>
                    </c:if>
                    <form  action="LoginServlet" method="POST" class="modal-content animate" style="border:none">
                        <div class="form-group">
                            <label for="usernamelabel">Username</label>
                            <input class="form-control" id="username" type="text" name ="username" placeholder="Enter username" required>
                        </div>
                        <div class="form-group">
                            <label for="passwordlabel">Password</label>
                            <input class="form-control" id="password" name="password" type="password" placeholder="Enter Password" required>
                        </div>
                        <input type = "submit" value = "Login" class="btn btn-primary btn-block" >
                        <a  style=color:white class="btn btn-primary btn-block"  onclick="document.getElementById('login').style.display = 'none'">Cancel</a>
                    </form>
                </div>
            </div>
        </div>



        <!-- About -->
        <section id="about">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <h2 class="section-heading text-uppercase">About</h2>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <ul class="timeline">
                            <li>
                                <div class="timeline-image">
                                    <img class="rounded-circle img-fluid" src="img/about/1.jpg" alt="">
                                </div>
                                <div class="timeline-panel">
                                    <div class="timeline-heading">
                                        <h4>Year 1928</h4>
                                        <h4 class="subheading">Our Humble Beginnings</h4>
                                    </div>
                                    <div class="timeline-body">
                                        <p class="text-muted">Maersk Line is the world's largest container shipping company having customers through 374 offices in 116 countries</p>
                                    </div>
                                </div>
                            </li>
                            <li class="timeline-inverted">
                                <div class="timeline-image">
                                    <img class="rounded-circle img-fluid" src="img/about/2.jpg" alt="">
                                </div>
                                <div class="timeline-panel">
                                    <div class="timeline-heading">
                                        <h4>Year 2018</h4>
                                        <h4 class="subheading">Our journey</h4>
                                    </div>
                                    <div class="timeline-body">
                                        <p class="text-muted">We employ approximately 7,000 sea farers and approximately 25,000 land-based people. Maersk Line operates over 600 vessels and has a capacity of 2.6 million TEU</p>
                                    </div>
                                </div>
                            </li>                            
                            <li class="timeline-inverted">
                                <div class="timeline-image">
                                    <h4>Be Part
                                        <br>Of Our
                                        <br>Story!</h4>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </section>

        
        <jsp:include page="Footer.jsp" />

        <!-- Bootstrap core JavaScript -->
        <script src="css/vendor/jquery/jquery.js"></script>
        <script src="css/vendor/bootstrap/js/bootstrap.bundle.js"></script>

        <!-- Plugin JavaScript -->
        <script src="css/vendor/jquery-easing/jquery.easing.js"></script>



        <!-- Custom scripts for this template -->
        <script src="js/agency.js"></script>
        <script src="css/customedjs.js"></script>


    </body>

</body>
</html>