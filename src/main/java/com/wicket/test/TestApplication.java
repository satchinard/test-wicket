package com.wicket.test;

import com.wicket.test.inscription.InscriptionPage;
import de.agilecoders.wicket.core.Bootstrap;
import de.agilecoders.wicket.core.settings.BootstrapSettings;
import org.apache.wicket.Page;
import org.apache.wicket.javascript.DefaultJavaScriptCompressor;
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
//        return BootStrapPur.class;
//        return BasePage.class;
        return InscriptionPage.class;
    }

    @Override
    protected void init() {
        getMarkupSettings().setDefaultMarkupEncoding("utf-8");
        getMarkupSettings().setAutomaticLinking(false);
        getMarkupSettings().setCompressWhitespace(true);
        getMarkupSettings().setStripWicketTags(true);

        getApplicationSettings().setUploadProgressUpdatesEnabled(true);
        getApplicationSettings().setDefaultMaximumUploadSize(Bytes.megabytes(5));

        getResourceSettings().setJavaScriptCompressor(new DefaultJavaScriptCompressor());
        getResourceSettings().setUseMinifiedResources(true);

        getComponentInstantiationListeners().add(new SpringComponentInjector(this));
        BootstrapSettings settings = new BootstrapSettings();
        Bootstrap.install(this, settings);
    }

}
