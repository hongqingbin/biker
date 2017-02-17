/**
 * 
 */
package com.unclesam.biker.app.registry;

import javax.servlet.http.HttpServlet;

import org.eclipse.jetty.servlet.ServletContextHandler;

import com.unclesam.biker.app.BikerActivator;
import com.unclesam.biker.app.BikerHttpServlet;
import com.unclesam.biker.app.util.StringUtil;

/**
 * @author unclesam 2017年2月16日
 * 
 */
public final class HttpServletRegistry {
	
	/**
	 * 注册Servlet
	 * @param servlet 
	 * @param pathSpec 例如：/user
	 */
	public static final void registerServlet(Class<? extends HttpServlet> servlet, String pathSpec) {
		if(StringUtil.isEmptyTrim(pathSpec)) {
			return ;
		}
		synchronized (pathSpec) {
			if(BikerActivator.SERVLET_MAP.get(pathSpec) != null) {
				BikerActivator.LOGGER.info(servlet.getName() + "register as path "+pathSpec+" failed.");
				return ;
			}
			ServletContextHandler handler = BikerActivator.getServletContextHandler();
			BikerActivator.SERVLET_MAP.put(pathSpec, servlet);
			if(handler == null) {
				BikerActivator.LAZY_REGISTER_SERVLET_MAP.put(pathSpec, servlet);
				BikerActivator.LOGGER.info(servlet.getName()+" will auto register as path"+pathSpec+" later.");
			}else {
				handler.addServlet(servlet, pathSpec);
				BikerActivator.LOGGER.info(servlet.getName() + "register as path "+pathSpec+" success.");
			}
			
		}
		
	}
	
	public static final void unRegisterServlet(String pathSpec) {
		ServletContextHandler handler = BikerActivator.getServletContextHandler();
		handler.addServlet(BikerHttpServlet.class, pathSpec);
		BikerActivator.LOGGER.info("path["+pathSpec+"] unregister success.");
	}

}
