<!-- ************************************* -->
<%@page contentType="text/html" pageEncoding="UTF-8" 
errorPage="error.jsp" 
import="model.identity.*,
		java.util.List,
		model.common.PermissionObject,
		model.common.PermissionScope"%>
<!-- ************************************* -->

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>Role Details</title>
<%
    //***********************
    Role role = (Role) request.getAttribute( "roleDetails" );
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
					<div class="span8">
						<div class="widget ">
							<div class="widget-header">
								<i class="icon-briefcase"></i>
								<h3>Product Details</h3>
							</div><!-- /widget-header -->
							<div class="widget-content">
							<% 
							//******************
							if(role != null)
							{
							%>
								<div class="tabbable">
			                        <ul class="nav nav-tabs">
			                          <li   class="active">
			                            <a href="#mainData" data-toggle="tab">Role Data</a>
			                          </li>
			                          <li>
			                             <a href="#extraData" data-toggle="tab">Extra Details</a>
			                          </li>
			                        </ul>
                                    <br>
		                            <div class="tab-content">
		                                <div class="tab-pane active" id="mainData">
                                           <table class="table table-striped table-bordered">
			                                   <tbody>
			                                        <tr>
			                                            <td width="120px"><b>Name:</b></td>
			                                            <td><%=role.getName() %></td>
			                                        </tr>
			                                        <tr>
			                                            <td><b>Type:</b></td>
			                                            <td><%=role.getType() %></td>
			                                        </tr>
                                                </tbody>
                                            </table>
                                            <br>
                                            <div class="widget-header">
				                                <i class="icon-key"></i>
				                                <h3>Role Permissions</h3>
				                            </div><!-- /widget-header -->
                                            <table class="table table-striped table-bordered">
                                                 <thead>
                                                    <tr>
                                                        <th width="10">No</th>
                                                        <th>Permission</th>
                                                        <th>Scope</th>
                                                        <th>Read</th>
                                                        <th>Write</th>
                                                        <th>Update</th>
                                                        <th>Delete</th>
                                                    </tr>
                                                 </thead>                                                  
                                                 <tbody>
                                                      <% 
                                                      //*************************
                                                      int recordCount = 0;
                                                      List<Permission> permissions = role.getPermissions();
                                                      
                                                      for(Permission permission : permissions)
                                                      {
                                                      %>
                                                      <tr>
                                                          <td><%=++recordCount%></td>
                                                          <td><%=PermissionObject.values()[permission.getObject()-1].name()  %></td>
                                                          <td><%=PermissionScope.values()[permission.getScope()-1].name()  %></td>
                                                          <td><%=(permission.isRead())?"True":"False" %></td>
                                                          <td><%=(permission.isWrite())?"True":"False" %></td>
                                                          <td><%=(permission.isUpdate())?"True":"False" %></td>
                                                          <td><%=(permission.isDelete())?"True":"False" %></td>
                                                      </tr>
                                                      <% 
                                                      }
                                                      //****************************
                                                      %>
                                                   </tbody>
                                               </table>
                                            
										</div>
                                        <div class="tab-pane" id="extraData">
                                        </div>
                                        <div class="form-actions">
											<a href="edit_role.vw?role_id=<%=role.getId()%>" 
											class="btn btn-mini btn-warning"> Edit</a>										
										</div><!-- /form-actions -->
										</div> <!-- /tabcontent -->
                                    </div> <!-- /tabbable -->
                            <% 
                            //***************************
							}
                            %>
							</div><!-- /widget-content -->
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
	
</body>

</html>
