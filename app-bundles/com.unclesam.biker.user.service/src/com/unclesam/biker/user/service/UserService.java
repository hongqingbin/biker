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
	 * 新增用户信息
	 * @param user 用户
	 * @return true表示新增成功，false表示失败
	 * @throws RemoteException
	 */
	public boolean addUser(User user);
	
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 * @throws RemoteException
	 */
	public boolean modifyUser(User user);
	
	/**
	 * 删除用户信息
	 * @param userId 用户ID
	 * @return
	 * @throws RemoteException
	 */
	public User deleteUser(String userId);
	
	/**
	 * 查询单个用户信息
	 * @param userId 用户ID
	 * @return
	 * @throws RemoteException
	 */
	public User findUser(String userId);
	
	/**
	 * 查询用户信息
	 * @param params 查询条件
	 * @param offset 起始位置
	 * @param limit 查询量
	 * @return
	 * @throws RemoteException
	 */
	public List<User> queryUsers(Map<String, Object> params, int offset, int limit);

}
