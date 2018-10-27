/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.salah.classes;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author ZAHIRA
 */
@Entity
public class Certificat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    @ManyToMany
    private List<Professeur> professeurs;

    public Certificat() {
    }

    public Certificat(String nom, List<Professeur> professeurs) {
        this.nom = nom;
        this.professeurs = professeurs;
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

    public List<Professeur> getProfesseurs() {
        return professeurs;
    }

    public void setProfesseurs(List<Professeur> professeurs) {
        this.professeurs = professeurs;
    }

}
