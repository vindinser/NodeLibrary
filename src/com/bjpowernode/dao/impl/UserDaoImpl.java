package com.bjpowernode.dao.impl;

import com.bjpowernode.bean.Constant;
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

	/**
	 * 修改用户
	 * @param user
	 */
	@Override
	public void update(User user) {
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		// 将list对象从文件中取出
		try {
			ois = new ObjectInputStream(new FileInputStream(PathConstant.USER_PATH));
			List<User> list = (List<User>)ois.readObject();
			if(list != null) {
				// 从list中查找要修改的数据
				User originUser = list.stream().filter(item -> item.getId() == user.getId()).findFirst().get();
				// 修改数据
				originUser.setName(user.getName());
				originUser.setMoney(user.getMoney());
				// 将数据持久化到文件中
				oos = new ObjectOutputStream(new FileOutputStream(PathConstant.USER_PATH));
				oos.writeObject(list);
			}
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

	/**
	 * 删除用户
	 * @param id
	 */
	@Override
	public void delete(int id) {
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(PathConstant.USER_PATH));
			List<User> list = (List<User>) ois.readObject();
			// 使用stream流查找删除用户
			User user = list.stream().filter(item -> item.getId() == id).findFirst().get();
			// 从list中删除
			list.remove(user);
			// 持久化到文件中
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

	/**
	 * 冻结用户
	 * @param id
	 */
	@Override
	public void freeze(int id) {
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(PathConstant.USER_PATH));
			List<User> list = (List<User>) ois.readObject();
			User user = list.stream().filter(item -> item.getId() == id).findFirst().get();
			user.setStatus(Constant.USER_FROZEN);
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
