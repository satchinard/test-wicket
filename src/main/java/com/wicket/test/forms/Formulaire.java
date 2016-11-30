package com.wicket.test.forms;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.apache.wicket.extensions.yui.calendar.DateField;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.ListMultipleChoice;
import org.apache.wicket.markup.html.form.Radio;
import org.apache.wicket.markup.html.form.RadioChoice;
import org.apache.wicket.markup.html.form.RadioGroup;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

/**
 *
 * @author cagecfi
 */
public class Formulaire extends WebPage {

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

    private final List<String> lesCursus = Arrays.asList("CEPD", "BEPC", "BAC", "Licence");
    private final List<String> sexes = Arrays.asList("Masculin", "Feminin");
    private final List<String> nationalites = Arrays.asList("Togolaise", "Béninoise", "Ghanéenne");
    private final List<String> statuts = Arrays.asList("Divorcé(e)", "Veuf(ve)",
            "Célibataire", "Marié(e)");

    public Formulaire() {

        add(new TextField("nom", new PropertyModel(this, "nom")));
        add(new TextField("prenom", new PropertyModel(this, "prenom")));
        add(new DateField("dateNaissance", new PropertyModel<Date>(this, "dateNaissance")));
        add(new TextField("lieuNaissance", new PropertyModel(this, "lieuNaissance")));

        add(new ListMultipleChoice("cursus", new PropertyModel<List<String>>(this, "cursus"), lesCursus));
        add(new DropDownChoice("sexe", new PropertyModel(this, "sexe"), sexes));

        add(new DropDownChoice("nationalite", new PropertyModel(this, "nationalite"), nationalites));

        RadioGroup scolarite = new RadioGroup("scolarite", new PropertyModel<Boolean>(this, "alphabetise"));
        scolarite.add(new Radio("non", Model.of(false)).setLabel(Model.of("Non")));
        scolarite.add(new Radio("oui", Model.of(true)).setLabel(Model.of("Oui")));
        add(scolarite);

        WebMarkupContainer wmc = new WebMarkupContainer("nbAnnee");
        wmc.add(new TextField("nbAnneeEtude", new PropertyModel(this, "nbAnneeEtude"), Integer.class));
        add(wmc);

        add(new RadioChoice("statut", new PropertyModel(this, "statut"), statuts));

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
