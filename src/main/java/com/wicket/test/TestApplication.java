package com.wicket.test;

import com.wicket.test.personne.PersonnePage;
import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.apache.wicket.util.lang.Bytes;

public class TestApplication extends WebApplication {

    /**
     *
     * @return
     */
    @Override
    public Class<? extends Page> getHomePage() {
        return PersonnePage.class;
    }

    @Override
    protected void init() {
        getMarkupSettings().setDefaultMarkupEncoding("utf-8");
        getMarkupSettings().setAutomaticLinking(false);
        getMarkupSettings().setCompressWhitespace(true);
        getMarkupSettings().setStripWicketTags(true);

        getApplicationSettings().setUploadProgressUpdatesEnabled(true);
        getApplicationSettings().setDefaultMaximumUploadSize(Bytes.megabytes(5));

        getComponentInstantiationListeners().add(new SpringComponentInjector(this));
    }

}
