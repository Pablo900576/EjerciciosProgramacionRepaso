package ej1;

public interface Vehiculo {
    String getMatricula();
    void registrarEntrada();
    void registrarSalida();
    long getDuracionEstancia(); // en minutos
    double calcularPrecio(); // calculará lo que debe pagar
}
