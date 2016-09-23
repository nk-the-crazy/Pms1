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
<title>Register User</title>
<%
    
    //***********************
    Company company = null;
    Person person = null;
    
    company = (Company) request.getAttribute( "companyInfo" );

    if(company != null)
    {
        person = company.getPersons().get( 0 );   
    }
    
    @SuppressWarnings("unchecked")
    List<Role> roles = (List<Role>) request.getAttribute( "roles" );
    
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
								<h3> + Register new User</h3>
							</div><!-- /widget-header -->
							<div class="widget-content">
								<table class="table table-striped table-bordered">
	                                <tbody>
	                                     <tr>
	                                         <td width="120px"><b>Company:</b></td>
	                                         <td><%=company.getCode()+" : "+ company.getName()  %></td>
	                                     </tr>
	                                     <tr>
	                                         <td><b>Person:</b></td>
                                             <td><%=person.getCode()+" : "+ person.getLastName()+" "+ person.getFirstName()  %></td>
	                                     </tr>
	                                  </tbody>
	                            </table>
	                            <br>
								<form id="register-user" class="form-horizontal" action="register_user.do" method="POST">
								    <input type="hidden" name="company_id" value="<%=company.getId()%>">
                                    <input type="hidden" name="person_id" value="<%=person.getId()%>">
									<fieldset>
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
                                           <div class="control-group">
												<label class="control-label" for="userName">Username</label>
												<div class="controls">
													<input type="text" class="span2" id="userName" name="userName">
												</div><!-- /controls -->
											</div><!-- /control-group -->
											<div class="control-group">                                          
                                            <label class="control-label" for="password1">Password</label>
                                            <div class="controls">
                                                <input type="password" class="span2" id="password1" name="password">
                                            </div> <!-- /controls -->               
	                                        </div> <!-- /control-group -->
	                                        
	                                        <div class="control-group">                                         
	                                            <label class="control-label" for="password2">Confirm</label>
	                                            <div class="controls">
	                                                <input type="password" class="span2" id="password2">
	                                            </div> <!-- /controls -->               
	                                        </div> <!-- /control-group -->
	                                        
											
                                           <div class="control-group">
                                                <label class="control-label" for="email">E-mail</label>
                                                <div class="controls">
                                                    <input type="text" class="span2" id="email" name="email">
                                                </div><!-- /controls -->
                                            </div><!-- /control-group -->
											
										</div>
										<div class="tab-pane" id="securityData">
                                           <div class="control-group">
													<select multiple="multiple" size="10"  name="role_ids" class='role_ids col-md-6'> 
													<% 
													int count = 1;
													
                                                    for(Role role:roles)
													{
													%>                   
		                                                <option value="<%=role.getId() %>"><%=(count++)+"-"+role.getName() %></option>
								                    <% 
													}
								                    %>
								                    </select>
                                            </div><!-- /control-group -->
										</div>
                                        <div class="form-actions">
											<button type="submit" class="btn btn-primary">Save</button>
											<button type="button" class="btn" onclick="history.back()">Cancel</button>
										</div>
										<!-- /form-actions -->
										</div> <!-- /tabcontent -->
                                        </div> <!-- /tabbable -->
									</fieldset>
								</form>
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
