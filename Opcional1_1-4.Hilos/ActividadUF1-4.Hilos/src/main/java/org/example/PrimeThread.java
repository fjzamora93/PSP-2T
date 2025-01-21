package org.example;

/**
 * Clase que representa un hilo que verifica si un número es primo.
 */
class PrimeThread extends Thread {
    private final int number;
    private final boolean saveToFile;

    public PrimeThread(int number, boolean saveToFile) {
        this.number = number;
        this.saveToFile = saveToFile;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        boolean isPrime = isPrime(number);
        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;

        DisplayResult result = new DisplayResult(number, getName(), isPrime, timeTaken);
        System.out.println(result);

        if (saveToFile) {
            result.saveToFile();
        }
    }

    /** Fórmula matemática facilitada por CHatGpt (ni me acordaba de que el 1 no era un número primo)*/
    private boolean isPrime(int number) {
        if (number <= 1) return false;
        if (number == 2) return true;
        if (number % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
