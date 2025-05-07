package com.ing.zoo;

import com.ing.zoo.animals.*;
import com.ing.zoo.commands.ZooCommandHandler;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Zoo {
    public static void main(String[] args) {
        List<Animal> animals = Arrays.asList(
                new Lion("henk"),
                new Zebra("marty"),
                new Hippo("elsa"),
                new Tiger("wally"),
                new Pig("dora")
        );

        Scanner scanner = new Scanner(System.in);

        ZooCommandHandler handler = new ZooCommandHandler(animals);

        while (true) {
            System.out.print("Voer uw command in (exit om te stoppen): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) break;
            handler.handleCommand(input);
        }
    }
}
