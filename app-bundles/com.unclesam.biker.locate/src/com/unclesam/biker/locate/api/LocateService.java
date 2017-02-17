/**
 * 
 */
package com.unclesam.biker.locate.api;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;
import com.unclesam.biker.locate.pojo.Location;

/**
 * @author JoinBean
 *
 */
public interface LocateService extends Remote {
	
	/**
	 * 记录定位信息
	 * @param location
	 * @return
	 * @throws RemoteException
	 */
	public boolean addLocation(Location location) throws RemoteException;
	
	/**
	 * 查询定位信息
	 * @param params
	 * @return
	 * @throws RemoteException
	 */
	public List<Location> getLocations(Map<String, Object> params, int offset, int limit) throws RemoteException;

}
