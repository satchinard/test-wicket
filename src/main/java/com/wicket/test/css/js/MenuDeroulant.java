package com.wicket.test.css.js;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.resource.PackageResourceReference;

/**
 *
 * @author cagecfi
 */
public class MenuDeroulant extends WebPage {

    public MenuDeroulant() {
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        response.render(CssHeaderItem.forReference(new PackageResourceReference(getClass(),
                "css/menu_deroulant.css")));
    }

}
