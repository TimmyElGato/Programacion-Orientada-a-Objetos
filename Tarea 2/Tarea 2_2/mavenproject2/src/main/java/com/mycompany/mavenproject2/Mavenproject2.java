/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject2;

/**
 *
 * @author santiagogutierrez
 */
public class Mavenproject2 {

    public static void main(String[] args) {
        // Definir el tamaño del arreglo
        int tamano = 50; // Hay 50 números pares entre 2 y 100
        int[] numerosPares = new int[tamano];

        // Llenar el arreglo con números pares usando un bucle for
        int indice = 0;
        for (int i = 2; i <= 100; i += 2) {
            numerosPares[indice] = i;
            indice++;
        }

        // Recorrer el arreglo y mostrar los números que se almacenaron
        System.out.println("Números pares del 2 al 100: ");
        for (int numero : numerosPares) {
            System.out.print(numero + " ");
        }
    }
}