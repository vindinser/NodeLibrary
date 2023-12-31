package com.bjpowernode.service;

import com.bjpowernode.bean.User;

import java.math.BigDecimal;
import java.util.List;

public interface UserService {
	// 用户查询
	List<User> select();

	// 添加用户
	void add(User user);

	// 修改用户
	void update(User user);

	// 删除用户
	void delete(int id);

	// 冻结用户
	void freeze(int id);

	// 解除冻结用户
	void unFreeze(int id);

	// 查询可以借书的用户
	List<User> selectUserToLend();

	// 充值
	User charge(User user, BigDecimal money);
}
