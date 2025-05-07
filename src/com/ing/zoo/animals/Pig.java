package com.ing.zoo.animals;

import java.util.Random;

public class Pig extends Animal implements Herbivore, Carnivore {
    public Pig(String name) {
        this.name = name;
        this.helloText = "splash";
    }

    @Override
    public void sayHello() {
        super.sayHello();
    }

    @Override
    public String getEatMeatText() {
        return "nomnomnom oink thx";
    }

    @Override
    public String getEatLeavesText() {
        return "munch munch oink";
    }

    @Override
    public boolean canPerformTrick() {
        return true;
    }

    @Override
    public void performTrick() {
        Random random = new Random();
        String generatedTrick = random.nextInt(2) == 0
                ? "rolls in the mud"
                : "runs in circles";
        System.out.println(generatedTrick);
    }
}
