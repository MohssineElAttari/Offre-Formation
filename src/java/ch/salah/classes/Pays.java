/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.salah.classes;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Mustapha
 */
@Entity
public class Pays {

    @Id
    @GeneratedValue

    private int id;
    private String nom;

    @OneToMany(mappedBy = "pays", fetch = FetchType.EAGER)
    private List<Ville> ville;

    public Pays() {
    }

    public Pays(String nom) {
        this.nom = nom;
    }

    public List<Ville> getVille() {
        return ville;
    }

    public void setVille(List<Ville> ville) {
        this.ville = ville;
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
}
