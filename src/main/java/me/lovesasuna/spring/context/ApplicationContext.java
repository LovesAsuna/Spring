package me.lovesasuna.spring.context;

import me.lovesasuna.spring.beans.factory.BeanFactory;

/**
 * @author LovesAsuna
 **/
public interface ApplicationContext extends BeanFactory {

    void refresh() throws Exception;
}
