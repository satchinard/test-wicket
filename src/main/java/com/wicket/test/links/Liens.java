package com.wicket.test.links;

import com.wicket.test.HomePage;
import com.wicket.test.bootstrap.pur.BootStrapPur;
import com.wicket.test.css.js.MenuDeroulant;
import com.wicket.test.forms.Formulaire;
import com.wicket.test.inscription.InscriptionPage;
import com.wicket.test.personne.PersonnePage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.DownloadLink;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.link.PopupSettings;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 *
 * @author cagecfi
 */
public class Liens extends WebPage {

    private int clickLinkCount;

    public Liens() {
        add(new FeedbackPanel("feedback"));
        add(new Link("lien1") {

            @Override
            public void onClick() {
                info("Bonjour. Vous venez de me cliquer !");
            }
        });

        add(new BookmarkablePageLink("lien2", HomePage.class));

        PageParameters params = new PageParameters();
        params.add("nom", "ANANI Koumah");
        add(new BookmarkablePageLink("lien3", HomePage.class, params));

        add(new ExternalLink("lien4", "http://www.google.tg", "Google.tg"));

        PopupSettings popUp = new PopupSettings(PopupSettings.STATUS_BAR);
        popUp.setWidth(200).setHeight(200);

        add(new ExternalLink("lien5", "http://jw.org", "JW.ORG")
                .setPopupSettings(popUp));

        add(new DownloadLink("lien6", new AbstractReadOnlyModel<File>() {

            @Override
            public File getObject() {
                File f = new File("hello.txt");
                PrintWriter pw = null;
                try {
                    pw = new PrintWriter(f);
                }
                catch (FileNotFoundException ex) {
                    Logger.getLogger(Liens.class.getName()).log(Level.SEVERE, null, ex);
                }
                pw.write("Bonjour le monde !");
                pw.flush();
                pw.close();
                return f;
            }
        }));

        add(new Link("lien7") {

            @Override
            public void onClick() {
                clickLinkCount++;
            }
        }
                .add(new Label("nbClicks", new PropertyModel(this, "clickLinkCount"))));

        add(new BookmarkablePageLink("lien8", HomePage.class, null));
        add(new BookmarkablePageLink("lien9", InscriptionPage.class, null));
        add(new BookmarkablePageLink("lien10", BootStrapPur.class));
        add(new BookmarkablePageLink("lien11", MenuDeroulant.class));
        add(new BookmarkablePageLink("lien12", Formulaire.class));
        add(new BookmarkablePageLink("lien13", PersonnePage.class));
    }

    public int getClickLinkCount() {
        return clickLinkCount;
    }

    public void setClickLinkCount(int clickLinkCount) {
        this.clickLinkCount = clickLinkCount;
    }

}
