<!-- ************************************* -->
<%@page contentType="text/html" 
pageEncoding="UTF-8" 
errorPage="error.jsp" 
import="model.company.*,
        model.person.*,
        model.identity.*,
        java.util.List" %>
<!-- ************************************* -->

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>User Details</title>
<%
    
    //***********************
    User user = (User) request.getAttribute( "userDetails" );
    //***********************
%>

<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/bootstrap-responsive.min.css" rel="stylesheet">
<link href="resources/lib/dual-list-box/css/duallistbox.css" rel="stylesheet">
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
					<div class="span8">
						<div class="widget ">
							<div class="widget-header">
								<i class="icon-briefcase"></i>
								<h3> User Details</h3>
							</div><!-- /widget-header -->
                            <% 
                            //******************************
                            if(user != null)
                            {
                            %>
							<div class="widget-content">
								<table class="table table-striped table-bordered">
	                                <tbody>
	                                     <tr>
	                                         <td width="120px"><b>Company:</b></td>
	                                         <td>
		                                         <a href="company_details.vw?company_id=<%=user.getCompany().getId() %>">
		                                         <%=user.getCompany().getCode()+" : "+ user.getCompany().getName()  %>
	                                         </a></td>
	                                     </tr>
	                                     <tr>
	                                         <td><b>Person:</b></td>
                                             <td>
	                                             <a href="person_details.vw?[erson]_id=<%=user.getPerson().getId() %>">
	                                             <%=user.getPerson().getCode()+" : "+ user.getPerson().getLastName()+" "+ user.getPerson().getFirstName()  %>
                                             </a></td>
	                                     </tr>
	                                  </tbody>
	                            </table>
	                            <br>
									<div class="tabbable">
			                        <ul class="nav nav-tabs">
			                          <li   class="active">
			                            <a href="#mainData" data-toggle="tab">User Data</a>
			                          </li>
			                          <li>
			                             <a href="#securityData" data-toggle="tab">Roles/Permissions</a>
			                          </li>
                                    </ul>
                                    <br>
		                            <div class="tab-content">
		                                <div class="tab-pane active" id="mainData">
			                                <table class="table table-striped table-bordered">
			                                    <tbody>
			                                         <tr>
			                                             <td width="80px"><b>Username:</b></td>
			                                             <td><%=user.getUserName() %>
			                                             </td>
			                                         </tr>
			                                         <tr>
			                                             <td width="80px"><b>E-mail:</b></td>
			                                             <td><%=user.getEmail() %>
			                                             </td>
			                                         </tr>
			                                      </tbody>
			                                </table>
										</div>
										<div class="tab-pane" id="securityData">
                                            <table class="table table-striped table-bordered">
                                                <thead>
			                                        <tr>
			                                            <th width="10">No</th>
			                                            <th>Role Name</th>
			                                        </tr>
			                                    </thead>
                                                <tbody>
													<% 
													int count = 1;
													
                                                    for(Role role : user.getRoles())
													{
													%>                   
                                                    <tr>
		                                               <td><%=(count++) %></td>
		                                               <td>
			                                               <a href="role_details.vw?role_id=<%=role.getId() %>">
			                                               <%=role.getName() %>
			                                               </a>
		                                               </td>
                                                     </tr>
								                    <% 
													}
								                    %>
                                                  </tbody>
                                            </table>
										</div>
                                        <div class="form-actions">
											<button type="submit" class="btn btn-primary">Edit</button>
											<button type="button" class="btn" onclick="history.back()">Cancel</button>
										</div>
										<!-- /form-actions -->
										</div> <!-- /tabcontent -->
                                        </div> <!-- /tabbable -->
							</div><!-- /widget-content -->
							<% 
                            }
                            //*****************************************
							%>
						</div><!-- /widget -->
					</div><!-- /span12 -->
				</div><!-- /row -->
			</div><!-- /container -->
		</div><!-- /main-inner -->
	</div><!-- /main -->
	
 
	<jsp:include page="footer.jsp"><jsp:param name="page" value="main" /></jsp:include>
	<!-- /footer -->


	<!-- Javascript ================================================ -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="resources/js/jquery-2.1.4.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/base.js"></script>
	<script src="resources/lib/dual-list-box/js/duallistbox.js"></script>
	<script>
      var role = $('.role_ids').bootstrapDualListbox({
          nonselectedlistlabel: 'Non-selected',
          selectedlistlabel: 'Selected',
          preserveselectiononmove: 'moved',
          moveonselect: false,
          bootstrap2compatible: true,
          showFilterInputs:false,
          selectedlistlabel:'<b>Assigned Roles</b>',
          nonselectedlistlabel:'<b>Available Roles</b>',
          infotext:''

      });
    </script>
	
</body>

</html>
