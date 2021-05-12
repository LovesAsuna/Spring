package me.lovesasuna.spring.beans.factory.xml;

import me.lovesasuna.spring.beans.BeanDefinition;
import me.lovesasuna.spring.beans.MutablePropertyValues;
import me.lovesasuna.spring.beans.PropertyValue;
import me.lovesasuna.spring.beans.factory.support.BeanDefinitionReader;
import me.lovesasuna.spring.beans.factory.support.BeanDefinitionRegistry;
import me.lovesasuna.spring.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

/**
 * @author LovesAsuna
 **/
public class XmlBeanDefinitionReader implements BeanDefinitionReader {

    private BeanDefinitionRegistry registry;

    public XmlBeanDefinitionReader() {
        registry = new SimpleBeanDefinitionRegistry();
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public void loadBeanDefinitions(String configLocation) throws Exception {
        SAXReader reader = new SAXReader();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(configLocation);
        Document document = reader.read(inputStream);
        Element rootElement = document.getRootElement();
        List<Element> beanElements = rootElement.elements("bean");
        for (Element beanElement : beanElements) {
            String id = beanElement.attributeValue("id");
            String className = beanElement.attributeValue("class");
            BeanDefinition beanDefinition = new BeanDefinition();
            beanDefinition.setId(id);
            beanDefinition.setClassName(className);

            MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
            List<Element> propertyElements = beanElement.elements("property");
            for (Element propertyElement : propertyElements) {
                String name = propertyElement.attributeValue("name");
                String ref = propertyElement.attributeValue("ref");
                String value = propertyElement.attributeValue("value");
                PropertyValue propertyValue = new PropertyValue(name, ref, value);
                mutablePropertyValues.addPropertyValue(propertyValue);
            }
            beanDefinition.setPropertyValues(mutablePropertyValues);
            registry.registerBeanDefinition(id, beanDefinition);
        }
    }
}
