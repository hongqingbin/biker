/**
 * 
 */
package com.unclesam.biker.user.api;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import com.unclesam.biker.user.pojo.User;

/**
 * @author JoinBean
 *
 */
public interface UserService extends Remote {
	
	/**
	 * �����û���Ϣ
	 * @param user �û�
	 * @return true��ʾ�����ɹ���false��ʾʧ��
	 * @throws RemoteException
	 */
	public boolean addUser(User user) throws RemoteException;
	
	/**
	 * �޸��û���Ϣ
	 * @param user
	 * @return
	 * @throws RemoteException
	 */
	public boolean modifyUser(User user) throws RemoteException;
	
	/**
	 * ɾ���û���Ϣ
	 * @param userId �û�ID
	 * @return
	 * @throws RemoteException
	 */
	public User deleteUser(String userId) throws RemoteException;
	
	/**
	 * ��ѯ�����û���Ϣ
	 * @param userId �û�ID
	 * @return
	 * @throws RemoteException
	 */
	public User findUser(String userId) throws RemoteException;
	
	/**
	 * ��ѯ�û���Ϣ
	 * @param params ��ѯ����
	 * @param offset ��ʼλ��
	 * @param limit ��ѯ��
	 * @return
	 * @throws RemoteException
	 */
	public List<User> queryUsers(Map<String, Object> params, int offset, int limit) throws RemoteException;

}
