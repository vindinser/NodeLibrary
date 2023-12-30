package com.bjpowernode.dao;

import com.bjpowernode.bean.User;

import java.util.List;

// 用户查询
public interface UserDao {
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
}
