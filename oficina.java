public class oficina extends espacio {
    private int TotalParqueos;
    private boolean Mantenimiento;

    public oficina(int ID, double MetrosCuadrados, int CantidadDisponible, int CantidadVendidos, String Estado,
                   int TotalParqueos, boolean Mantenimiento) {
        super(MetrosCuadrados, CantidadDisponible, CantidadVendidos, Estado);
        this.TotalParqueos = TotalParqueos;
        this.Mantenimiento = Mantenimiento;
    }

    // Getter y Setter específico para TotalParqueos
    public int getTotalParqueos() {
        return TotalParqueos;
    }

    public void setTotalParqueos(int TotalParqueos) {
        this.TotalParqueos = TotalParqueos;
    }

    // Getter y Setter específico para Mantenimiento
    public boolean isMantenimiento() {
        return Mantenimiento;
    }

    public void setMantenimiento(boolean Mantenimiento) {
        this.Mantenimiento = Mantenimiento;
    }
}
