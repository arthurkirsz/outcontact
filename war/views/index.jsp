<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="fr.esiea.outcontact.services.ContactService" %>

<!DOCTYPE html>
<html lang="en">
    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>OutContact</title>

        <!-- Bootstrap Core CSS -->
        <link href="assets/css/lib/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="assets/css/lib/sb-admin.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="assets/font-awesome-4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">

        <!-- Custom Fonts -->
        <link href="assets/css/custom.css" rel="stylesheet" type="text/css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>

        <div id="wrapper">

            <!-- Navigation -->
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                        <span class="sr-only">Afficher la navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="/">OutContact</a>
                </div>
                
                <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
                <div class="collapse navbar-collapse navbar-ex1-collapse">
                    <ul class="nav navbar-nav side-nav" id="item-list">
                    	<li>
                            <div class="btn-group blue-toggle menu-toggle">
                                <c:if test="${contactList!=null}">
                                    <button type="button" class="btn btn-default active">
                                        <a href="/">Contacts</a>
                                    </button>
                                    <button type="button" class="btn btn-default">
                                        <a href="/?list=address">Adresses</a>
                                    </button>
                                </c:if>
                                <c:if test="${addressList!=null}">
                                    <button type="button" class="btn btn-default">
                                        <a href="/">Contacts</a>
                                    </button>
                                    <button type="button" class="btn btn-default active">
                                        <a href="/?list=address">Adresses</a>
                                    </button>
                                </c:if>
                    		</div>
    					</li>
    					<li>
                          <form class="navbar-form navbar-left" role="search" style="margin-left: auto;margin-right: auto;">
                            <div class="form-group">
                              <input type="text" class="form-control" placeholder="Recherche..." id="search"
                              style="border-radius: 2px;background: #232323;border-color: #777;">
                            </div>
                          </form>
                        </li>
                        <li>
                        	<div style="width: 12em;
										height: 2px;
										background: #313131;
										left: 2em;
										position: relative;
										margin-top: 20px;
										margin-bottom: 20px;"></div>
                        </li>

                        <li style="">
                            <c:if test="${contactList!=null}">
                                <button type="button" class="btn btn-default active" style="left: 45px;position: relative;">
                                    <a href="createContact" id="create-contact">Créer un contact</a>
                                </button>
                            </c:if>
                            <c:if test="${addressList!=null}">
                                <button type="button" class="btn btn-default active" style="left: 40px;position: relative;">
                                    <a href="createAddress">Créer une adresse</a>
                                </button>
                            </c:if>
                        </li>
    					
    					
                    	<c:forEach var="contactItem" items="${contactList}">
    		   				<li class="item">
    		   					<a href="<c:url value="/?contact=${contactItem.m_contactKey}" />">
    		   						<c:out value="${contactItem.m_contactFirstName}"/> <c:out value="${contactItem.m_contactLastName}"/>
    		   					</a>
    		   				</li>
    					</c:forEach>
    					<c:forEach var="addressItem" items="${addressList}">
    		   				<li class="item">
    		   					<a href="<c:url value="/?address=${addressItem.m_addressKey}" />">
    		   						<c:out value="${addressItem.m_addressNumber}"/> <c:out value="${addressItem.m_addressStreet}"/>
    		   					</a>
    		   				</li>
    					</c:forEach>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </nav>

            <div id="page-wrapper" style="min-height: 600px;background-color: gray;background-image: linear-gradient(90deg, #586C79 50%, rgba(88,108,121,.9) 50%);background-size: 15px 15px;">

                
                    
                <style type="text/css">
                    .btn {
                        border-radius: 2px;
                        border-bottom: 2px solid rgba(0,0,0,.2);
                    }
                    .adress-list {
                        
                    }
                    .adress-list li{
                        list-style-type: none;
                    }

                    .row {
                        margin : 0px;
                    }
                </style>
                
                <div class="row" style="background: #006BA0;height: 25px;border-bottom: 2px solid rgba(0,0,0,.2);line-height: 40px;text-indent: 2%;">
                    <div class="col-lg-12">

                    </div>
                </div>
                <c:if test="${selectedContact==null && selectedAddress==null}">
                    <div class="row">
                        <h1 style="font-size: 45px;text-align: center;font-weight: 100;color: #fff;margin: 35px auto 15px;">
                            An experimental Contact App in J2EE
                        </h1>
                        <h2 style="text-align: center;font-weight: 100; color: #aaa;">
                            By David Porcheron, Arthur Kirsz and Warren Levin
                        </h2>

                        <h2></h2>
                        <p></p>
                    </div>
                    <div class="row">
                        <div class="col-lg-12">                  
                            <div class="tube">
                                <div class="bolhas-top bolha1"></div>
                                <div class="bolhas-top bolha2"></div>
                                <div class="bolhas-top bolha3"></div>
                                <div class="bolhas-top bolha4"></div>
                                <div class="bolhas-top bolha5"></div>
                            </div>
                        </div>
                    </div>
                </c:if>


                <c:if test="${selectedContact!=null}">

                    <div class="row content-wrapper" style="background: #586C79;background-color: gray;background-image: linear-gradient(90deg, #586C79 50%, rgba(88,108,121,.9) 50%);background-size: 15px 15px;">

                        <div class="col-lg-6" style="background: #586C79; height: 100%;min-height: 580px;background-color: gray;background-image: linear-gradient(90deg, #586C79 50%, rgba(88,108,121,.9) 50%);background-size: 15px 15px;">

                            <div style="padding: 10px;">

                                    <div style="border-radius: 100px; margin:40px auto 20px; overflow:hidden;width: 150px;">
                                        <img src="/assets/images/user.png" class="randomuser" width="150" height="150px">
                                    </div>
                                    <h1 style="font-size: 45px;text-align: center;font-weight: 100;color: #fff;margin: 35px 0 15px;">
                                        <c:out value="${selectedContact.m_contactFirstName}"/> <c:out value="${selectedContact.m_contactLastName}"/>
                                    </h1>
                                    <h2 style="text-align: center;">
                                        <a href="mailto:${selectedContact.m_contactMail}" style="font-size: 16px;color: #bbb;letter-spacing: 2px;font-weight: 100;"><c:out value="${selectedContact.m_contactMail}"/></a>
                                    </h2>
                                
                                    <h3 style="text-align: center;font-size: 16px;color: #353535;">
                                        <img src="/assets/images/cake.png" style="width: 20px;position: relative;top: -6px;left: -3px;">
                                        <fmt:formatDate value="${selectedContact.m_contactBirthDate}" pattern="dd/MM/yyyy" />
                                    </h3>

                                    <div style="margin: 50px auto; width: 310px;">
                                        <a href="modifyContact?contact=${selectedContact.m_contactKey}" class="btn btn-primary">
                                            Modifier le contact
                                        </a>
                                        <a href="/?deleteContact=${selectedContact.m_contactKey}" onclick="javascript:return confirm('Attention, cette action est irréversible. Continuer ?');" class="btn btn-primary">
                                            Supprimer le contact
                                        </a>
                                    </div>
                            </div>
                        </div>
                        <div class="col-lg-6" style="background: #ccc;
                                                min-height: 580px;
                                                border-left: 2px solid #444;
                                                padding-top: 10px;">
                            <h3 style="font-size: 14px;text-transform: uppercase;border-top: 1px solid #000;border-bottom: 1px solid #000;padding: 8px 0;width: 95%;">
                                <spring:message code="index.billingAddress" /> 
                                <a href="newContactAddress?contact=${selectedContact.m_contactKey}&type=billing" 
                                style="${btnAddBillingAddressVisible};" class="plus-button">
                                +</a> 
                            </h3>
                            <ul style="margin: 0px;padding: 0px;">
                                <c:forEach var="billingAddressItem" items="${billingAddressContact}">
                                    <li style="position:relative; overflow:hidden;margin: 0px;margin-bottom: 20px;  width: 95%;height: 100px;border: 1px solid #333;">

                                            
                                            <img src='https://maps.googleapis.com/maps/api/staticmap?center=${billingAddressItem}&zoom=13&size=600x150&maptype=roadmap&markers=color:blue%7Clabel:S%7C40.702147,-74.015794&markers=color:green%7Clabel:G%7C40.711614,-74.012318&markers=color:red%7Clabel:C%7C40.718217,-73.998284' style="position:absolute;top:0px;left:0px;">

                                            <address style="position: absolute;top: 0px;left: 0px;display: block;background: rgba(0,0,0,.7);color: #fff;padding: 10px;height: 100px;width: 100%;text-align: center;line-height: 40px;font-size: 25px;font-weight: 100;letter-spacing: 1px;">
                                                <c:out value="${billingAddressItem}"/> <a href="/?contact=${selectedContact.m_contactKey}&deleteAddress=${billingAddressItem.m_addressKey}&type=billing" onclick="javascript:return confirm('Attention, cette action est irréversible. Continuer ?');" class="cross-button">x</a>
                                            </address>

                                        </li>
                                </c:forEach>
                            </ul>


                            <div style="height: 1px;width: 95%; border-top:1px dashed #aaa; margin: 30px 0;"></div>


                            <h3 style="font-size: 14px;text-transform: uppercase;border-top: 1px solid #000;border-bottom: 1px solid #000;padding: 8px 0;width: 95%;">
                                <spring:message code="index.deliveryAddress"/> 
                                <a href="newContactAddress?contact=${selectedContact.m_contactKey}&type=delivery" 
                                class="plus-button">+</a>
                            </h3>

                            <ul class="adress-list" style="margin: 0px;padding: 0px;">
                                <c:forEach var="deliveryAddressItem" items="${deliveryAddressListContact}">
                                    <li style="position:relative; overflow:hidden;margin: 0px;margin-bottom: 20px;  width: 95%;height: 100px;border: 1px solid #333;">

                                        
                                        <img src='https://maps.googleapis.com/maps/api/staticmap?center=${deliveryAddressItem}&zoom=13&size=600x150&maptype=roadmap&markers=color:blue%7Clabel:S%7C40.702147,-74.015794&markers=color:green%7Clabel:G%7C40.711614,-74.012318&markers=color:red%7Clabel:C%7C40.718217,-73.998284' style="position:absolute;top:0px;left:0px;">

                                        <address style="position: absolute;top: 0px;left: 0px;display: block;background: rgba(0,0,0,.7);color: #fff;padding: 10px;height: 100px;width: 100%;text-align: center;line-height: 40px;font-size: 25px;font-weight: 100;letter-spacing: 1px;">
                                            <c:out value="${deliveryAddressItem}"/> 
                                            <a onclick="javascript:return confirm('Attention, cette action est irréversible. Continuer ?');" href="/?contact=${selectedContact.m_contactKey}&deleteAddress=${deliveryAddressItem.m_addressKey}&type=delivery" class="cross-button">x</a>
                                        </address>

                                    </li>
                                </c:forEach>
                            </ul>

                        </div>
                    </div>
                </c:if>


                <c:if test="${selectedAddress!=null}">
                    <div class="row">
                        <div class="col-lg-12" style="position:relative; height: 650px;overflow:hidden;">


                            <div style="position: absolute; top: 0px; left: 0px; bottom: 0px ; right: 0px;background: #000;opacity:.4; z-index:10;">
                            </div>

                            <img src='https://maps.googleapis.com/maps/api/staticmap?center=${selectedAddress.m_addressNumber}+${selectedAddress.m_addressStreet}+${selectedAddress.m_addressZipCode}+${selectedAddress.m_addressCity}&zoom=13&size=2024x350&maptype=roadmap&markers=color:blue%7Clabel:S%7C40.702147,-74.015794&markers=color:green%7Clabel:G%7C40.711614,-74.012318&markers=color:red%7Clabel:C%7C40.718217,-73.998284' style="position: absolute; top: 0px; left: 0px; bottom: 0px ; right: 0px;height:100%;opacity:1; z-index:3;" class="map">
                            
                        

                            <div style="z-index: 99;color: #fff;background-color: rgba(0,0,0, .7);padding: 15px 20px;height: 245px;opacity:1;position:absolute;top: 25%;left: 25%;right:25%;">
                                <h1 style="font-size: 4rem;text-align: center;font-weight: 100;color: #fff;margin: 35px 0 15px;"><c:out value="${selectedAddress.m_addressNumber}"/> <c:out value="${selectedAddress.m_addressStreet}"/></h1>
                                <h2 style="text-align:center;font-size: 25px;color: #bbb;letter-spacing: 2px;font-weight: 100;"><c:out value="${selectedAddress.m_addressCity}"/></h2>
                                <h3 style="text-align:center;font-size: 15px;color: #999;letter-spacing: 1px;font-weight: 400;"><c:out value="${selectedAddress.m_addressZipCode}"/></h3>
                                <div style="width: 300px; margin: 20px auto;">
                                    <a href="modifyAddress?address=${selectedAddress.m_addressKey}" class="btn btn-default">Modifier l'adresse</a>
                                    <a href="/?deleteAddress=${selectedAddress.m_addressKey}" onclick="javascript:return confirm('Attention, cette action est irréversible. Continuer ?');" class="btn btn-default">Supprimer l'adresse</a>
                                </div>

                            </div>

                        </div>
                    </div>
                </c:if>


            </div>
            <!-- /#page-wrapper -->
        </div>
        <!-- /#wrapper -->

        <!-- jQuery Version 1.11.0 -->
        <script src="assets/js/lib/jquery-1.11.0.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="assets/js/lib/bootstrap.min.js"></script>

        <script type="text/javascript">
            jQuery(document).ready(function($) {
                $("#search").keyup(function(event) {
                    var value = $(this).val().toLowerCase();
                    $("#item-list .item").show();    


                    if(value!="") {
                        $("#item-list .item").each(function(index, val) {
                            str = $(this).html().toLowerCase();
                            if ( str.indexOf(value) < 0 ) 
                            {
                                $(this).hide();
                            }
                        });
                    }

                });
            });
        </script>

    </body>
</html>