import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

public class Importar {
    public LinkedList<EstudyInge> ImportarArchivoING(LinkedList<Computadora> pcs) {
        String rutaArchivo = "Estudiantes.txt";
        LinkedList<EstudyInge> lista = new LinkedList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            EstudyInge obj = null;

            while ((linea = br.readLine()) != null) {

                if (linea.startsWith("Nombre:")) {
                    if (obj != null) {
                        lista.add(obj);
                    }
                    obj = new EstudyInge();

                    obj.setNombre(linea.substring(8).trim());

                } else if (linea.startsWith("Apellido:")) {
                    if (obj != null) {
                        obj.setApellido(linea.substring(10).trim());
                    }

                } else if (linea.startsWith("Cedula:")) {
                    if (obj != null) {
                        obj.setCedula(linea.substring(8).trim());
                    }

                } else if (linea.startsWith("Telefono:")) {
                    if (obj != null) {
                        obj.setTelefono(linea.substring(10).trim());
                    }

                } else if (linea.startsWith("Semestre:")) {
                    if (obj != null) {
                        obj.setNumeroSemestre(Integer.parseInt(linea.substring(10).trim()));
                    }

                } else if (linea.startsWith("Promedio:")) {
                    if (obj != null) {
                        obj.setPromedio(Double.parseDouble(linea.substring(10).trim()));
                    }

                } else if (linea.startsWith("Serial:")) {
                    if (obj != null) {
                        String serialImportado = linea.substring(8).trim();
                        obj.setSerial(serialImportado);
                        lista.add(obj);
                        obj = null;
                    }
                }
            }
            System.out.println("Archivo de Ingenieria importado correctamente ");

        } catch (Exception e) {
            System.out.println("Error al importar: " + e.getMessage());
        }
        return lista;
    }
}
