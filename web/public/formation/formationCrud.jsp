<%-- 
    Document   : professeur
    Created on : 25 oct. 2018, 15:35:27
    Author     : salah
--%>
<%@page import="services.TypeService"%>
<%@page import="services.FormationService"%>
<%@page import="classes.Formation" %>
<%@page import="classes.Professeur" %>
<%@page import="classes.Type" %>
<%@page import="services.ProfesseurService" %>
<%
    FormationService fs = new FormationService();
    ProfesseurService ps = new ProfesseurService();
    TypeService ts = new TypeService();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="../includes/header.jsp" %>
    </head>
    <body>
        <%@ include file="../includes/sidebarmenu.jsp" %>
        <div id="page-wrapper">
            <div class="row col-md-12">
                <div class="col-lg-12">
                    <h1 class="page-header">Gestion des formations</h1>
                </div>
                <!-- /.col-lg-12 -->
                <legend style="margin-left: 2%">Ajouter une formation</legend> 
                <div class="row col-md-12">
                    <div class="form-group col-md-3">
                        <label>Nom :</label>
                        <input class="form-control" type="text" name="nom" id="nom"/>
                    </div>
                    <div class="form-group col-md-3">
                        <label>Description :</label>
                        <input class="form-control" type="text" name="descr" id="descr"/>
                    </div>

                    <div class="form-group col-md-3">
                        <label>Prerequis :</label>
                        <input class="form-control" type="text" name="prerequis" id="prerequis"/>
                    </div>
                    <div class="form-group col-md-3">
                        <label>Date debut :</label>
                        <input class="form-control" type="date" name="dateDebut" id="dateDebut"/>
                    </div>

                </div>
                <div class="row col-md-12"> 
                    <div class="form-group col-md-3">
                        <label>Date fin :</label>
                        <input class="form-control" type="date" name="dateFin" id="dateFin"/>
                    </div>
                    <div class="form-group col-md-3">
                        <label>Nombre de places :</label>
                        <input class="form-control" type="text" name="nbrplace" id="nbrplace"/>
                    </div>
                    <div class="form-group col-md-3">
                        <label>Lieu :</label>
                        <input class="form-control" type="text" name="lieu" id="lieu"/>
                    </div>  
                    <div class="form-group col-md-3">
                        <label>Professeur :</label>
                        <select class="form-control" id="professeur" name="professeur">
                            <option value="hidden" >Choisir un professeur </option>
                            <% for (Professeur p : ps.findAll()) {%>
                            <option value="<%= p.getId()%>" ><%= p.getNom()%></option>
                            <% }%>
                        </select>
                    </div>
                </div>
                <div class="form-group col-md-3">
                    <label>Type :</label>
                    <select class="form-control" id="type" name="type">
                        <option value="hidden" >Choisir un type </option>
                        <% for (Type t : ts.findAll()) {%>
                        <option value="<%= t.getId()%>" ><%= t.getNom()%></option>
                        <% }%>
                    </select>
                </div>
                <br>
                <div class="row col-md-12">
                    <div class="form-group col-md-3" style="margin-left: 45%">
                        <input type="button" value="Ajouter" id="saveFor" name="saveFor" onclick="addFormation()" class="btn btn-success"/>
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
                            Liste de formations
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <th>Nom</th>
                                            <th>Description</th>
                                            <th>Prerequis</th>
                                            <th>Date debut</th>
                                            <th>Date fin</th>
                                            <th>Nombre de places</th>
                                            <th>Lieu</th>
                                            <th>Professeur</th>
                                            <th>Type</th>
                                            <th>Suprimer</th>
                                            <th>Modifier</th>
                                        </tr>
                                    </thead>
                                     <tbody id="fTable">
                                        <% for (Formation f : fs.findAll()) {%>
                                        <tr>
                                            <td><%= f.getNom() %></td>
                                            <td><%= f.getDescr() %></td>
                                            <td><%= f.getPrerequis() %></td>
                                            <td><%= f.getDateDebut() %></td>
                                            <td><%= f.getDateFin() %></td>
                                            <td><%= f.getNbrplace() %></td>
                                            <td><%= f.getLieu()%></td>
                                            <td><%= f.getProfesseur().getNom() %></td>                                          
                                            <td><%= f.getType().getNom() %></td>
                                            <td><Button onclick="deleteFormation(<%=f.getId()%>)" class="btn btn-danger" >Supprimer</Button></td>
                                            <td><Button onclick="updateFormation(<%=f.getId() %>,'<%= f.getNom() %>','<%= f.getDescr() %>','<%= f.getPrerequis() %>','<%= f.getDateDebut() %>','<%= f.getDateFin() %>','<%= f.getDateDebut() %>','<%= f.getNbrplace() %>','<%= f.getLieu() %>','<%= f.getProfesseur().getNom() %>','<%= f.getType().getNom() %>')" class="btn btn-info" id ="update">Modifier</Button></td>
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
        <%@ include file="../includes/footer.jsp" %>

        <script src="Script/formationCrudScript.js" type="text/javascript"></script>
        <script src="Script/moment.js" type="text/javascript"></script>
    </body>
</html>