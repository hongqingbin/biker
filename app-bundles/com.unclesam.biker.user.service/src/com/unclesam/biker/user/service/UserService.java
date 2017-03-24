/**
 * 
 */
package com.unclesam.biker.user.service;

import java.util.List;
import java.util.Map;

/**
 * @author JoinBean
 *
 */
public interface UserService {
	
	public boolean addUser(User user);
	
	public boolean modifyUser(User user);
	
	public User deleteUser(String userId);
	
	public User findUser(String userId);
	
	public List<User> queryUsers(Map<String, Object> params, int offset, int limit);

}
