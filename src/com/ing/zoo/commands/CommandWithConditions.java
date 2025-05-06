package com.ing.zoo.commands;

import com.ing.zoo.animals.Animal;

import java.util.function.Function;
import java.util.function.Predicate;

public class CommandWithConditions extends Command {
    private final Predicate<Animal> condition;
    private final Function<Animal, Runnable> validAction;
    private final Function<Animal, String> fallbackMessage;

    public CommandWithConditions(String keyword,
                              Predicate<Animal> condition,
                              Function<Animal, Runnable> validAction,
                              Function<Animal, String> fallbackMessage) {
        super(keyword);
        this.condition = condition;
        this.validAction = validAction;
        this.fallbackMessage = fallbackMessage;
    }

    @Override
    public Runnable getAction(Animal animal) {
        if (condition.test(animal)) {
            return validAction.apply(animal);
        } else {
            return () -> System.out.println(fallbackMessage.apply(animal));
        }
    }
}
