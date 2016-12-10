package org.thinkingingis.servlet3;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.thinkingingis.config.SpringWebConfig;



public class MyWebInitializer extends
		AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { SpringWebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

}