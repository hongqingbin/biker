/**
 * 
 */
package com.unclesam.biker.app;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 默认请求处理器
 * @author unclesam 2017年2月16日
 * 
 */
public class BikerHttpServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(BikerHttpServlet.class);

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getOutputStream().print("BikerHttpServlet DO POST.");
		resp.flushBuffer();
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		logger.info("UserApiGateway inited!");
	}

}
