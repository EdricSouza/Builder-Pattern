package com.ucsal;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ReflectiveBuilder<T> {
    private Class<T> genericClass;
    private Map<String, Object> fieldsValues = new HashMap<>();

    public ReflectiveBuilder(Class<T> genericClass) {
        this.genericClass = genericClass;
    }
    public ReflectiveBuilder<T> with(String fieldName, Object value) {
        fieldsValues.put(fieldName,value);
        return this;
    }

    public T build() {
        try {
            T instance = genericClass.getDeclaredConstructor().newInstance();
            for (Map.Entry<String, Object> entry : fieldsValues.entrySet()) {
                String fieldName = entry.getKey();
                Object fieldValue = entry.getValue();

                Field field = genericClass.getDeclaredField(fieldName);

                field.setAccessible(true);

                field.set(instance, fieldValue);
            }
            return instance;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
