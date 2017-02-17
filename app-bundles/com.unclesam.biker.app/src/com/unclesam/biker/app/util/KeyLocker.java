/**
 * 
 */
package com.unclesam.biker.app.util;

import java.util.ArrayList;
import java.util.List;

/**
 * <li>ע�⣺Ҫȷ��locker.releaseLock���������ã��������finally�������
 * @author JoinBean
 *
 */
public final class KeyLocker {
	
	private final List<String> keyHolder = new ArrayList<String>();
	
	/**
	 * ��ס���ݣ�ҵ���߼����ݷ��ؽ����������������
	 * @param key ���磺recid.toString()�� ������<code>null</code>
	 * @return true��ʾ������������Խ��к���������false���ܽ��к�������
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
	 * �ͷ�����һ��ҵ�񼶱�������������Ժ�Ӧ���ͷ���
	 * @param key ���磺recid.toString()��������<code>null</code>
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
	 * �ж�key�Ƿ��Ѿ�����ס
	 * @param key
	 * @return true��ʾ�Ѿ�����ס�����鲻Ҫ����
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
