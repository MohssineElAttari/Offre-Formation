/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import classes.Professeur;
import services.ProfesseurService;
import services.SpecialiteService;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author salah
 */
@WebServlet(name = "AddProfesseur", urlPatterns = {"/AddProfesseur"})
public class AddProfesseur extends HttpServlet {

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
             ProfesseurService ps = new ProfesseurService();
             SpecialiteService ss = new SpecialiteService();
             
        try (PrintWriter out = response.getWriter()) {
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            String sexe = request.getParameter("sexe");
            String tel = request.getParameter("tel");
            String email = request.getParameter("email");
            int s = Integer.parseInt(request.getParameter("specialite"));
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
             Date dateE = null;
            try {
                dateE = format.parse(request.getParameter("dateE"));
             } catch (Exception ex) {
                 
                 Logger.getLogger(AddProfesseur.class.getName()).log(Level.SEVERE, null, ex);
             }
            
            if (!request.getParameter("idupdate").isEmpty()) {
                int id = Integer.parseInt(request.getParameter("idupdate"));
                Professeur p = ps.findById(id);
                p.setDateEmbouche(dateE);
                p.setEmail(email);
                p.setNom(nom);
                p.setPrenom(prenom);
                p.setTelephone(tel);
                p.setSexe(sexe);
                p.setSpecialite(ss.findById(s));
                ps.update(p);
                Gson gs = new Gson();
                out.write(gs.toJson(ps.getProfs()));
            }else{
                Professeur p = new Professeur();
                p.setDateEmbouche(dateE);
                p.setEmail(email);
                p.setNom(nom);
                p.setPrenom(prenom);
                p.setTelephone(tel);
                p.setSexe(sexe);
                p.setSpecialite(ss.findById(s));
                ps.create(p);
                Gson gs = new Gson();
                out.write(gs.toJson(ps.getProfs()));
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
