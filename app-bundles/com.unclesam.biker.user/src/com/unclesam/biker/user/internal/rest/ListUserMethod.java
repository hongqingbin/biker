/**
 * 
 */
package com.unclesam.biker.user.internal.rest;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.unclesam.biker.app.rest.Method;

/**
 * �г��û���Ϣ�б�ҵ��������
 * @author JoinBean
 *
 */
public class ListUserMethod implements Method {

	public JSONObject handle(JSONObject reqBody) throws JSONException {
		JSONObject json = new JSONObject();
		json.put("call", this.getClass().getName());
		return json;
	}

}