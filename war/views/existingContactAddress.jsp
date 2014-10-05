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
		<a href="newContactAddress?contact=${contactId}&type=${addressType}"><spring:message code="contactAddressForm.addNewAddress" /></a>
		<a href=""><spring:message code="contactAddressForm.addExistingAddress" /></a>
	</div>
	<body>
		<h2><spring:message code="${strTitle}" /></h2>

	<form:form method="POST" commandName="addressForm">
		<table>
			<tr>	
				<td><spring:message code="contactAddressForm.existingAddresses" />:</td>	
				<td>
					<form:select path="m_addressKey" itemValue="m_addressKey" items="${addressList}"/> 
				</td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="<spring:message code="btnSubmit.save" />" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>