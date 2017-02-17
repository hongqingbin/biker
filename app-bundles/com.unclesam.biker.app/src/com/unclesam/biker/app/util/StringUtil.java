/**
 * 
 */
package com.unclesam.biker.app.util;

/**
 * @author unclesam 2017Äê2ÔÂ16ÈÕ
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
