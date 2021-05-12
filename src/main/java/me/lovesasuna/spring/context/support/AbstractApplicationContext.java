package me.lovesasuna.spring.context.support;

import me.lovesasuna.spring.beans.factory.support.BeanDefinitionReader;
import me.lovesasuna.spring.beans.factory.support.BeanDefinitionRegistry;
import me.lovesasuna.spring.context.ApplicationContext;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author LovesAsuna
 **/
public abstract class AbstractApplicationContext implements ApplicationContext {

    protected BeanDefinitionReader beanDefinitionReader;

    protected Map<String, Object> singletonObjects = new ConcurrentHashMap<>();

    protected String configLocation;

    @Override
    public void refresh() throws Exception {
        beanDefinitionReader.loadBeanDefinitions(configLocation);
    }

    private void finishBeanInitialization() throws Exception {
        BeanDefinitionRegistry registry = beanDefinitionReader.getRegistry();
        String[] beanNames = registry.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            getBean(beanName);
        }
    }
}
