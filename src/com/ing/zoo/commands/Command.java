package com.ing.zoo.commands;

import com.ing.zoo.animals.Animal;

public abstract class Command {
    protected final String keyword;

    public Command(String keyword) {
        this.keyword = keyword.toLowerCase();
    }

    public String getKey(Animal animal) {
        return (keyword + " " + animal.getName()).toLowerCase();
    }

    public abstract Runnable getAction(Animal animal);
}