package com.romain.security;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Needed to integrate Spring Security with Spring MVC
 * @author Romain
 *
 */
public class MvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer  {

	// the Root Config is registered in SecurityInitializer
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    // the Spring MVC configuration should be added to SecurityInitializer constructor
    // i.e.
    // super(MvcConfig.class, WebSecurityConfig.class);
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}