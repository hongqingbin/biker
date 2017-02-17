/**
 * 
 */
package com.unclesam.biker.user.pojo;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * �û�ʵ��
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
	 * Ψһ��ʶ
	 * @return
	 */
	public String getRecid() {
		return recid;
	}

	public void setRecid(String recid) {
		this.recid = recid;
	}

	/**
	 * ����
	 * @return
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * ����
	 * @return
	 */
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * �Ա�0Ů��1�У�2����
	 * @return
	 */
	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	/**
	 * ְҵ
	 * @return
	 */
	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	/**
	 * �ֻ���
	 * @return
	 */
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * ΢�ź�
	 * @return
	 */
	public String getWxAccount() {
		return wxAccount;
	}

	public void setWxAccount(String wxAccount) {
		this.wxAccount = wxAccount;
	}

	/**
	 * QQ��
	 * @return
	 */
	public String getQqAccount() {
		return qqAccount;
	}

	public void setQqAccount(String qqAccount) {
		this.qqAccount = qqAccount;
	}

	/**
	 * �����ַ
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
