package ej5;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Ej5 {

    public static void colapsar(Deque<Integer> pila) {
        Deque<Integer> aux = new ArrayDeque<>();
        Queue<Integer> cola = new ArrayDeque<>();

        // Paso 1: Invertir pila para procesar desde el fondo al tope
        while (!pila.isEmpty()) {
            aux.push(pila.pop());
        }

        // Paso 2: Agrupar en pares y colapsar
        while (!aux.isEmpty()) {
            int primero = aux.pop();
            if (!aux.isEmpty()) {
                int segundo = aux.pop();
                cola.offer(primero + segundo); // Suma del par
            } else {
                cola.offer(primero); // Elemento impar al fondo
            }
        }

        // Paso 3: Volver a poner en la pila (preservando el orden final)
        while (!cola.isEmpty()) {
            pila.push(cola.poll());
        }
    }

    // Método auxiliar para imprimir la pila desde el fondo al tope
    public static void imprimirPila(Deque<Integer> pila) {
        System.out.println("Pila (fondo → tope): " + pila);
    }

    // Ejemplo de uso
    public static void main(String[] args) {
        Deque<Integer> pila = new ArrayDeque<>();
        int[] datos = {5, 11, -3, 14, 9, 4, 21, -42, 13, 2}; // Tope al final

        for (int i = datos.length - 1; i >= 0; i--) {
            pila.push(datos[i]);
        }

        System.out.println("Contenido inicial:");
        imprimirPila(pila);

        colapsar(pila);

        System.out.println("Contenido final:");
        imprimirPila(pila);
    }
}