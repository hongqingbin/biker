/**
 * 
 */
package com.unclesam.biker.user.internal.rest;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.unclesam.biker.app.rest.Method;
import com.unclesam.biker.user.service.UserService;

/**
 * 新增用户信息业务处理方法
 * @author JoinBean
 *
 */
public class AddUserMethod implements Method {

	public JSONObject handle(JSONObject reqBody) throws JSONException {
		JSONObject json = new JSONObject();
		json.put("call", this.getClass().getName());
		try {
			Registry registry = LocateRegistry.getRegistry(1099);
			UserService userService = (UserService) registry.lookup("UserService");
			userService.addUser(null);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return json;
	}

}
