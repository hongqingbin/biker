/**
 * 
 */
package com.unclesam.biker.user.impl;

import java.util.List;
import java.util.Map;

import com.unclesam.biker.user.service.User;
import com.unclesam.biker.user.service.UserService;

/**
 * @author JoinBean
 *
 */
public class UserServiceImpl implements UserService {


	public boolean addUser(User user) {
		System.out.println("com.unclesam.biker.user.impl.UserServiceImpl.addUser(User) is Called.");
		return false;
	}

	public boolean modifyUser(User user) {
		System.out.println("com.unclesam.biker.user.impl.UserServiceImpl.modifyUser(User) is Called.");
		return false;
	}

	public User deleteUser(String userId) {
		System.out.println("com.unclesam.biker.user.impl.UserServiceImpl.deleteUser(String) is Called.");
		return null;
	}

	public User findUser(String userId) {
		System.out.println("com.unclesam.biker.user.impl.UserServiceImpl.findUser(String) is Called.");
		return null;
	}

	public List<User> queryUsers(Map<String, Object> params, int offset, int limit) {
		System.out.println("com.unclesam.biker.user.impl.UserServiceImpl.queryUsers(Map<String, Object>, int, int) is Called.");
		return null;
	}

}
