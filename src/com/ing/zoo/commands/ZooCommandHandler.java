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
    private final List<Animal> animals;

    public ZooCommandHandler(List<Animal> animals) {
        this.animals = animals;

        List<Command> commands = Arrays.asList(
                new BasicCommand("hello", a -> a::sayHello),
                new CommandWithConditions(
                        "perform trick",
                        Animal::canPerformTrick,
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

        String[] parts = input.trim().toLowerCase().split(" ");
        String command = parts[0];
        String subcommand = parts.length > 1 ? parts[1] : null;

        if (subcommand == null) {
            if ("hello".equals(command)) {
                animals.forEach(a -> {
                    System.out.print(a.getName() + " says ");
                    a.sayHello();
                });
            } else {
                System.out.println("Unknown command: " + input);
            }
            System.out.println();
            return;
        }

        switch (command) {
            case "give":
                if ("meat".equals(subcommand)) {
                    animals.stream()
                            .filter(a -> a instanceof Carnivore)
                            .forEach(a -> {
                                System.out.print(a.getName() + " says ");
                                ((Carnivore) a).eatMeat();
                            });
                } else if ("leaves".equals(subcommand)) {
                    animals.stream()
                            .filter(a -> a instanceof Herbivore)
                            .forEach(a -> {
                                System.out.print(a.getName() + " says ");
                                ((Herbivore) a).eatLeaves();
                            });
                } else {
                    System.out.println("Unknown give command: " + input);
                }
                break;

            case "perform":
                if ("trick".equals(subcommand)) {
                    animals.stream()
                            .filter(Animal::canPerformTrick)
                            .forEach(a -> {
                                System.out.print(a.getName() + " performs ");
                                a.performTrick();
                            });
                } else {
                    System.out.println("Unknown perform command: " + input);
                }
                break;

            default:
                Runnable action = commandMap.get(input.toLowerCase().trim());
                if (action != null) {
                    action.run();
                } else {
                    System.out.println("Unknown command: " + input);
                }
        }

        System.out.println();
    }
}
