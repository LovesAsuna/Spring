package me.lovesasuna.spring.beans.factory.support;

/**
 * 解析配置文件
 *
 * @author LovesAsuna
 **/
public interface BeanDefinitionReader {

    /**
     * 获取注册表对象
     *
     * @return 注册表
     **/
    BeanDefinitionRegistry getRegistry();

    /**
     * 加载配置文件并在注册表中注册
     *
     * @param configLocation 配置文件路径
     **/
    void loadBeanDefinitions(String configLocation) throws Exception;
}
