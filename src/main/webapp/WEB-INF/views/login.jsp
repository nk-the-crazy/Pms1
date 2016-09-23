<!-- ************************************* -->
<%@page 
contentType="text/html" 
pageEncoding="UTF-8" 
errorPage="error.jsp" %>
<!-- ************************************* -->

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>Login</title>


<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/bootstrap-responsive.min.css" rel="stylesheet">
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600" rel="stylesheet">
<link href="resources/css/font-awesome.css" rel="stylesheet">
<link href="resources/css/style.css" rel="stylesheet">
<link href="resources/css/pages/signin.css" rel="stylesheet" type="text/css">


<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
</head>

<% 
//**********************************************
    String message = "";
    message = (String)request.getAttribute( "loginMessage" );
//*********************************************
%>

<body>
    <div class="navbar navbar-fixed-top">
        <div class="navbar-inner">
            <div class="container">
                <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> <span class="icon-bar"></span>
                    <span class="icon-bar"></span> <span class="icon-bar"></span>
                </a> <a class="brand" href="index.htm">Tms1</a>
                <!--/.nav-collapse -->
            </div>
            <!-- /container -->
        </div><!-- /navbar-inner -->
    </div>
    <!-- /navbar -->
    
    <div class="main">
        <div class="account-container">
            <div class="content clearfix">
                <form action="login.do" method="post">
                    <h1>Login</h1>
                    <div class="login-fields">
                     <% 
                        //*************************************
                        if(message!=null)
                        {
                        %>
                             <div class="alert alert-danger"><%=message %></div>
                        <% 
                        }
                        //*************************************
                        %>
                        <div class="field">
                            <label for="username">Username</label> <input type="text" id="username" name="username" value=""
                                placeholder="Username" class="login username-field" />
                        </div>
                        <!-- /field -->
                        <div class="field">
                            <label for="password">Password:</label> <input type="password" id="password" name="password"
                                value="" placeholder="Password" class="login password-field" />
                        </div>
                        <!-- /password -->
                    </div>
                    <!-- /login-fields -->
                    <div class="login-actions">
                        <button class="button btn btn-success btn-mini">Логин</button>
                    </div>
                    <!-- .actions -->
                </form>
            </div>
            <!-- /content -->
        </div>
        <!-- /account-container -->
    </div>
    <!-- /main -->

    <jsp:include page="footer.jsp"><jsp:param name="page" value="main" /></jsp:include>
    <!-- /footer -->


    <!-- Le javascript
================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="resources/js/jquery-2.1.4.min.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
    <script src="resources/js/base.js"></script>
</body>

</html>
