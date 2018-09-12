package com.arka.shubhamsharma.annotations.field;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
public class JsonSerializer {
    private static String getSerializedKey(Field field) {
        String annotationValue = field.getAnnotation(JsonField.class).value();
        if (annotationValue.isEmpty()) {
            return field.getName();
        } else {
            return annotationValue;
        }
    }

    public String serialize(Object object) throws JsonSerializeException {
        try {
            Class<?> objectClass = requireNonNull(object).getClass();
            Map<String, String> jsonElements = new HashMap<>();
            for (Field field : objectClass.getDeclaredFields()) {

                field.setAccessible(true);
                if (field.isAnnotationPresent(JsonField.class)) {
                    jsonElements.put(getSerializedKey(field), (String) field.get(object));
                } else if (field.isAnnotationPresent(IgnoreMe.class)) {

                } else {
                    jsonElements.put(field.getName(), (String) field.get(object));
                }
            }
            System.out.println(toJsonString(jsonElements));
            return toJsonString(jsonElements);
        } catch (IllegalAccessException e) {
            throw new JsonSerializeException(e.getMessage());
        }
    }

    private Object requireNonNull(Object object) {
        if (object == null) {
            throw new NullPointerException();
        } else {
            return object;
        }

    }

    private String toJsonString(Map<String, String> jsonMap) {


        StringBuilder elementsString = new StringBuilder();
        for (Map.Entry<String, String> entry : jsonMap.entrySet())
            elementsString.append("\"").append(entry.getKey()).append("\":\"").append(entry.getValue()).append("\"");
        return "{" + elementsString + "}";
    }
}