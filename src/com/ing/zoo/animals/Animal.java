package com.ing.zoo.animals;

public abstract class Animal {
    protected String name;
    protected String helloText;
    protected String trick;

    public void sayHello(){
        System.out.println(helloText);
    }

    public void performTrick(){
        System.out.println(trick);
    }

    public String getName() {
        return name;
    }

    public String getTrick() {
        return trick;
    }
}
