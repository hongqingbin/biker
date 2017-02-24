/**
 * 
 */
package com.unclesam.biker.user.service;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

/**
 * @author JoinBean
 *
 */
public interface UserService {
	
	/**
	 * �����û���Ϣ
	 * @param user �û�
	 * @return true��ʾ�����ɹ���false��ʾʧ��
	 * @throws RemoteException
	 */
	public boolean addUser(User user);
	
	/**
	 * �޸��û���Ϣ
	 * @param user
	 * @return
	 * @throws RemoteException
	 */
	public boolean modifyUser(User user);
	
	/**
	 * ɾ���û���Ϣ
	 * @param userId �û�ID
	 * @return
	 * @throws RemoteException
	 */
	public User deleteUser(String userId);
	
	/**
	 * ��ѯ�����û���Ϣ
	 * @param userId �û�ID
	 * @return
	 * @throws RemoteException
	 */
	public User findUser(String userId);
	
	/**
	 * ��ѯ�û���Ϣ
	 * @param params ��ѯ����
	 * @param offset ��ʼλ��
	 * @param limit ��ѯ��
	 * @return
	 * @throws RemoteException
	 */
	public List<User> queryUsers(Map<String, Object> params, int offset, int limit);

}
