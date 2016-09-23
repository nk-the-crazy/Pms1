<!-- ************************************* -->
<%@page contentType="text/html" 
pageEncoding="UTF-8" 
errorPage="error.jsp" 
import="model.person.*,model.company.*,
        java.util.List"%>
<!-- ************************************* -->

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>Add Employee</title>
<%
//***********************
Company company = (Company) request.getAttribute( "companyData" );
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
								<h3> + Register Employee</h3>
							</div><!-- /widget-header -->
							<div class="widget-content">
								<form name="add_person" id="addPerson" class="form-horizontal" action="add_person.do" method="POST">
									<fieldset>
									<div class="tabbable">
			                        <ul class="nav nav-tabs">
			                          <li   class="active">
			                            <a href="#mainData" data-toggle="tab">Sales Orders</a>
			                          </li>
                                    </ul>
                                    <br>
		                            <div class="tab-content">
		                                <div class="tab-pane active" id="mainData">
		                                 <table id="tbOrders" class="table table-striped table-bordered">
                                            <tr>
                                                <td>Company Code:</td>
                                                <td><input type="text" class="span2" id="txtCompanyCode" value="<%=company.getCode() %>">
													<input type="hidden" id="txtCompanyId" name="company_id" value="<%=company.getId()%>">
												</td>
                                                <td>Company name:</td>
                                                <td><div id="dvCompanyName"><%=company.getName() %></div></td>
												<td>	
	                                                <button id="btnGetCompanyData" class="btn btn-mini btn-success" type="button">
	                                                    <i class="icon-circle-arrow-down">  Get Company Data</i>
	                                                </button>
                                                </td>
											</tr>
                                            <tr>
                                                <td>Person Code:</td>
                                                <td><input type="text" class="span2" id="txtPersonCode">
                                                    <input type="hidden" id="txtPersonId" name="person_id">
                                                </td>
                                                <td>Person name:</td>
                                                <td><div id="dvPersonName"></div></td>
                                                <td>    
                                                    <button id="btnGetPersonData" class="btn btn-mini btn-success" type="button">
                                                        <i class="icon-circle-arrow-down">  Get Person Data</i>
                                                    </button>
                                                </td>
                                            </tr>
                                          </table>
										</div>
										<div class="form-actions">
											<button type="submit" class="btn btn-primary">Add Person</button>
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
            
       //*****************************************
       $("#btnGetPersonData").click(function()
       {
        
    	   var jqxhr = $.getJSON( 'rest/person?code='+ $('#txtPersonCode').val(),
	       function(data)
	       {
    		    $('#dvPersonName').text(data.lastName+" - "+data.firstName);
                $('#txtPersonId').val(data.id);
               
	       }).fail(function() 
	       {
               $('#dvPersonName').text("Person Not found !!!");
               $('#txtPersonId').val("");
	       });
    	   
       });
       
        
       //*****************************************
       $("#btnGetCompanyData").click(function()
       {
        
    	   var jqxhr = $.getJSON( 'rest/company?code='+ $('#txtCompanyCode').val(),
           function(data)
           {
           	   $('#dvCompanyName').text(data.name);
           	   $('#txtCompanyId').val(data.id);
           	   
           }).fail(function() 
           {
               $('#dvCompanyName').text("Company Not found !!!");
               $('#txtCompanyId').val("");
           });
           
       });
       
    
  });    
    </script>
    
</body>

</html>
