package com.bjpowernode.service.impl;

import com.bjpowernode.bean.User;
import com.bjpowernode.dao.UserDao;
import com.bjpowernode.dao.impl.UserDaoImpl;
import com.bjpowernode.service.UserService;

import java.util.List;

/**
 * �û�������
 */
public class UserServiceImpl implements UserService {
	// ���� Dao ����󣨶�̬��
	private UserDao userDao = new UserDaoImpl();

	/**
	 * ��ѯ
	 * @return
	 */
	@Override
	public List<User> select() {
		// ���� Dao ��д�õķ���
		return userDao.select();
	}

	/**
	 * ����û�
	 * @param user
	 */
	@Override
	public void add(User user) {
		userDao.add(user);
	}

	/**
	 * �޸��û�
	 * @param user
	 */
	@Override
	public void update(User user) {
		userDao.update(user);
	}

	/**
	 * ɾ���û�
	 * @param id
	 */
	@Override
	public void delete(int id) {
		userDao.delete(id);
	}

	/**
	 * �����û�
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
