package me.lovesasuna.spring.beans;

/**
 * 封装Bean标签下的property标签的属性
 *
 * @author LovesAsuna
 **/
public class PropertyValue {

    private String name;
    private String ref;
    private String value;

    public PropertyValue(String name, String ref, String value) {
        this.name = name;
        this.ref = ref;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
