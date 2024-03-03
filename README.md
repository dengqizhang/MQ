# RabbitMQ在微服务场景下的使用

- 使用说明：    
拉取本项目后配置环境如下    
maven ： 3.6.0
jdk ： 17

- 项目描述
该项目可以学习RabbitMQ在微服务场景下的应用，并且了解AOP编程自定义注解的技术。

- 关键元素
项目用于SpringCloudAlibaba生态，集成了nacos，openfeign，RabbitMQ，SpringAMQP。       
并使用了AOP技术完成方法的日志打印逻辑耗时，数据库使用了mysql，mybatis。

- 使用项目
配置完环境后更新依赖，配置数据库连接信息，并启动nacos完成服务发现注册，启动RabbitMQ的后台。     
根据po创建数据库表



- 示例代码及片段

在未引入RabbitMQ时，该接口的业务逻辑执行为4500毫秒
```
2024-03-03 22:55:52.632  INFO 5072 --- [nio-7100-exec-1] c.e.demo.utility.LogExecutionTimeAspect  : 方法耗时：4514
```
引入RabbitMQ后，接口方法执行耗时为348毫秒
```
2024-03-03 22:56:57.827  INFO 12648 --- [nio-7100-exec-1] c.e.demo.utility.LogExecutionTimeAspect  : 方法耗时：348
```


并在消费者成功获取到消息
```
object.queue接收到消息：{amount=1999.99, pid=1}
```