package com.ing.zoo.animals;

public class Lion extends Animal implements Carnivore {
    public Lion(String name) {
        this.name = name;
        this.helloText = "roooooaaaaar";
    }

    @Override
    public void sayHello() {
        super.sayHello();
    }

    @Override
    public String getEatText() {
        return "nomnomnom thx mate";
    }
}
