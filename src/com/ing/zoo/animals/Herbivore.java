package com.ing.zoo.animals;

public interface Herbivore {
    String getEatText();

    default void eatLeaves() {
        System.out.println(getEatText());
    }
}
