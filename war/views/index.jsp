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
        <link rel="stylesheet" type="text/css" href="assets/css/lib/foundation.min.css">
        <link rel="stylesheet" type="text/css" href="assets/css/style.css">
    </head>
    <body>
        <nav class="top-bar" data-topbar>
        	<section class="row" style="max-width: 62.5rem">
                <ul class="title-area">
                   
                  <li class="name">
                    <h1>
                      <a href="/">
                        OutContact
                      </a>
                    </h1>
                  </li>
                  <li class="toggle-topbar menu-icon"><a href="#"><span>Menu</span></a></li>
                </ul>
            </section>
        </nav>
        
          <div id="contacts" class="row">
         
            <div class="large-6 columns">
              <div class="panel">
                <h5>Panel Title</h5>
                <% ContactServiceImpl contactService = new ContactServiceImpl(); %>
            	<%=contactService.listContact() %>
              </div>
            </div>
            <div class="large-2 columns">
              <div class="panel">
                <p>
                  <img src="http://placehold.it/200x200"/>
                </p>
              </div>
            </div>
            <div class="large-4 columns">
              <div class="panel">
                <h5>Panel Title</h5>
                <p>This is a four columns grid panel with an arbitrary height. Bacon ipsum dolor sit amet salami.</p>
              </div>
            </div>
          </div>
         
          <br>
          <section class="row">
         	<a href="contact" class="button">create contact</a>
           </section>
           
           <section class="row">
         	<a href="list" class="button">contact list</a>
           </section>
         
          <footer class="row">
            <div class="large-12 columns">
              <hr/>
              <div class="row">
                <div class="large-6 columns">
                  <p>&copy; OutContact inc.</p>
                </div>
                <div class="large-6 columns">
                  <ul class="inline-list right">
                    <li><a href="#">About</a></li>
                    <li><a href="#">Career</a></li>
                    <li><a href="#">Contact</a></li>
                    <li><a href="#">Press</a></li>
                  </ul>
                </div>
              </div>
            </div>
          </footer>
          <script type="text/javascript" src="assets/js/lib/jquery.js"></script>
    </body>
</html>
