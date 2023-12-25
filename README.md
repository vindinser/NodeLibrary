# Ŀ¼

- [NodeLibrary](#nodelibrary)
- [��¼����](#��¼����)
- [��ݼ�](#��ݼ�)
- [�ֲ�˼��](#�ֲ�˼��)
- [�û�����](#�û�����)

## NodeLibrary

���ߣ�ZhangShuang

�汾��1.0.0

��Ȩ��ZhangShuang

### ������Ϣ

- ͼ�����
- JDK�汾 8
- ��Ŀ���� GBK
- ʹ�ü���
    - JavaSE
      - �������˼��
      - �ֲ�˼��
      - �ӿ�
      - �쳣
      - ����
      - ���ڴ���
      - Stream��
      - IO��
      - ����
    - Javafx
    - css
    - Jfoenix���ṩ���۵�UI�ؼ�
    - Dashboardfx�����UI�ؼ��������Ǳ���
- ��Ŀ�ṹ
    ``` java
        .
	    ������ admin                       // ����˻�����
	    ������ lib                         // ��Ŀ�������� jar ��
	    ������ src                         // Ŀ¼
	    ��  ������ bean                     // ���ʵ����İ�
	    ��  ��  ������ Admin                 // ����˻�����
	    ��  ��  ������ Book                  // ����鼮����
	    ��  ��  ������ Constant              // ����
	    ��  ��  ������ Lend                  // ������ص���
	    ��  ��  ������ User                  // �û���ص���
	    ��  ������ global                   // �����һЩȫ��ʹ�õ���
	    ��  ������ media.img                // ���һЩͼƬ
	    ��  ������ module                   // ��Ž�����ص���
	    ��  ������ service                  // ��ŷ��������
	    ��  ������ theme                    // �������������ص��ļ�
	    ��  ������ until                    // ��Ź�����
	    ��  ������ dao                      // ��Žӿ�
	    ��  ��  ������ imp                   // ʵ���ࣨimplement��
	    ��  ��  ������ UserDao               // ��ѯ�û�
	    ������������ App                      // ����
    ```

### ��¼����

### �ֲ�˼��

> ��Java��˿����У�DAO��Data Access Object������Ҫ���������ݿ���н�������װ�����ݿ�����ľ���ϸ�ڡ���Service����������ҵ���߼��ģ������ṩҵ������Ľӿڣ�ͬʱ�������DAO�������ݵĶ�ȡ�ͱ��档 DAO��Service�ǽ��������ģ����ҹ�ͬ����������ϵͳ��ҵ��ʵ�֡�Ŀǰ���ܶ�Java��ܶ�����������������˼�룬����Spring��Hibernate��

- controller��������㣩��������������ݽ��н�������
- service��ҵ���߼��㣩������ҵ���߼���ش���
  - Service����Ҫ��ҵ���߼��ӿں����Ӧ��ʵ������ɡ�ҵ���߼��ӿ��ж����˾���ҵ���߼���Ҫʵ�ֵķ�����ʵ�����и����߼��������DAO��������ݶ�ȡ�ͱ��档
- DAO�����ݳ־ò㣩���������ݳ־û�������DAO��ȫ����Data Access Object
  - DAO����Ҫ�����ݷ��ʽӿں����Ӧ��ʵ������ɡ��ӿ��ж��������ݿ���ʵķ�����ʵ�������Ǿ���ʵ����Щ������ͨ������£�DAO���ʵ�ֻ�������ĳ�����ݳ־û���ܣ�����Hibernate ORM�� 

**��Service����ע��DAO���ʵ���࣬ʹ��DAO��ķ��������ݽ��в��������ַ�ʽ��װ�����ݷ��ʲ�����ʹ������Ӽ����׶���**

### ��ݼ�

��ݼ� | ����
- | -
ctrl+alt+u | �鿴�̳нṹͼ
ctrl+alt+t | �����쳣
ctrl+o | ��д����

### �û�����

- ��ʼ���û�����
    - ���� ����û����ļ���Ҫ����ʹ�ã����Դ��� ���� �����д洢·��
- �û���ѯ����
    ``` powershell
        # writing aborted; java.io.NotSerializableException: com.bjpowernode.bean.User
        public class User implements Serializable {
        # java.io.InvalidClassException: com.bjpowernode.bean.User; local class incompatible: stream classdesc serialVersionUID = 8610945373491150863, local class serialVersionUID = 3415128512889338154
        # �汾���кŸı䣬User����� private static final long serialVersionUID = 1L;
    ```
