/**
 * 
 */
package com.unclesam.biker.app.util;

import java.util.ArrayList;
import java.util.List;

/**
 * <li>注意：要确保locker.releaseLock方法被调用，建议放在finally代码块中
 * @author JoinBean
 *
 */
public final class KeyLocker {
	
	private final List<String> keyHolder = new ArrayList<String>();
	
	/**
	 * 锁住数据（业务逻辑根据返回结果决定后续操作）
	 * @param key 例如：recid.toString()， 不能是<code>null</code>
	 * @return true表示获得了锁，可以进行后续操作；false不能进行后续操作
	 */
	public boolean lock(String key) {
		if(key == null) {
			return false;
		}
		boolean success = false;
		synchronized (key) {
			if(!keyHolder.contains(key)) {
				keyHolder.add(key);
				success = true;
			}
		}
		return success;
	}
	
	/**
	 * 释放锁，一个业务级别的事务操作完毕以后，应该释放锁
	 * @param key 例如：recid.toString()，不能是<code>null</code>
	 */
	public void releaseLock(String key) {
		if(key == null) {
			return ;
		}
		synchronized (key) {
			keyHolder.remove(key);
		}
	}

	/**
	 * 判断key是否已经被锁住
	 * @param key
	 * @return true表示已经被锁住，建议不要操作
	 */
	public boolean isLocked(String key) {
		if(key == null) {
			return false;
		}
		boolean islocked = false;
		synchronized (key) {
			islocked = keyHolder.contains(key);
		}
		return islocked;
	}
}
