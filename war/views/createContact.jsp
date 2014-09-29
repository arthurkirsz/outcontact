<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<title>OutContact</title>
		<link rel="stylesheet" type="text/css"
			href="assets/css/lib/normalize.css">
		<link rel="stylesheet" type="text/css"
			href="assets/css/lib/foundation.min.css">
		<link rel="stylesheet" type="text/css" href="assets/css/style.css">
	</head>
	
	<body>
		<h2><spring:message code="createContactForm.title" /></h2>
	
		<form:form method="POST" commandName="contact">
			<table>
				<tr>
					<td><spring:message code="createContactForm.lastName" />:</td>
					<td><form:input basename="messages" path="m_contactFirstName" /></td>
					<td><form:errors basename="errors" path="m_contactFirstName" cssStyle="color: #ff0000;"/></td>
				</tr>
				<tr>
					<td><spring:message code="createContactForm.firstName" />:</td>
					<td><form:input basename="messages" path="m_contactLastName" /></td>
					<td><form:errors basename="errors" path="m_contactLastName" cssStyle="color: #ff0000;"/></td>
				</tr>
				<tr>
					<td><spring:message code="createContactForm.mail" />:</td>
					<td><form:input basename="messages" path="m_contactMail" /></td>
					<td><form:errors basename="errors" path="m_contactMail" cssStyle="color: #ff0000;"/></td>
				</tr>
				<tr>
					<td><spring:message code="createContactForm.birthDate" />:</td>
					<td><form:input basename="messages" path="m_contactBirthDate" type="date" /></td>
					<td><form:errors basename="errors" path="m_contactBirthDate" cssStyle="color: #ff0000;"/></td>
				</tr>
				<tr>
					<td><input type="submit" name="submit" value="<spring:message code="createContactForm.create" />"/></td>
				</tr>
			</table>
		</form:form>
		
	</body>
</html>