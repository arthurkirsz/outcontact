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
          <ul>
          	<c:forEach var="contactItem" items="${contactList}">
   				<li>
   					<a href="<c:url value="/?id=${contactItem.m_contactKey}" />">
   						<c:out value="${contactItem.m_contactFirstName}"/> <c:out value="${contactItem.m_contactLastName}"/>
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
            <a href="#">Modifier une adresse</a>
            <a href="#">Modifier le contact</a>
            <a href="#">!!! Supprimer le contact</a>
        </div>
        <div class="wrapper" style="border: 1px solid black; width: 400px; margin:0  200px;">
          <!-- <img src="http://placehold.it/100x100" width="100px" class="left"> -->

          <h1><c:out value="${selectedContact.m_contactFirstName}"/> <c:out value="${selectedContact.m_contactLastName}"/></h1>
		  <h2><c:out value="${selectedContact.m_contactMail}"/></h2>
		  <h3><fmt:formatDate value="${selectedContact.m_contactBirthDate}" pattern="dd/MM/yyyy" /></h3>
          <!-- <h3>Adresse Domicile</h3>
          <address>
            38 rue Alebrt de Mun, 94100 Saint Maur des fossés
          </address>
          <h3>Adresse Facturation</h3>
          <address>
            19 rue Camille Mouquet Charenton le Pont 94220
          </address>-->


        </div>

      </section>
         
        <footer>
        </footer>
        <script type="text/javascript" src="assets/js/lib/jquery.js"></script>
        <script type="text/javascript" src="assets/js/app.js"></script>
    </body>
</html>
