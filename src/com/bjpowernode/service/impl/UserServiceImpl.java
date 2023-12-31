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
 * 用户服务类
 */
public class UserServiceImpl implements UserService {
	// 创建 Dao 层对象（多态）
	private UserDao userDao = new UserDaoImpl();

	private LendDao lendDao = new LendDaoImpl();

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

	@Override
	public List<User> selectUserToLend() {
		return userDao.selectUserToLend();
	}

	/**
	 * 充值
	 * @param user
	 * @param money
	 * @return
	 */
	@Override
	public User charge(User user, BigDecimal money) {
		// 计算充值之后的余额
		BigDecimal sum = money.add(user.getMoney());
		// 充值之后余额是否大于0，且用户当前状态为冻结，修改用户状态为正常
		if(BigDecimal.ZERO.compareTo(sum) < 0 && Constant.USER_FROZEN.equals(user.getStatus())) {
			user.setStatus(Constant.USER_OK);
		}
		// 设置充值后余额
		user.setMoney(sum);
		// 更新用户
		userDao.update(user);

		// 修改借阅文件中的用户数据
		Lend lend = new Lend();
		lend.setUser(user);
		List<Lend> lendList = lendDao.select(lend);
		Lend originLend = lendList.get(0);
		originLend.setUser(user);
		lendDao.update(originLend);

		return user;
	}
}
