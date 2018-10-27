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
public class Professeur_Cerfiticat {
    @EmbeddedId
    private ProfesseurCertificatPK id;
    @JoinColumn(name = "professeur_id",referencedColumnName = "id" ,updatable = false,insertable = false)
    @ManyToOne
    private Professeur professeur;
    @JoinColumn(name = "certificat_id",referencedColumnName = "id" ,updatable = false,insertable = false)
    @ManyToOne
    private Certificat certificat;

    public Professeur_Cerfiticat(ProfesseurCertificatPK id, Professeur professeur, Certificat certificat) {
        this.id = id;
        this.professeur = professeur;
        this.certificat = certificat;
    }

    public Professeur_Cerfiticat() {
    }
    
    public ProfesseurCertificatPK getId() {
        return id;
    }

    public void setId(ProfesseurCertificatPK id) {
        this.id = id;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }

    public Certificat getCertificat() {
        return certificat;
    }

    public void setCertificat(Certificat certificat) {
        this.certificat = certificat;
    }
    
    
}
