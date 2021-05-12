package me.lovesasuna.spring.beans;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 用于存储和管理多个PropertyValue对象
 *
 * @author LovesAsuna
 **/
public class MutablePropertyValues implements Iterable<PropertyValue> {

    // 存储多个PropertyValue对象
    private final List<PropertyValue> propertyValueList;

    public MutablePropertyValues() {
        this.propertyValueList = new ArrayList<>();
    }

    public MutablePropertyValues(List<PropertyValue> propertyValueList) {
        if (propertyValueList == null) {
            this.propertyValueList = new ArrayList<>();
        } else {
            this.propertyValueList = propertyValueList;
        }
    }

    /**
     * 以数组形式返回PropertyValues
     *
     * @return PropertyValue数组
     **/
    public PropertyValue[] getPropertyValues() {
        return propertyValueList.toArray(new PropertyValue[0]);
    }

    /**
     * 根据name属性值获取PropertyValue对象
     *
     * @param propertyName propertyName
     * @return PropertyValue
     **/
    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue propertyValue : propertyValueList) {
            if (propertyValue.getName().equals(propertyName)) {
                return propertyValue;
            }
        }
        return null;
    }

    /**
     * 判断集合是否为空
     *
     * @return boolean
     **/
    public boolean isEmpty() {
        return propertyValueList.isEmpty();
    }

    /**
     * 往集合中添加PropertyValue对象
     *
     * @param value PropertyValue对象
     * @return MutablePropertyValues 本身
     **/
    public MutablePropertyValues addPropertyValue(PropertyValue value) {
        // 判断是否重复
        for (int i = 0; i < propertyValueList.size(); i++) {
            PropertyValue currentValue = propertyValueList.get(i);
            if (currentValue.getName().equals(value.getName())) {
                // 覆盖
                propertyValueList.set(i, value);
                // 链式编程
                return this;
            }
        }
        propertyValueList.add(value);
        return this;
    }

    /**
     * 判断是否有指定name的PropertyValue对象
     *
     * @param propertyName propertyName
     * @return 操作是否成功
     **/
    public boolean contains(String propertyName) {
        return getPropertyValue(propertyName) != null;
    }

    @NotNull
    @Override
    public Iterator<PropertyValue> iterator() {
        return propertyValueList.iterator();
    }
}
