package com.romain.security;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

import com.romain.configurations.SecurityConfig;

/**
 * Load SecurityConfig through a ContextLoaderListener
 * @author Romain
 *
 */
public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {

	public SecurityInitializer() {
        super(SecurityConfig.class);
    }
	
}
