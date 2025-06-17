package ej1;

public abstract class VehiculoGeneral implements Vehiculo{
	 protected String matricula;
	    protected EntradaSalida es;

	    public VehiculoGeneral(String matricula) {
	        this.matricula = matricula;
	        this.es = new EntradaSalida();
	    }

	    public String getMatricula() {
	        return matricula;
	    }

	    public void registrarEntrada() {
	        es.registrarEntrada();
	    }

	    public void registrarSalida() {
	        es.registrarSalida();
	    }

	    public long getDuracionEstancia() {
	        return es.getDuracionEnMinutos();
	    }

	    public abstract double calcularPrecio();
	}

