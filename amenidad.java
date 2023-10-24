public class amenidad extends espacio {
    private String Tipo;
    private int CapacidadPersonas;

    public amenidad(int ID, double MetrosCuadrados, int CantidadDisponible, int CantidadVendidos, String Estado,
                    String Tipo, int CapacidadPersonas) {
        super(MetrosCuadrados, CantidadDisponible, CantidadVendidos, Estado);
        this.Tipo = Tipo;
        this.CapacidadPersonas = CapacidadPersonas;
    }

    // Getter y Setter específico para Tipo
    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    // Getter y Setter específico para CapacidadPersonas
    public int getCapacidadPersonas() {
        return CapacidadPersonas;
    }

    public void setCapacidadPersonas(int CapacidadPersonas) {
        this.CapacidadPersonas = CapacidadPersonas;
    }
}
