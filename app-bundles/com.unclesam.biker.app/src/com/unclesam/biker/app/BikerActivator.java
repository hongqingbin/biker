package com.unclesam.biker.app;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServlet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHandler;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * Biker 生命周期控制器
 * @author unclesam 2017年2月16日
 *
 */
public class BikerActivator implements BundleActivator {
	public final static Log LOGGER = LogFactory.getLog(BikerActivator.class);
	public final static Map<String, Class<? extends HttpServlet>> SERVLET_MAP = new HashMap<String, Class<? extends HttpServlet>>();
	public final static Map<String, Class<? extends HttpServlet>> LAZY_REGISTER_SERVLET_MAP = new HashMap<String, Class<? extends HttpServlet>>();

	private static BundleContext context;
	
	private static ServletContextHandler contextHandler;

	public static final BundleContext getContext() {
		return context;
	}
	
	public static final ServletContextHandler getServletContextHandler() {
		return contextHandler;
	}

	public void start(BundleContext bundleContext) throws Exception {
		BikerActivator.context = bundleContext;
		contextHandler = new ServletContextHandler();
		contextHandler.setContextPath("/biker");
		ServletHandler servletHandler = new ServletHandler();
		contextHandler.setServletHandler(servletHandler);
        context.registerService(ContextHandler.class.getName(), contextHandler, null);
        this.registerLazyServlets();
        LOGGER.info("BikerActivator 启动完毕");
	}
	
	private void registerLazyServlets() {
		if(LAZY_REGISTER_SERVLET_MAP.isEmpty()) {
			return ;
		}
		Iterator<String> paths = LAZY_REGISTER_SERVLET_MAP.keySet().iterator();
		Class<? extends HttpServlet> servlet;
		String pathSpec;
		while(paths.hasNext()) {
			pathSpec = paths.next();
			servlet = LAZY_REGISTER_SERVLET_MAP.get(pathSpec);
			BikerActivator.LOGGER.info(servlet.getName() + "register as path "+pathSpec+" success.");
		}
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Iterator<String> paths = SERVLET_MAP.keySet().iterator();
		String pathSpec;
		while(paths.hasNext()) {
			pathSpec = paths.next();
			contextHandler.addServlet(BikerHttpServlet.class, pathSpec);
			BikerActivator.LOGGER.info("path["+pathSpec+"] unregister success.");
		}
		BikerActivator.context = null;
		LOGGER.info("BikerActivator 已经停止");
	}

}
