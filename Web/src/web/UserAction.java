/*
*www.dyr.com
*Copyright(c)2014 All Rights Reserved.
*/
/**
 * 
 */
package web;

import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.RequestAware;

import service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import entity.Mony;
import entity.Umlog;
import entity.UserInfo;

/**
 * Project:Money
 * package:web
 * FileName:UserAction.java
 * Comments:
 * JDK  Version:
 * Author:Casper
 * Create Date:2015-3-3 ÏÂÎç4:19:21
 * Modified By:Casper
 * Modified Time:
 * What is Modified:
 * Version:
 */
public class UserAction extends ActionSupport implements RequestAware {
	
	public String tologin(){
		return SUCCESS;
	}
	
	public String login(){
		UserInfo user=userService.getUserByNameAndPswd(uname,upswd);
		if(user!=null){
			ActionContext.getContext().getSession().put("user", user);
			return SUCCESS;
		}
		else{
			ActionContext.getContext().put("tip", "*µÇÂ¼Ê§°Ü£¡");
			return INPUT;
		}
	}
	
	public String show(){
		UserInfo user= (UserInfo) ActionContext.getContext().getSession().get("user");
		Mony mony=userService.getMonyByUid(user.getUid());
		request.put("mony", mony);
		List<Umlog>  umlogs=userService.getUmlogByUid(user.getUid());
		request.put("umlogs", umlogs);
		return SUCCESS;
	}
	
	public String moveMoney(){
		int result=userService.modifyMonyByUid(uid,muid,mje);
		return SUCCESS;
	}
	
	
	private Map<String,Object> request;
	public void setRequest(Map<String, Object> request) {
		this.request=request;
	}
	private String uname;
	private  String upswd;
	private int uid;
	private int muid;
	private double mje; 

	private UserService userService;
	
	/**
	 * @return the userService
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * @param userService the userService to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * @return the uname
	 */
	public String getUname() {
		return uname;
	}

	/**
	 * @param uname the uname to set
	 */
	public void setUname(String uname) {
		this.uname = uname;
	}

	/**
	 * @return the upswd
	 */
	public String getUpswd() {
		return upswd;
	}

	/**
	 * @param upswd the upswd to set
	 */
	public void setUpswd(String upswd) {
		this.upswd = upswd;
	}

	/**
	 * @return the uid
	 */
	public int getUid() {
		return uid;
	}

	/**
	 * @param uid the uid to set
	 */
	public void setUid(int uid) {
		this.uid = uid;
	}

	/**
	 * @return the muid
	 */
	public int getMuid() {
		return muid;
	}

	/**
	 * @param muid the muid to set
	 */
	public void setMuid(int muid) {
		this.muid = muid;
	}

	/**
	 * @return the mje
	 */
	public Double getMje() {
		return mje;
	}

	/**
	 * @param mje the mje to set
	 */
	public void setMje(Double mje) {
		this.mje = mje;
	}

	/* (non-Javadoc)
	 * @see org.apache.struts2.interceptor.RequestAware#setRequest(java.util.Map)
	 */

	
}
