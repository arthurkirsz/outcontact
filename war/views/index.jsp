<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="fr.esiea.outcontact.services.ContactService" %>
 
<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <title>OutContact</title>
        <link rel="stylesheet" type="text/css" href="assets/css/lib/normalize.css">
        <link rel="stylesheet" type="text/css" href="assets/css/style.css">
    </head>
    <body>
      <header>
        Outcontact
      </header>
      <aside>
        <nav>
          <div class="search"><input type="text"></div>
          <div>
          	<a href="/">Lister contact</a>
          	<a href="/?list=address">Lister adresses</a>
          </div>
          <ul>
          	<c:forEach var="contactItem" items="${contactList}">
   				<li>
   					<a href="<c:url value="/?contact=${contactItem.m_contactKey}" />">
   						<c:out value="${contactItem.m_contactFirstName}"/> <c:out value="${contactItem.m_contactLastName}"/>
   					</a>
   				</li>
			</c:forEach>
			<c:forEach var="addressItem" items="${addressList}">
   				<li>
   					<a href="<c:url value="/?address=${addressItem.m_addressKey}" />">
   						<c:out value="${addressItem.m_addressNumber}"/> <c:out value="${addressItem.m_addressStreet}"/>
   					</a>
   				</li>
			</c:forEach>
          </ul>
        </nav>
        <a href="createContact" class="button" id="create-contact">create contact</a>
      </aside>

      <section class="content">
        <div class="toolbar" style="width: 100%; height: 30px; background: #aaa">
            <a href="createAddress">Créer une adresse</a>
            <a href="modifyAddress?address=${selectedAddress.m_addressKey}">Modifier une adresse</a>
            <a href="/?deleteAddress=${selectedAddress.m_addressKey}">Supprimer une adresse</a>
            <br />
            <a href="modifyContact?contact=${selectedContact.m_contactKey}">Modifier le contact</a>
            <a href="/?deleteContact=${selectedContact.m_contactKey}">Supprimer le contact</a>
        </div>
        <div class="wrapper" style="border: 1px solid black; width: 400px; margin:0  200px;">
          <!-- <img src="http://placehold.it/100x100" width="100px" class="left"> -->

          <h1><c:out value="${selectedContact.m_contactFirstName}"/> <c:out value="${selectedContact.m_contactLastName}"/></h1>
          <h1><c:out value="${selectedAddress.m_addressNumber}"/> <c:out value="${selectedAddress.m_addressStreet}"/></h1>
		  <h2><c:out value="${selectedContact.m_contactMail}"/></h2>
		  <h2><c:out value="${selectedAddress.m_addressZipCode}"/></h2>
		  <h3><fmt:formatDate value="${selectedContact.m_contactBirthDate}" pattern="dd/MM/yyyy" /></h3>
		  <h3><c:out value="${selectedAddress.m_addressCity}"/></h3>
          <h3><spring:message code="index.billingAddress" /> <a href="newContactAddress?contact=${selectedContact.m_contactKey}&type=billing" style="${btnAddBillingAddressVisible}">+</a> </h3>
          <c:forEach var="billingAddressItem" items="${billingAddressContact}">
          	<li>
          		<address>
					<c:out value="${billingAddressItem}"/> <a href="/?contact=${selectedContact.m_contactKey}&deleteAddress=${billingAddressItem.m_addressKey}&type=billing">-</a>
				</address>
   			</li>
		  </c:forEach>
		  <h3><spring:message code="index.deliveryAddress"/> <a href="newContactAddress?contact=${selectedContact.m_contactKey}&type=delivery">+</a></h3>
		  <c:forEach var="deliveryAddressItem" items="${deliveryAddressListContact}">
          	<li>
          		<address>
					<c:out value="${deliveryAddressItem}"/> <a href="/?contact=${selectedContact.m_contactKey}&deleteAddress=${deliveryAddressItem.m_addressKey}&type=delivery">-</a>
				</address>
   			</li>
		  </c:forEach>

        </div>

      </section>
         
        <footer>
        </footer>
        <script type="text/javascript" src="assets/js/lib/jquery.js"></script>
        <script type="text/javascript" src="assets/js/app.js"></script>
    </body>
</html>
