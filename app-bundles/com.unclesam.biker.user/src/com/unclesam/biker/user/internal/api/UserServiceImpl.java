/**
 * 
 */
package com.unclesam.biker.user.internal.api;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import com.unclesam.biker.user.api.UserService;
import com.unclesam.biker.user.pojo.User;

/**
 * @author JoinBean
 *
 */
public class UserServiceImpl implements UserService {

	public boolean addUser(User user) throws RemoteException {
		return false;
	}

	public boolean modifyUser(User user) throws RemoteException {
		return false;
	}

	public User deleteUser(String userId) throws RemoteException {
		return null;
	}

	public User findUser(String userId) throws RemoteException {
		return null;
	}

	public List<User> queryUsers(Map<String, Object> params, int offset, int limit) throws RemoteException {
		return null;
	}

}
