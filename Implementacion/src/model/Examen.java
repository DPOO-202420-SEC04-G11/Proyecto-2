
package model;

import java.util.ArrayList;
import java.util.List;

public class Examen extends Actividades {
    private List<Pregunta> preguntas;  
    private boolean aprobado;  
    private int puntajeTotal;  
    private int puntajeMaximo; 

    // Constructor
    public Examen(String descripcion, String objetivo, String dificultad, int duracion, List<Actividades> prerequisitos, String titulo) {
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

    public void recogerRespuestas(List<String> respuestas) {
        int respuestasCorrectas = 0;
        int puntajeObtenido = 0;

        for (int i = 0; i < preguntas.size(); i++) {
            Pregunta pregunta = preguntas.get(i);
            String respuestaEstudiante = respuestas.get(i);

           
            if (respuestaEstudiante.equalsIgnoreCase(pregunta.getRespuestaCorrecta())) {
                respuestasCorrectas++;
                puntajeObtenido += pregunta.getPuntaje();
                System.out.println("Pregunta: " + pregunta.getPregunta());
                System.out.println("Respuesta correcta: " + respuestaEstudiante);
                System.out.println("Puntaje obtenido: " + pregunta.getPuntaje() + " (Correcta)");
            } else {
                System.out.println("Pregunta: " + pregunta.getPregunta());
                System.out.println("Respuesta dada: " + respuestaEstudiante);
                System.out.println("Puntaje obtenido: 0 (Incorrecta)");
            }
        }
        double calificacion = (double) puntajeObtenido / puntajeMaximo * 5;

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

