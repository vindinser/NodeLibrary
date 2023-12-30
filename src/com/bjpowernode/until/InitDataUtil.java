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
        // initUser(null);
        // initBook(null);

        // ��ʼ���û�����
        List<User> userList = new ArrayList<>();
        userList.add(new User(1001, "�Ŵ�", Constant.USER_OK, BigDecimal.TEN));
        initData(PathConstant.USER_PATH, userList);

        // ��ʼ��ͼ������
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book(1, "java���������", "�϶�", Constant.TYPE_COMPUTER, "2023-1", "�����ڵ������", Constant.STATUS_STORAGE));
        bookList.add(new Book(2, "JavaSE����", "�϶�", Constant.TYPE_COMPUTER, "2023-1", "�����ڵ������", Constant.STATUS_STORAGE));
        bookList.add(new Book(3, "MySQL���������", "�϶�", Constant.TYPE_COMPUTER, "2023-3", "�����ڵ������", Constant.STATUS_STORAGE));
        bookList.add(new Book(4, "JDBC���������", "�϶�", Constant.TYPE_COMPUTER, "2023-4", "�����ڵ������", Constant.STATUS_STORAGE));
        initData(PathConstant.BOOK_PATH, bookList);
    }

    /**
     * ��ʼ������
     * @param path д���ļ�·��
     * @param list д���ļ�����
     */
    public static void initData(String path, List<?> list) {
        ObjectOutputStream oos = null;
        try {
            // �����ļ���
            File directory = new File(path.split("/")[0] + "/");
            // �����ļ�
            File file = new File(path);
            // �ж��ļ����Ƿ����
            if(!directory.exists()) {
                directory.mkdir();
            }
            // �ж��ļ��Ƿ����
            if(!file.exists()) {
                file.createNewFile();
            }
            // ���ö����������list����д�����ļ���
            oos = new ObjectOutputStream(new FileOutputStream(path));
            oos.writeObject(list);
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
                oos = new ObjectOutputStream(new FileOutputStream(PathConstant.BOOK_PATH));
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
