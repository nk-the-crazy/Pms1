<!-- ************************************* -->
<%@page contentType="text/html" 
pageEncoding="UTF-8" 
errorPage="error.jsp" 
import="model.identity.*,
        java.util.List,
        model.sales.*,
        model.product.*" %>
<!-- ************************************* -->

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>Sales Order Details</title>
<%
    //***********************
    int recordCount = 0;
    SalesOrder salesOrder = (SalesOrder) request.getAttribute( "salesOrderDetails" );
    //***********************
%>

<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/bootstrap-responsive.min.css" rel="stylesheet">
<link href="resources/lib/datetimepicker/css/datepicker.css" rel="stylesheet">
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600" rel="stylesheet">
<link href="resources/css/font-awesome.css" rel="stylesheet">
<link href="resources/css/style.css" rel="stylesheet">
<link href="resources/css/pages/dashboard.css" rel="stylesheet">
<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">

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
								<h3> Sales Order Details</h3>
							</div><!-- /widget-header -->
							<div class="widget-content">
								<% 
	                            //******************
	                            if(salesOrder != null)
	                            {
	                            %>
									<div class="tabbable">
			                        <ul class="nav nav-tabs">
			                          <li   class="active">
			                            <a href="#mainData" data-toggle="tab">Sales Orders</a>
			                          </li>
                                    </ul>
                                    <br>
		                            <div class="tab-content">
		                                <div class="tab-pane active" id="mainData">
                                            <table class="table table-striped table-bordered">
                                               <tbody>
                                                    <tr>
                                                        <td width="120px"><b>Code:</b></td>
                                                        <td><%=salesOrder.getCode() %></td>
                                                    </tr>
                                                    <tr>
                                                        <td><b>Date:</b></td>
                                                        <td><%=salesOrder.getOrderDate() %></td>
                                                    </tr>
                                                    <tr>
                                                        <td><b>Customer:</b></td>
                                                        <td></td>
                                                    </tr>
                                             </tbody>
                                            </table>
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
                                                    <% 
                                                    //*****************************
                                                    float pricePerUnit = 0;
                                                    float quantity = 0;
                                                    float totalPrice = 0;
                                                    float overallPrice = 0;
                                                    
                                                    
                                                    for(SalesOrderDetails orderDetails:salesOrder.getOrderDetails())
                                                    {
                                                        pricePerUnit = orderDetails.getUnitPrice();   
                                                        quantity  = orderDetails.getQuantity();
                                                        totalPrice = pricePerUnit * quantity;
                                                        overallPrice += totalPrice;
                                                        
                                                    %>
                                                        <tr>
                                                            <td><%=++recordCount %></td>
                                                            <td><a href="product_details.vw?product_id=<%=orderDetails.getProduct().getId() %>">
                                                            <%=orderDetails.getProduct().getCode() %></a></td>
                                                            <td><a href="product_details.vw?product_id=<%=orderDetails.getProduct().getId() %>">
                                                            <%=orderDetails.getProduct().getName() %></a></td>
                                                            <td><%=pricePerUnit%></td>
                                                            <td><%=quantity%></td>
                                                            <td></td>
                                                            <td><%=totalPrice%></td>
                                                            <td>
                                                            <button class="btn btn-danger btn-mini btn-remove" type="button">
                                                                        <i class="icon-minus-sign"></i>
                                                                </button></td>
                                                        </tr>
                                                    <% 
                                                    }
                                                    //****************************
                                                    %>
                                                    </tbody>
                                                    <tfoot>
                                                        <tr>
                                                            <td colspan="4">Overall</td>
                                                            <td><div></div></td>
                                                            <td></td>
                                                            <td><div id="dvOverallPrice"><%=overallPrice %></div></td>
                                                            <td></td>
                                                        </tr>
                                                    </tfoot>
	                                            </table>
                                            </div>
										</div>
										<div class="form-actions">
											<button type="submit" class="btn btn-warning">Edit</button>
                                            <button type="submit" class="btn btn-info"><i
                                            class="fa fa-file-pdf-o" style="font-size:16px;color:red"></i>&nbsp;Export PDF</button>
											<button type="button" class="btn" onclick="history.back()">&lt;&lt; Back</button>
										</div>
										<!-- /form-actions -->
										</div> <!-- /tabcontent -->
                                        </div> <!-- /tabbable -->
                                        <%
                                        } 
                                        //****************************
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
