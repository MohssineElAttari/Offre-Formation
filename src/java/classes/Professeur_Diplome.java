/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Sinponzakra
 */
@Entity
public class Professeur_Diplome {
    @EmbeddedId
    private ProfesseurDiplomePK id;
    @JoinColumn(name = "professeur_id",referencedColumnName = "id" ,updatable = false,insertable = false)
    @ManyToOne
    private Professeur professeur;
    @JoinColumn(name = "diplome_id",referencedColumnName = "id" ,updatable = false,insertable = false)
    @ManyToOne
    private Diplome diplome;

    public Professeur_Diplome() {
    }

    public Professeur_Diplome(ProfesseurDiplomePK id, Professeur professeur, Diplome diplome) {
        this.id = id;
        this.professeur = professeur;
        this.diplome = diplome;
    }

    public ProfesseurDiplomePK getId() {
        return id;
    }

    public void setId(ProfesseurDiplomePK id) {
        this.id = id;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }

    public Diplome getDiplome() {
        return diplome;
    }

    public void setDiplome(Diplome diplome) {
        this.diplome = diplome;
    }
    
    
}
