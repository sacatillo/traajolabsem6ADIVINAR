/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.montes_alberto;

/**
 *
 * @author Martin Montes
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Montes_AlbertoJUEGO {
    private static final int OPORTUNIDADES = 5;
    private static List<String> palabras = new ArrayList<>();
    private static Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        inicializarPalabras();
        boolean continuar = true;

        while (continuar) {
            jugar();
            continuar = mostrarMenu();
        }

        System.out.println("Gracias por jugar!");
    }

    private static void inicializarPalabras() {
        palabras.add("HONDURAS");
        palabras.add("JAVA");
        palabras.add("PROGRAMACION");
        palabras.add("COMPUTADORA");
        palabras.add("ALGORITMO");
        palabras.add("DESARROLLO");
        palabras.add("JAVASCRIPT");
        palabras.add("PYTHON");
        palabras.add("SWING");
        palabras.add("HTML");
    }

    private static void jugar() {
        String palabra = palabras.get(random.nextInt(palabras.size()));
        StringBuilder palabraOculta = new StringBuilder("_".repeat(palabra.length()));
        int oportunidadesRestantes = OPORTUNIDADES;
        List<Character> letrasAdivinadas = new ArrayList<>();

        System.out.println(" Comienza el juego! >:)");
        System.out.println(palabraOculta);

        while (oportunidadesRestantes > 0 && palabraOculta.toString().contains("_")) {
            System.out.print("Ingresa un caracter: ");
            char letra = scanner.nextLine().toUpperCase().charAt(0);

            if (letrasAdivinadas.contains(letra)) {
                System.out.println("Ya has adivinado esa letra. Intenta con otra.");
                continue;
            }

            letrasAdivinadas.add(letra);
            if (palabra.indexOf(letra) >= 0) {
                System.out.println(" Le atinaste a un caracter!");
                for (int i = 0; i < palabra.length(); i++) {
                    if (palabra.charAt(i) == letra) {
                        palabraOculta.setCharAt(i, letra);
                    }
                }
            } else {
                oportunidadesRestantes--;
                System.out.println("La palabra no contiene ese caracter. Oportunidades restantes: " + oportunidadesRestantes);
            }

            System.out.println(palabraOculta);
        }

        if (palabraOculta.toString().equals(palabra)) {
            System.out.println(" Felicidades! Adivinaste la palabra: " + palabra);
        } else {
            System.out.println("Perdiste. La palabra era: " + palabra);
        }
    }

    private static boolean mostrarMenu() {
        System.out.println("\n--- Menu ---");
        System.out.println("1. Jugar");
        System.out.println("2. Cambiar Palabras");
        System.out.println("3. Salir");
        System.out.print("Selecciona una opcion: ");
        
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer AMMM

        switch (opcion) {
            case 1:
                return true; // Volver a jugar
            case 2:
                cambiarPalabras();
                return true; // Jugar inmediatamente después de cambiar palabras
            case 3:
                return false; // Salir del juego
            default:
                System.out.println("Opcion no valida. Intenta de nuevo.");
                return mostrarMenu(); // Volver a mostrar el menú
        }
    }

    private static void cambiarPalabras() {
        palabras.clear();
        System.out.println("Ingresa 10 palabras (una por linea):");
        for (int i = 0; i < 10; i++) {
            System.out.print("Palabra " + (i + 1) + ": ");
            String palabra = scanner.nextLine();
            palabras.add(palabra.toUpperCase());
        }
        System.out.println("Palabras actualizadas.");
    }
}
