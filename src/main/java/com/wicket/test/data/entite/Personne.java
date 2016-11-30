package com.wicket.test.data.entite;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author cagecfi
 */
@Entity
@Table(name = "PERSONNE")
public class Personne implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "NOM")
    private String nom;
    @Column(name = "PRENOMS")
    private String prenoms;

    public Personne() {
    }

    public Personne(String nom, String prenoms) {
        this.nom = nom;
        this.prenoms = prenoms;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenoms() {
        return prenoms;
    }

    public void setPrenoms(String prenoms) {
        this.prenoms = prenoms;
    }

    @Override
    public String toString() {
        return "Personne {id = " + id + "; nom = " + nom + "; prenoms = " + prenoms + "}";
    }

}
