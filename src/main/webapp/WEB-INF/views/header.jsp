<!-- ************************************* -->
<%@page 
contentType="text/html" 
pageEncoding="UTF-8"
errorPage="error.jsp"
%>
<!-- ************************************* -->

<div class="navbar-inner">
    <div class="container">
        <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> <span class="icon-bar"></span>
            <span class="icon-bar"></span> <span class="icon-bar"></span>
        </a> <a class="brand" href="index.htm">Pms1</a>
        <div class="nav-collapse">
            <ul class="nav pull-right">
                <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"> <i
                        class="icon-cog"></i> Account <b class="caret"></b>
                </a>
                    <ul class="dropdown-menu">
                        <li><a href="edit_password.vw">Change Password</a></li>
                        <li><a href="logout.do">Logout</a></li>
                        <li><a href="javascript:;">Help</a></li>
                    </ul></li>
            </ul>
        </div>
        <!--/.nav-collapse -->
    </div>
    <!-- /container -->
</div><!-- /navbar-inner -->
