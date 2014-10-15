<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="/templates/header.jsp" %>

    	<div class="row">
    		<div class="col-lg-2"></div>

    		<div class="col-lg-8" style="margin: 50px auto;">
            	<div class="panel panel-default">
            		<div class="panel-heading">
						<h3 class="panel-title"><spring:message code="createAddressForm.title" /></h3>
					</div>

					<div class="panel-body">
						<form:form method="POST" commandName="addressModel" role="form">
							<div class="form-group">
								<label for="m_addressNumber">
									<spring:message code="addressForm.number" />
								</label>
								<form:input basename="messages" path="m_addressNumber"  class="form-control" id="m_addressNumber" placeholder="Numéro de rue"/>

								<form:errors basename="errors" path="m_addressNumber" cssStyle="color: #ff0000;"/>
							</div>

							<div class="form-group">
								<label for="m_addressStreet">
									<spring:message code="addressForm.street" />
								</label>
								<form:input basename="messages" path="m_addressStreet"  class="form-control" id="m_addressStreet" placeholder="Numéro de rue"/>

								<form:errors basename="errors" path="m_addressStreet" cssStyle="color: #ff0000;"/>
							</div>

							<div class="form-group">
								<label for="m_addressZipCode">
									<spring:message code="addressForm.zipCode" />
								</label>
								<form:input basename="messages" path="m_addressZipCode"  class="form-control" id="m_addressZipCode" placeholder="Numéro de rue"/>
								<form:errors basename="errors" path="m_addressZipCode" cssStyle="color: #ff0000;"/>
							</div>

							<div class="form-group">
								<label for="m_addressCity">
									<spring:message code="addressForm.city" />
								</label>
								<form:input basename="messages" path="m_addressCity"  class="form-control" id="m_addressCity" placeholder="Numéro de rue"/>
								<form:errors basename="errors" path="m_addressCity" cssStyle="color: #ff0000;"/>
							</div>

							<div class="form-group has-error has-feedback">
							  <label class="control-label" for="inputError2">Input Test error</label>
							  <input type="text" class="form-control" id="inputError2">
							  <span class="glyphicon glyphicon-remove form-control-feedback"></span>
							</div>


							<input type="submit" name="submit" value="<spring:message code='btnSubmit.create'/>" class="btn btn-default">

						</form:form>
					</div>
				</div>
    		</div>

    		<div class="col-lg-2"></div>
    	</div>
	</body>
</html>