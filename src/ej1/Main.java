package ej1;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		 Aparcamiento ap = new Aparcamiento();

	        Vehiculo pepe = new Resto("1234ABC");
	        Vehiculo juan = new Residente("4321XYZ", "1234-5678-9012-3456");
	        Vehiculo poli = new Oficial("0000GOV");

	        ap.registrarVehiculo(juan);
	        ap.registrarVehiculo(poli);

	        ap.entradaVehiculo(pepe);
	        ap.entradaVehiculo(juan);
	        ap.entradaVehiculo(poli);

	        // Tiempo de estancia
	        Thread.sleep(3000); 

	        ap.salidaVehiculo("1234ABC");
	        ap.salidaVehiculo("4321XYZ");
	        ap.salidaVehiculo("0000GOV");
	    }
	

}
