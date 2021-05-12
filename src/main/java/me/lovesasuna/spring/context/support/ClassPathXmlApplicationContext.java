package me.lovesasuna.spring.context.support;

import me.lovesasuna.spring.beans.BeanDefinition;
import me.lovesasuna.spring.beans.MutablePropertyValues;
import me.lovesasuna.spring.beans.PropertyValue;
import me.lovesasuna.spring.beans.factory.support.BeanDefinitionRegistry;
import me.lovesasuna.spring.beans.factory.xml.XmlBeanDefinitionReader;
import me.lovesasuna.spring.utils.StringUtil;

import java.lang.reflect.Method;

/**
 * 记载类路径下的XML格式的配置文件
 *
 * @author LovesAsuna
 **/
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

    public ClassPathXmlApplicationContext(String configLocation) {
        this.configLocation = configLocation;
        beanDefinitionReader = new XmlBeanDefinitionReader();
        try {
            refresh();
        } catch (Exception e) {

        }
    }

    @Override
    public Object getBean(String name) throws Exception {
        Object obj = singletonObjects.get(name);
        if (obj != null) {
            return obj;
        }
        BeanDefinitionRegistry registry = beanDefinitionReader.getRegistry();
        BeanDefinition beanDefinition = registry.getBeanDefinition(name);
        String className = beanDefinition.getClassName();
        Class<?> clazz = Class.forName(className);
        Object beanObj = clazz.getDeclaredConstructor().newInstance();

        MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
        for (PropertyValue propertyValue : propertyValues) {
            String propertyName = propertyValue.getName();
            String value = propertyValue.getValue();
            String ref = propertyValue.getRef();
            if (ref != null && !"".equals(ref)) {
                Object bean = getBean(ref);
                String methodName = StringUtil.getSetterMethodByFieldName(propertyName);
                Method[] methods = clazz.getMethods();
                for (Method method : methods) {
                    if (methodName.equals(method.getName())) {
                        method.setAccessible(true);
                        method.invoke(beanObj, bean);
                    }
                }
            }

            if (value != null && !"".equals(value)) {
                String methodName = StringUtil.getSetterMethodByFieldName(value);
                Method method = clazz.getDeclaredMethod(methodName, String.class);
                method.setAccessible(true);
                method.invoke(beanObj, value);
            }
        }

        singletonObjects.put(name, beanObj);
        return beanObj;
    }

    @Override
    public <T> T getBean(String name, Class<T> clazz) throws Exception {
        Object bean = getBean(name);
        if (bean == null) {
            return null;
        } else {
            return clazz.cast(bean);
        }
    }
}
