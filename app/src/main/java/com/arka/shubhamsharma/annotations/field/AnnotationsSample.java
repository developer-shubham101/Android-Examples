package com.arka.shubhamsharma.annotations.field;

import com.arka.shubhamsharma.annotations.field.Car;
import com.arka.shubhamsharma.annotations.field.JsonSerializeException;
import com.arka.shubhamsharma.annotations.field.JsonSerializer;

public class AnnotationsSample {

    protected void execute() {
        Car car = new Car("Ford", "F150", "2018");
        JsonSerializer serializer = new JsonSerializer();
        try {
            serializer.serialize(car);
        } catch (JsonSerializeException e) {
            e.printStackTrace();
        }
    }
}
