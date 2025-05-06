package com.ing.zoo.commands;

import com.ing.zoo.animals.Animal;

import java.util.function.Function;

public class BasicCommand extends Command {
    private final Function<Animal, Runnable> action;

    public BasicCommand(String keyword, Function<Animal, Runnable> action) {
        super(keyword);
        this.action = action;
    }

    @Override
    public Runnable getAction(Animal animal) {
        return action.apply(animal);
    }
}