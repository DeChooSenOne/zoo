package com.ing.zoo.animals;

import java.util.Random;

public class Tiger extends Animal implements Carnivore {
    public Tiger(String name) {
        this.name = name;
        this.helloText = "rraaarww";
    }

    @Override
    public void sayHello() {
        super.sayHello();
    }

    @Override
    public String getEatMeatText() {
        return "nomnomnom oink wubalubadubdub";
    }

    @Override
    public boolean canPerformTrick() {
        return true;
    }

    @Override
    public void performTrick() {
        Random random = new Random();
        String generatedTrick = random.nextInt(2) == 0
                ? "jumps in tree"
                : "scratches ears";
        System.out.println(generatedTrick);
    }
}
