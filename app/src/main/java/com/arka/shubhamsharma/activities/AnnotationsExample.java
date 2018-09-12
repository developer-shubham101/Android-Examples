package com.arka.shubhamsharma.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class AnnotationsExample extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /*Car car = new Car("Ford", "F150", "2018");
        JsonSerializer serializer = new JsonSerializer();
        try {
            serializer.serialize(car);
        } catch (JsonSerializeException e) {
            e.printStackTrace();
        }*/


       /* BusinessLogic businessLogic = new BusinessLogic(5);
        try {
            TodoReport.getTodoReportForBusinessLogic(businessLogic);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }*/

        String s = "one";
        System.out.println("address 1 = " + Integer.toHexString(s.hashCode()));

        String s2 = "one";
        System.out.println("address 2 = " + Integer.toHexString(s2.hashCode()));


    }


}
