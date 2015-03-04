/*
*www.dyr.com
*Copyright(c)2014 All Rights Reserved.
*/
/**
 * 
 */
package entity;

/**
 * Project:Money
 * package:entity
 * FileName:Mony.java
 * Comments:
 * JDK  Version:
 * Author:Casper
 * Create Date:2015-3-3 ÏÂÎç3:55:20
 * Modified By:Casper
 * Modified Time:
 * What is Modified:
 * Version:
 */
public class Mony {
	private int mid;
	private double mje;
	private UserInfo userInfo;
	
	/**
	 * @return the userInfo
	 */
	public UserInfo getUserInfo() {
		return userInfo;
	}
	/**
	 * @param userInfo the userInfo to set
	 */
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	/**
	 * @return the mid
	 */
	public int getMid() {
		return mid;
	}
	/**
	 * @param mid the mid to set
	 */
	public void setMid(int mid) {
		this.mid = mid;
	}
	/**
	 * @return the mje
	 */
	public double getMje() {
		return mje;
	}
	/**
	 * @param mje the mje to set
	 */
	public void setMje(double mje) {
		this.mje = mje;
	}
}
