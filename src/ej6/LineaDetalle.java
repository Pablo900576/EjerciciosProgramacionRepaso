package ej6;

public class LineaDetalle {
    private final int numeroLinea;
    private final String producto;
    private double precioUnitario;
    private int cantidad;

    public LineaDetalle(int numeroLinea, String producto, double precioUnitario, int cantidad) {
        this.numeroLinea = numeroLinea;
        this.producto = producto;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
    }

    public int getNumeroLinea() {
        return numeroLinea;
    }

    public String getProducto() {
        return producto;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return String.format("Línea %d: %s, %.2f €, %d uds", numeroLinea, producto, precioUnitario, cantidad);
    }
}