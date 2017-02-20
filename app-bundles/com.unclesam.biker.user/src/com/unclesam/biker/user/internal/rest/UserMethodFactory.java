/**
 * 
 */
package com.unclesam.biker.user.internal.rest;

import java.util.HashMap;
import java.util.Map;

import com.unclesam.biker.app.rest.MethAbstractFactory;
import com.unclesam.biker.app.rest.Method;

/**
 * 用户信息业务处理方法工厂
 * @author JoinBean
 *
 */
public class UserMethodFactory extends MethAbstractFactory{
	
	public static final UserMethodFactory BUILDER = new UserMethodFactory();
	
	private Map<String, Class<? extends Method>> userMethods = new HashMap<String, Class<? extends Method>>();
	
	private UserMethodFactory () {
		userMethods.put("/biker/user/add", AddUserMethod.class);
		userMethods.put("/biker/user/delete", DeleteUserMethod.class);
		userMethods.put("/biker/user/modify", ModifyUserMethod.class);
		userMethods.put("/biker/user/find", FindUserMethod.class);
		userMethods.put("/biker/user/list", ListUserMethod.class);
	}

	public Method buildMethod(String restUrl) {
		Class<? extends Method> clazz = userMethods.get(restUrl);
		Method method = null;
		try {
			if(clazz != null) {
				method = clazz.newInstance();
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return method;
	}

}
