package ej4;

import java.util.*;

public class JuegoNaipes {
    // Mapa para almacenar las manos de los jugadores
    private static final Map<String, Set<String>> manos = new LinkedHashMap<>();

    // Mapa de valores de rangos y palos
    private static final Map<String, Integer> valorRango = new HashMap<>();
    private static final Map<Character, Integer> valorPalo = new HashMap<>();

    static {
        for (int i = 2; i <= 10; i++) {
            valorRango.put(String.valueOf(i), i);
        }
        valorRango.put("J", 11);
        valorRango.put("Q", 12);
        valorRango.put("K", 13);
        valorRango.put("A", 14);

        valorPalo.put('S', 4);
        valorPalo.put('H', 3);
        valorPalo.put('D', 2);
        valorPalo.put('C', 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lectura de entrada
        while (true) {
            System.out.print("> ");
            String linea = scanner.nextLine().trim();

            if (linea.equalsIgnoreCase("fin")) break;

            if (!procesarLinea(linea)) {
                System.out.println("Línea inválida. Inténtalo de nuevo.");
            }
        }

        // Cálculo de puntuaciones
        System.out.println("\nPUNTUACIONES:");
        for (String jugador : manos.keySet()) {
            int total = 0;
            for (String carta : manos.get(jugador)) {
                total += calcularValorCarta(carta);
            }
            System.out.println(jugador + ": " + total + " puntos");
        }
        scanner.close();
    }

    // Procesa una línea y la almacena en la estructura si es válida
    private static boolean procesarLinea(String linea) {
        String[] partes = linea.split("\\s+");
        if (partes.length < 2) return false;

        String nombre = partes[0];
        Set<String> cartas = new HashSet<>();

        for (int i = 1; i < partes.length; i++) {
            String carta = partes[i].toUpperCase();

            if (!validarCarta(carta)) return false;

            cartas.add(carta); // Evita duplicados automáticamente
        }

        // Añadir o actualizar la mano del jugador
        manos.putIfAbsent(nombre, new HashSet<>());
        manos.get(nombre).addAll(cartas);

        return true;
    }

    // Valida que una carta tenga formato correcto
    private static boolean validarCarta(String carta) {
        String rango;
        char palo;

        if (carta.length() < 2 || carta.length() > 3) return false;

        rango = carta.substring(0, carta.length() - 1);
        palo = carta.charAt(carta.length() - 1);

        return valorRango.containsKey(rango) && valorPalo.containsKey(palo);
    }

    // Calcula el valor de una carta
    private static int calcularValorCarta(String carta) {
        String rango = carta.substring(0, carta.length() - 1);
        char palo = carta.charAt(carta.length() - 1);

        return valorRango.get(rango) * valorPalo.get(palo);
    }
}