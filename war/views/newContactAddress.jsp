<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<title>OutContact</title>
		<link rel="stylesheet" type="text/css" href="assets/css/lib/normalize.css">
		<link rel="stylesheet" type="text/css" href="assets/css/lib/foundation.min.css">
		<link rel="stylesheet" type="text/css" href="assets/css/style.css">
	</head>
	<div>
		<a href=""><spring:message code="contactAddressForm.addNewAddress" /></a>
		<a href="existingContactAddress?contact=${contactId}&type=${addressType}"><spring:message code="contactAddressForm.addExistingAddress" /></a>
	</div>
	<body>
		<h2><spring:message code="${strTitle}" /></h2>

		<form:form method="POST" commandName="addressModel">
			<table>
				<tr>
					<td><spring:message code="addressForm.number" />:</td>
					<td><form:input basename="messages" path="m_addressNumber" /></td>
					<td><form:errors basename="errors" path="m_addressNumber" cssStyle="color: #ff0000;"/></td>
				</tr>
				<tr>
					<td><spring:message code="addressForm.street" />:</td>
					<td><form:input basename="messages" path="m_addressStreet" /></td>
					<td><form:errors basename="errors" path="m_addressStreet" cssStyle="color: #ff0000;"/></td>
				</tr>
				<tr>
					<td><spring:message code="addressForm.zipCode" />:</td>
					<td><form:input basename="messages" path="m_addressZipCode" /></td>
					<td><form:errors basename="errors" path="m_addressZipCode" cssStyle="color: #ff0000;"/></td>
				</tr>
				<tr>
					<td><spring:message code="addressForm.city" />:</td>
					<td><form:input basename="messages" path="m_addressCity" /></td>
					<td><form:errors basename="errors" path="m_addressCity" cssStyle="color: #ff0000;"/></td>
				</tr>
				<tr>
					<td><input type="submit" name="submit" value="<spring:message code="btnSubmit.create" />"/></td>
				</tr>
			</table>
		</form:form>
		
	</body>
</html>