
public class Resto extends VehiculoGeneral{

	public Resto(String matricula) {
		super(matricula);
	}
	
	
	public double calcularPrecio() {
		long tiempo=0;
		if(getDuracionEstancia()==0) {
			tiempo=1;
		}else {
			tiempo= getDuracionEstancia();
		}
        return tiempo * 0.05;
    }
}
