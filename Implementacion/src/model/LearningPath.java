
package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LearningPath {
    private String titulo;
    private String descripcion;
    private String dificultad;
    private int duracion;
    private Rating rating;
    private String fechaCreacion;
    private List<Actividades> actividades;
    
    public LearningPath(String titulo, String descripcion, String dificultad, int duracion, Rating rating, String fechaCreacion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.dificultad = dificultad;
        this.duracion = duracion;
        this.rating = rating;
        this.fechaCreacion = fechaCreacion;
        this.actividades = new ArrayList<>();
    }
    
    public void agregarActividad(Actividades actividad) {
        actividades.add(actividad);
    }

    public void mostrarActividadesPosibles(List<Actividades> todasLasActividades) {
        for (Actividades actividad : todasLasActividades) {
            if (!actividades.contains(actividad)) {
                System.out.println("Actividad posible: " + actividad.getTitulo());
            }
        }
    }

    public void editarActividad(int indice, Actividades nuevaActividad) {
        if (indice >= 0 && indice < actividades.size()) {
            actividades.set(indice, nuevaActividad);
        } else {
            System.out.println("Índice no válido.");
        }
    }

    public void quitarActividad(int indice) {
        if (indice >= 0 && indice < actividades.size()) {
            actividades.remove(indice);
        } else {
            System.out.println("Índice no válido.");
        }
    }

    public void modificarOrdenActividades(int indice, int nuevoIndice) {
        if (indice >= 0 && indice < actividades.size() && nuevoIndice >= 0 && nuevoIndice < actividades.size()) {
            Actividades actividad = actividades.remove(indice);
            actividades.add(nuevoIndice, actividad);
        } else {
            System.out.println("Índice no válido.");
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public List<Actividades> getActividades() {
        return actividades;
    }

    public void setActividades(List<Actividades> actividades) {
        this.actividades = actividades;
    }
}