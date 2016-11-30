package com.wicket.test;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class HomePage extends WebPage {

    public HomePage() {
        add(new Label("label", "Bonjour le monde !"));
    }

    public HomePage(PageParameters params) {
        if (params != null && !params.get("nom").isEmpty()) {
            add(new Label("label", "Bonjour mon cher ami " + params.get("nom")));
        } else {
            add(new Label("label", "Bonjour mon cher Super INCONNU "));
        }
    }
}
