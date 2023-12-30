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

    // 初始化用户数据
    public static void initUser(List<User> userList) {
        ObjectOutputStream oos = null;
        try {
            // 创建文件夹
            File directory = new File("user/");
            // 创建文件
            File file = new File(PathConstant.USER_PATH);
            // 判断文件夹是否存在
            if(!directory.exists()) {
                directory.mkdir();
            }
            // 判断文件是否存在
            if(!file.exists()) {
                file.createNewFile();
                List<User> list = new ArrayList<>();
                // 判断userList是否为空
                if(userList == null) {
                    list.add(new User(1001, "张大虎", Constant.USER_OK, BigDecimal.TEN));
                } else {
                    list = userList;
                }
                // 利用对象输出流将list数据写出到文件中
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

    // 初始化图书数据
    public static void initBook(List<Book> bookList) {
        ObjectOutputStream oos = null;
        try {
            // 创建文件夹
            File directory = new File("book/");
            // 创建文件
            File file = new File(PathConstant.BOOK_PATH);
            // 判断文件夹是否存在
            if(!directory.exists()) {
                directory.mkdir();
            }
            // 判断文件是否存在
            if(!file.exists()) {
                file.createNewFile();
                List<Book> list = new ArrayList<>();
                // 判断 bookList 是否为空
                if(bookList == null) {
                    list.add(new Book(1, "java零基础入门", "老杜", Constant.TYPE_COMPUTER, "123-1", "动力节点出版社", Constant.STATUS_STORAGE));
                } else {
                    list = bookList;
                }
                // 利用对象输出流将list数据写出到文件中
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
