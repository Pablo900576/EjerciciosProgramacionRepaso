import java.time.Duration;
import java.time.LocalDateTime;

public class EntradaSalida {
	private LocalDateTime entrada;
    private LocalDateTime salida;

    public void registrarEntrada() {
        entrada = LocalDateTime.now();
    }

    public void registrarSalida() {
        salida = LocalDateTime.now();
    }

    public long getDuracionEnMinutos() {
        if (entrada != null && salida != null) {
            return Duration.between(entrada, salida).toMinutes();
        }
        return 0;
    }

    public LocalDateTime getEntrada() {
        return entrada;
    }

    public LocalDateTime getSalida() {
        return salida;
    }
}