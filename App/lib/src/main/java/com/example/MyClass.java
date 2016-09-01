package com.example;

import java.util.Observable;
import java.util.Observer;

public class MyClass implements Observer {

    //    public static void main(String[] args) {
//        System.out.print("ggg");
//    }
    private String name;

    public MyClass(String s) {
        this.name = s;
    }

    @Override
    public void update(Observable o, Object arg) {

        System.out.println("MyClassTwo" + "数据更新" + name);

    }

    @Override
    public String toString() {
        return name;
    }
}
