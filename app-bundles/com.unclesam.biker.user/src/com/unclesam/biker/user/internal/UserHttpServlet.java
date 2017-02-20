/**
 * 
 */
package com.unclesam.biker.user.internal;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.unclesam.biker.app.rest.Method;
import com.unclesam.biker.user.internal.rest.UserMethodFactory;

/**
 * @author JoinBean
 *
 */
public class UserHttpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String restUrl = req.getRequestURI();
		Method method = UserMethodFactory.BUILDER.buildMethod(restUrl);
		if(method != null) {
			JSONObject respBody = method.handle(null);
			resp.getOutputStream().print(respBody.toJSONString());
		}
		resp.flushBuffer();
	}
	
}
