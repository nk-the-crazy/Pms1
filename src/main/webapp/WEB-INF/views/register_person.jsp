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
<title>Register Person</title>
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
								<h3> + Register new Person (Employee)</h3>
							</div><!-- /widget-header -->
							<div class="widget-content">
								<form id="register-person" class="form-horizontal" action="register_person.do" method="POST">
									<fieldset>
									<div class="tabbable">
			                        <ul class="nav nav-tabs">
			                          <li   class="active">
			                            <a href="#mainData" data-toggle="tab">Person Data</a>
			                          </li>
			                          <li>
			                             <a href="#contactData" data-toggle="tab">Contacts/Address</a>
			                          </li>
                                      <li>
                                         <a href="#detailsData" data-toggle="tab">Person Details</a>
                                      </li>
			                        </ul>
                                    <br>
		                            <div class="tab-content">
		                                <div class="tab-pane active" id="mainData">
                                            
                                            <div class="control-group">                                            
                                                <label class="control-label" for=txtPersonCode>Person Code</label>
                                                <div class="controls">
                                                   <div class="input-append">
                                                      <input class="span2 m-wrap" id="txtPersonCode" name="code" type="text">
                                                      <button class="btn" type="button" id="btnGenCode">Generate</button>
                                                    </div>
                                                  </div>    <!-- /controls -->          
                                             </div> <!-- /control-group -->
                                            
                                            <div class="control-group">                                            
	                                            <label class="control-label" for="firstName">Firstname</label>
	                                            <div class="controls">
	                                               <div class="input-append">
	                                                  <input type="text" class="span2 m-wrap" id="firstName" name="firstName">
	                                                </div>
	                                              </div>    <!-- /controls -->          
                                             </div> <!-- /control-group -->
	
											<div class="control-group">
												<label class="control-label" for="lastName">Lastname</label>
												<div class="controls">
													<input type="text" class="span2" id="lastName" name="lastName">
												</div><!-- /controls -->
											</div><!-- /control-group -->
                                            <div class="control-group">
                                                <label class="control-label" for="midlleName">MiddleName</label>
                                                <div class="controls">
                                                    <input type="text" class="span2" id="middleName" name="middleName">
                                                </div><!-- /controls -->
                                            </div><!-- /control-group -->
											<div class="control-group">
												<label class="control-label" for="gender">Gender</label>
												<div class="controls">
											        <select class="form-control" class="span2" name="gender">
									                    <option value=0 selected="selected">Select Gender</option>
									                    <option value=1>Male</option>
	                                                    <option value=2>Female</option>
									                </select>											
												</div><!-- /controls -->
											</div><!-- /control-group -->
										</div>
										<div class="tab-pane" id="contactData">
										   <div class="control-group">
                                                <label class="control-label" for="contact.code">Phone Code/Number</label>
                                                <div class="controls">
                                                    <input type="text" class="span1" id="contact.code" name="contact.code">
                                                    <input type="text" class="span2" id="contact.phone" name="contact.phone">
                                                </div><!-- /controls -->
                                            </div><!-- /control-group -->
                                           <div class="control-group">
                                                <label class="control-label" for="contact.email">E-Mail</label>
                                                <div class="controls">
                                                    <input type="text" class="span4" id="contact.email" name="contact.email">
                                                </div><!-- /controls -->
                                            </div><!-- /control-group -->
                                            <div class="control-group">
                                                <label class="control-label" for="address.country">Country</label>
                                                <div class="controls">
                                                    <select class="form-control" name="address.country">
                                                        <option value=0 selected="selected">Select country</option>
                                                        <option value=996>KGZ</option>
                                                        <option value=2>KZ</option>
                                                        <option value=3>UZB</option>
                                                    </select>                                           
                                                </div><!-- /controls -->
                                            </div><!-- /control-group -->
                                            <div class="control-group">
                                                <label class="control-label" for="address.region">Region</label>
                                                <div class="controls">
                                                    <select class="form-control" name="address.region">
                                                        <option value=0 selected="selected">Select Region</option>
                                                        <option value=1>Bishkek</option>
                                                        <option value=2>Osh</option>
                                                    </select>                                           
                                                </div><!-- /controls -->
                                            </div><!-- /control-group -->
                                           <div class="control-group">
                                                <label class="control-label" for="city">City</label>
                                                <div class="controls">
                                                    <input type="text" class="span2" id="city" name="address.city">
                                                </div><!-- /controls -->
                                            </div><!-- /control-group -->
                                           <div class="control-group">
                                                <label class="control-label" for="address_line1">Address Line1</label>
                                                <div class="controls">
                                                    <input type="text" class="span6" id="address_line1" name="address.addressLine1">
                                                </div><!-- /controls -->
                                            </div><!-- /control-group -->
                                           <div class="control-group">
                                                <label class="control-label" for="address_line2">Address Line2</label>
                                                <div class="controls">
                                                    <input type="text" class="span6" id="address_line2" name="address.addressLine2">
                                                </div><!-- /controls -->
                                            </div><!-- /control-group -->
										</div>
                                        <div class="tab-pane" id="detailsData">
                                            <div class="control-group">
                                                <label class="control-label" for="dp3">Birth Date</label>
	                                                <div class="controls">
	                                                   <div class="input-append date" id="dp3" data-date="12.02.2012" data-date-format="dd.mm.yyyy">
	                                                     <input class="span2" size="16" type="text" value="12.02.2012" readonly>
	                                                     <span class="add-on"><i class="icon-th"></i></span>
	                                                </div>
                                                </div>
                                            </div><!-- /control-group -->
                                           <div class="control-group">
                                                <label class="control-label" for="address.region">Marital Status</label>
                                                <div class="controls">
                                                    <select class="form-control" name="personDetails.maritalStatus">
                                                        <option value=0 selected="selected">Select Status</option>
                                                        <option value=1>Single</option>
                                                        <option value=2>Married</option>
                                                    </select>                                           
                                                </div><!-- /controls -->
                                            </div><!-- /control-group -->
                                            <div class="control-group">
                                                <label class="control-label" for="tax_payer_number">Passport Serial/Number</label>
                                                <div class="controls">
                                                    <input type="text" class="span1" id="tax_payer_number" name="personDetails.passportSerial">
                                                    <input type="text" class="span2" id="tax_payer_number" name="personDetails.passportNumber">
                                                </div><!-- /controls -->
                                            </div><!-- /control-group -->
                                            <div class="control-group">
                                                <label class="control-label" for="tax_payer_number">Tax Payer Number</label>
                                                <div class="controls">
                                                    <input type="text" class="span4" id="tax_payer_number" name="personDetails.taxPayerNumber">
                                                </div><!-- /controls -->
                                            </div><!-- /control-group -->
                                            <div class="control-group">
                                                <label class="control-label" for="tax_payer_number">Description</label>
                                                <div class="controls">
                                                    <input type="text" class="span4" id="tax_payer_number" name="personDetails.details">
                                                </div><!-- /controls -->
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
	<script src="resources/lib/datetimepicker/js/bootstrap-datepicker.js"></script> 
	<script src="resources/js/base.js"></script>
	<script>
     $(function()
     {
         $('#dp3').datepicker();
     });
    </script>
    
    <script type="text/javascript">
    
    $(document).ready(function()
    {
        $("#btnGenCode").click(function()
        {
            $.ajax({url: "rest/person/code/generate", success: function(result)
            {
                $("#txtPersonCode").val(result);
            }});
        });
    }); 
    </script>
</body>

</html>
