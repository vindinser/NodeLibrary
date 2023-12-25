# 目录

- [NodeLibrary](#nodelibrary)
- [登录功能](#登录功能)
- [快捷键](#快捷键)
- [分层思想](#分层思想)
- [用户管理](#用户管理)

## NodeLibrary

作者：ZhangShuang

版本：1.0.0

版权：ZhangShuang

### 基本信息

- 图书管理
- JDK版本 8
- 项目编码 GBK
- 使用技术
    - JavaSE
      - 面向对象思想
      - 分层思想
      - 接口
      - 异常
      - 集合
      - 日期处理
      - Stream流
      - IO流
      - 反射
    - Javafx
    - css
    - Jfoenix：提供美观的UI控件
    - Dashboardfx：组合UI控件，构成仪表盘
- 项目结构
    ``` java
        .
	    ├── admin                       // 存放账户密码
	    ├── lib                         // 项目中依赖的 jar 包
	    ├── src                         // 目录
	    │  ├── bean                     // 存放实体类的包
	    │  │  ├── Admin                 // 存放账户密码
	    │  │  ├── Book                  // 存放书籍的类
	    │  │  ├── Constant              // 常量
	    │  │  ├── Lend                  // 借阅相关的类
	    │  │  └── User                  // 用户相关的类
	    │  ├── global                   // 存放了一些全局使用的类
	    │  ├── media.img                // 存放一些图片
	    │  ├── module                   // 存放界面相关的类
	    │  ├── service                  // 存放服务相关类
	    │  ├── theme                    // 存放美化界面相关的文件
	    │  ├── until                    // 存放工具类
	    │  ├── dao                      // 存放接口
	    │  │  ├── imp                   // 实现类（implement）
	    │  │  └── UserDao               // 查询用户
	    └──└── App                      // 主类
    ```

### 登录功能

### 分层思想

> 在Java后端开发中，DAO（Data Access Object）层主要负责与数据库进行交互，封装了数据库操作的具体细节。而Service层则是面向业务逻辑的，对外提供业务操作的接口，同时负责调用DAO进行数据的读取和保存。 DAO和Service是紧密相连的，并且共同构成了整个系统的业务实现。目前，很多Java框架都采用了这两层分离的思想，比如Spring和Hibernate。

- controller（请求处理层）：负责与界面数据进行交互处理
- service（业务逻辑层）：负责业务逻辑相关处理
  - Service层主要由业务逻辑接口和其对应的实现类组成。业务逻辑接口中定义了具体业务逻辑需要实现的方法，实现类中根据逻辑需求调用DAO层进行数据读取和保存。
- DAO（数据持久层）：负责数据持久化操作，DAO的全称是Data Access Object
  - DAO层主要由数据访问接口和其对应的实现类组成。接口中定义了数据库访问的方法，实现类则是具体实现这些方法。通常情况下，DAO层的实现会依赖于某种数据持久化框架，比如Hibernate ORM。 

**在Service层中注入DAO层的实现类，使用DAO层的方法对数据进行操作。这种方式封装了数据访问操作，使代码更加简洁和易懂。**

### 快捷键

快捷键 | 作用
- | -
ctrl+alt+u | 查看继承结构图
ctrl+alt+t | 捕获异常
ctrl+o | 重写方法

### 用户管理

- 初始化用户数据
    - 由于 存放用户的文件需要经常使用，所以创建 常量 来进行存储路径
- 用户查询操作
    ``` powershell
        # writing aborted; java.io.NotSerializableException: com.bjpowernode.bean.User
        public class User implements Serializable {
        # java.io.InvalidClassException: com.bjpowernode.bean.User; local class incompatible: stream classdesc serialVersionUID = 8610945373491150863, local class serialVersionUID = 3415128512889338154
        # 版本序列号改变，User中添加 private static final long serialVersionUID = 1L;
    ```
