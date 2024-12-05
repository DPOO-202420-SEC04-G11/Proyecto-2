
package model;

import java.util.List;

public class Tarea extends Actividades {
    private String estadoEntrega;
    private String resultado;
    
    public Tarea(String descripcion, String objetivo, String dificultad, int duracion, List<Actividades> prerequisitos, String titulo) {
        super(descripcion, objetivo, dificultad, duracion, prerequisitos, titulo);
        this.estadoEntrega = estadoEntrega;
        this.resultado = resultado;
    }
    
    public boolean Terminado() {
        if (estadoEntrega.equals("recibido") && resultado.equals("validado")) {
            return true;
        }
        return false;
    }

    public String getEstadoEntrega() {
        return estadoEntrega;
    }

    public void setEstadoEntrega(String estadoEntrega) {
        this.estadoEntrega = estadoEntrega;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public void crearActividad() {
        throw new UnsupportedOperationException("Unimplemented method 'crearActividad'");
    }
}
