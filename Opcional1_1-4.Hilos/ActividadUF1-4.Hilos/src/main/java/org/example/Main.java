package org.example;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar 4 números al usuario
        int[] numbers = new int[4];
        System.out.println("Dame 4 números:");
        for (int i = 0; i < 4; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        // Cambiar a false si no se quiere guardar
        for (int number : numbers) {
            PrimeThread thread = new PrimeThread(number, true);
            thread.start();
        }


    }
}