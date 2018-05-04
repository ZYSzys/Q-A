# Q & A 
灵感来自于知乎----乞丐版Q & A  
![登录页面](/assets/login.png)  
![注册页面](/assets/register.png)  
![首面](/assets/home.png)  
![回答页面](/assets/answer.png)  

## 使用技术
- 后端：MVC框架
- 前端：Bootstrap、jQuery、font-awesome、canvas......

## 运行环境
- IDE：IntelliJ IDEA
- 数据库：MySQL
- Java版本：9.0.4
- Tomcat版本：9

## 模块介绍

#### 1.登录模块  
* 普通用户登录
* 管理员登录 

#### 2.注册模块
#### 3.提问模块
#### 4.回答模块

## 下载运行

1. 下载到本地或`git clone git@github.com:ZYSzys/Q-A.git`  
2. 导入到IDEA中  
3. 将tomcat配置到项目中并开启mysql  
4. 更改[DBconn.java](/src/com/util/DBconn.java)下的`password`为自己机子的`mysql`密码  
5. 相继在`mysql`中执行[schema](/sql/schema.sql)、[data](/sql/data.sql)  
6. Build and Run


## Todolist：
* 后台管理