import java.io.*;
import java.util.Random;

public class espacio {
    private int ID;
    private double MetrosCuadrados;
    private int CantidadDisponible;
    private int CantidadVendidos;
    private String Estado;

    public espacio(double MetrosCuadrados, int CantidadDisponible, int CantidadVendidos, String Estado) {
        this.ID = generarIDAleatorio(); // Genera un ID aleatorio
        this.MetrosCuadrados = MetrosCuadrados;
        this.CantidadDisponible = CantidadDisponible;
        this.CantidadVendidos = CantidadVendidos;
        this.Estado = Estado;
    }

    public int getID() {
        return ID;
    }

    public double getMetrosCuadrados() {
        return MetrosCuadrados;
    }

    public int getCantidadDisponible() {
        return CantidadDisponible;
    }

    public int getCantidadVendidos() {
        return CantidadVendidos;
    }

    public String getEstado() {
        return Estado;
    }

    public void setCantidadDisponible(int CantidadDisponible) {
        this.CantidadDisponible = CantidadDisponible;
    }

    public void setCantidadVendidos(int CantidadVendidos) {
        this.CantidadVendidos = CantidadVendidos;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    private int generarIDAleatorio() {
        Random rand = new Random();
        return rand.nextInt(100000); // Puedes ajustar el rango de IDs según tus necesidades.
    }

    public String toCSV() {
        return ID + "," + MetrosCuadrados + "," + CantidadDisponible + "," + CantidadVendidos + "," + Estado;
    }

    public static espacio fromCSV(String csvLine) {
        String[] data = csvLine.split(",");
        int id = Integer.parseInt(data[0]);
        double metrosCuadrados = Double.parseDouble(data[1]);
        int cantidadDisponible = Integer.parseInt(data[2]);
        int cantidadVendidos = Integer.parseInt(data[3]);
        String estado = data[4];
        espacio espacio = new espacio(metrosCuadrados, cantidadDisponible, cantidadVendidos, estado);
        espacio.ID = id;
        return espacio;
    }

    // Método para guardar el espacio en un archivo CSV
    public void guardarEnCSV(String archivoCSV) {
        try (FileWriter writer = new FileWriter(archivoCSV, true);
             BufferedWriter bufferWriter = new BufferedWriter(writer)) {
            bufferWriter.write(this.toCSV());
            bufferWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

