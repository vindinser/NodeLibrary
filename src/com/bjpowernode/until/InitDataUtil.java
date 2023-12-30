package com.bjpowernode.until;

import com.bjpowernode.bean.Book;
import com.bjpowernode.bean.Constant;
import com.bjpowernode.bean.PathConstant;
import com.bjpowernode.bean.User;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class InitDataUtil {
    public static void main(String[] args) {
        initUser(null);
        initBook(null);
    }

    // ��ʼ���û�����
    public static void initUser(List<User> userList) {
        ObjectOutputStream oos = null;
        try {
            // �����ļ���
            File directory = new File("user/");
            // �����ļ�
            File file = new File(PathConstant.USER_PATH);
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
                    list.add(new User(1001, "�Ŵ�", Constant.USER_OK, BigDecimal.TEN));
                } else {
                    list = userList;
                }
                // ���ö����������list����д�����ļ���
                oos = new ObjectOutputStream(new FileOutputStream(PathConstant.USER_PATH));
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

    // ��ʼ��ͼ������
    public static void initBook(List<Book> bookList) {
        ObjectOutputStream oos = null;
        try {
            // �����ļ���
            File directory = new File("book/");
            // �����ļ�
            File file = new File(PathConstant.BOOK_PATH);
            // �ж��ļ����Ƿ����
            if(!directory.exists()) {
                directory.mkdir();
            }
            // �ж��ļ��Ƿ����
            if(!file.exists()) {
                file.createNewFile();
                List<Book> list = new ArrayList<>();
                // �ж� bookList �Ƿ�Ϊ��
                if(bookList == null) {
                    list.add(new Book(1, "java���������", "�϶�", Constant.TYPE_COMPUTER, "123-1", "�����ڵ������", Constant.STATUS_STORAGE));
                } else {
                    list = bookList;
                }
                // ���ö����������list����д�����ļ���
                oos = new ObjectOutputStream(new FileOutputStream(PathConstant.USER_PATH));
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
