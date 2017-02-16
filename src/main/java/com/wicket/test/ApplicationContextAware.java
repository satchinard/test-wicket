package com.wicket.test;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author cagecfi
 */
public interface ApplicationContextAware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
