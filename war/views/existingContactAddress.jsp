<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/templates/header.jsp" %>


		
    	<div class="row">
    		<div class="col-lg-12">
		        <div class="btn-group blue-toggle">
		        	<button type="button" class="btn btn-default">
		          		<a href="newContactAddress?contact=${contactId}&type=${addressType}">
		          			<spring:message code="contactAddressForm.addNewAddress" />
		          		</a>
					</button>
					<button type="button" class="btn btn-default active">
						<a href="#">
							<spring:message code="contactAddressForm.addExistingAddress" />
						</a>
					</button>
				</div>
			</div>
		</div>

    	<div class="row">
    		<div class="col-lg-2">
    			
    		</div>

    		<div class="col-lg-8" style="margin: 50px auto;">
            	<div class="panel panel-default">
            		<div class="panel-heading">
						<h3 class="panel-title">
							<spring:message code="${strTitle}" />
						</h3>
					</div>

					<div class="panel-body">
						<form:form method="POST" commandName="addressForm">

							<div class="form-group">
								<label for="m_addressNumber">
									<spring:message code="contactAddressForm.existingAddresses" />
								</label>
								<form:select path="m_addressKey" itemValue="m_addressKey" items="${addressList}" class="form-control"/>
							</div>

							<input type="submit" name="submit" value="<spring:message code="btnSubmit.save" />" class="btn btn-default" />
						</form:form>

					</div>
				</div>
			</div>

    		<div class="col-lg-2">
    			
    		</div>
    	</div>

	</body>
</html>