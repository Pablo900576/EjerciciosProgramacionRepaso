package ej6;

import java.time.LocalDate;
import java.util.*;

public class OrdenCompra implements Comparable<OrdenCompra> {
    private final int identificador;
    private final LocalDate fecha;
    private final List<LineaDetalle> lineas;

    public OrdenCompra(int identificador, LocalDate fecha) {
        this.identificador = identificador;
        this.fecha = fecha;
        this.lineas = new ArrayList<>();
    }

    public OrdenCompra(int identificador) {
        this(identificador, LocalDate.now());
    }

    public int getIdentificador() {
        return identificador;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public List<LineaDetalle> getLineas() {
        // Retorna una copia ordenada de las líneas para evitar modificación externa
        List<LineaDetalle> copia = new ArrayList<>(lineas);
        copia.sort(Comparator.comparingInt(LineaDetalle::getNumeroLinea));
        return Collections.unmodifiableList(copia);
    }

    public void añadirLinea(String producto, double precio, int cantidad) throws PrecioException {
        for (LineaDetalle linea : lineas) {
            if (linea.getProducto().equalsIgnoreCase(producto)) {
                if (Double.compare(linea.getPrecioUnitario(), precio) != 0) {
                    throw new PrecioException("Precio diferente para el mismo producto: " + producto);
                }
                linea.setCantidad(linea.getCantidad() + cantidad);
                return;
            }
        }

        int nuevoNumeroLinea = lineas.size() + 1;
        LineaDetalle nueva = new LineaDetalle(nuevoNumeroLinea, producto, precio, cantidad);
        lineas.add(nueva);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OrdenCompra [ID=").append(identificador).append(", Fecha=").append(fecha).append("]\n");
        for (LineaDetalle l : getLineas()) {
            sb.append("  ").append(l).append("\n");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof OrdenCompra)) return false;
        OrdenCompra otra = (OrdenCompra) o;
        return identificador == otra.identificador && fecha.equals(otra.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador, fecha);
    }

    @Override
    public int compareTo(OrdenCompra otra) {
        int cmp = fecha.compareTo(otra.fecha);
        return cmp != 0 ? cmp : Integer.compare(identificador, otra.identificador);
    }
}