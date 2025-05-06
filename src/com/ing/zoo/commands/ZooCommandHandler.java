package com.ing.zoo.commands;

import com.ing.zoo.animals.Animal;
import com.ing.zoo.animals.Carnivore;
import com.ing.zoo.animals.Herbivore;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZooCommandHandler {
    private final Map<String, Runnable> commandMap = new HashMap<>();

    public ZooCommandHandler(List<Animal> animals) {
        List<Command> commands = Arrays.asList(
                new BasicCommand("hello", a -> a::sayHello),
                new CommandWithConditions(
                        "perform trick",
                        a -> a.getTrick() != null && !a.getTrick().trim().isEmpty(),
                        a -> a::performTrick,
                        a -> a.getName() + " can't perform any trick."
                ),
                new CommandWithConditions(
                        "give meat",
                        a -> a instanceof Carnivore,
                        a -> ((Carnivore) a)::eatMeat,
                        a -> a.getName() + " can't eat meat."
                ),
                new CommandWithConditions(
                        "give leaves",
                        a -> a instanceof Herbivore,
                        a -> ((Herbivore) a)::eatLeaves,
                        a -> a.getName() + " can't eat leaves."
                )
        );

        for (Animal animal : animals) {
            for (Command command : commands) {
                commandMap.put(command.getKey(animal), command.getAction(animal));
            }
        }
    }

    public void handleCommand(String input) {
        if (input == null || input.trim().isEmpty()) {
            System.out.println("Can't process empty command.\n");
            return;
        }

        Runnable action = commandMap.get(input.toLowerCase().trim());
        if (action != null) {
            action.run();
            System.out.println();
        } else {
            System.out.println("Unknown command: " + input);
            System.out.println();
        }
    }
}
