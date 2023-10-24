import java.util.*;
import java.io.*;

public class SpaceUVGManager {
    private ArrayList<espacio> espacios;

    public SpaceUVGManager() {
        espacios = new ArrayList<>();
    }

    // Método para cargar espacios desde un archivo CSV
    public void cargarEspaciosDesdeCSV(String archivoCSV) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                espacio espacioObj = espacio.fromCSV(linea); // Cambia el nombre de la variable
                espacios.add(espacioObj);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para buscar un espacio por su ID
    public espacio buscarEspacioPorID(int id) {
        for (espacio espacio : espacios) {
            if (espacio.getID() == id) {
                return espacio;
            }
        }
        return null; // Espacio no encontrado
    }

    // Método para listar espacios de una categoría específica
    public ArrayList<espacio> listarEspaciosPorCategoria(String categoria) {
        ArrayList<espacio> espaciosCategoria = new ArrayList<>();
        for (espacio espacio : espacios) {
            if (espacio.getClass().getSimpleName().equalsIgnoreCase(categoria)) {
                espaciosCategoria.add(espacio);
            }
        }
        return espaciosCategoria;
    }

    // Método para mostrar el estado de los espacios por categoría
    public void mostrarEstadoEspaciosPorCategoria(String categoria) {
        int disponibles = 0;
        int reservados = 0;
        int vendidos = 0;

        for (espacio espacio : espacios) {
            if (espacio.getClass().getSimpleName().equalsIgnoreCase(categoria)) {
                if (espacio.getEstado().equalsIgnoreCase("disponible")) {
                    disponibles++;
                } else if (espacio.getEstado().equalsIgnoreCase("reservado")) {
                    reservados++;
                } else if (espacio.getEstado().equalsIgnoreCase("vendido")) {
                    vendidos++;
                }
            }
        }

        System.out.println("Espacios " + categoria + " disponibles: " + disponibles);
        System.out.println("Espacios " + categoria + " reservados: " + reservados);
        System.out.println("Espacios " + categoria + " vendidos: " + vendidos);
    }

    // Método para generar el informe
    public void generarInforme() {
        // Listado de categorías con el total de espacios registrados
        HashMap<String, Integer> categoriasTotales = new HashMap<>();
        for (espacio espacio : espacios) {
            String categoria = espacio.getClass().getSimpleName();
            categoriasTotales.put(categoria, categoriasTotales.getOrDefault(categoria, 0) + 1);
        }

        // Listado de espacios por categoría
        System.out.println("Listado de espacios por categoría:");
        for (String categoria : categoriasTotales.keySet()) {
            System.out.println(categoria + " - " + categoriasTotales.get(categoria));
        }

        // Total de espacios por estado por categoría
        for (String categoria : categoriasTotales.keySet()) {
            mostrarEstadoEspaciosPorCategoria(categoria);
        }
    }

    public static void main(String[] args) {
        SpaceUVGManager manager = new SpaceUVGManager();
        manager.cargarEspaciosDesdeCSV("espacios.csv");

        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("----- Menú de Space UVG -----");
            System.out.println("1. Buscar espacio por ID");
            System.out.println("2. Listar espacios por categoría");
            System.out.println("3. Mostrar estado de espacios por categoría");
            System.out.println("4. Generar informe");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el ID a buscar: ");
                    int idABuscar = scanner.nextInt();
                    espacio espacioEncontrado = manager.buscarEspacioPorID(idABuscar);
                    if (espacioEncontrado != null) {
                        System.out.println("Espacio encontrado: " + espacioEncontrado.getClass().getSimpleName());
                    } else {
                        System.out.println("Espacio no encontrado");
                    }
                    break;

                case 2:
                    System.out.print("Ingrese la categoría a listar (Apartamento, Oficina, Amenidad, etc.): ");
                    scanner.nextLine(); // Consumir la línea en blanco
                    String categoria = scanner.nextLine();
                    ArrayList<espacio> espaciosCategoria = manager.listarEspaciosPorCategoria(categoria);
                    for (espacio espacio : espaciosCategoria) {
                        System.out.println("ID: " + espacio.getID() + ", Estado: " + espacio.getEstado());
                    }
                    break;

                case 3:
                    System.out.print("Ingrese la categoría para mostrar el estado (Apartamento, Oficina, Amenidad, etc.): ");
                    scanner.nextLine(); // Consumir la línea en blanco
                    String categoriaEstado = scanner.nextLine();
                    manager.mostrarEstadoEspaciosPorCategoria(categoriaEstado);
                    break;

                case 4:
                    manager.generarInforme();
                    break;

                case 5:
                    salir = true;
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }

        scanner.close();
    }
}