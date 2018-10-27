/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author salah
 */
@Entity
@NamedQuery(name="findBetweenDate",query="From Professeur Where dateEmbouche between :dateD and :dateF")
public class Professeur {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    private String telephone;
    private String email;
    @Temporal(TemporalType.DATE)
    private Date dateEmbouche;
    private String sexe;
    @ManyToOne
    private Specialite specialite;

    public Professeur(int id, String nom, String prenom, String telephone, String email, Date dateEmbouche, String sexe, Specialite specialite) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.email = email;
        this.dateEmbouche = dateEmbouche;
        this.sexe = sexe;
        this.specialite = specialite;
    }

    public Professeur() {
    }

    public int getId() {
        return id;
    }

    public Specialite getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateEmbouche() {
        return dateEmbouche;
    }

    public void setDateEmbouche(Date dateEmbouche) {
        this.dateEmbouche = dateEmbouche;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }
    
    
}
