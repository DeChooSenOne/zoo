package com.ing.zoo.animals;

public interface Carnivore {
    String getEatText();

    default void eatMeat(){
        System.out.println(getEatText());
    }
}
