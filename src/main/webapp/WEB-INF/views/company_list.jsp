<!-- ************************************* -->
<%@page contentType="text/html" pageEncoding="UTF-8"
	errorPage="error.jsp"
	import="java.util.List,
        java.util.ArrayList, 
        model.company.*"%>
<!-- ************************************* -->

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>Company List</title>
<%
    //***********************
    int recordCount = 0;
    @SuppressWarnings("unchecked")
    List<Company> companies = (List<Company>) request.getAttribute( "companyList" );
    //***********************
%>

<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/bootstrap-responsive.min.css" rel="stylesheet">
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600"
	rel="stylesheet">
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
		<jsp:include page="header.jsp"><jsp:param name="page"
				value="main" /></jsp:include>
		<jsp:include page="main_menu.jsp"><jsp:param name="page"
				value="main" /></jsp:include>
	</div>
	<!-- /navbar -->

	<div class="main">
		<div class="main-inner">
			<div class="container">
				<div class="row">
					<div  class="span8">
						<div class="widget widget-table action-table">
							<div class="widget-header">
								<i class="icon-th-list"></i>
								<h3>Company List</h3>
							</div>
							<div class="widget-content">
								<br>
								<form id="register-company" class="form-horizontal"
									action="register_company.do" method="POST">
									<fieldset>
										<label class="control-label" for="phone_details">Code/Name</label>
										<div class="controls">
											<input type="text" class="span1" id="phone_code"
												name="phone_code"> <input type="text" class="span2"
												id="phone_number" name="phone_number">
											<button type="submit" class="btn btn-primary btn-mini">
												<i class="icon-search"></i>&nbsp;&nbsp; Search
											</button>
										</div>
										<!-- /controls -->
									</fieldset>
								</form>
							</div>
							<div class="widget-content">
								<%
								    //******************************
								    if ( !companies.isEmpty() )
								    {
								%>
								<table class="table table-striped table-bordered">
									<thead>
										<tr>
											<th width="10">No</th>
											<th>Code</th>
											<th>Name</th>
											<th>Type</th>
											<th>Manage</th>
										</tr>
									</thead>
									<tbody>
										<%
										  for ( Company company : companies )
										  {
										%>
										<tr>
											<td><%=++recordCount%></td>
											<td><a href="company_details.vw?company_id=<%=company.getId()%>"><%=company.getCode()%></a>
											</td>
											<td><%=company.getName()%></td>
											<td><%=company.getType()%></td>
											<td><a
												href="company_details.vw?company_id=<%=company.getId()%>"
												class="btn btn-mini btn-warning"> Edit</a>
												
										     <a href="register_person.vw?company_id=<%=company.getId()%>"
                                                class="btn btn-mini btn-success"> + Add Employee</a>
										     </td>
										</tr>
										<%
										    }
										%>
									</tbody>
								</table>
								<%
								    }
								    //*******************************
								%>
							</div>
							<!-- /widget-content -->
							<div class="alert alert-success">
                                    <strong><%=recordCount %> Records Found</strong>&nbsp;&nbsp;&nbsp;  
                                    <%
                                    //***************************
                                    if(recordCount > 0)
                                    { 
                                    %>
	                                    <button type="button" class="btn btn-primary btn-mini"> &lt; Prev</button>
	                                    <button type="button" class="btn btn-primary btn-mini">Next &gt;</button>
	                                <% 
                                    }
                                    //****************************
                                    %>
                             </div>
						</div>
						<!-- /widget -->
					</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp"><jsp:param name="page"
			value="main" /></jsp:include>
	<!-- /footer -->


	<!-- Javascript ================================================ -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="resources/js/jquery-2.1.4.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/base.js"></script>
</body>

</html>
