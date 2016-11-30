package com.wicket.test.inscription;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author cagecfi
 */
public class Inscription implements Serializable {

    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String lieuNaissance;
    private List<String> cursus;
    private String sexe;
    private String nationalite;
    private boolean alphabetise;
    private Integer nbAnneeEtude;
    private String statut;

    public Inscription() {
    }

    public Inscription(String nom, String prenom, Date dateNaissance, String lieuNaissance, String sexe) {
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

    public List<String> getCursus() {
        return cursus;
    }

    public void setCursus(List<String> cursus) {
        this.cursus = cursus;
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

}
