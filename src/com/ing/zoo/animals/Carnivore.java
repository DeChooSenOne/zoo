package com.ing.zoo.animals;

public interface Carnivore {
    String getEatMeatText();

    default void eatMeat(){
        System.out.println(getEatMeatText());
    }
}
