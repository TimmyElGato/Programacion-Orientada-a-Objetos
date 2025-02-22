package com.mycompany.actividad_4;

import java.util.ArrayList;
import java.util.List;

// Clase Materia
class Materia {
    private String nombre;
    private String clave;
    private int creditos;
    private int horasSemanales;

    // Constructor por defecto
    public Materia() {
        this.nombre = "";
        this.clave = "";
        this.creditos = 0;
        this.horasSemanales = 0;
    }

    // Constructor con parámetros
    public Materia(String nombre, String clave, int creditos, int horasSemanales) {
        this.nombre = nombre;
        this.clave = clave;
        this.creditos = creditos;
        this.horasSemanales = horasSemanales;
    }

    // Constructor de copia
    public Materia(Materia otra) {
        this.nombre = otra.nombre;
        this.clave = otra.clave;
        this.creditos = otra.creditos;
        this.horasSemanales = otra.horasSemanales;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getClave() { return clave; }
    public void setClave(String clave) { this.clave = clave; }
    public int getCreditos() { return creditos; }
    public void setCreditos(int creditos) { this.creditos = creditos; }
    public int getHorasSemanales() { return horasSemanales; }
    public void setHorasSemanales(int horasSemanales) { this.horasSemanales = horasSemanales; }
}

// Clase Curso
class Curso {
    private String nombre;
    private List<Materia> materias;

    // Constructor por defecto
    public Curso() {
        this.nombre = "";
        this.materias = new ArrayList<>();
    }

    // Constructor con parámetros
    public Curso(String nombre, List<Materia> materias) {
        if (materias.size() != 3) {
            throw new IllegalArgumentException("Un curso debe contener exactamente tres materias.");
        }
        this.nombre = nombre;
        this.materias = new ArrayList<>(materias);
    }

    // Constructor de copia
    public Curso(Curso otro) {
        this.nombre = otro.nombre;
        this.materias = new ArrayList<>(otro.materias);
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public List<Materia> getMaterias() { return materias; }
    public int getTotalCreditos() {
        return materias.stream().mapToInt(Materia::getCreditos).sum();
    }
}

// Clase Profesor
class Profesor {
    private String nombre;
    private int numeroNomina;
    private double sueldoPorHora;
    private Materia materia;
    private int horasSemanales;

    // Constructor por defecto
    public Profesor() {
        this.nombre = "";
        this.numeroNomina = 0;
        this.sueldoPorHora = 0.0;
        this.materia = null;
        this.horasSemanales = 0;
    }

    // Constructor con parámetros
    public Profesor(String nombre, int numeroNomina, double sueldoPorHora) {
        this.nombre = nombre;
        this.numeroNomina = numeroNomina;
        this.sueldoPorHora = sueldoPorHora;
    }

    // Constructor de copia
    public Profesor(Profesor otro) {
        this.nombre = otro.nombre;
        this.numeroNomina = otro.numeroNomina;
        this.sueldoPorHora = otro.sueldoPorHora;
        this.materia = otro.materia;
        this.horasSemanales = otro.horasSemanales;
    }

    // Método para calcular sueldo semanal
    public double calcularSueldoSemanal() {
        return sueldoPorHora * horasSemanales;
    }
}

// Clase Alumno
class Alumno {
    private String matricula;
    private String nombre;
    private int edad;
    private Curso curso;

    // Constructor por defecto
    public Alumno() {
        this.matricula = "";
        this.nombre = "";
        this.edad = 0;
        this.curso = null;
    }

    // Constructor con parámetros
    public Alumno(String matricula, String nombre, int edad, Curso curso) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.edad = edad;
        this.curso = curso;
    }

    // Constructor de copia
    public Alumno(Alumno otro) {
        this.matricula = otro.matricula;
        this.nombre = otro.nombre;
        this.edad = otro.edad;
        this.curso = otro.curso;
    }
    //Getters y Setters
    public String getNombre(){return nombre;}
    public Curso getCurso(){return curso;}
    public String getMatricula(){ return matricula; }
    public int getEdad(){return edad;}
}

// Clase principal para probar la estructura
public class Actividad_4 {
    public static void main(String[] args) {
        // Creación de materias
        Materia m1 = new Materia("Matemáticas", "MAT101", 5, 4);
        Materia m2 = new Materia("Historia", "HIS202", 3, 3);
        Materia m3 = new Materia("Ciencias", "CIE303", 4, 4);

        // Creación de curso
        List<Materia> listaMaterias1 = List.of(m1, m2, m3);
        Curso curso1 = new Curso("Curso A", listaMaterias1);

        // Creación de alumno
        Alumno alumno = new Alumno("AL404", "Juan Pérez", 20, curso1);

        // Creación de profesor
        Profesor profesor = new Profesor("María López", 1234, 150.0);
        profesor.calcularSueldoSemanal();

        // Salida de datos
        System.out.println("Alumno: " + alumno.getNombre() + " inscrito en " + alumno.getCurso().getNombre());
        System.out.println("Total de créditos del curso: " + alumno.getCurso().getTotalCreditos());
    }
}

