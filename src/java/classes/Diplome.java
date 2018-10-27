/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author AbderrahmanGu3
 */
@Entity
public class Diplome {
    
    @Id
    @GeneratedValue
    private int id;
    private String type;
    private String nom;
    
    public Diplome() {
    }

    public Diplome(String type, String nom) {
        this.type = type;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    
    
}
