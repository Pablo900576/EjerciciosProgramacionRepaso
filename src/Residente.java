
public class Residente extends Vehiculo implements Pagable{
	String tarjeta;
	public Residente(String matricula, String tarjeta) {
		super(matricula);
		this.tarjeta= tarjeta;
	}
	
	@Override
	public void pagar(int importe) {
		
	}
	

}
