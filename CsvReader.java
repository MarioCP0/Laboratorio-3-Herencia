import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase lee los datos de un archivo CSV y los muestra.
 */
public class CsvReader {

    /**
     * Punto de entrada del programa. Lee datos de un archivo CSV y los muestra.
     *
     * @param args Los argumentos de línea de comandos (no se utilizan en este programa).
     */
    public static void main(String[] args) {
        // Define la ruta al archivo CSV que se va a leer.
        String csvFilePath = "Mascotas.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            List<String[]> allData = new ArrayList<>();

            // Lee cada línea del archivo CSV y la almacena como un array de valores.
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                allData.add(values);
            }

            // Itera a través de la lista de datos y los muestra en la consola.
            for (String[] row : allData) {
                for (String cell : row) {
                    System.out.print(cell + "\t"); // Imprime cada celda separada por un tabulador.
                }
                System.out.println(); // Se mueve a la siguiente línea después de imprimir cada fila.
            }

        } catch (IOException e) {
            e.printStackTrace(); // Si ocurre una excepción durante el manejo del archivo, imprime la traza de pila para fines de depuración.
        }
    }
}
