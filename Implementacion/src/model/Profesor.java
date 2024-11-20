package model;

import java.util.ArrayList;
import java.util.List;

public class Profesor {
    private String id;
    private String name;
    private List<String> actividadesCreadas;

    public Profesor(String id, String name) {
        this.id = id;
        this.name = name;
        this.actividadesCreadas = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getActividadesCreadas() {
        return actividadesCreadas;
    }

    public void crearActividad(String actividad) {
        actividadesCreadas.add(actividad);
    }
}

