/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;




/**
 *
 * @author dell
 */
@Entity
public class Formation {
    @Id
    @GeneratedValue
    private int id;
    private String nom;
    private String descr;
    private String prerequis;
    private Date dateDebut;
    private Date dateFin;
    private int nbrplace;
    private String lieu;
    
    @ManyToOne
    private Professeur professeur;
    
    @ManyToOne
    private Type type;

    public Formation() {
    }

    public Formation(String nom, String descr, String prerequis, Date dateDebut, Date dateFin, int nbrplace, String lieu, Professeur professeur, Type type) {
        this.nom = nom;
        this.descr = descr;
        this.prerequis = prerequis;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nbrplace = nbrplace;
        this.lieu = lieu;
        this.professeur = professeur;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getPrerequis() {
        return prerequis;
    }

    public void setPrerequis(String prerequis) {
        this.prerequis = prerequis;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public int getNbrplace() {
        return nbrplace;
    }

    public void setNbrplace(int nbrplace) {
        this.nbrplace = nbrplace;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
    
    
}
