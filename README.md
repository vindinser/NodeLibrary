# 目录

- [NodeLibrary](#nodelibrary)
- [登录功能](#登录功能)

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
	    └──└──  App                     // 主类
    ```

### 登录功能

### 分层思想

- controller（请求处理层）：负责与界面数据进行交互处理
- service（业务逻辑层）：负责业务逻辑相关处理
- DAO（数据持久层）：负责数据持久化操作，DAO的全称是Data Access Object

