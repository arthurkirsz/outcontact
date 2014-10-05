<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<title>OutContact</title>
		<link rel="stylesheet" type="text/css" href="assets/css/lib/normalize.css">
		<link rel="stylesheet" type="text/css" href="assets/css/lib/foundation.min.css">
		<link rel="stylesheet" type="text/css" href="assets/css/style.css">
	</head>
	
	<body>
		<h2><spring:message code="modifyContactForm.title" /></h2>
	
		<form:form method="POST" commandName="contactModel">
			<table>
				<tr>
					<td><spring:message code="contactForm.lastName" />:</td>
					<td><form:input basename="messages" path="m_contactLastName" value="${selectedContact.m_contactLastName}"/></td>
					<td><form:errors basename="errors" path="m_contactLastName" cssStyle="color: #ff0000;"/></td>
				</tr>
				<tr>
					<td><spring:message code="contactForm.firstName" />:</td>
					<td><form:input basename="messages" path="m_contactFirstName" value="${selectedContact.m_contactFirstName}"/></td>
					<td><form:errors basename="errors" path="m_contactFirstName" cssStyle="color: #ff0000;"/></td>
				</tr>
				<tr>
					<td><spring:message code="contactForm.mail" />:</td>
					<td><form:input basename="messages" path="m_contactMail" value="${selectedContact.m_contactMail}"/></td>
					<td><form:errors basename="errors" path="m_contactMail" cssStyle="color: #ff0000;"/></td>
				</tr>
				<tr>
					<td><spring:message code="contactForm.birthDate" />:</td>
					<td><form:input basename="messages" path="m_contactBirthDate" type="date" value="${selectedContactBirthDate}"/></td>
					<td><form:errors basename="errors" path="m_contactBirthDate" cssStyle="color: #ff0000;"/></td>
				</tr>
				<tr>
					<td><input type="submit" name="submit" value="<spring:message code="btnSubmit.modify" />"/></td>
				</tr>
			</table>
		</form:form>
		
	</body>
</html>