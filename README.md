# Spring
> 结合学习的23种设计模式来自定义一个简单的Spring框架

## 主要实现的Spring框架部分为以下两个
* Spring Core
* Spring Context

## 项目主要用的设计模式
* 工厂模式: 采用工厂模式+配置文件实现
* 单例模式: Spring IOC管理的Bean对象都是单例的，此处的单例不是通过构造器进行单例的控制，而是Spring框架对每一个Bean只创建了一个对象
* 模板方法模式: AbstractApplicationContext类中的finishBeanInitialization方法调用了子类的getBean方法，其实现延迟到了子类进行
* 迭代器模式: MutablePropertyValue类定义了迭代器模式，因此此类存储冰管理PropertyValue对象，也属于一个容器，因此给该容器提供一个遍历方式

> Spring框架还使用到了很多设计模式，如AOP使用到了代理模式，选择JDK代理或CGLib代理则使用了策略模式，还有适配器模式，装饰器模式，观察者模式等
