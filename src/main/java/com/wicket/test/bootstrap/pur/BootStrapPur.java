package com.wicket.test.bootstrap.pur;

import com.google.common.collect.Lists;
import de.agilecoders.wicket.core.markup.html.bootstrap.form.BootstrapCheckbox;
import de.agilecoders.wicket.core.markup.html.bootstrap.form.BootstrapForm;
import de.agilecoders.wicket.core.markup.html.bootstrap.form.BootstrapRadioChoice;
import de.agilecoders.wicket.core.markup.html.bootstrap.heading.Heading;
import de.agilecoders.wicket.core.markup.html.bootstrap.heading.HeadingBehavior;
import de.agilecoders.wicket.core.markup.html.bootstrap.html.MetaTag;
import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.Navbar;
import de.agilecoders.wicket.extensions.markup.html.bootstrap.form.DateTextField;
import de.agilecoders.wicket.extensions.markup.html.bootstrap.form.select.BootstrapSelect;
import java.util.Arrays;
import java.util.Date;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 *
 * @author cagecfi
 */
public class BootStrapPur extends WebPage {

    private Date date;
    private Form<Void> form;
    private Button submit;
    private DateTextField dateField;
    private PropertyModel<Date> dateModel;

    public BootStrapPur() {
        add(new MetaTag("charset", Model.of("charset"), Model.of("utf-8")));
        add(new MetaTag("viewport", Model.of("viewport"), Model.of("width=device-width, initial-scale=1.0")));
        add(new MetaTag("description", Model.of("description"), Model.of("Apache Wicket & Twitter Bootstrap Test")));
        add(new MetaTag("author", Model.of("author"), Model.of("Ada ATCHINARD <adaro2000@cagecfi.com>")));

        Navbar navbar = new Navbar("navbarId");

        navbar.setBrandName(Model.of("TestWicket"));
        navbar.setPosition(Navbar.Position.DEFAULT);
        navbar.fluid();

        add(navbar);

        Heading entete = new Heading("entete", Model.of("Inscription"));
        entete.add(new HeadingBehavior());

        add(entete);

        Form<Void> form = new BootstrapForm<>("forms");
        add(form);

        form.add(new BootstrapCheckbox("checkbox", null, Model.of("Checkbox demo")));
        form.add(new BootstrapRadioChoice<>("radio", Lists.newArrayList("Radio One", "Radio Two")));
        form.add(new BootstrapSelect("list", Arrays.asList("Wicket", "Bootstrap")));

        add(form);

        createModels();
        createComponents();
        addComponents();

//        add(new BootstrapButton("submit", Buttons.Type.Info).setLabel(new ResourceModel("valider", "Valider")));
    }

    public BootStrapPur(PageParameters parameters) {
        super(parameters);
        createModels();
        createComponents();
        addComponents();
    }

    private void addComponents() {
        form.add(dateField);
        form.add(submit);
        add(form);
    }

    private void createModels() {
        dateModel = new PropertyModel<>(this, "date");
    }

    private void createComponents() {
        form = new Form<Void>("form") {
            @Override
            protected void onSubmit() {
                printOutDate();
            }
        };

        dateField = new DateTextField("dateField", dateModel); // , new PatternDateConverter("dd/MM/YYYY", true)

        submit = new Button("submit");
        form.setDefaultButton(submit);
    }

    private void printOutDate() {
        System.out.println("Selected date: " + date);
    }

    // GETTER & SETTER
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
