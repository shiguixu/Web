/*
*www.dyr.com
*Copyright(c)2014 All Rights Reserved.
*/
/**
 * 
 */
package dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import entity.Mony;
import entity.Umlog;
import entity.UserInfo;

/**
 * Project:Money
 * package:dao
 * FileName:UserInfoDao.java
 * Comments:
 * JDK  Version:
 * Author:Casper
 * Create Date:2015-3-3 下午4:12:55
 * Modified By:Casper
 * Modified Time:
 * What is Modified:
 * Version:
 */
public interface UserDao {

	
	@Select("select * from	USERINFO where UNAME=#{uname} and UPSWD=#{upswd} ")
	@Results({
		@Result(id=true,column="UID",property="uid"),
		@Result(column="UNAME",property="uname"),
		@Result(column="UPSWD",property="upswd")
	})
	public UserInfo selectUserByNameAndPswd(@Param("uname")String uname, @Param("upswd")String upswd);
	
	@Select("select * from	USERINFO where UID=#{uid} ")
	@Results({
		@Result(id=true,column="UID",property="uid"),
		@Result(column="UNAME",property="uname"),
		@Result(column="UPSWD",property="upswd")
	})
	public UserInfo selectUserByUid(@Param("uid")int uid);
	
	/**
	 *@author Casper
	 *Create Time:2015-3-3 下午6:32:00
	 * Description:
	 * @param uid
	 * @return
	 */
	@Select("select * from	MONY where muid=#{uid}")
	@Results({
		@Result(id=true,column="MID",property="mid"),
		@Result(column="MJE",property="mje"),
		@Result(column="MUID",property="userInfo",one=@One(select="dao.UserDao.selectUserByUid"))
	})
	public Mony selectMonyByUid(int uid);

	/**
	 *@author Casper
	 *Create Time:2015-3-3 下午6:37:45
	 * Description:
	 * @param uid
	 * @return
	 */
	@Select("select * from umlog where LUID=#{uid}")
	@Results({
		@Result(id=true,column="LID",property="lid"),
		@Result(column="LCN",property="lcn"),
		@Result(column="LDATE",property="ldate"),
		@Result(column="LUID",property="userInfo",one=@One(select="dao.UserDao.selectUserByUid"))
	})
	public List<Umlog> selectUmlogByUid(int uid);

	/**
	 *@author Casper
	 *Create Time:2015-3-4 上午11:44:32
	 * Description:
	 * @param uid
	 * @param mje
	 */
	@Update("update MONY set MJE=((select mje from Mony where muid=#{uid})-#{mje}) where muid=#{uid}")
	public void updateMonyByUid(@Param("uid")int muid, @Param("mje")double mje);

	/**
	 *@author Casper
	 *Create Time:2015-3-4 上午11:45:34
	 * Description:
	 * @param muid
	 * @param mje
	 */
	@Update("update MONY set MJE=((select mje from Mony where muid=#{uid})+#{mje}) where muid=#{uid}")
	public void updateMonyByMuid(@Param("uid")int muid, @Param("mje")double mje);

	/**
	 *@author Casper
	 *Create Time:2015-3-4 上午11:46:29
	 * Description:
	 * @param uid
	 */
	@Insert("insert into umlog values(#{str},default,#{uid})")
	public void insertUmlogByUid(@Param("uid")int uid, @Param("str")String str);
}
