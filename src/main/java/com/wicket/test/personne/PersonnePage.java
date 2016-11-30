package com.wicket.test.personne;

import com.wicket.test.data.entite.Personne;
import com.wicket.test.data.service.IPersonneService;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

/**
 *
 * @author cagecfi
 */
public class PersonnePage extends WebPage {

    @SpringBean
    IPersonneService personneService;

    public PersonnePage() {
        add(new FeedbackPanel("feedback"));
        Form<Personne> pForm = new Form<Personne>("form") {

            @Override
            protected void onSubmit() {
                personneService.ajouter(this.getModelObject());
                info("Personne enregistrée avec succès.");
                setResponsePage(PersonnePage.class);
            }

        };
        pForm.setModel(new CompoundPropertyModel<Personne>(new Personne()));
        add(pForm);
        pForm.add(new TextField("nom").setRequired(true));
        pForm.add(new TextField("prenoms").setRequired(true));
    }

}
