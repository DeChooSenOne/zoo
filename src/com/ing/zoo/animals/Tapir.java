package com.ing.zoo.animals;

public class Tapir extends Animal implements Herbivore {
    public Tapir(String name) {
        this.name = name;
        this.helloText = "squeak squeak";
    }

    @Override
    public void sayHello() {
        super.sayHello();
    }

    @Override
    public String getEatLeavesText() {
        return "munch squeakkkkkk munch";
    }

    @Override
    public boolean canPerformTrick() {
        return true;
    }

    @Override
    public void performTrick() {
        System.out.println("whips trunk around");
    }
}
