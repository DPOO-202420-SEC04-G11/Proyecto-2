
package model;

import java.util.List;
import java.util.ArrayList;

public class Quiz extends Actividades {
    private List<Pregunta> preguntas;
    private int puntajeMaximo;
    private int puntajeTotal;
    private boolean aprobado;
    
    public Quiz(String descripcion, String objetivo, String dificultad, int duracion, List<Actividades> prerequisitos, String titulo) {
        super(descripcion, objetivo, dificultad, duracion, prerequisitos, titulo);
        this.preguntas = new ArrayList<>();
        this.puntajeTotal = 0;
        this.puntajeMaximo = 0;
        this.aprobado = false;

    }
    
    public void agregarPregunta(Pregunta pregunta) {
        preguntas.add(pregunta);
        puntajeMaximo += pregunta.getPuntaje();
    }

    public void mostrarResultados() {
        int puntajeObtenido = 0;
        for (Pregunta pregunta : preguntas) {
            if (pregunta.isRespuestaCorrecta()) {
                puntajeObtenido += pregunta.getPuntaje(); 
            }
            System.out.println(pregunta.getPregunta() + " - Respuesta Correcta: " + pregunta.isRespuestaCorrecta());
        }
        double calificacion = (double) puntajeObtenido / puntajeMaximo * 5; 
        System.out.println("Puntaje total: " + puntajeObtenido + "/" + puntajeMaximo);
        System.out.println("Calificación sobre 5: " + calificacion);
        

        if (calificacion >= 3.0) {
            aprobado = true;
            System.out.println("¡Aprobado!");
        } else {
            aprobado = false;
            System.out.println("No Aprobado");
        }
    }
    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public boolean isAprobado() {
        return aprobado;
    }

    public int getPuntajeTotal() {
        return puntajeTotal;
    }

    public void setPuntajeTotal(int puntajeTotal) {
        this.puntajeTotal = puntajeTotal;
    }

    public int getPuntajeMaximo() {
        return puntajeMaximo;
    }

    public void setPuntajeMaximo(int puntajeMaximo) {
        this.puntajeMaximo = puntajeMaximo;
    }

    public void crearActividad() {
        throw new UnsupportedOperationException("Unimplemented method 'crearActividad'");
    }
}

