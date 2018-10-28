/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


/**
 *
 * @author Mustapha
 */
@Entity
public class Ville {

    @Id
    @GeneratedValue

    private int id;
    private String nom;
    
    @OneToMany(mappedBy = "ville",fetch = FetchType.EAGER) 
    private List<Client> client;

    @ManyToOne
    private Pays pays;

    public Ville() {
    }

    public Ville(String nom, List<Client> client, Pays pays) {
        this.nom = nom;
        this.client = client;
        this.pays = pays;
    }

    

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
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

    public List<Client> getClient() {
        return client;
    }

    public void setClient(List<Client> client) {
        this.client = client;
    }
    

}
