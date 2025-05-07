package com.ing.zoo.animals;

public class Hippo extends Animal implements Herbivore {
    public Hippo(String name) {
        this.name = name;
        this.helloText = "splash";
    }

    @Override
    public void sayHello() {
        super.sayHello();
    }

    @Override
    public String getEatLeavesText() {
        return "munch munch lovely";
    }

}
