/**============================================================
 * 版权： 小驿科技 版权所有 (c) 2002 - 2012
 * 包： com.jiuqi.sjyz.app.servlet
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2016年2月5日       JoinBean        
 * ============================================================*/

package com.unclesam.biker.app.rest;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

/**
 * <p>HTTP请求处理方法</p>
 * <li>HTTP请求内容，例如：<code>{"identity":"用户标识","reqdata":{请求参数}}</code>
 * <li>HTTP响应内容，例如：<code>{"retcode":0,"description":"成功","time":1454634831491,"respdata":{响应结果}}</code>
 * <p>Copyright: 版权所有 (c) 2013 - 2015<br> Company: 小驿科技</p>
 *
 * @author JoinBean
 * @version 2016年2月5日
 */

public interface Method {
	
	/**
	 * 处理HTTP请求
	 * 
	 * @param reqBody 请求内容，例如：<code>{"identity":"用户标识","reqdata":{...}}</code>
	 * @return JSONObject 响应内容，例如：<code>{"retcode":0,"description":"成功","time":1454634831491,"respdata":{...}}</code>
	 */
	public JSONObject handle(JSONObject reqBody)  throws JSONException ;

}
