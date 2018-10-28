<%-- 
    Document   : InscriptionFormation
    Created on : Oct 28, 2018, 3:11:53 PM
    Author     : mst
--%>
<%@page import="classes.Formation"%>
<%@page import="classes.Professeur"%>
<%@page import="services.FormationService"%>
<%@page import="services.ProfesseurService"%>
<% 
    FormationService fs = new FormationService();
    ProfesseurService ps = new ProfesseurService();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="../includes/header.jsp" %>
        <script src="Script/searchData.js" type="text/javascript"></script>
    </head>
    <body>
        <%@ include file="../includes/sidebarmenu.jsp" %>
        <div id="page-wrapper">
            <div class="row col-md-12">
                <div class="col-lg-12">
                    <h1 class="page-header">Gestion des Professeur</h1>
                </div>
                <!-- /.col-lg-12 -->
                <legend style="margin-left: 2%">Ajouter un Professeur</legend> 
                <div class="row col-md-12">
                    
                </div>
                <div class="row col-md-12">
                    <div class="form-group col-md-8">
                        <label>Formation :</label>
                        <select class="form-control" id="formations" name="formations">
                            <option value="heddin" >kkk</option>
                            <% 
                                for (Formation f : fs.findAll()) {
                            %>
                            <option value="<%=f.getId()%>" ><%=f.getNom()%></option>
                            <% } %>
                        </select>
                    </div>
                </div>
                <div class="row col-md-12">
                    <div class="form-group col-md-3" style="margin-left: 40%">
                        <input type="button" value="Ajouter" id="saveProf" name="saveProf" onclick="addProfesseur()" class="btn btn-success"/>
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
                            Tableau des Professeurs
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover">
                                    <thead>
                                        <tr> 
                                            <th>ID</th>
                                            <th>NOM</th>
                                            <th>DESCRIPTION</th>
                                            <th>PREREQUIS</th>
                                            <th>DATE DEBUT</th>
                                            <th>DATE FIN</th>
                                            <th>NBR BLACE</th>
                                            <th>LIEU</th>
                                        </tr>
                                    </thead>
                                    <tbody id="mTable">
                                        
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
        <script src="Script/searchData.js" type="text/javascript"></script>
        <%@ include file="../includes/footer.jsp" %>
        <script src="Script/moment.js" type="text/javascript"></script>
        <script src="Script/searchData.js" type="text/javascript"></script>
    </body>
</html>
