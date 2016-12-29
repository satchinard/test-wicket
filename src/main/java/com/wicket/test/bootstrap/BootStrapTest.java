package com.wicket.test.bootstrap;

import com.wicket.test.web.TestWebResources;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.resource.PackageResourceReference;

/**
 *
 * @author cagecfi
 */
public class BootStrapTest extends WebPage {

    public BootStrapTest() {
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        response.render(CssHeaderItem.forReference(new PackageResourceReference(TestWebResources.class,
                "/bootstrap/css/bootstrap.min.css")));
        response.render(CssHeaderItem.forReference(new PackageResourceReference(TestWebResources.class,
                "/bootstrap/css/bootstrap-theme.min.css")));
        response.render(JavaScriptHeaderItem.forReference(new PackageResourceReference(TestWebResources.class,
                "/jquery/jquery-3.1.1.min.js")));
        response.render(JavaScriptHeaderItem.forReference(new PackageResourceReference(TestWebResources.class,
                "/bootstrap/js/bootstrap.min.js")));
    }
}
