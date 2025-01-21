package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
/**
 * CLase que simplemente muestra los resultados y guarda los resultados en un fichero.
 */
class DisplayResult {
    private final int number;
    private final String threadName;
    private final boolean isPrime;
    private final long timeTaken;

    public DisplayResult(int number, String threadName, boolean isPrime, long timeTaken) {
        this.number = number;
        this.threadName = threadName;
        this.isPrime = isPrime;
        this.timeTaken = timeTaken;
    }

    @Override
    public String toString() {
        return "Número: " + number +
                ", NOmbre del proceso: " + threadName +
                ", ¿Es primo?: " + (isPrime) +
                ", Tiempo de precesamiento: " + timeTaken + "ms";
    }


    /**Los resultados se guardarán resources*/
    public void saveToFile() {
        String currentDir = Paths.get("").toAbsolutePath().toString();
        String filePath = Paths.get(currentDir, "src", "main", "resources", "resultado_" + threadName+ ".txt").toString();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(filePath), true))) {
            writer.write(this.toString());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo: " + e.getMessage());
        }
    }
}