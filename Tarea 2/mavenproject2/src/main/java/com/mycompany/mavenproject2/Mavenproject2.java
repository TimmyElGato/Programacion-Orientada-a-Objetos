/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject2;

import java.util.Scanner;

public class Mavenproject2 {
    public static void main(String[] args) {
        // Crea un objeto Scanner para leer la entrada del usuario desde la consola
        Scanner scanner = new Scanner(System.in);

        // Imprime un mensaje pidiendo al usuario que ingrese su nombre
        System.out.println("Ingresa tu nombre:");

        // Lee la línea completa de entrada como el nombre del usuario
        String nombre = scanner.nextLine();

        // Cierra el objeto Scanner para liberar recursos
        scanner.close();

        // Convierte el nombre a minúsculas y elige una respuesta basada en el nombre ingresado
        switch (nombre.toLowerCase()) {
            case "juan" -> System.out.println("¡Hola Juan! ¿Cómo estás hoy?");
            case "ana" -> System.out.println("¡Hola Ana! ¿Cómo estás hoy?");
            default -> System.out.println("¡Hola! ¿Cómo estás?");
        }
    }
}
