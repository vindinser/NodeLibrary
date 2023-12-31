package com.bjpowernode.service.impl;

import com.bjpowernode.bean.Constant;
import com.bjpowernode.bean.Lend;
import com.bjpowernode.bean.User;
import com.bjpowernode.dao.LendDao;
import com.bjpowernode.dao.UserDao;
import com.bjpowernode.dao.impl.LendDaoImpl;
import com.bjpowernode.dao.impl.UserDaoImpl;
import com.bjpowernode.service.UserService;

import java.math.BigDecimal;
import java.util.List;

/**
 * �û�������
 */
public class UserServiceImpl implements UserService {
	// ���� Dao ����󣨶�̬��
	private UserDao userDao = new UserDaoImpl();

	private LendDao lendDao = new LendDaoImpl();

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

	@Override
	public List<User> selectUserToLend() {
		return userDao.selectUserToLend();
	}

	/**
	 * ��ֵ
	 * @param user
	 * @param money
	 * @return
	 */
	@Override
	public User charge(User user, BigDecimal money) {
		// �����ֵ֮������
		BigDecimal sum = money.add(user.getMoney());
		// ��ֵ֮������Ƿ����0�����û���ǰ״̬Ϊ���ᣬ�޸��û�״̬Ϊ����
		if(BigDecimal.ZERO.compareTo(sum) < 0 && Constant.USER_FROZEN.equals(user.getStatus())) {
			user.setStatus(Constant.USER_OK);
		}
		// ���ó�ֵ�����
		user.setMoney(sum);
		// �����û�
		userDao.update(user);

		// �޸Ľ����ļ��е��û�����
		Lend lend = new Lend();
		lend.setUser(user);
		List<Lend> lendList = lendDao.select(lend);
		Lend originLend = lendList.get(0);
		originLend.setUser(user);
		lendDao.update(originLend);

		return user;
	}
}
