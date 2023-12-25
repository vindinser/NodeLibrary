package com.bjpowernode.dao.impl;

import com.bjpowernode.bean.PathConstant;
import com.bjpowernode.bean.User;
import com.bjpowernode.dao.UserDao;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户Dao层
 */
public class UserDaoImpl implements UserDao {
  /**
   * 从硬盘数据中读取文件
   * @return
   */
  @Override
  public List<User> select() {
		// 自动关闭流
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PathConstant.USER_PATH))) {
			List<User> list = (List<User>) ois.readObject();
			return list;
		} catch(Exception e) {
			e.printStackTrace();
		}
		// 如果出现异常，则返回一个List对象
    return new ArrayList<>();
  }
}
