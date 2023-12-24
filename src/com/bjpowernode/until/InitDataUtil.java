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

    // 初始化用户数据
    public static void initUser(List<User> userList) {
        ObjectOutputStream oos = null;
        try {
            // 创建文件夹
            File directory = new File("user/");
            // 创建文件
            File file = new File("user/user.txt");
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
                    list.add(new User(1001, "张大虎", "正常", BigDecimal.TEN));
                } else {
                    list = userList;
                }
                // 利用对象输出流将list数据写出到文件中
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
