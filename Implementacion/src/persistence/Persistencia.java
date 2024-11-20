
package persistence;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import model.Estudiante;
import model.Profesor;

public class Persistencia {
    private static final String FILE_PATH = "data.json";

    public static Map<String, Object> cargarDatos() {
        Map<String, Object> datos = new HashMap<>();
        try (FileReader reader = new FileReader(FILE_PATH)) {
            StringBuilder jsonData = new StringBuilder();
            int i;
            while ((i = reader.read()) != -1) {
                jsonData.append((char) i);
            }
            JSONObject jsonObject = new JSONObject(jsonData.toString());

            // Cargar estudiantes
            Map<String, Estudiante> estudiantes = new HashMap<>();
            JSONArray estudiantesArray = jsonObject.getJSONArray("estudiantes");
            for (int j = 0; j < estudiantesArray.length(); j++) {
                JSONObject estJSON = estudiantesArray.getJSONObject(j);
                Estudiante est = new Estudiante(estJSON.getString("id"), estJSON.getString("name"));
                JSONArray actividades = estJSON.getJSONArray("actividadesCompletadas");
                for (int k = 0; k < actividades.length(); k++) {
                    est.completarActividad(actividades.getString(k));
                }
                JSONObject calificaciones = estJSON.getJSONObject("calificaciones");
                for (String key : calificaciones.keySet()) {
                    est.agregarCalificacion(key, calificaciones.getInt(key));
                }
                estudiantes.put(est.getId(), est);
            }
            datos.put("estudiantes", estudiantes);

            // Cargar profesores
            Map<String, Profesor> profesores = new HashMap<>();
            JSONArray profesoresArray = jsonObject.getJSONArray("profesores");
            for (int j = 0; j < profesoresArray.length(); j++) {
                JSONObject profJSON = profesoresArray.getJSONObject(j);
                Profesor prof = new Profesor(profJSON.getString("id"), profJSON.getString("name"));
                JSONArray actividades = profJSON.getJSONArray("actividadesCreadas");
                for (int k = 0; k < actividades.length(); k++) {
                    prof.crearActividad(actividades.getString(k));
                }
                profesores.put(prof.getId(), prof);
            }
            datos.put("profesores", profesores);

        } catch (IOException e) {
            System.out.println("Archivo no encontrado, iniciando sin datos.");
        }
        return datos;
    }

    public static void guardarDatos(Map<String, Object> datos) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            JSONObject jsonObject = new JSONObject();

            // Guardar estudiantes
            JSONArray estudiantesArray = new JSONArray();
            Map<String, Estudiante> estudiantes = (Map<String, Estudiante>) datos.get("estudiantes");
            for (Estudiante est : estudiantes.values()) {
                JSONObject estJSON = new JSONObject();
                estJSON.put("id", est.getId());
                estJSON.put("name", est.getName());
                estJSON.put("actividadesCompletadas", est.getActividadesCompletadas());
                estJSON.put("calificaciones", new JSONObject(est.getCalificaciones()));
                estudiantesArray.put(estJSON);
            }
            jsonObject.put("estudiantes", estudiantesArray);

            // Guardar profesores
            JSONArray profesoresArray = new JSONArray();
            Map<String, Profesor> profesores = (Map<String, Profesor>) datos.get("profesores");
            for (Profesor prof : profesores.values()) {
                JSONObject profJSON = new JSONObject();
                profJSON.put("id", prof.getId());
                profJSON.put("name", prof.getName());
                profJSON.put("actividadesCreadas", prof.getActividadesCreadas());
                profesoresArray.put(profJSON);
            }
            jsonObject.put("profesores", profesoresArray);

            writer.write(jsonObject.toString(4)); // Pretty print JSON
        } catch (IOException e) {
            System.out.println("Error al guardar datos: " + e.getMessage());
        }
    }
}
