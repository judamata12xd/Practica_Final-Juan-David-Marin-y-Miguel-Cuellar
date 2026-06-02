import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class ExportarIng {
    
    public void exportarArchivoING(LinkedList<EstudyInge> lista, LinkedList<Computadora> pcs, LinkedList<Tableta> tabletas) {
        if (lista.isEmpty()) {
            System.out.println("La lista esta vacia, no se puede exportar el archivo.");
            return;
        } 
        
        try (FileWriter e = new FileWriter("Estudiantes_Ingenieria.txt")) {
            
            for (EstudyInge obj : lista) {
                e.write("Nombre: " + obj.getNombre() + "\n");
                e.write("Apellido: " + obj.getApellido() + "\n");
                e.write("Cedula: " + obj.getCedula() + "\n");
                e.write("Telefono: " + obj.getTelefono() + "\n");
                e.write("Semestre: " + obj.getNumeroSemestre() + "\n");
                e.write("Promedio: " + obj.getPromedio() + "\n");
                
                String serial = obj.getSerial();
                
                if (serial == null || serial.trim().isEmpty() || serial.equals("0")) {
                    e.write("Serial: 0\n"); 
                } else {
                    e.write("Serial: " + serial + "\n");
                    
                    boolean equipoEncontrado = false;
                    
                    for (Computadora pc : pcs) {
                        if (pc.getSerial().equals(serial)) {
                            e.write("TipoEquipo: PC\n");
                            e.write("Marca: " + pc.getMarca() + "\n");
                            e.write("Tamano: " + pc.getTamaño() + "\n");
                            e.write("Precio: " + pc.getPrecio() + "\n");
                            e.write("SO: " + pc.getSistemaOperativo() + "\n");
                            e.write("Procesador: " + pc.getProcesador() + "\n");
                            equipoEncontrado = true;
                            break;
                        }
                    }
                    
                    if (!equipoEncontrado) {
                        for (Tableta tab : tabletas) {
                            if (tab.getSerial().equals(serial)) {
                                e.write("TipoEquipo: Tableta\n");
                                e.write("Marca: " + tab.getMarca() + "\n");
                                e.write("Tamano: " + tab.getTamaño() + "\n");
                                e.write("Precio: " + tab.getPrecio() + "\n");
                                e.write("Almacenamiento: " + tab.getAlmacenamiento() + "\n");
                                e.write("Peso: " + tab.getPeso() + "\n");
                                break;
                            }
                        }
                    }
                }
                e.write("------------------------------------------------------\n");
            }
            System.out.println("-->Archivo de Ingenieria y sus equipos exportados correctamente.");

        } catch (IOException ex) {
            System.out.println("Error al exportar el archivo: " + ex.getMessage());
        }
    }
}