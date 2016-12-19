package com.wicket.test.base;

import com.wicket.test.web.TestWebResources;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.resource.PackageResourceReference;

/**
 *
 * @author cagecfi
 */
public class BasePage extends WebPage {

    public BasePage() {
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        response.render(CssHeaderItem.forReference(new PackageResourceReference(TestWebResources.class,
                "bootstrap-3.3.7.css/bootstrap.min.css")));
        response.render(CssHeaderItem.forReference(new PackageResourceReference(TestWebResources.class,
                "bootstrap-3.3.7.css/bootstrap-theme.min.css")));
    }

}
