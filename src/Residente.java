
public class Residente extends VehiculoGeneral{
	String tarjeta;
	public Residente(String matricula, String tarjeta) {
		super(matricula);
		this.tarjeta= tarjeta;
	}
	
	public double calcularPrecio() {
        return getDuracionEstancia() * 0.005;
    }

    public String getTarjetaBancaria() {
        return tarjeta;
    }
	

}
