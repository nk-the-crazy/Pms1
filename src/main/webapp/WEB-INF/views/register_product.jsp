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
<title>Register Product</title>
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
								<h3> + Register new Product</h3>
							</div><!-- /widget-header -->
							<div class="widget-content">
								<form id="register-person" class="form-horizontal" action="register_product.do" method="POST">
									<fieldset>
									<div class="tabbable">
			                        <ul class="nav nav-tabs">
			                          <li   class="active">
			                            <a href="#mainData" data-toggle="tab">Product Data</a>
			                          </li>
			                          <li>
			                             <a href="#costData" data-toggle="tab">Cost/Tax Details</a>
			                          </li>
                                      <li>
                                         <a href="#detailsData" data-toggle="tab">Product Details</a>
                                      </li>
			                        </ul>
                                    <br>
		                            <div class="tab-content">
		                                <div class="tab-pane active" id="mainData">
                                            <div class="control-group">                                            
	                                            <label class="control-label" for="txtProductCode">code</label>
	                                            <div class="controls">
	                                               <div class="input-append">
	                                                  <input type="text" class="span2 m-wrap" id="txtProductCode" name="code">
                                                      <button class="btn" type="button" id="btnGenCode">Generate</button>
	                                                </div>
	                                              </div>    <!-- /controls -->          
                                             </div> <!-- /control-group -->
	
											<div class="control-group">
												<label class="control-label" for="name">Name</label>
												<div class="controls">
													<input type="text" class="span2" id="name" name="name">
												</div><!-- /controls -->
											</div><!-- /control-group -->
											<div class="control-group">
												<label class="control-label" for="type">Product Type</label>
												<div class="controls">
											        <select class="form-control" class="span2" name="type">
									                    <option value=0 selected="selected">Select Type</option>
									                    <option value=1>Electronics</option>
	                                                    <option value=2>Household</option>
                                                        <option value=2>Jewelry</option>
									                </select>											
												</div><!-- /controls -->
											</div><!-- /control-group -->
										</div>
										<div class="tab-pane" id="costData">
										   <div class="control-group">
                                                <label class="control-label" for="product.cost">Price</label>
                                                <div class="controls">
                                                    <input type="text" class="span1" id="product.cost" name="productCostDetails.unitPrice">
                                                </div><!-- /controls -->
                                            </div><!-- /control-group -->
                                            
                                            <div class="control-group">
                                                <label class="control-label" for="type">Product Type</label>
                                                <div class="controls">
                                                    <select class="form-control" class="span2" name="productCostDetails.unit">
                                                        <option value=0 selected="selected">Select Unit</option>
                                                        <option value=1>PCS</option>
                                                        <option value=2>(Mass)KG</option>
                                                        <option value=2>(Volume)LT</option>
                                                        <option value=2>(Dim)M</option>
                                                    </select>                                           
                                                </div><!-- /controls -->
                                            </div><!-- /control-group -->
                                            
										</div>
                                        <div class="tab-pane" id="detailsData">
                                            <div class="control-group">
                                                <label class="control-label" for="productDetails.details">Description</label>
                                                <div class="controls">
                                                    <input type="text" class="span4" id="productDetails.details" name="productDetails.details">
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
            $.ajax({url: "rest/product/code/generate", success: function(result)
            {
                $("#txtProductCode").val(result);
            }});
        });
    }); 
    </script>
</body>

</html>
