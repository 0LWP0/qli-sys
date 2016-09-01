package com.example;

/**
 * Created by qli on 16/8/29.
 */
public class MainClass {

    public static void main(String[] args) {
        MyClass myClassTwo = new MyClass("one");
        MyClass myClassTwo2 = new MyClass("two");
        MyClass myClassTwo3 = new MyClass("tress");
        MyClass myClassTwo4 = new MyClass("four");


        MyClassTwo myClassTwo1 = new MyClassTwo();
        myClassTwo1.addObserver(myClassTwo);
        myClassTwo1.addObserver(myClassTwo2);

        myClassTwo1.addObserver(myClassTwo3);
        myClassTwo1.addObserver(myClassTwo4);

        myClassTwo1.post("wwww");
    }
}
