package com.mycompany.sgp;

import java.util.*;

// Clase principal del sistema de gestión de proyectos
class Sistema_de_Gestion_de_Proyectos {
    private List<Usuario> usuarios; // Lista de usuarios registrados en el sistema
    private List<Proyecto> proyectos; // Lista de proyectos dentro del sistema
    private List<Equipo> equipos; // Lista de equipos de trabajo

    // Constructor que inicializa las listas
    public Sistema_de_Gestion_de_Proyectos() {
        this.usuarios = new ArrayList<>();
        this.proyectos = new ArrayList<>();
        this.equipos = new ArrayList<>();
    }

    // Método para agregar un nuevo proyecto a la lista
    public void agregarProyecto(Proyecto proyecto) {
        proyectos.add(proyecto);
    }

    // Método para eliminar un proyecto de la lista
    public void eliminarProyecto(Proyecto proyecto) {
        proyectos.remove(proyecto);
    }

    // Método para registrar un usuario en el sistema
    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }
}

// Clase que representa a un Usuario dentro del sistema
class Usuario {
    private int id;
    private String nombre;
    private String email;
    private String rol;
    private List<Proyecto> proyectos; // Lista de proyectos asignados al usuario

    // Constructor para inicializar un usuario con sus atributos
    public Usuario(int id, String nombre, String email, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.rol = rol;
        this.proyectos = new ArrayList<>();
    }
    
    // Métodos Getters para acceder a los atributos privados
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public String getRol() { return rol; }
    public List<Proyecto> getProyectos() { return proyectos; }
    
    // Métodos Setters para modificar los atributos privados
    public void setId(int id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEmail(String email) { this.email = email; }
    public void setRol(String rol) { this.rol = rol; }
    
    // Método para asignar un proyecto a un usuario
    public void asignarProyecto(Proyecto proyecto) {
        proyectos.add(proyecto);
    }

    // Representación del usuario en formato de cadena
    public String toString() {
        return "Usuario[ID: " + id + ", Nombre: " + nombre + ", Email: " + email + ", Rol: " + rol + "]";
    }
}

// Clase que representa un Proyecto dentro del sistema
class Proyecto {
    private int id;
    private String nombre;
    private Date fechaInicio;
    private Date fechaFin;
    private String descripcion;
    private String estado;
    private List<Tarea> tareas; // Lista de tareas dentro del proyecto
    private List<Usuario> equipo; // Lista de usuarios asignados al proyecto

    // Constructor para inicializar un proyecto con sus atributos
    public Proyecto(int id, String nombre, Date fechaInicio, Date fechaFin, String descripcion, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.descripcion = descripcion;
        this.estado = estado;
        this.tareas = new ArrayList<>();
        this.equipo = new ArrayList<>();
    }
    
    // Métodos Getters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public Date getFechaInicio() { return fechaInicio; }
    public Date getFechaFin() { return fechaFin; }
    public String getDescripcion() { return descripcion; }
    public String getEstado() { return estado; }
    
    // Métodos Setters
    public void setId(int id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setFechaInicio(Date fechaInicio) { this.fechaInicio = fechaInicio; }
    public void setFechaFin(Date fechaFin) { this.fechaFin = fechaFin; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setEstado(String estado) { this.estado = estado; }
    
    // Representación del proyecto en formato de cadena
    public String toString() {
        return "Proyecto[ID: " + id + ", Nombre: " + nombre + ", Estado: " + estado + "]";
    }
}

// Clase que representa una Tarea dentro de un Proyecto
class Tarea {
    private int id;
    private String titulo;
    private String descripcion;
    private Usuario asignadoA;
    private Date fechaInicio;
    private Date fechaFin;
    private String estado;

    // Constructor para inicializar una tarea con sus atributos
    public Tarea(int id, String titulo, String descripcion, Usuario asignadoA, Date fechaInicio, Date fechaFin, String estado) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.asignadoA = asignadoA;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
    }

    // Representación de la tarea en formato de cadena
    public String toString() {
        return "Tarea[ID: " + id + ", Titulo: " + titulo + ", Estado: " + estado + "]";
    }
}

// Clase que representa un equipo dentro del sistema
class Equipo {
    private int id;
    private String nombre;
    private List<Usuario> miembros; // Lista de miembros dentro del equipo

    // Constructor para inicializar un equipo con su ID y nombre
    public Equipo(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.miembros = new ArrayList<>();
    }

    // Método para agregar un usuario al equipo
    public void agregarMiembro(Usuario usuario) {
        miembros.add(usuario);
    }

    // Representación del equipo en formato de cadena
    public String toString() {
        return "Equipo[ID: " + id + ", Nombre: " + nombre + ", Miembros: " + miembros.size() + "]";
    }
}

// Clase principal que interactúa con el usuario
public class SGP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Creación de un usuario a partir de la entrada del usuario
        System.out.println("Ingrese el ID del usuario: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // Consumir la línea
        System.out.println("Ingrese el nombre del usuario: ");
        String userName = scanner.nextLine();
        System.out.println("Ingrese el email del usuario: ");
        String userEmail = scanner.nextLine();
        System.out.println("Ingrese el rol del usuario: ");
        String userRole = scanner.nextLine();
        
        Usuario usuario = new Usuario(userId, userName, userEmail, userRole);
        System.out.println("Usuario creado: " + usuario);
        
        scanner.close();
    }
}
