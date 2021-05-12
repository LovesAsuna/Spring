package me.lovesasuna.spring.beans.factory;

/**
 * @author LovesAsuna
 **/
public interface BeanFactory {

    /**
     * 返回对应name的Bean对象
     *
     * @param name Bean的名字
     * @return 对应的Bean对象
     **/
    Object getBean(String name) throws Exception;

    /**
     * 返回具有确切类型的对应name的Bean对象
     *
     * @param name Bean的名字
     * @param clazz 对应Bean对象的class
     * @return 对应的Bean对象
     **/
    <T> T getBean(String name, Class<T> clazz) throws Exception;
}
