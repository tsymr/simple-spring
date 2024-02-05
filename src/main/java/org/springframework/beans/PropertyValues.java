package org.springframework.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * PropertyValues
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/2/5 10:12 AM
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue value){
        propertyValueList.add(value);
    }

    public PropertyValue[] getPropertyValueList() {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName){
        for (PropertyValue propertyValue : this.propertyValueList) {
            if(propertyValue.getName().equals(propertyName)){
                return  propertyValue;
            }
        }
        return null;
    }
}
