package ej2;

public class PosicionGancho {
    // Atributos
    private double b;   // Altura de la base
    private double l1;  // Longitud del primer brazo
    private double l2;  // Longitud del segundo brazo
    private double g;   // Altura del gancho (desplazamiento vertical)
    private double alpha;  // Ángulo del primer brazo con la horizontal (radianes)
    private double beta;  // Ángulo entre los dos brazos (radianes)
    private double gamma;  // Ángulo calculado como α + β - π

    // Constructor
    public PosicionGancho(double b, double l1, double l2, double g, double alpha, double beta) {
        this.b = b;
        this.l1 = l1;
        this.l2 = l2;
        this.g = g;
        this.alpha = alpha;
        this.beta=beta;
        this.gamma = alpha + beta - Math.PI;
    }

    // Método para calcular la altura h del gancho
    public double calcularAltura() {
        return l1 * Math.sin(alpha) - l2 * Math.sin(gamma) + b - g;
    }

    // Método para calcular el radio r del gancho
    public double calcularRadio() {
        return l1 * Math.cos(alpha) + l2 * Math.cos(gamma);
    }

    // Getters (opcional, si quieres acceder a los valores desde fuera)
    public double getGamma() {
        return gamma;
    }
}