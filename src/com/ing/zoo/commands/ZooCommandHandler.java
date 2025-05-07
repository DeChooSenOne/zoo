package com.ing.zoo.commands;

import com.ing.zoo.animals.Animal;
import com.ing.zoo.animals.Carnivore;
import com.ing.zoo.animals.Herbivore;

import java.util.*;

public class ZooCommandHandler {
    private final Map<String, Runnable> commandMap = new HashMap<>();
    private final List<Animal> animals;

    public ZooCommandHandler(List<Animal> animals) {
        this.animals = animals;
        registerCommands();
    }

    public void handleCommand(String input) {
        if (input == null || input.trim().isEmpty()) {
            System.out.println("Can't process empty command.\n");
            return;
        }

        String[] parts = input.trim().toLowerCase().split(" ");
        String command = parts[0];
        String subcommand = parts.length > 1 ? parts[1] : null;

        Runnable action = commandMap.get(input.toLowerCase().trim());
        if (action != null) {
            action.run();
            System.out.println();
            return;
        }

        if (handleGroupCommand(command, subcommand)) return;

        System.out.println("Unknown command: " + input);
        System.out.println();
    }

    private void registerCommands() {
        List<Command> commands = Arrays.asList(
                new BasicCommand("hello", a -> a::sayHello),
                new BasicCommand("help", a -> this::printAvailableCommands),
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

    private boolean handleGroupCommand(String command, String subcommand) {
        switch (command) {
            case "give":
                if ("meat".equals(subcommand)) {
                    animals.stream()
                            .filter(a -> a instanceof Carnivore)
                            .forEach(a -> {
                                System.out.print(a.getName() + " says ");
                                ((Carnivore) a).eatMeat();
                            });
                    System.out.println();
                    return true;
                } else if ("leaves".equals(subcommand)) {
                    animals.stream()
                            .filter(a -> a instanceof Herbivore)
                            .forEach(a -> {
                                System.out.print(a.getName() + " says ");
                                ((Herbivore) a).eatLeaves();
                            });
                    System.out.println();
                    return true;
                } else {
                    System.out.println("Unknown give command: give " + subcommand);
                    System.out.println();
                    return true;
                }

            case "perform":
                if ("trick".equals(subcommand)) {
                    animals.stream()
                            .filter(Animal::canPerformTrick)
                            .forEach(a -> {
                                System.out.print(a.getName() + " performs ");
                                a.performTrick();
                            });
                    System.out.println();
                } else {
                    System.out.println("Unknown perform command: perform " + subcommand);
                    System.out.println();
                }
                return true;

            default:
                return false;
        }
    }

        System.out.println();
    }
}
