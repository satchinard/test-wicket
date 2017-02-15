package com.wicket.test;

import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.apache.wicket.spring.test.ApplicationContextMock;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;

/**
 *
 * @author cagecfi
 */
public abstract class AbstractWicketTest {

    protected static final String BEAN_NAME_MESSAGE_SERVICE = "messageService";

    private ApplicationContextMock applicationContextMock;

    private WicketTester tester = null;

    @Before
    public void setUp() throws Exception {
        //Creates a new application context mock.
        applicationContextMock = new ApplicationContextMock();

        //Creates a new WicketTester
        tester = new WicketTester();
        //Configures the SpringBean annotation support to use the mock application context.
        //This ensures that the mock objects are injected instead of the actual bean classes.
        tester.getApplication().getComponentInstantiationListeners()
                .add(new SpringComponentInjector(tester.getApplication(),
                                applicationContextMock));
        setupTest();
    }

    /**
     * Subclasses can use this method to provide the configuration needed by
     * each test.
     */
    protected abstract void setupTest();

    /**
     * Adds mock to the mock application context.
     *
     * @param beanName The name of the mock bean.
     * @param mock The mock object.
     */
    protected void addMock(String beanName, Object mock) {
        applicationContextMock.putBean(beanName, mock);
    }

    protected ApplicationContextMock getApplicationContextMock() {
        return applicationContextMock;
    }

    protected WicketTester getTester() {
        return tester;
    }
}
