<!-- ************************************* -->
<%@page contentType="text/html" 
pageEncoding="UTF-8" 
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
<title>Register New Role/Permission</title>
<%
    //***********************
    //***********************
%>

<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/bootstrap-responsive.min.css" rel="stylesheet">
<link href="resources/lib/datetimepicker/css/datepicker.css" rel="stylesheet">
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
								<h3> + Register new Role/Permissions</h3>
							</div><!-- /widget-header -->
							<div class="widget-content">
								<form name="role" id="register-role" class="form-horizontal" action="register_role.do" method="POST">
									<fieldset>
									<div class="tabbable">
			                        <ul class="nav nav-tabs">
			                          <li   class="active">
			                            <a href="#mainData" data-toggle="tab">Role/Permissions</a>
			                          </li>
			                          <li>
			                             <a href="#extraData" data-toggle="tab">Extra Details</a>
			                          </li>
                                    </ul>
                                    <br>
		                            <div class="tab-content">
		                                <div class="tab-pane active" id="mainData">
                                            <div class="control-group">
												<label class="control-label" for="name">Role Name:</label>
												<div class="controls">
													<input type="text" class="span2" id="name" name="name">
												</div><!-- /controls -->
											</div><!-- /control-group -->
											
										    <div class="widget-header">
                                                <i class="icon-key"></i>
                                                <h3>Role Permissions</h3>
                                            </div><!-- /widget-header -->
                                            <div class="widget-content">
                                                <button id="btnAddRow" class="btn btn-mini btn-success" type="button">
                                                    <i class="icon-circle-arrow-down">  Add Permission</i>
                                                </button>
                                                 
                                                <br><br>
                                                <table id="tbPermissions" class="table table-striped table-bordered">
	                                               <thead>
	                                                    <tr>
	                                                        <th>Permission</th>
	                                                        <th>Scope</th>
	                                                        <th>R-W-U-D</th>
	                                                        <th>Manage</th>
	                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                      
                                                      <tr>
                                                          <td> 
                                                                <select class="form-control" id="selPermObj" name="permissions[0].object">
                                                                <% 
                                                                for( int x=0; x < PermissionObject.values().length; x++)
                                                                {
                                                                %>
                                                                    <option value=<%=PermissionObject.values()[x].getId() %> >
                                                                    <%=PermissionObject.values()[x].name() %></option>
                                                                <% 
                                                                }
                                                                %>
                                                                </select>
                                                          </td>
                                                          <td> 
                                                                <select class="form-control" id="selPermScope" name="permissions[0].scope">
                                                                <% 
                                                                for( int x=0; x < PermissionScope.values().length; x++)
                                                                {
                                                                %>
                                                                    <option value=<%=PermissionScope.values()[x].getId() %> >
                                                                    <%=PermissionScope.values()[x].name() %></option>
                                                                <% 
                                                                }
                                                                %>
                                                                </select>
                                                           </td>
                                                           <td>
                                                                <input onclick='this.value = this.checked' type="checkbox" id="chxPermRead" name="permissions[0].read">
                                                                <input onclick='this.value = this.checked' type="checkbox" id="chxPermWrite" name="permissions[0].write">
                                                                <input onclick='this.value = this.checked' type="checkbox" id="chxPermUpdate" name="permissions[0].update">
                                                                <input onclick='this.value = this.checked' type="checkbox" id="chxPermDelete" name="permissions[0].delete">
                                                           </td>
                                                           <td>
                                                                <button class="btn btn-danger btn-mini btn-remove" type="button">
                                                                        <i class="icon-minus-sign"></i>
                                                                </button>
                                                           </td>
                                                      </tr>
                                                   </tbody>
	                                            </table>
                                            </div>
										</div>
										<div class="tab-pane" id="extraData">
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
    <script type="text/javascript">
    
    $(document).ready(function() 
	{
	    //Disable the Remove Button
	    var rowCount = $('table >tbody:last >tr').length;
	    if(rowCount == 1) 
	    {
	        document.getElementsByClassName('btn-remove')[0].disabled = true;
	    }
	    
	    $(document).on('click', '#btnAddRow', function(e) 
	    {
	        e.preventDefault();
	        
	        var controlForm = $('table');
	        var currentEntry = $('table>tbody>tr:last');
	        var newEntry = $(currentEntry.clone()).appendTo(controlForm);
	        newEntry.find('input').val('');                                         
	        //Remove the Data - as it is cloned from the above
	        
	        //Add the button  
	        var rowCount = $('table >tbody:last >tr').length;
	        if(rowCount > 1) 
	        {
	            var removeButtons = document.getElementsByClassName('btn-remove');
	            for(var i = 0; i < removeButtons.length; i++) 
	            {
	                removeButtons.item(i).disabled = false;
	            }
	        }
	        
	        updateRowIndex();
	         
	    }).on('click', '.btn-remove', function(e) 
	    {
	        $(this).parents('tr:first').remove();
	        
	        //Disable the Remove Button
	        var rowCount = $('table >tbody:last >tr').length;
	        if(rowCount == 1) 
	        {
	            document.getElementsByClassName('btn-remove')[0].disabled = true;
	        }
	
	        e.preventDefault();
	        
	        updateRowIndex();
	        
	        return false;
	    });
	    
	    
	    function updateRowIndex()
        {
            $('#tbPermissions > tbody  > tr').each(function(rowIndex) 
            {
                $(this).find("#selPermObj").attr('name','permissions['+rowIndex+'].object');
                $(this).find("#selPermScope").attr('name','permissions['+rowIndex+'].scope');
                $(this).find("#chxPermRead").attr('name','permissions['+rowIndex+'].read');
                $(this).find("#chxPermWrite").attr('name','permissions['+rowIndex+'].write');
                $(this).find("#chxPermUpdate").attr('name','permissions['+rowIndex+'].update');
                $(this).find("#chxPermDelete").attr('name','permissions['+rowIndex+'].delete');
            }); 
        }
	    
	   
	
	});    
    </script>
    
</body>

</html>
