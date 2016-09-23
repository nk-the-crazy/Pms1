<!-- ************************************* -->
<%@page contentType="text/html" 
pageEncoding="UTF-8" 
errorPage="error.jsp" 
import="model.common.session.*, model.identity.User"%>
<!-- ************************************* -->

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>Main</title>
<% 
//***********************
SessionData  sData = (SessionData)session.getAttribute( "sessionData" );
User user  = (User)request.getAttribute( "userDetails" ); 
//***********************
%>

<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/bootstrap-responsive.min.css" rel="stylesheet">
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600" rel="stylesheet">
<link href="resources/css/font-awesome.css" rel="stylesheet">
<link href="resources/css/style.css" rel="stylesheet">
<link href="resources/css/pages/dashboard.css" rel="stylesheet">

<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
</head>

<body>
	<div class="navbar navbar-fixed-top">
		<jsp:include page="header.jsp"><jsp:param name="page" value="main" /></jsp:include>
		<jsp:include page="main_menu.jsp"><jsp:param name="page" value="main" /></jsp:include>
	</div>
	<!-- /navbar -->

	<div class="main">
		<div class="main-inner">
			<div class="container">
				<div class="row">
					<div class="span4">
						<div class="widget widget-table action-table">
							<div class="widget-header">
								<i class="icon-th-list"></i>
								<h3>User Details</h3>
							</div>
							<!-- /widget-header -->
							<div class="widget-content">
								<table class="table table-striped table-bordered">
									<thead>
										<tr>
											<th>User</th>
											<th>Detailed info for Logged User</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>UserName:</td>
											<td><%=sData.gerUser().getUserName() %></td>
										</tr>
										<tr>
											<td>Last Login:</td>
											<td><%=sData.gerUser().getLastLogin() %></td>
										</tr>
										<% 
										//************
										if(user != null)
										{
										%>
                                        <tr>
                                            <td>Personal Details:</td>
                                            <td><%=user.getPerson().getLastName() %>-<%=user.getPerson().getFirstName() %></td>
                                        </tr>
                                        <tr>
                                            <td>User Company Details:</td>
                                            <td><%=user.getCompany().getCode() %></td>
                                        </tr>
                                        <tr>
                                            <td>User Company Details:</td>
                                            <td><%=user.getCompany().getName() %></td>
                                        </tr>
                                        <% 
                                        }
                                        //*************
                                        %>
                                        
									</tbody>
								</table>
							</div>
							<!-- /widget-content -->
						</div>
						<!-- /widget -->
					</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp"><jsp:param name="page" value="main" /></jsp:include>
	<!-- /footer -->


	<!-- Javascript ================================================ -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="resources/js/jquery-2.1.4.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/base.js"></script>
</body>

</html>
