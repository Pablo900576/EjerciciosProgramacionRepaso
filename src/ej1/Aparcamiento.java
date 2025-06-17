package ej1;
import java.util.*;

public class Aparcamiento {
	private Map<String, Vehiculo> vehiculosDentro = new HashMap<>();
    private List<Oficial> vehiculosOficiales = new ArrayList<>();
    private List<Residente> vehiculosResidentes = new ArrayList<>();

    public void registrarVehiculo(Vehiculo vehiculo) {
        if (vehiculo instanceof Oficial) {
            vehiculosOficiales.add((Oficial) vehiculo);
        } else if (vehiculo instanceof Residente) {
            vehiculosResidentes.add((Residente) vehiculo);
        }
    }

    public void entradaVehiculo(Vehiculo vehiculo) {
        vehiculo.registrarEntrada();
        vehiculosDentro.put(vehiculo.getMatricula(), vehiculo);
        System.out.println("Entrada registrada: " + vehiculo.getMatricula());
    }

    public void salidaVehiculo(String matricula) {
        Vehiculo vehiculo = vehiculosDentro.remove(matricula);
        if (vehiculo != null) {
            vehiculo.registrarSalida();
            double precio = vehiculo.calcularPrecio();
            System.out.printf("Salida de %s - Duración: %d minutos - Precio: %.2f €\n",
                              matricula, vehiculo.getDuracionEstancia(), precio);
        } else {
            System.out.println("Vehículo no encontrado dentro del aparcamiento.");
        }
    }
}
	


