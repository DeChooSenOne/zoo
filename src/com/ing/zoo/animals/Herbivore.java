package com.ing.zoo.animals;

public interface Herbivore {
    String getEatLeavesText();

    default void eatLeaves() {
        System.out.println(getEatLeavesText());
    }
}
