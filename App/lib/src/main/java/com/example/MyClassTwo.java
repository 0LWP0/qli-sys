package com.example;

import java.util.Observable;

/**
 * Created by qli on 16/8/29.
 */
public class MyClassTwo extends Observable{

    public void post(String context){
        setChanged();

        notifyObservers(context);

    }
}
