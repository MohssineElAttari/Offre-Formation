/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import classes.Formation;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.FormationService;
import services.ProfesseurService;
import services.TypeService;

/**
 *
 * @author dell
 */
@WebServlet(name = "AddFormation", urlPatterns = {"/AddFormation"})
public class AddFormation extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json;charset=UTF-8");
        FormationService fs = new FormationService();
        ProfesseurService ps = new ProfesseurService();
        TypeService ts = new TypeService();
        try (PrintWriter out = response.getWriter()) {
            String nom = request.getParameter("nom");
            String desc = request.getParameter("desc");
            String prerequis = request.getParameter("prerequis");

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date dated = null;
            Date datef = null;
            try { 
                datef = format.parse(request.getParameter("dateFin"));
                dated = format.parse(request.getParameter("dateDebut"));
            } catch (Exception ex) {
                Logger.getLogger(AddProfesseur.class.getName()).log(Level.SEVERE, null, ex);
            }

            int nbrplace = Integer.parseInt(request.getParameter("nbrplace"));
            String lieu = request.getParameter("lieu");
            int p = Integer.parseInt(request.getParameter("professeur"));
            int t = Integer.parseInt(request.getParameter("type"));

            if (!request.getParameter("idupdate").isEmpty()) {
                int id = Integer.parseInt(request.getParameter("idupdate"));
                Formation f = fs.findById(id);
                f.setDateDebut(dated);
                f.setDateFin(datef);
                f.setDesc(desc);
                f.setLieu(lieu);
                f.setNbrplace(nbrplace);
                f.setNom(nom);
                f.setPrerequis(prerequis);
                f.setProfesseur(ps.findById(p));
                f.setType(ts.findById(t));
                fs.update(f);
                Gson gs = new Gson();
                out.write(gs.toJson(fs.getFormations()));
            } else {
                Formation f = new Formation();
                f.setDateDebut(dated);
                f.setDateFin(datef);
                f.setDesc(desc);
                f.setLieu(lieu);
                f.setNbrplace(nbrplace);
                f.setNom(nom);
                f.setPrerequis(prerequis);
                f.setProfesseur(ps.findById(p));
                f.setType(ts.findById(t));
                fs.create(f);
                Gson gs = new Gson();
                out.write(gs.toJson(fs.getFormations()));
            }
        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
