public class apartamento extends espacio {
    private boolean LineaBlanca;
    private int Habitaciones;

    public apartamento(double MetrosCuadrados, int CantidadDisponible, int CantidadVendidos, String Estado,
                      boolean LineaBlanca, int Habitaciones) {
        super(MetrosCuadrados, CantidadDisponible, CantidadVendidos, Estado); // ID se generará aleatoriamente
        this.LineaBlanca = LineaBlanca;
        this.Habitaciones = Habitaciones;
    }

    public boolean isLineaBlanca() {
        return LineaBlanca;
    }

    public void setLineaBlanca(boolean LineaBlanca) {
        this.LineaBlanca = LineaBlanca;
    }

    public int getHabitaciones() {
        return Habitaciones;
    }

    public void setHabitaciones(int Habitaciones) {
        this.Habitaciones = Habitaciones;
    }
}

