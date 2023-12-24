package com.bjpowernode.until;

import com.bjpowernode.bean.User;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InitDataUtil {
    public static void main(String[] args) {
        initUser(null);
    }

    // ��ʼ���û�����
    public static void initUser(List<User> userList) {
        ObjectOutputStream oos = null;
        try {
            // �����ļ���
            File directory = new File("user/");
            // �����ļ�
            File file = new File("user/user.txt");
            // �ж��ļ����Ƿ����
            if(!directory.exists()) {
                directory.mkdir();
            }
            // �ж��ļ��Ƿ����
            if(!file.exists()) {
                file.createNewFile();
                List<User> list = new ArrayList<>();
                // �ж�userList�Ƿ�Ϊ��
                if(userList == null) {
                    list.add(new User(1001, "�Ŵ�", "����", BigDecimal.TEN));
                } else {
                    list = userList;
                }
                // ���ö����������list����д�����ļ���
                oos = new ObjectOutputStream(new FileOutputStream("user/user.txt"));
                oos.writeObject(list);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
