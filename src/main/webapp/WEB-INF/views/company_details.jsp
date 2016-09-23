<!-- ************************************* -->
<%@page contentType="text/html" pageEncoding="UTF-8" 
errorPage="error.jsp" 
import="model.company.*,
        model.contact.*,
        model.person.*,
        java.util.List"%>
<!-- ************************************* -->

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>Company Details</title>
<%
    //***********************
    Company company = (Company) request.getAttribute( "companyDetails" );
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
								<h3>Company Details</h3>
							</div><!-- /widget-header -->
							<div class="widget-content">
							<% 
							//******************
							if(company != null)
							{
							%>
								<div class="tabbable">
			                        <ul class="nav nav-tabs">
			                          <li   class="active">
			                            <a href="#mainData" data-toggle="tab">Company Data</a>
			                          </li>
			                          <li>
			                             <a href="#contactData" data-toggle="tab">Contacts/Address</a>
			                          </li>
                                      <li>
                                         <a href="#detailsData" data-toggle="tab">Company Details</a>
                                      </li>
                                      <li>
                                         <a href="#personData" data-toggle="tab">Employees</a>
                                      </li>
			                        </ul>
                                    <br>
		                            <div class="tab-content">
		                                <div class="tab-pane active" id="mainData">
                                           <table class="table table-striped table-bordered">
			                                   <tbody>
			                                        <tr>
			                                            <td width="120px"><b>Code:</b></td>
			                                            <td><%=company.getCode() %></td>
			                                        </tr>
			                                        <tr>
			                                            <td><b>Name:</b></td>
			                                            <td><%=company.getName() %></td>
			                                        </tr>
                                                    <tr>
                                                        <td><b>Type:</b></td>
                                                        <td><%=company.getType() %></td>
                                                    </tr>
			                                        <tr>
                                                        <td><b>Status:</b></td>
                                                        <td><%=company.getStatus() %></td>
                                                    </tr>
                                                 </tbody>
                                            </table>
										</div>
                                        <div class="tab-pane" id="contactData">
	                                         <table class="table table-striped table-bordered">
				                                     <tbody>
			                                            <% 
			                                            //*************************
			                                            Contact contact = company.getContact();
			                                            
			                                            if(contact != null)
			                                            {
			                                            %>
	                                                    <tr>
	                                                        <td width="120px"><b>Phone Code/Number:</b></td>
	                                                        <td><%=contact.getCode() %>/<%=contact.getPhone() %></td>
	                                                    </tr>
	                                                    <tr>
	                                                        <td><b>E-Mail:</b></td>
	                                                        <td><%=contact.getEmail() %></td>
	                                                    </tr>
	                                                    <% 
			                                            }
			                                            
			                                            Address address = company.getAddress();
			                                            
			                                            if( address != null)
			                                            {
	                                                    %>
	                                                    <tr>
	                                                        <td><b>Country:</b></td>
	                                                        <td><%=address.getCountryId() %></td>
	                                                    </tr>
	                                                    <tr>
	                                                        <td><b>Region:</b></td>
	                                                        <td><%=address.getRegionId() %></td>
	                                                    </tr>
                                                        <tr>
                                                            <td><b>City:</b></td>
                                                            <td><%=address.getCity() %></td>
                                                        </tr>
                                                        <tr>
                                                            <td><b>Address Line 1:</b></td>
                                                            <td><%=address.getAddressLine1() %></td>
                                                        </tr>
                                                        <tr>
                                                            <td><b>Address Line 2:</b></td>
                                                            <td><%=address.getAddressLine2() %></td>
                                                        </tr>
			                                            <%
			                                            }
			                                            //***********************
			                                            %>
	                                                 </tbody>
	                                           </table>
                                        </div>
                                        <div class="tab-pane" id="detailsData">
                                             <table class="table table-striped table-bordered">
                                                   <tbody>
                                                        <% 
                                                        //*************************
                                                        CompanyDetails companyDetails = company.getCompanyDetails();
                                                        
                                                        if(companyDetails != null)
                                                        {
                                                        %>
                                                        <tr>
                                                            <td width="120px"><b>Sector:</b></td>
                                                            <td><%=companyDetails.getSector() %></td>
                                                        </tr>
                                                        <tr>
                                                            <td><b>Registration Number:</b></td>
                                                            <td><%=companyDetails.getRegistrationNumber() %></td>
                                                        </tr>
                                                        <tr>
                                                            <td><b>Tax Payer Number</b></td>
                                                            <td><%=companyDetails.getTaxPayerNumber() %></td>
                                                        </tr>
                                                        <tr>
                                                            <td><b>Details</b></td>
                                                            <td><%=companyDetails.getDetails() %></td>
                                                        </tr>
                                                        <% 
                                                        }
                                                        //****************************
                                                        %>
                                                     </tbody>
                                               </table>
                                        </div>
                                        <div class="tab-pane" id="personData">
                                             <table class="table table-striped table-bordered">
                                                   <thead>
                                                      <tr>
                                                          <th width="10">No</th>
                                                          <th>LastName</th>
                                                          <th>FirstName</th>
                                                          <th>MiddleName</th>
                                                          <th>Manage</th>
                                                      </tr>
                                                   </thead>                                                  
                                                   <tbody>
                                                        <% 
                                                        //*************************
                                                        int recordCount = 0;
                                                        List<Person> persons = company.getPersons();
                                                        
                                                        for(Person person : persons)
                                                        {
                                                        %>
                                                        <tr>
				                                            <td><%=++recordCount%></td>
				                                            <td><a href="person_details.vw?company_id=<%=person.getId()%>"><%=person.getLastName() %></a>
				                                            </td>
                                                            <td><%=person.getFirstName() %></td>
                                                            <td><%=person.getMiddleName() %></td>
                                                            <td><a href="company_details.vw?company_id=<%=company.getId()%>"
                                                                    class="btn btn-mini btn-danger"> Remove</a>
				                                             <a href="register_user.vw?person_id=<%=person.getId()%>&company_id=<%=company.getId() %>"
				                                                class="btn btn-mini btn-success"> + Assign User</a>
				                                             </td>
                                                        </tr>
                                                        <% 
                                                        }
                                                        //****************************
                                                        %>
                                                     </tbody>
                                               </table>
                                        </div>
										<div class="form-actions">
											<a href="edit_company.vw?company_id=<%=company.getId()%>" 
											class="btn btn-mini btn-warning"> Edit</a>	
                                            <a href="add_person.vw?company_id=<%=company.getId()%>" 
                                            class="btn btn-mini btn-success"> + Add Employee</a>  
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
