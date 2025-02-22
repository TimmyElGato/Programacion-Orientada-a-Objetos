package com.mycompany.producto;
import java.util.Scanner;

public class Producto {
    // Atributos privados
    private String codigo;
    private String tipo;
    private double costo;
    private double impuesto;

    // Constructor
    public Producto() {
    }

    public Producto(String codigo, String tipo, double costo, double impuesto) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.costo = costo;
        this.impuesto = impuesto;
    }

    // Métodos de acceso (getters)
    public String getCodigo() {
        return codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public double getCosto() {
        return costo;
    }

    public double getImpuesto() {
        return impuesto;
    }

    // Métodos establecedores (setters)
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    // Método para mostrar la información del producto
    public void muestraProducto() {
        System.out.println("Código: " + codigo);
        System.out.println("Tipo: " + tipo);
        System.out.println("Costo: " + costo);
        System.out.println("Impuesto: " + impuesto);
    }

    // Método funcional para calcular el precio de venta
    public double calcularPrecio(double utilidad) {
        double precioAntesImpuestos = costo + (costo * utilidad / 100);
        double precioFinal = precioAntesImpuestos + (precioAntesImpuestos * impuesto / 100);
        return precioFinal;
    }

    // Método para comparar dos productos
    public static String compararProductos(Producto p1, Producto p2, double utilidad) {
        double precio1 = p1.calcularPrecio(utilidad);
        double precio2 = p2.calcularPrecio(utilidad);
        
        if (precio1 > precio2) {
            return "El producto con mayor precio de venta es: " + p1.getTipo();
        } else if (precio2 > precio1) {
            return "El producto con mayor precio de venta es: " + p2.getTipo();
        } else {
            return "Ambos productos tienen el mismo precio de venta.";
        }
    }

    // Método principal para probar la clase
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Producto producto1 = new Producto();
        Producto producto2 = new Producto();

        try {
            // Ingresar datos del primer producto
            System.out.println("Ingrese el código del primer producto:");
            producto1.setCodigo(scanner.nextLine());
            System.out.println("Ingrese el tipo del primer producto:");
            producto1.setTipo(scanner.nextLine());
            System.out.println("Ingrese el costo del primer producto:");
            producto1.setCosto(Double.parseDouble(scanner.nextLine()));
            System.out.println("Ingrese el impuesto del primer producto:");
            producto1.setImpuesto(Double.parseDouble(scanner.nextLine()));

            // Ingresar datos del segundo producto
            System.out.println("Ingrese el código del segundo producto:");
            producto2.setCodigo(scanner.nextLine());
            System.out.println("Ingrese el tipo del segundo producto:");
            producto2.setTipo(scanner.nextLine());
            System.out.println("Ingrese el costo del segundo producto:");
            producto2.setCosto(Double.parseDouble(scanner.nextLine()));
            System.out.println("Ingrese el impuesto del segundo producto:");
            producto2.setImpuesto(Double.parseDouble(scanner.nextLine()));
        } catch (Exception e) {
            System.out.println("Error en la entrada de datos. Asegúrese de ingresar los valores correctamente.");
            return;
        }

        // Mostrar productos
        System.out.println("\nDatos del primer producto:");
        producto1.muestraProducto();
        System.out.println("\nDatos del segundo producto:");
        producto2.muestraProducto();

        // Comparar productos
        System.out.println("\nIngrese el porcentaje de utilidad para calcular el precio de venta:");
        double utilidad = Double.parseDouble(scanner.nextLine());
        String resultado = compararProductos(producto1, producto2, utilidad);
        System.out.println(resultado);
    }
}
