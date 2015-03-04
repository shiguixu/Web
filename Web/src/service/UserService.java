/*
*www.dyr.com
*Copyright(c)2014 All Rights Reserved.
*/
/**
 * 
 */
package service;

import java.util.List;

import dao.UserDao;
import entity.Mony;
import entity.Umlog;
import entity.UserInfo;

/**
 * Project:Money
 * package:service
 * FileName:UserInfoService.java
 * Comments:
 * JDK  Version:
 * Author:Casper
 * Create Date:2015-3-3 下午4:18:40
 * Modified By:Casper
 * Modified Time:
 * What is Modified:
 * Version:
 */
public class UserService {
	
	
	
	private UserDao userDao;

	
	/**
	 * @return the userDao
	 */
	public UserDao getUserDao() {
		return userDao;
	}

	/**
	 * @param userDao the userDao to set
	 */
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 *@author Casper
	 *Create Time:2015-3-3 下午5:50:30
	 * Description:
	 * @param upswd 
	 * @param uname 
	 * @param uname
	 * @param upswd
	 * @return
	 */
	public UserInfo getUserByNameAndPswd(String uname, String upswd) {
		UserInfo user=userDao.selectUserByNameAndPswd(uname,upswd);
		return user;
	}

	/**
	 *@author Casper
	 *Create Time:2015-3-3 下午5:53:24
	 * Description:
	 * @param uid
	 * @return
	 */
	public Mony getMonyByUid(int uid) {
		Mony mony=userDao.selectMonyByUid(uid);
		return mony;
	}

	/**
	 *@author Casper
	 *Create Time:2015-3-3 下午5:53:28
	 * Description:
	 * @param uid
	 * @return
	 */
	public List<Umlog> getUmlogByUid(int uid) {
		List<Umlog> list=userDao.selectUmlogByUid(uid);
		return list;
	}

	/**
	 *@author Casper
	 *Create Time:2015-3-4 上午11:43:23
	 * Description:
	 * @param uid
	 * @param muid
	 * @param mje
	 * @return
	 */
	public int modifyMonyByUid(int uid, int muid, double mje) {
		userDao.updateMonyByMuid(muid,mje);
		userDao.updateMonyByUid(uid,mje);
		UserInfo user=userDao.selectUserByUid(uid);
		String str=user.getUname()+"转出"+mje+"元";
		userDao.insertUmlogByUid(uid,str);
		String str2=user.getUname()+"转入"+mje+"元";
		userDao.insertUmlogByUid(muid,str2);
		return 1;
	}


}
