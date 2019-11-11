# 介绍

这是一个只用了一个阿里的fastjson和lombok实现的类似spring firework的ioc+aop（尚未完成）的框架。

# 如何开始

com.tt.fffffirework.example.IOCTest  是测试类直接跑main就可以看到效果

### 示例

```java
TTBeanFactory ttBeanFactory = new TTBeanFactory("target/classes/application.json");
Bean2 bean2 = (Bean2)ttBeanFactory.getBeanFromName("bean2");
```

这样就能获得到配置好的bean

# 待完成

本项目暂时只能，支持无参构造函数创建类，配置类里面嵌套的类，基本参数的注入尚未完成

