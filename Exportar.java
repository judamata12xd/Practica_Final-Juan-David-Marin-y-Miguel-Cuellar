import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;


public class Exportar {
    
    public void exportarArchivoING(LinkedList<EstudyInge> lista) {
        if (lista.isEmpty()) {
            System.out.println("La lista esta vacia no se puede exportar el archivo");
            return;
        } 
        
        // El try-with-resources asegura que el archivo se cierre solo al terminar
        try (FileWriter e = new FileWriter("Estudiantes.txt")) {
            
            for (EstudyInge obj : lista) {
                // Escribimos los datos respetando rigurosamente el orden del importador
                e.write("Nombre: " + obj.getNombre() + "\n");
                e.write("Apellido: " + obj.getApellido() + "\n");
                e.write("Cedula: " + obj.getCedula() + "\n");
                e.write("Telefono: " + obj.getTelefono() + "\n");
                e.write("Semestre: " + obj.getNumeroSemestre() + "\n");
                e.write("Promedio: " + obj.getPromedio() + "\n");
                e.write("Serial: " + obj.getSerial() + "\n");
                
                // Separador visual solicitado por el profesor
                e.write("------------------------------------------------------ \n");
            }
            System.out.println("Archivo de Ingenieria exportado correctamente ");

        } catch (IOException e) {
            System.out.println("Error al exportar el archivo: " + e.getMessage());
        }
    }
}

