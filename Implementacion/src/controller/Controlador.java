package controller;

import java.util.*;
import model.Estudiante;
import model.Profesor;
import persistence.Persistencia;

public class Controlador {
    private Map<String, Estudiante> estudiantes;
    private Map<String, Profesor> profesores;

    public Controlador() {
        Map<String, Object> datos = Persistencia.cargarDatos();
        estudiantes = (Map<String, Estudiante>) datos.getOrDefault("estudiantes", new HashMap<>());
        profesores = (Map<String, Profesor>) datos.getOrDefault("profesores", new HashMap<>());
    }

    public void iniciarConsola() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al sistema. ¿Es usted Profesor o Estudiante?");
        String tipoUsuario = scanner.nextLine().toLowerCase();

        if (tipoUsuario.equals("profesor")) {
            manejarProfesor(scanner);
        } else if (tipoUsuario.equals("estudiante")) {
            manejarEstudiante(scanner);
        } else {
            System.out.println("Tipo de usuario no reconocido.");
        }

        guardarDatos(); // Guardar al salir
    }

    private void manejarProfesor(Scanner scanner) {
        System.out.println("Ingrese su ID:");
        String id = scanner.nextLine();

        Profesor profesor = profesores.getOrDefault(id, new Profesor(id, "Profesor " + id));
        profesores.putIfAbsent(id, profesor);

        System.out.println("Bienvenido, Profesor " + profesor.getName());
        while (true) {
            System.out.println("Opciones: 1. Crear Actividad  2. Ver Actividades  3. Poner Calificación  4. Salir");
            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> {
                    System.out.println("Ingrese el título de la actividad:");
                    String actividad = scanner.nextLine();
                    profesor.crearActividad(actividad);
                    System.out.println("Actividad creada.");
                }
                case 2 -> {
                    System.out.println("Actividades creadas:");
                    profesor.getActividadesCreadas().forEach(System.out::println);
                }
                case 3 -> {
                    System.out.println("Ingrese el ID del estudiante:");
                    String estudianteId = scanner.nextLine();
                    Estudiante estudiante = estudiantes.get(estudianteId);
                    if (estudiante == null) {
                        System.out.println("Estudiante no encontrado.");
                        break;
                    }
                    System.out.println("Ingrese el título de la actividad:");
                    String actividad = scanner.nextLine();
                    if (!estudiante.getActividadesCompletadas().contains(actividad)) {
                        System.out.println("El estudiante no ha completado esta actividad.");
                        break;
                    }
                    System.out.println("Ingrese la calificación (0-100):");
                    int calificacion = Integer.parseInt(scanner.nextLine());
                    estudiante.agregarCalificacion(actividad, calificacion);
                    System.out.println("Calificación asignada.");
                }
                case 4 -> {
                    System.out.println("Saliendo...");
                    return;
                }
                default -> System.out.println("Opción no válida.");
            }
        }
    }

    private void manejarEstudiante(Scanner scanner) {
        System.out.println("Ingrese su ID:");
        String id = scanner.nextLine();

        Estudiante estudiante = estudiantes.getOrDefault(id, new Estudiante(id, "Estudiante " + id));
        estudiantes.putIfAbsent(id, estudiante);

        System.out.println("Bienvenido, Estudiante " + estudiante.getName());
        while (true) {
            System.out.println("Opciones: 1. Completar Actividad  2. Ver Actividades Completadas  3. Ver Calificaciones  4. Salir");
            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> {
                    System.out.println("Ingrese el título de la actividad:");
                    String actividad = scanner.nextLine();
                    estudiante.completarActividad(actividad);
                    System.out.println("Actividad completada.");
                }
                case 2 -> {
                    System.out.println("Actividades completadas:");
                    estudiante.getActividadesCompletadas().forEach(System.out::println);
                }
                case 3 -> {
                    System.out.println("Calificaciones:");
                    estudiante.getCalificaciones().forEach((actividad, calificacion) ->
                            System.out.println(actividad + ": " + calificacion));
                }
                case 4 -> {
                    System.out.println("Saliendo...");
                    return;
                }
                default -> System.out.println("Opción no válida.");
            }
        }
    }

    private void guardarDatos() {
        Map<String, Object> datos = new HashMap<>();
        datos.put("estudiantes", estudiantes);
        datos.put("profesores", profesores);
        Persistencia.guardarDatos(datos);
    }

    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        controlador.iniciarConsola();
    }
}
