<%-- 
    Document   : professeur
    Created on : 25 oct. 2018, 15:35:27
    Author     : salah
--%>
<%@page import="ch.salah.classes.Specialite" %>
<%@page import="ch.salah.classes.Professeur" %>
<%@page import="ch.salah.service.ProfesseurService" %>
<%@page import="ch.salah.service.SpecialiteService" %>
<%
    SpecialiteService ss = new SpecialiteService();
    ProfesseurService ps = new ProfesseurService();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="includes/header.jsp" %>
    </head>
    <body>
        <%@ include file="includes/sidebarmenu.jsp" %>
        <div id="page-wrapper">
            <div class="row col-md-12">
                <div class="col-lg-12">
                    <h1 class="page-header">Gestion des Professeur</h1>
                </div>
                <!-- /.col-lg-12 -->
                <legend style="margin-left: 2%">Ajouter un Professeur</legend> 
                <div class="row col-md-12">
                    <div class="form-group col-md-3">
                        <label>Nom :</label>
                        <input class="form-control" type="text" name="nom" id="nom"/>
                    </div>
                    <div class="form-group col-md-3">
                        <label>Prenom :</label>
                        <input class="form-control" type="text" name="prenom" id="prenom"/>
                    </div>
                    <div class="form-group col-md-3">
                        <label>Tel :</label>
                        <input class="form-control" type="text" name="tel" id="tel"/>
                    </div>
                    <div class="form-group col-md-3">
                        <label>Email :</label>
                        <input class="form-control" type="text" name="email" id="email"/>
                    </div>
                </div>
                <div class="row col-md-12">
                    <div class="form-group col-md-3">
                        <label>Specialite :</label>
                        <select class="form-control" id="specialite" name="specialite">
                            <option value="hidden" >Choisir Une Spécialite </option>
                            <% for (Specialite s : ss.findAll()) {%>
                            <option value="<%= s.getId()%>" ><%= s.getLibelle()%></option>
                            <% }%>
                        </select>
                    </div>
                    <div class="form-group col-md-3">
                        <label>Sexe :</label>
                        <select class="form-control" id="sexe" name="sexe">
                            <option value="hidden" >Choisir Genre </option>
                            <option value="H" >Homme</option>
                            <option value="F" >Femme</option>
                        </select>
                    </div>
                    <div class="form-group col-md-3">
                        <label>Date Embouche :</label>
                        <input class="form-control" type="date" name="dateEmbouche" id="dateEmbouche"/>
                    </div>
                </div>
                <div class="row col-md-12">
                    <div class="form-group col-md-3">
                        <button  value="Valider" id="save" onclick="addProfesseur()" class="btn btn-success">Ajouter</button>
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
                            Tableau des Employes
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <th>Nom</th>
                                            <th>Prenom</th>
                                            <th>Telephone</th>
                                            <th>Email</th>
                                            <th>Sexe</th>
                                            <th>Specialite</th>
                                            <th>Date Embouche</th>
                                            <th>Suprimer</th>
                                            <th>Modifier</th>
                                        </tr>
                                    </thead>
                                    <tbody id="mTable">
                                        <% for (Professeur p : ps.findAll()) {%>
                                        <tr>
                                            <td><%= p.getNom()%></td>
                                            <td><%= p.getPrenom()%></td>
                                            <td><%= p.getTelephone()%></td>
                                            <td><%= p.getEmail()%></td>
                                            <td><%= p.getSexe()%></td>
                                            <td><%= p.getSpecialite().getLibelle()%></td>
                                            <td><%= p.getDateEmbouche()%></td>
                                            <td><Button onclick="deleteProfesseur(<%=p.getId()%>)" class="btn btn-danger" >Supprimer</Button></td>
                                            <td><Button onclick="updateProfesseur(<%=p.getId()%>)" class="btn btn-info" id ="update">Modifier</Button></td>
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
        <%@ include file="includes/footer.jsp" %>

        <script src="CRUD_Script/prof_crud_script.js" type="text/javascript"></script>
    </body>
</html>
