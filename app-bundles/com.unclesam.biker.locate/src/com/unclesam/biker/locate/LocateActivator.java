package com.unclesam.biker.locate;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.unclesam.biker.app.registry.HttpServletRegistry;

public class LocateActivator implements BundleActivator {
	
	private String pathSpec = "/locate";

	public void start(BundleContext bundleContext) throws Exception {
		HttpServletRegistry.registerServlet(LocateHttpServlet.class, pathSpec);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		HttpServletRegistry.unRegisterServlet(pathSpec);
	}

}
