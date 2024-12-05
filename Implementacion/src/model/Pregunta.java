
package model;

import java.util.List;

public class Pregunta {
    private String pregunta;
    private List<String> opciones;
    private boolean respuestaCorrecta;
    private int puntaje;
    private String explicacion;
    
    public Pregunta(String pregunta, List<String> opciones, boolean respuestaCorrecta,int puntaje,  String explicacion) {
        this.pregunta = pregunta;
        this.opciones = opciones;
        this.respuestaCorrecta = respuestaCorrecta;
        this.explicacion = explicacion;
    }

    public String getPregunta() {
        return pregunta;
    }

    public boolean isRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public int getPuntaje() {
        return puntaje;
    }
    
    public boolean validarRespuesta(String respuestaSeleccionada) {
        return respuestaSeleccionada.equals(respuestaCorrecta);
    }
    
    public String mostrarExplicacion() {
        return explicacion;
    }
    
    public String getTexto() { return pregunta; }
    public List<String> getOpciones() { return opciones; }
    public String getRespuestaCorrecta() { return respuestaCorrecta; }
    public String getExplicacion() { return explicacion; }
}
