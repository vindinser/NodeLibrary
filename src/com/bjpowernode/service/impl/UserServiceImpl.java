package com.bjpowernode.service.impl;

import com.bjpowernode.bean.User;
import com.bjpowernode.dao.UserDao;
import com.bjpowernode.dao.impl.UserDaoImpl;
import com.bjpowernode.service.UserService;

import java.util.List;

/**
 * 用户服务类
 */
public class UserServiceImpl implements UserService {
	// 创建 Dao 层对象（多态）
	private UserDao userDao = new UserDaoImpl();

	/**
	 * 查询
	 * @return
	 */
	@Override
	public List<User> select() {
		// 调用 Dao 层写好的方法
		return userDao.select();
	}

	/**
	 * 添加用户
	 * @param user
	 */
	@Override
	public void add(User user) {
		userDao.add(user);
	}

	/**
	 * 修改用户
	 * @param user
	 */
	@Override
	public void update(User user) {
		userDao.update(user);
	}

	/**
	 * 删除用户
	 * @param id
	 */
	@Override
	public void delete(int id) {
		userDao.delete(id);
	}

	/**
	 * 冻结用户
	 * @param id
	 */
	@Override
	public void freeze(int id) {
		userDao.freeze(id);
	}

	@Override
	public void unFreeze(int id) {
		userDao.unFreeze(id);
	}
}
