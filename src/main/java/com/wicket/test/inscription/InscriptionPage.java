package com.wicket.test.inscription;

import com.wicket.test.data.service.IPersonneService;
import com.wicket.test.data.entite.Personne;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormChoiceComponentUpdatingBehavior;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.extensions.yui.calendar.DateField;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.ListMultipleChoice;
import org.apache.wicket.markup.html.form.Radio;
import org.apache.wicket.markup.html.form.RadioChoice;
import org.apache.wicket.markup.html.form.RadioGroup;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.AbstractItem;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.model.ResourceModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.validation.validator.RangeValidator;

/**
 *
 * @author cagecfi
 */
public class InscriptionPage extends WebPage {

    private final List<String> lesCursus = Arrays.asList("CEPD", "BEPC", "BAC", "Licence");
    private final List<String> sexes = Arrays.asList("Masculin", "Feminin");
    private final List<String> nationalites = Arrays.asList("Togolaise", "Béninoise", "Ghanéenne");
    private final List<String> statuts = Arrays.asList("Divorcé(e)", "Veuf(ve)",
            "Célibataire", "Marié(e)");
    private final List<Locale> langues = Arrays.asList(Locale.FRENCH, Locale.ENGLISH);

    private final Form<Inscription> formInscript;

    private Locale langue;
    private List<Inscription> lesInscriptions = new LinkedList<Inscription>();

    @SpringBean
    private IPersonneService personneService;

    public InscriptionPage() {

//        add(new Label("dateJour",
//                Instant.now()));
        add(new Label("dateJour",
                Calendar.getInstance(getSession().getLocale()).get(Calendar.DATE)
                + " " + Calendar.getInstance(getSession().getLocale()).get(Calendar.LONG_FORMAT)
                + " " + Calendar.getInstance(getSession().getLocale()).get(Calendar.YEAR)));
        getSession().setLocale(Locale.ENGLISH);

        ChoiceRenderer<Locale> crL = new ChoiceRenderer<Locale>() {

            @Override
            public Object getDisplayValue(Locale object) {
                if (object.getLanguage().equals("fr")) {
                    return "Français";
                }
                return "Anglais";
            }

        };
        add(new DropDownChoice<Locale>("langue", new PropertyModel<Locale>(this, "langue"),
                langues, crL) {

                    @Override
                    protected void onSelectionChanged(Locale newSelection) {
                        getSession().setLocale(newSelection);
                    }

                    @Override
                    protected boolean wantOnSelectionChangedNotifications() {
                        return true;
                    }

                });

        add(new FeedbackPanel("erreurs"));

        formInscript = new Form<Inscription>("monForm") {

            @Override
            protected void onSubmit() {
                lesInscriptions.add(this.getModelObject());
                personneService.ajouter(new Personne(this.getModelObject().getNom(),
                        this.getModelObject().getPrenom()));
                this.setModelObject(new Inscription());
            }

        };
        formInscript.setModel(new CompoundPropertyModel<Inscription>(new Inscription()));
        add(formInscript);

        final TextField nomTxt = new TextField("nom");
        formInscript.add(nomTxt.setRequired(true)
                .add(new AjaxFormComponentUpdatingBehavior("onblur") {

                    @Override
                    protected void onUpdate(AjaxRequestTarget target) {
                        formInscript.getModelObject().setNom(((String) nomTxt.getModelObject()).toUpperCase());
                        target.add(nomTxt);
                    }
                }));
        formInscript.add(new TextField("prenom").setRequired(true));
        formInscript.add(new DateField("dateNaissance").setRequired(true)
                .setLabel(new ResourceModel("dateNaissance")));
        formInscript.add(new TextField("lieuNaissance"));

        formInscript.add(new ListMultipleChoice("cursus", lesCursus));
        formInscript.add(new DropDownChoice("sexe", sexes).setRequired(true));

        formInscript.add(new DropDownChoice("nationalite", nationalites));

        final WebMarkupContainer wmc = new WebMarkupContainer("nbAnnee");
        wmc.setOutputMarkupId(true);
        formInscript.add(wmc.setVisible(false));

        RadioGroup scolarite = new RadioGroup("alphabetise");
        scolarite.add(new Radio("non", Model.of(false)).setLabel(Model.of("Non")));
        scolarite.add(new Radio("oui", Model.of(true)).setLabel(Model.of("Oui")));
        formInscript.add(scolarite.setRequired(true).setOutputMarkupId(true));

        scolarite.add(new AjaxFormChoiceComponentUpdatingBehavior() {

            @Override
            protected void onUpdate(AjaxRequestTarget target) {
                wmc.setVisible(true);
                target.add(wmc);
            }
        });

        wmc.add(new TextField("nbAnneeEtude").setOutputMarkupId(true)
                .add(new RangeValidator(6, 15)));

        formInscript.add(new RadioChoice("statut", statuts));

        WebMarkupContainer wmcInscrits = new WebMarkupContainer("inscriptions");
        wmcInscrits.add(getLesInscrits());
        add(wmcInscrits);
        WebMarkupContainer wmcDVInscrits = new WebMarkupContainer("dataInscrits");
        wmcDVInscrits.add(getDataView());
        add(wmcDVInscrits);

    }

