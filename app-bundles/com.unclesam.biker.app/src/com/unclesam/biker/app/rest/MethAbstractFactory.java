/**
 * 
 */
package com.unclesam.biker.app.rest;

/**
 * Method 抽象工厂,根据请求url生成对应的业务处理method对象
 * @author unclesam 2017年2月20日
 * 
 */
public abstract class MethAbstractFactory {
	
	/**
	 * 根据请求url生成对应的业务处理method对象
	 * @param restUrl restUrl业务请求对象
	 * @return Method 业务处理方法对象
	 */
	public abstract Method buildMethod(String restUrl);

}
