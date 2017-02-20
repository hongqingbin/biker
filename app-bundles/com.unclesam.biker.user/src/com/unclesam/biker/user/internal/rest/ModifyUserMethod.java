/**
 * 
 */
package com.unclesam.biker.user.internal.rest;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.unclesam.biker.app.rest.Method;

/**
 * 修改用户信息业务处理方法
 * @author JoinBean
 *
 */
public class ModifyUserMethod implements Method {

	public JSONObject handle(JSONObject reqBody) throws JSONException {
		JSONObject json = new JSONObject();
		json.put("call", this.getClass().getName());
		return json;
	}

}
