<!-- ************************************* -->
<%@page contentType="text/html" 
pageEncoding="UTF-8" 
errorPage="error.jsp" 
import="model.common.session.*"%>
<!-- ************************************* -->

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>Update user password</title>
<% 
//***********************
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
								<i class="icon-key"></i>
								<h3>Change Password</h3>
							</div>
							<!-- /widget-header -->
							<div class="widget-content">
							<form id="edit-password" class="form-horizontal" action="edit_password.do" method="POST">
                                <fieldset>
								<table class="table table-striped table-bordered">
									<tbody>
										<tr>
											<td width="110px">Old Password:</td>
											<td><input type="password" name="old_password" class="span2"></td>
										</tr>
										<tr>
											<td>New Password:</td>
											<td><input type="password" name="new_password" id="txtNewPsw" class="span2"></td>
										</tr>
                                        <tr>
                                            <td>Re-New Password:</td>
                                            <td><input type="password" name="re_new_password" id="txtReNewPsw" class="span2"></td>
                                        </tr>
                                       
									</tbody>
								</table>
								<div class="form-actions">
                                     <button type="submit" class="btn btn-primary">Change</button>
                                     <button type="button" class="btn" onclick="history.back()">Cancel</button>
                                 </div>
								</fieldset>
                            </form>								
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
