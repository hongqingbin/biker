/**
 * 
 */
package com.unclesam.biker.app.rest;

/**
 * Method ���󹤳�,��������url���ɶ�Ӧ��ҵ����method����
 * @author unclesam 2017��2��20��
 * 
 */
public abstract class MethAbstractFactory {
	
	/**
	 * ��������url���ɶ�Ӧ��ҵ����method����
	 * @param restUrl restUrlҵ���������
	 * @return Method ҵ����������
	 */
	public abstract Method buildMethod(String restUrl);

}
