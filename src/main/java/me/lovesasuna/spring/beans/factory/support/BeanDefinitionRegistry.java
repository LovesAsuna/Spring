package me.lovesasuna.spring.beans.factory.support;

import me.lovesasuna.spring.beans.BeanDefinition;

/**
 * 注册表
 *
 * @author LovesAsuna
 **/
public interface BeanDefinitionRegistry {

    /**
     * 注册Bean对象到注册表中
     *
     * @param beanName       Bean的名称
     * @param beanDefinition Bean对象
     **/
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    /**
     * 从注册表移除指定名称的Bean对象
     *
     * @param beanName Bean的名称
     **/
    void removeBeanDefinition(String beanName);

    /**
     * 从注册表获取指定名称的Bean对象
     *
     * @param beanName Bean的名称
     * @return BeanDefinition
     **/
    BeanDefinition getBeanDefinition(String beanName) throws Exception;

    /**
     * 注册表中是否包含指定名称的Bean对象
     *
     * @param beanName Bean的名称
     * @return boolean
     **/
    boolean containsBeanDefinition(String beanName);

    /**
     * 返回注册表中Bean对象的数量
     *
     * @return boolean
     **/
    int getBeanDefinitionCount();

    /**
     * 返回注册表中Bean对象的名称集合
     *
     * @return 名称集合
     **/
    String[] getBeanDefinitionNames();
}
