/**
 * 
 */
package com.unclesam.biker.app.util;

/**
 * @author unclesam 2017��2��16��
 * 
 */
public final class StringUtil {
	
	public static boolean isEmpty(String str) {
		return str == null || "".equals(str);
	}
	
	public static boolean isEmptyTrim(String str) {
		return str == null || "".equals(str.trim());
	}

}
