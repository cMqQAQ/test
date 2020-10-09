## 接口代码模板

## 更新说明

### v1.1.1（2020-09-10）

1. 修复oracle初始化脚本报错BUG。
2. 增加日志归档和定时清除功能。
3. 打包文件中增加日志配置文件。

### v1.1.0（2020-07-28）

1. 增加内存限制，在新版服务管理工具可动态修改服务运行内存。
2. 启用moduleCode字段，定时任务和日志以moduleCode作为条件进行区分。
3. 修复日志查询开始时间不生效BUG。

### 1. 克隆仓库
```shell script
git clone http://10.0.2.104/common/interface-template.git
```

### 2. 初始化数据库

执行`sql`下对应数据库类型-interface.sql脚本

### 3. 工程目录说明
```
interface-template
│
├─sql            数据库初始化脚本
│
│ 
├─src/com.jfsoft.interfaces
│    │ 
│    ├─business         业务代码
│    │ 
│    ├─config           全局配置
│    │ 
│    ├─core             核心业务代码
│    │ 
│    ├─http             http类业务
│    │ 
│    ├─task             定时任务
│    │ 
│    ├─utils            工具
│    │ 
│    └─webservice       webservice类业务
│   
└─reources              资源文件
```

### 4. 业务开发

#### Http 类业务

**服务端**：直接在business包内开发即可。

**客户端**：多为定时任务，具体参考定时任务。

- WebService 类业务

**服务端**：

参考business\下DemoServie


**客户端**：多为定时任务，具体参考定时任务。

[下载CXF客户端工具](http://10.0.2.200:9527/help/static//20200402/apache-cxf-3.2.12.zip)
```
wsdl2java -p com.jfsoft.interfaces.webservice.client -d E:\webservice-client\src -client http://10.0.2.72:9008/webservice/demo?wsdl
```

生成代码后复制到`com.jfsoft.interfaces/webservice/client/业务包/`下

#### 定时任务

具体参考`task`包下的`DemoTask.java`

**注意**：初始化定时任务表后，要保证interface_scheduled_task表中的task_key和项目中`core/scheduled/ScheduledTaskEnum.java`中的任务列表一一对应

#### 日志

**要求**：`interface_log`表中每个字段都尽可能填值。

### 5. 服务管理

```shell script
http://127.0.0.1:9008
```

### 6. 发布
依次修改APP_NAME内容,保证各处APP_NAME一致

1. 修改 `pom.xml` 中 `app.name`的值

2. 修改 `bin` 目录下 `startup.bat`、`debug.bat`、`debug_local.bat` 中的APP_NAME的值

3. 修改 `logback-spring.xml` 中 `LOG_HOME`和`LOG_NAME`的值



### 7. 相关文档

[Mybatis-plus](https://mp.baomidou.com/)

[Hutool](https://hutool.cn/docs/#/)

[SpringBoot2.1.6 整合CXF 实现Webservice](https://blog.csdn.net/Lan_Xuan/article/details/94061194)


### 注意事项

1. 程序在测试上线后需上传代码到`http://10.0.2.104/interfaces`组织中，仓库简介格式 接口名称-开发：[开发工程师姓名]-实施:[实施工程师姓名]-开发时间:[开发时间]

2. 相应接口文档需放在`docs`文件夹，视图文件需要放在`sql`文件夹下

3. 代码方法上应标注接口文档具体对应的章节
