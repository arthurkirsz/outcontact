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
		<h2>Spring's form textbox example</h2>
	
		<form:form method="POST" commandName="contact">
			<table>
				<tr>
					<td><spring:message code="contactForm.lastName" />:</td>
					<td><form:input basename="messages" path="m_contactFirstName" /></td>
					<td><form:errors basename="errors" path="m_contactFirstName" cssStyle="color: #ff0000;"/></td>
				</tr>
				<tr>
					<td><spring:message code="contactForm.firstName" />:</td>
					<td><form:input basename="messages" path="m_contactLastName" /></td>
					<td><form:errors basename="errors" path="m_contactLastName" cssStyle="color: #ff0000;"/></td>
				</tr>
				<tr>
					<td><spring:message code="contactForm.mail" />:</td>
					<td><form:input basename="messages" path="m_contactMail" /></td>
					<td><form:errors basename="errors" path="m_contactMail" cssStyle="color: #ff0000;"/></td>
				</tr>
				<tr>
					<td><input type="submit" name="submit" value="Submit"/></td>
				</tr>
			</table>
		</form:form>
		
	</body>
</html>