/**
 * 
 */
package com.unclesam.biker.user.pojo;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 用户实体
 * @author JoinBean
 *
 */
public class User extends UnicastRemoteObject implements Serializable, Cloneable{

	private static final long serialVersionUID = 1L;
	
	private String recid;
	private String name;
	private int age;
	private int sex;
	private String profession;
	private String telephone;
	private String wxAccount;
	private String qqAccount;
	private String email;

	public User() throws RemoteException {
		super();
	}
	
	
	/**
	 * 唯一标识
	 * @return
	 */
	public String getRecid() {
		return recid;
	}

	public void setRecid(String recid) {
		this.recid = recid;
	}

	/**
	 * 姓名
	 * @return
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 年龄
	 * @return
	 */
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * 性别：0女，1男，2其他
	 * @return
	 */
	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	/**
	 * 职业
	 * @return
	 */
	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	/**
	 * 手机号
	 * @return
	 */
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * 微信号
	 * @return
	 */
	public String getWxAccount() {
		return wxAccount;
	}

	public void setWxAccount(String wxAccount) {
		this.wxAccount = wxAccount;
	}

	/**
	 * QQ号
	 * @return
	 */
	public String getQqAccount() {
		return qqAccount;
	}

	public void setQqAccount(String qqAccount) {
		this.qqAccount = qqAccount;
	}

	/**
	 * 邮箱地址
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
