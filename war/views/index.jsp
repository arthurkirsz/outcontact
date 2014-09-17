<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    
<%@ page import="fr.esiea.outcontact.services.ContactServiceImpl" %>
 
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
            <li><a href="#" class="active">Arthur Kirsz</a></li>
            <li><a href="#">DAVID Porcheron</a></li>
            <li><a href="#">Arthur Kirsz</a></li>
            <li><a href="#">Arthur Kirsz</a></li>
            <li><a href="#">Arthur Kirsz</a></li>
            <li><a href="#">Arthur Kirsz</a></li>
            <li><a href="#">Arthur Kirsz</a></li>
            <li><a href="#">Arthur Kirsz</a></li>
            <li><a href="#">Arthur Kirsz</a></li>
            <li><a href="#">Arthur Kirsz</a></li>
            <li><a href="#">Arthur Kirsz</a></li>
            <li><a href="#">Arthur Kirsz</a></li>
            <li><a href="#">Arthur Kirsz</a></li>
            <li><a href="#">Arthur Kirsz</a></li>
            <li><a href="#">Arthur Kirsz</a></li>
            <li><a href="#">Arthur Kirsz</a></li>
            <li><a href="#">Arthur Kirsz</a></li>
            <li><a href="#">Arthur Kirsz</a></li>
            <li><a href="#">Arthur Kirsz</a></li>
          </ul>
        </nav>
        <a href="contact" class="button" id="create-contact">create contact</a>
      </aside>

      <section class="content">
        <div class="toolbar" style="width: 100%; height: 30px; background: #aaa">
            <a href="#">Créer une adresse</a>
            <a href="#">Modifier une adresse</a>
            <a href="#">Modifier le contact</a>
            <a href="#">!!! Supprimer le contact</a>
        </div>
        <div class="wrapper" style="border: 1px solid black; width: 400px; margin:0  200px;">
          <img src="http://placehold.it/100x100" width="100px" class="left">

          <h1>Arthur Kirsz</h1>

          <h3>Adresse Domicile</h3>
          <address>
            38 rue Alebrt de Mun, 94100 Saint Maur des fossés
          </address>
          <h3>Adresse Facturation</h3>
          <address>
            19 rue Camille Mouquet Charenton le Pont 94220
          </address>


        </div>

      </section>



      <div id="contacts">
        <% ContactServiceImpl contactService = new ContactServiceImpl(); %>
        <%=contactService.listContact() %>
      </div>
         
        <footer>
        </footer>
        <script type="text/javascript" src="assets/js/lib/jquery.js"></script>
        <script type="text/javascript" src="assets/js/app.js"></script>
    </body>
</html>
