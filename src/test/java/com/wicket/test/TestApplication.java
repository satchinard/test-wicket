package com.wicket.test;

import com.wicket.test.inscription.InscriptionPage;
import com.wicket.test.links.Liens;
import org.apache.wicket.util.tester.FormTester;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author cagecfi
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:ApplicationContext.xml"})
public class TestApplication {

    private WicketTester tester;

    @Autowired
    private TestWicketApplication application;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        tester = new WicketTester(application);
    }

    @After
    public void tearDown() {
        tester.destroy();
    }

    @Test
    public void HomePageTest() {
        tester.startPage(Liens.class);
        tester.assertRenderedPage(Liens.class);
        tester.clickLink("lien9");
        tester.assertRenderedPage(InscriptionPage.class);
        FormTester form = tester.newFormTester("monForm", false);
        tester.isRequired("monForm:nom");
        form.submit();
        tester.assertNoInfoMessage();
    }
}
