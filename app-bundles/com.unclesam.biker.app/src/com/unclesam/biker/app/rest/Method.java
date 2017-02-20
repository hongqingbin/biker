/**============================================================
 * ��Ȩ�� С��Ƽ� ��Ȩ���� (c) 2002 - 2012
 * ���� com.jiuqi.sjyz.app.servlet
 * �޸ļ�¼��
 * ����                ����           ����
 * =============================================================
 * 2016��2��5��       JoinBean        
 * ============================================================*/

package com.unclesam.biker.app.rest;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

/**
 * <p>HTTP��������</p>
 * <li>HTTP�������ݣ����磺<code>{"identity":"�û���ʶ","reqdata":{�������}}</code>
 * <li>HTTP��Ӧ���ݣ����磺<code>{"retcode":0,"description":"�ɹ�","time":1454634831491,"respdata":{��Ӧ���}}</code>
 * <p>Copyright: ��Ȩ���� (c) 2013 - 2015<br> Company: С��Ƽ�</p>
 *
 * @author JoinBean
 * @version 2016��2��5��
 */

public interface Method {
	
	/**
	 * ����HTTP����
	 * 
	 * @param reqBody �������ݣ����磺<code>{"identity":"�û���ʶ","reqdata":{...}}</code>
	 * @return JSONObject ��Ӧ���ݣ����磺<code>{"retcode":0,"description":"�ɹ�","time":1454634831491,"respdata":{...}}</code>
	 */
	public JSONObject handle(JSONObject reqBody)  throws JSONException ;

}
