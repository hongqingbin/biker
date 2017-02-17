/**
 * 
 */
package com.unclesam.biker.locate.pojo;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

/**
 * 定位信息
 * @author JoinBean
 *
 */
public class Location extends UnicastRemoteObject implements Serializable, Cloneable{

	private static final long serialVersionUID = 1L;
	
	private String deviceId;
	
	private Date locateTime;
	
	private double lat;
	
	private double lng;
	
	private String cityCode;
	
	private String address;

	public Location() throws RemoteException {
		super();
	}
	

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getLocateTime() {
		return locateTime;
	}

	public void setLocateTime(Date locateTime) {
		this.locateTime = locateTime;
	}
	
}
