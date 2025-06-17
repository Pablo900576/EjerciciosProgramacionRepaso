package ej3;

import java.util.*;

public class Palabras extends HashMap<Integer, TreeSet<String>> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Constructor por defecto
    public Palabras() {
        super();
    }

    // Constructor que recibe una cadena de texto
    public Palabras(String texto) {
        this();
        añadirTexto(texto);
    }

    // Método para añadir una sola palabra
    public void añadirPalabra(String palabra) {
        palabra = palabra.toLowerCase().trim();
        if (palabra.isEmpty()) return;

        int longitud = palabra.length();
        this.putIfAbsent(longitud, new TreeSet<>());
        this.get(longitud).add(palabra);
    }

    // Método para añadir todas las palabras contenidas en una cadena
    public void añadirTexto(String texto) {
        String[] palabras = texto.split("\\W+");  // Divide por caracteres no alfanuméricos
        for (String palabra : palabras) {
            añadirPalabra(palabra);
        }
    }

    // Comprobar si una palabra está contenida
    public boolean contiene(String palabra) {
        palabra = palabra.toLowerCase();
        int longitud = palabra.length();
        return this.containsKey(longitud) && this.get(longitud).contains(palabra);
    }

    // Borrar todas las palabras
    public void borrarTodo() {
        this.clear();
    }

    // Borrar palabras de longitud n
    public void borrarLongitud(int n) {
        this.remove(n);
    }

    // Borrar palabras contenidas en un texto
    public void borrarTexto(String texto) {
        String[] palabras = texto.split("\\W+");
        for (String palabra : palabras) {
            palabra = palabra.toLowerCase();
            int longitud = palabra.length();
            if (this.containsKey(longitud)) {
                this.get(longitud).remove(palabra);
                if (this.get(longitud).isEmpty()) {
                    this.remove(longitud);
                }
            }
        }
    }

    // Obtener palabras de longitud n
    public Set<String> obtenerPalabras(int n) {
        return this.getOrDefault(n, new TreeSet<>());
    }
}
