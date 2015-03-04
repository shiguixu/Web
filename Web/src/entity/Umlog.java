/*
*www.dyr.com
*Copyright(c)2014 All Rights Reserved.
*/
/**
 * 
 */
package entity;

import java.util.Date;

/**
 * Project:Money
 * package:entity
 * FileName:Umlog.java
 * Comments:
 * JDK  Version:
 * Author:Casper
 * Create Date:2015-3-3 ÏÂÎç3:56:38
 * Modified By:Casper
 * Modified Time:
 * What is Modified:
 * Version:
 */
public class Umlog {
	private int lid;
	private String lcn;
	private String	ldate;
	private UserInfo userInfo;
	
	
	/**
	 * @return the lid
	 */
	public int getLid() {
		return lid;
	}
	/**
	 * @param lid the lid to set
	 */
	public void setLid(int lid) {
		this.lid = lid;
	}
	/**
	 * @return the lcn
	 */
	public String getLcn() {
		return lcn;
	}
	/**
	 * @param lcn the lcn to set
	 */
	public void setLcn(String lcn) {
		this.lcn = lcn;
	}
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
	 * @return the ldate
	 */
	public String getLdate() {
		return ldate;
	}
	/**
	 * @param ldate the ldate to set
	 */
	public void setLdate(String ldate) {
		this.ldate = ldate;
	}
	
}
