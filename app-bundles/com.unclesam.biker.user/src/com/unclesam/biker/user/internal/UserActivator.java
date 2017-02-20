/**
 * 
 */
package com.unclesam.biker.user.internal;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.unclesam.biker.app.registry.HttpServletRegistry;

/**
 * @author JoinBean
 *
 */
public class UserActivator implements BundleActivator {
	
	private String pathSpec = "/user/*";

	public void start(BundleContext context) throws Exception {
		//ע��Servlet
		HttpServletRegistry.registerServlet(UserHttpServlet.class, pathSpec);
	}

	public void stop(BundleContext context) throws Exception {
		//ȡ��ע��Servlet
		HttpServletRegistry.unRegisterServlet(pathSpec);
	}

}
