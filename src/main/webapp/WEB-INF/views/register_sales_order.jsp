<!-- ************************************* -->
<%@page contentType="text/html" 
pageEncoding="UTF-8" 
errorPage="error.jsp" 
import="model.identity.*,
        java.util.List"%>
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
								<h3> + Register new Sales Orders</h3>
							</div><!-- /widget-header -->
							<div class="widget-content">
								<form name="role" id="register-order" class="form-horizontal" action="register_sales_order.do" method="POST">
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
                                            <div class="control-group">
												<label class="control-label" for="code">Product Code/Quantity:</label>
												<div class="controls">
													<input type="text" class="span2" id="txtCode">
                                                    <input type="text" class="span1" id="txtQuantity">
	                                                <button id="btnAddRow" class="btn btn-mini btn-success" type="button">
	                                                    <i class="icon-circle-arrow-down">  Add Order</i>
	                                                </button>
                                                </div><!-- /controls -->
											</div><!-- /control-group -->
										    <div class="widget-header">
                                                <i class="icon-shopping-cart"></i>
                                                <h3>Product List</h3>
                                            </div><!-- /widget-header -->
                                            <div class="widget-content">
                                                 <table id="tbOrders" class="table table-striped table-bordered">
	                                               <thead>
	                                                    <tr>
                                                            <th>No</th>
	                                                        <th>Product Code</th>
	                                                        <th>Name</th>
	                                                        <th>Price PerUnit</th>
	                                                        <th>Quantity</th>
                                                            <th>Unit</th>
                                                            <th>Total Price</th>
                                                            <th></th>
	                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    </tbody>
                                                    <tfoot>
                                                        <tr>
                                                            <td colspan="4">Overall</td>
                                                            <td><div></div></td>
                                                            <td></td>
                                                            <td><div id="dvOverallPrice"></div></td>
                                                            <td></td>
                                                        </tr>
                                                    </tfoot>
	                                            </table>
                                            </div>
										</div>
										<div class="form-actions">
											<button type="submit" class="btn btn-primary">Apply Order</button>
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
       $("#btnAddRow").click(function()
       {
        
    	   $.getJSON( 'rest/product/cost?code='+ $('#txtCode').val(),
    			       function(data)
    			       {
    		                addRow(data)   
    			       });
    	   
       });
       
       //*****************************************
       $("#tbOrders").on('click', '.btn-remove', function () 
       {
    	    $(this).closest('tr').remove();
    	    updateRowIndex();
       });
    	       
       //*****************************************
       function addRow(data)
       {
    	   //**************************
    	   var quantity = $('#txtQuantity').val();
    	   var totalPrice =  quantity * data.productCostDetails.unitPrice
    	   
    	   
           $("#tbOrders tbody").append(
                      "<tr>" +
                        "<td><div id='dvIndex'></div><input id='txtProductId' type='hidden' value='"+data.id+"'></td>" +
                        "<td>"+data.code+"</td>" +
                        "<td>"+data.name+"</td>" +
                        "<td><div id='dvIndex'></div><input id='txtUnitPrice' type='hidden' value='"+data.productCostDetails.unitPrice+"'>"+
                        data.productCostDetails.unitPrice+"</td>" +
                        "<td><input id='txtQuantity' type='hidden' value='"+quantity+"'>"+quantity+"</td>" +
                        "<td>"+data.productCostDetails.unit+"</td>" +
                        "<td><div id='dvTotalPrice'>"+totalPrice+"</div></td>" +
                        "<td><button id='btnRemoveRow' class='btn btn-danger " + 
                             "btn-mini btn-remove' type='button'>"+
                        "<i class='icon-minus-sign'></i></button></td>" +
                      "</tr>"
                  );  
    	   
    	   updateRowIndex();
        
       }
       
       
       function updateRowIndex()
       {
           var overallPrice = 0;
           
    	   $('#tbOrders> tbody  > tr').each(function(rowIndex) 
           {
               $(this).find("#txtProductId").attr('name','orderDetails['+rowIndex+'].product.id');
               $(this).find("#txtQuantity").attr('name','orderDetails['+rowIndex+'].quantity');
               $(this).find("#txtUnitPrice").attr('name','orderDetails['+rowIndex+'].unitPrice');
    		   $(this).find("#dvIndex").text(rowIndex + 1); 
               overallPrice += parseInt($(this).find("#dvTotalPrice").text());
           }); 
           
           
           //**************************
           $('#dvOverallPrice').text(overallPrice);
           //**************************

       }
       
       
      
       

  });    
    </script>
    
</body>

</html>
