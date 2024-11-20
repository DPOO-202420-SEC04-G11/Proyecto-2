
package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Estudiante {
    private String id;
    private String name;
    private List<String> actividadesCompletadas;
    private Map<String, Integer> calificaciones;

    public Estudiante(String id, String name) {
        this.id = id;
        this.name = name;
        this.actividadesCompletadas = new ArrayList<>();
        this.calificaciones = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getActividadesCompletadas() {
        return actividadesCompletadas;
    }

    public Map<String, Integer> getCalificaciones() {
        return calificaciones;
    }

    public void completarActividad(String actividad) {
        actividadesCompletadas.add(actividad);
    }

    public void agregarCalificacion(String actividad, int calificacion) {
        calificaciones.put(actividad, calificacion);
    }
}
