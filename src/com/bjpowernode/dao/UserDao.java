package com.bjpowernode.dao;

import com.bjpowernode.bean.User;

import java.util.List;

// 用户查询
public interface UserDao {
  // 用户查询
  List<User> select();

  // 添加用户
  void add(User user);
}
