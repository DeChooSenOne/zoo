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
                new Zebra("marty")
        );
//
//        Hippo elsa = new Hippo();
//        elsa.name = "elsa";
//        Pig dora = new Pig();
//        dora.name = "dora";
//        Tiger wally = new Tiger();
//        wally.name = "wally";

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