    public Locale getLangue() {
        return langue;
    }

    public void setLangue(Locale langue) {
        this.langue = langue;
    }

    public List<Inscription> getLesInscriptions() {
        return lesInscriptions;
    }

    public void setLesInscriptions(List<Inscription> lesInscriptions) {
        this.lesInscriptions = lesInscriptions;
    }

    private ListView<Inscription> getLesInscrits() {
        ListView<Inscription> inscrits = new ListView<Inscription>("inscrits", new PropertyModel<List<Inscription>>(this, "lesInscriptions")) {

            @Override
            protected void populateItem(ListItem<Inscription> item) {
                final Inscription i = item.getModelObject();
                item.add(new Label("nom", new PropertyModel(i, "nom")));
                item.add(new Label("prenom", new PropertyModel(i, "prenom")));
                item.add(new Label("dateNaissance", new PropertyModel(i, "dateNaissance")));
                item.add(new Label("statut", new PropertyModel(i, "statut")));
                item.add(new Label("alphabetise", new PropertyModel(i, "alphabetise")));
                item.add(new Label("nbAnneeEtude", new PropertyModel(i, "nbAnneeEtude")));
                item.add(new Link("supprimer") {

                    @Override
                    public void onClick() {
                        getLesInscriptions().remove(i);
                    }
                });
                item.add(new Link("modifier") {

                    @Override
                    public void onClick() {
                        formInscript.setModelObject(i);
                        getLesInscriptions().remove(i);
                    }
                });
            }
        };
        inscrits.setReuseItems(true);
        inscrits.setOutputMarkupId(true);
        return inscrits;
    }

    private DataView<Inscription> getDataView() {
        InscriptionProvider is = new InscriptionProvider(lesInscriptions);
        DataView<Inscription> dataInscript = new DataView<Inscription>("inscrits", is, 2) {

            @Override
            protected void populateItem(Item<Inscription> item) {
                RepeatingView rv = new RepeatingView("inscrit");
                AbstractItem ai = new AbstractItem(rv.newChildId());
                rv.add(ai);
                final Inscription i = item.getModelObject();
                item.add(new Label("nom", new PropertyModel(i, "nom")));
                item.add(new Label("prenom", new PropertyModel(i, "prenom")));
                item.add(new Label("dateNaissance", new PropertyModel(i, "dateNaissance")));
                item.add(new Label("statut", new PropertyModel(i, "statut")));
                item.add(new Label("alphabetise", new PropertyModel(i, "alphabetise")));
                item.add(new Label("nbAnneeEtude", new PropertyModel(i, "nbAnneeEtude")));
                item.add(new Link("supprimer") {

                    @Override
                    public void onClick() {
                        getLesInscriptions().remove(i);
                    }
                });
                item.add(new Link("modifier") {

                    @Override
                    public void onClick() {
                        formInscript.setModelObject(i);
                        getLesInscriptions().remove(i);
                    }
                });
            }
        };
        dataInscript.setOutputMarkupId(true);
        return dataInscript;
    }

}

class InscriptionProvider implements IDataProvider<Inscription> {

    public List<Inscription> lesInscrits;

    public InscriptionProvider(List<Inscription> lesInscrits) {
        this.lesInscrits = lesInscrits;
    }

    public Iterator<? extends Inscription> iterator(long arg0, long arg1) {
        return lesInscrits.subList((int) arg0, (int) arg1).iterator();
    }

    public long size() {
        return lesInscrits.size();
    }

    public IModel<Inscription> model(Inscription object) {
        return Model.of(object);
    }

    public void detach() {

    }

}
