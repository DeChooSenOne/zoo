package com.ing.zoo.animals;

import java.util.Random;

public class Raccoon extends Animal implements Herbivore, Carnivore {
    public Raccoon(String name) {
        this.name = name;
        this.helloText = "roar screech screech";
    }

    @Override
    public void sayHello() {
        super.sayHello();
    }

    @Override
    public String getEatLeavesText() {
        return "scrunch scrunch screechhhhh";
    }

    @Override
    public String getEatMeatText() {
        return "roarr screech munch munch";
    }

    @Override
    public boolean canPerformTrick() {
        return true;
    }

    @Override
    public void performTrick() {
        Random random = new Random();
        String generatedTrick = random.nextInt(2) == 0
                ? "climbs into a trash can and digs through the trash"
                : "sits on its hind legs and waves its paws while doing the puppy eyes";

        System.out.println(generatedTrick);
    }
}
