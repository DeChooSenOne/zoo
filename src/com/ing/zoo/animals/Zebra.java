package com.ing.zoo.animals;

public class Zebra extends Animal implements Herbivore {
    public Zebra(String name) {
        this.name = name;
        this.helloText = "zebra zebra";
    }

    @Override
    public void sayHello() {
        super.sayHello();
    }

    @Override
    public String getEatLeavesText() {
        return "munch munch zank yee bra";
    }

}
