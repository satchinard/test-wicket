package com.wicket.test;

import com.wicket.test.links.Liens;
import de.agilecoders.wicket.core.Bootstrap;
import de.agilecoders.wicket.core.settings.BootstrapSettings;
import org.apache.wicket.Page;
import org.apache.wicket.javascript.DefaultJavaScriptCompressor;
import org.apache.wicket.protocol.http.CsrfPreventionRequestCycleListener;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.apache.wicket.util.lang.Bytes;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class TestWicketApplication extends WebApplication
        implements ApplicationContextAware {

    @Autowired
    private ApplicationContext ctx;

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
        getMarkupSettings().setAutomaticLinking(false);
        getMarkupSettings().setCompressWhitespace(true);
        getMarkupSettings().setStripWicketTags(true);
        getRequestCycleListeners().add(new CsrfPreventionRequestCycleListener());

        getApplicationSettings().setUploadProgressUpdatesEnabled(true);
        getApplicationSettings().setDefaultMaximumUploadSize(Bytes.megabytes(5));

        getResourceSettings().setJavaScriptCompressor(new DefaultJavaScriptCompressor());
        getResourceSettings().setUseMinifiedResources(true);

        getComponentInstantiationListeners().add(new SpringComponentInjector(this, ctx, true));
        BootstrapSettings settings = new BootstrapSettings();
        Bootstrap.install(this, settings);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }

}
