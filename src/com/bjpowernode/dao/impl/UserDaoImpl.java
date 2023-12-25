package com.bjpowernode.dao.impl;

import com.bjpowernode.bean.PathConstant;
import com.bjpowernode.bean.User;
import com.bjpowernode.dao.UserDao;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * �û�Dao��
 */
public class UserDaoImpl implements UserDao {
  /**
   * ��Ӳ�������ж�ȡ�ļ�
   * @return
   */
  @Override
  public List<User> select() {
		// �Զ��ر���
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PathConstant.USER_PATH))) {
			List<User> list = (List<User>) ois.readObject();
			return list;
		} catch(Exception e) {
			e.printStackTrace();
		}
		// ��������쳣���򷵻�һ��List����
    return new ArrayList<>();
  }
}
