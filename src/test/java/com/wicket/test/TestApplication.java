package com.wicket.test;

import com.wicket.test.links.Liens;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.protocol.http.mock.MockServletContext;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author cagecfi
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:WEB-INF/ApplicationContext.xml"})
public class TestApplication {

    private WicketTester tester;

    private WebApplication application;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        application = new TestWicketApplication();
        tester = new WicketTester(application, new MockServletContext(application, "/"));
    }

    @After
    public void tearDown() {
        tester.destroy();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void HomePageTest() {
        tester.assertRenderedPage(Liens.class);
        tester.clickLink("lien4");
    }
}
