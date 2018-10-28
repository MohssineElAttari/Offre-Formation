<%-- 
    Document   : certificatCrud
    Created on : 27 oct. 2018, 17:12:50
    Author     : ZAHIRA
--%>

<%@page import="classes.Professeur" %>
<%@page import="services.ProfesseurService" %>
<%@page import="classes.Certificat" %>
<%@page import="services.CertificatService" %>


<%  
    ProfesseurService ps = new ProfesseurService();
    CertificatService cs = new CertificatService();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="../header.jsp" %>
    </head>
    <body>
         <%@ include file="../NavbarMenu.jsp" %>
         
         <div id="page-wrapper">
            <div class="row col-md-12">
                <div class="col-lg-12">
                    <h1 class="page-header">Gestion des certificats</h1>
                </div>
                <!-- /.col-lg-12 -->
                <legend style="margin-left: 2%">Ajouter une certificat</legend> 
                <div class="row col-md-12">
                    <div class="form-group col-md-3">
                        <label>Nom :</label>
                        <input class="form-control" type="text" name="nom" id="nom"/>
                    </div>                 
                </div> 
                
                <%-- <div class="row col-md-12">   
                    <div class="form-group col-md-3">
                        <label>Professeur :</label>
                        <select class="form-control" id="professeur" name="professeur">
                            <option value="hidden" >Choisir un professeur </option>
                            <% for (Professeur p : ps.findAll()) {%>
                            <option value="<%= p.getId()%>" ><%= p.getNom()%></option>
                            <% }%>
                        </select>
                    </div>
                 </div> --%>
                        
                <br>
                <div class="row col-md-12">
                    <div class="form-group col-md-3" style="margin-left: 45%">
                        <input type="button" value="Ajouter" id="saveFor" name="saveFor" onclick="addCertificat()" class="btn btn-success"/>
                    </div>
                </div>

                <br>
                <input type="hidden" id="idupdate" name="idupdate" value="" />



            </div>
            <!-- /#page-wrapper -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Liste des certificat
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <th>Nom</th>  
                                        </tr>
                                    </thead>
                                     <tbody id="fTable">
                                        <% for (Certificat c : cs.findAll()) {%>
                                        <tr>
                                            <td><%= c.getNom() %></td>
                                            <td><Button onclick="deleteCertificat(<%=c.getId()%>)" class="btn btn-danger" >Supprimer</Button></td>
                                            <td><Button onclick="updateCertificat(<%=c.getId() %>,'<%= c.getNom() %>')" class="btn btn-info" id ="update">Modifier</Button></td>
                                        </tr>
                                        <% }%>
                                    </tbody>

                                </table>
                            </div>
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
            </div>
        </div>
        <%@ include file="../footer.jsp" %>

        <script src="Script/certificatCrudScript.js" type="text/javascript"></script>
        <script src="Script/moment.js" type="text/javascript"></script>

    </body>
</html>
