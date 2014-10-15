<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<%@ include file="/templates/header.jsp" %>


    	<div class="row">
    		<div class="col-lg-2">
    		</div>

    		<div class="col-lg-8" style="margin: 50px auto;">
            	<div class="panel panel-default">
            		<div class="panel-heading">
						<h3 class="panel-title">
							<spring:message code="modifyContactForm.title" />
						</h3>
					</div>

					<div class="panel-body">
						<form:form method="POST" commandName="contactModel" role="form">

							<div class="form-group">
								<label for="m_contactFirstName">
									<spring:message code="contactForm.firstName" />
								</label>
								<form:input basename="messages" path="m_contactFirstName"  class="form-control" id="m_contactFirstName" value="${selectedContact.m_contactFirstName}"/>

								<form:errors basename="errors" path="m_contactFirstName" cssStyle="color: #ff0000;"/>
							</div>
							
							<div class="form-group">
								<label for="m_contactLastName">
									<spring:message code="contactForm.lastName" />
								</label>
								<form:input basename="messages" path="m_contactLastName"  class="form-control" id="m_contactLastName" value="${selectedContact.m_contactLastName}"/>

								<form:errors basename="errors" path="m_contactLastName" cssStyle="color: #ff0000;"/>
							</div>

							<div class="form-group">
								<label for="m_contactMail">
									<spring:message code="contactForm.mail" />
								</label>
								<form:input basename="messages" path="m_contactMail"  class="form-control" id="m_contactMail" value="${selectedContact.m_contactMail}"/>

								<form:errors basename="errors" path="m_contactMail" cssStyle="color: #ff0000;"/>
							</div>

							<div class="form-group">
								<label for="m_contactBirthDate">
									<spring:message code="contactForm.birthDate" />
								</label>
								<form:input basename="messages" path="m_contactBirthDate"  class="form-control" id="m_contactBirthDate" value="${selectedContactBirthDate}" type="date"/>

								<form:errors basename="errors" path="m_contactBirthDate" cssStyle="color: #ff0000;"/>
							</div>

							<input type="submit" name="submit" value="<spring:message code='btnSubmit.modify'/>" class="btn btn-default">
						</form:form>
					</div>
				</div>
    		</div>

    		<div class="col-lg-2">	
    		</div>
    	</div>




		
	</body>
</html>