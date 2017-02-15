package com.wicket.test.data.entite;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author cagecfi
 */
@Entity
@Table(name = "INSCRIPTION")
//@SequenceGenerator(name = "INSCRIPTIONS_SEQ_GEN")
public class Inscription implements Serializable {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO, generator = "INSCRIPTIONS_GEN")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NOM")
    private String nom;
    @Column(name = "PRENOM")
    private String prenom;
    @Column(name = "DATE_NAISS")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateNaissance;
    @Column(name = "LIEU_NAISS")
    private String lieuNaissance;
    @Column(name = "DERNIER_DIPLOME")
    private String dernierDiplome;
    @Column(name = "SEXE")
    private String sexe;
    @Column(name = "NATIONALTE")
    private String nationalite;
    @Column(name = "ALPHABETISE")
    private boolean alphabetise;
    @Column(name = "NB_ANNEE_ETUDE")
    private Integer nbAnneeEtude;
    @Column(name = "STATUT")
    private String statut;

    public Inscription() {
    }

    public Inscription(String nom, String prenom, Date dateNaissance,
            String lieuNaissance, String sexe) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.sexe = sexe;
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

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public String getDernierDiplome() {
        return dernierDiplome;
    }

    public void setDernierDiplome(String dernierDiplome) {
        this.dernierDiplome = dernierDiplome;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public boolean isAlphabetise() {
        return alphabetise;
    }

    public void setAlphabetise(boolean alphabetise) {
        this.alphabetise = alphabetise;
    }

    public Integer getNbAnneeEtude() {
        return nbAnneeEtude;
    }

    public void setNbAnneeEtude(Integer nbAnneeEtude) {
        this.nbAnneeEtude = nbAnneeEtude;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "Inscription{" + "id=" + id + ", nom=" + nom
                + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance
                + ", lieuNaissance=" + lieuNaissance + ", dernierDiplome=" + dernierDiplome
                + ", sexe=" + sexe + ", nationalite=" + nationalite
                + ", alphabetise=" + alphabetise
                + ", nbAnneeEtude=" + nbAnneeEtude + ", statut=" + statut + '}';
    }

}
