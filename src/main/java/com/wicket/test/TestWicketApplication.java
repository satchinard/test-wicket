package com.wicket.test;

import com.wicket.test.links.Liens;
import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

public class TestWicketApplication extends WebApplication {

    /**
     *
     * @return
     */
    @Override
    public Class<? extends Page> getHomePage() {
        return Liens.class;
    }

    @Override
    protected void init() {
        getMarkupSettings().setDefaultMarkupEncoding("utf-8");
//        getMarkupSettings().setAutomaticLinking(false);
//        getMarkupSettings().setCompressWhitespace(true);
//        getMarkupSettings().setStripWicketTags(true);
//        getRequestCycleListeners().add(new CsrfPreventionRequestCycleListener());
//
//        getApplicationSettings().setUploadProgressUpdatesEnabled(true);
//        getApplicationSettings().setDefaultMaximumUploadSize(Bytes.megabytes(5));
//
//        getResourceSettings().setJavaScriptCompressor(new DefaultJavaScriptCompressor());
//        getResourceSettings().setUseMinifiedResources(true);
//
//        getComponentInstantiationListeners().add(new SpringComponentInjector(this));
//        BootstrapSettings settings = new BootstrapSettings();
//        Bootstrap.install(this, settings);
    }

}
