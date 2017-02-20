/**
 * 
 */
package com.unclesam.biker.user.internal.rest;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.unclesam.biker.app.rest.Method;

/**
 * 删除用户信息业务处理方法
 * @author JoinBean
 *
 */
public class DeleteUserMethod implements Method {

	public JSONObject handle(JSONObject reqBody) throws JSONException {
		JSONObject json = new JSONObject();
		json.put("call", this.getClass().getName());
		return json;
	}

}
