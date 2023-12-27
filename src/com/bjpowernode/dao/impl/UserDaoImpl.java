package com.bjpowernode.dao.impl;

import com.bjpowernode.bean.PathConstant;
import com.bjpowernode.bean.User;
import com.bjpowernode.dao.UserDao;

import java.io.*;
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

	/**
	 * 添加用户
	 * @param user
	 */
	@Override
	public void add(User user) {
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
        try {
			// 读取文件中的List对象
			ois = new ObjectInputStream(new FileInputStream(PathConstant.USER_PATH));
			List<User> list = (List<User>)ois.readObject();
			if(list != null) {
				// 最后一个用户
				User lastUser = list.get(list.size() - 1);
				// 生成用户编号
				user.setId(lastUser.getId() + 1);
			} else {
				list = new ArrayList<>();
				user.setId(1001);
			}
			// 将user对象放到list中
			list.add(user);
			// 将list写入文件
			oos = new ObjectOutputStream(new FileOutputStream(PathConstant.USER_PATH));
			oos.writeObject(list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
			try {
				if(ois != null) {
					ois.close();
				}
				if(oos != null) {
					oos.close();
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
    }
}
