package com.bjpowernode.dao.impl;

import com.bjpowernode.bean.PathConstant;
import com.bjpowernode.bean.User;
import com.bjpowernode.dao.UserDao;

import java.io.*;
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

	/**
	 * ����û�
	 * @param user
	 */
	@Override
	public void add(User user) {
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
        try {
			// ��ȡ�ļ��е�List����
			ois = new ObjectInputStream(new FileInputStream(PathConstant.USER_PATH));
			List<User> list = (List<User>)ois.readObject();
			if(list != null) {
				// ���һ���û�
				User lastUser = list.get(list.size() - 1);
				// �����û����
				user.setId(lastUser.getId() + 1);
			} else {
				list = new ArrayList<>();
				user.setId(1001);
			}
			// ��user����ŵ�list��
			list.add(user);
			// ��listд���ļ�
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
