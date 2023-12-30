# 目录

- [NodeLibrary](#nodelibrary)
- [登录功能](#登录功能)
- [快捷键](#快捷键)
- [分层思想](#分层思想)
- [用户管理](#用户管理)
- [图书管理](#图书管理)

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
    - DashboardFx：组合UI控件，构成仪表盘
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

| 快捷键        | 作用      |
|------------|---------|
| ctrl+alt+u | 查看继承结构图 |
| ctrl+alt+t | 捕获异常    |
| ctrl+o     | 重写方法    |

### 用户管理

- 初始化用户数据
    - 由于 存放用户的文件需要经常使用，所以创建 常量 来进行存储路径
- 用户查询操作
    ``` powershell
        # writing aborted; java.io.NotSerializableException: com.bjpowernode.bean.User
        # 通过IO流将List对象数据持久化到硬盘的文件中，List中存放的数据是User类型，所以要让User类实现Serializable接口。倘若我们要对某个类的对象进行IO操作时，别忘了让这个类实现Serializable接口。
        public class User implements Serializable {
        # java.io.InvalidClassException: com.bjpowernode.bean.User; local class incompatible: stream classdesc serialVersionUID = 8610945373491150863, local class serialVersionUID = 3415128512889338154
        # 版本序列号改变，User中添加 private static final long serialVersionUID = 1L;
    ```
> - 用户分层的使用：通过接口的使用可以提高代码的可插拔性，提高了程序的可维护性。
>> - controller： UserViewCtrl
>> - service：接口UserService，实现类UserServiceImpl
>> - dao：接口UserDao，实现类UserDaoImpl

- 用户添加

> - 在添加界面输入用户信息之后，点击提交按钮，会将用户对象传到service层，service层再调用DAO，在DAO中使用对象输入流将用户集合数据读到内存中，将新增的user对象存入集合里面，之后使用对象输出流将用户集合数据写出到硬盘文件中。
> - 在创建类似User这样的类时，我们通常会在里面添加一个id编号属性，目的是作为该对象的唯一标识，便于查询，修改，删除操作。为了保证id编号不重复，这里通过程序控制id编号自动增长，在多线程环境下需要注意线程安全的问题。

- 用户修改
> 点击修改按钮之后需要将当前选中的修改数据显示到修改界面中，修改界面里面要存储数据的编号id，这些数据传到DAO层之后，通过id在用户集合中找到相应的用户对象，从而进行修改操作。这里的修改界面跟添加界面使用的是同一个fxml

- 删除用户
    - 点击删除按钮之后将当前选中数据的id编号传到service层，service层将id传到DAO层，然后根据id从用户集合中找到对应的用户对象，将其从集合移除即可。需要注意的是用户类User中要重写hashcode和equals方法。
    - 我们在DAO层中使用了try  catch对异常进行了捕获，倘若DAO层出现了异常，其上层的service和controller中是不知道的，这里最好在DAO层的catch里面再抛出异常，目的是通知上层这里有异常，上层代码获取到异常之后再进行后续的处理。

- 冻结用户：点击冻结按钮之后，将当前选中的id编号传到DAO，然后再根据id从用户集合中找到对应用户对象，将该对象中的状态修改为冻结即可。
- 解除冻结用户：点击解除冻结按钮之后，将当前选中的id编号传到DAO，然后再根据id从用户集合中找到对应用户对象，将该对象中的状态修改为正常即可。

### 图书管理

- 图书数据初始化
  - 创建若干Book对象，将对象放入到List中，把List对象利用对象输出流写出到硬盘的文件中，总体功能与用户数据初始化操作类似。
  - 图书数据初始化和用户数据初始化类似，所以将两个方法进行重构，重构之后合并为一个方法。方法中添加两个形参，分别是String path（存放的路径）和List<?> list(存放的数据)。这里由于list中的泛型是不同的，所以不能在形参中填写具体的类型，这里我们使用了泛型通配符来解决该问题。