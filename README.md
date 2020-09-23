# demo1
# 入口启动：DemoApplication
目前分为几个层次
#1.bean 接收数据实体类与返回数据实体类
当前bean 类为 登录表 与 用户信息表 
#2. controller 实现请求接口类 主要是接收数据，处理数据，返回数据
#3.dao 具体数据库操作与SQL 拼接层
#4.returnDataUtils 封装 返回数据信息类 主要是错误信息或操作数据库返回的信息通过此类返回给客户端
application.properties sql 配置类
pom.xml 引用第三方库 maven  


