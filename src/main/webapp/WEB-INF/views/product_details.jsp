<!-- ************************************* -->
<%@page contentType="text/html" pageEncoding="UTF-8" 
errorPage="error.jsp" 
import="model.product.*,
        model.contact.*"%>
<!-- ************************************* -->

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>Product Details</title>
<%
    //***********************
    Product product = (Product) request.getAttribute( "productDetails" );
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
							if(product != null)
							{
							%>
								<div class="tabbable">
			                        <ul class="nav nav-tabs">
			                          <li   class="active">
			                            <a href="#mainData" data-toggle="tab">Product Data</a>
			                          </li>
			                          <li>
			                             <a href="#contactData" data-toggle="tab">Cost/Tax Details</a>
			                          </li>
                                      <li>
                                         <a href="#detailsData" data-toggle="tab">Product Details</a>
                                      </li>
			                        </ul>
                                    <br>
		                            <div class="tab-content">
		                                <div class="tab-pane active" id="mainData">
                                           <table class="table table-striped table-bordered">
			                                   <tbody>
			                                        <tr>
			                                            <td width="120px"><b>Code:</b></td>
			                                            <td><%=product.getCode() %></td>
			                                        </tr>
			                                        <tr>
			                                            <td><b>Name:</b></td>
			                                            <td><%=product.getName() %></td>
			                                        </tr>
                                                    <tr>
                                                        <td><b>Type:</b></td>
                                                        <td><%=product.getType() %></td>
                                                    </tr>
                                             </tbody>
                                            </table>
										</div>
                                        <div class="tab-pane" id="contactData">
                                             <table class="table table-striped table-bordered">
                                                   <tbody>
                                                        <% 
                                                        //*************************
                                                        ProductCostDetails costDetails = product.getProductCostDetails();
                                                        
                                                        if(costDetails != null)
                                                        {
                                                        %>
                                                        <tr>
                                                            <td width="120px"><b>Price:</b></td>
                                                            <td><%=costDetails.getUnitPrice() %></td>
                                                        </tr>
                                                        <tr>
                                                            <td width="120px"><b>Unit:</b></td>
                                                            <td><%=costDetails.getUnit() %></td>
                                                        </tr>
                                                        <% 
                                                        }
                                                        //****************************
                                                        %>
                                                     </tbody>
                                               </table>
                                        </div>
                                        <div class="tab-pane" id="detailsData">
                                             <table class="table table-striped table-bordered">
                                                   <tbody>
                                                        <% 
                                                        //*************************
                                                        ProductDetails productDetails = product.getProductDetails();
                                                        
                                                        if(productDetails != null)
                                                        {
                                                        %>
                                                        <tr>
                                                            <td width="120px"><b>Details:</b></td>
                                                            <td><%=productDetails.getDetails() %></td>
                                                        </tr>
                                                        <% 
                                                        }
                                                        //****************************
                                                        %>
                                                     </tbody>
                                               </table>
                                        </div>
										<div class="form-actions">
											<a href="edit_product.vw?product_id=<%=product.getId()%>" 
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
