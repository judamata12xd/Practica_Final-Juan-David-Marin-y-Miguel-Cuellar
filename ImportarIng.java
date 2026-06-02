import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

public class ImportarIng {
    
    public LinkedList<EstudyInge> ImportarArchivoING(LinkedList<Computadora> pcs, LinkedList<Tableta> tabletas) {
        String rutaArchivo = "Estudiantes_Ingenieria.txt";
        LinkedList<EstudyInge> lista = new LinkedList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            
            EstudyInge estudianteTemp = new EstudyInge();
            Computadora pcTemp = null; 
            Tableta tabTemp = null; 

            while ((linea = br.readLine()) != null) {
                
                if (linea.startsWith("---")) {
                    lista.add(estudianteTemp);
                    
                    if (pcTemp != null) pcs.add(pcTemp);
                    if (tabTemp != null) tabletas.add(tabTemp);
                    
                    estudianteTemp = new EstudyInge();
                    pcTemp = null;
                    tabTemp = null;
                    continue; 
                }

                if (linea.startsWith("Nombre:")) {
                    estudianteTemp.setNombre(linea.substring(7).trim());
                } else if (linea.startsWith("Apellido:")) {
                    estudianteTemp.setApellido(linea.substring(9).trim());
                } else if (linea.startsWith("Cedula:")) {
                    estudianteTemp.setCedula(linea.substring(7).trim());
                } else if (linea.startsWith("Telefono:")) {
                    estudianteTemp.setTelefono(linea.substring(9).trim());
                } else if (linea.startsWith("Semestre:")) {
                    estudianteTemp.setNumeroSemestre(Integer.parseInt(linea.substring(9).trim()));
                } else if (linea.startsWith("Promedio:")) {
                    estudianteTemp.setPromedio(Double.parseDouble(linea.substring(9).trim()));
                } else if (linea.startsWith("Serial:")) {
                    estudianteTemp.setSerial(linea.substring(7).trim());
                    
                } else if (linea.startsWith("TipoEquipo:")) {
                    String tipo = linea.substring(11).trim();
                    if (tipo.equals("PC")) {
                        pcTemp = new Computadora();
                        pcTemp.setSerial(estudianteTemp.getSerial()); 
                    } else if (tipo.equals("Tableta")) {
                        tabTemp = new Tableta();
                        tabTemp.setSerial(estudianteTemp.getSerial()); 
                    }
                    
                } else if (linea.startsWith("Marca:")) {
                    if (pcTemp != null) pcTemp.setMargca(linea.substring(6).trim());
                    if (tabTemp != null) tabTemp.setMarca(linea.substring(6).trim());
                    
                } else if (linea.startsWith("Tamano:")) {
                    double tamano = Double.parseDouble(linea.substring(7).trim());
                    if (pcTemp != null) pcTemp.setTamaño(tamano);
                    if (tabTemp != null) tabTemp.setTamaño(tamano);
                    
                } else if (linea.startsWith("Precio:")) {
                    double precio = Double.parseDouble(linea.substring(7).trim());
                    if (pcTemp != null) pcTemp.setPrecio(precio);
                    if (tabTemp != null) tabTemp.setPrecio(precio);
                
                } else if (linea.startsWith("SO:")) {
                    if (pcTemp != null) pcTemp.setSistemaOperativo(linea.substring(3).trim());
                    
                } else if (linea.startsWith("Procesador:")) {
                    if (pcTemp != null) pcTemp.setProcesador(linea.substring(11).trim());
                    
                } else if (linea.startsWith("Almacenamiento:")) {
                    if (tabTemp != null) tabTemp.setAlmacenamiento(linea.substring(15).trim());
                    
                } else if (linea.startsWith("Peso:")) {
                    double peso = Double.parseDouble(linea.substring(5).trim());
                    if (tabTemp != null) tabTemp.setPeso(peso);
                }
            }
            
            System.out.println("-->Archivo de Ingenieria, computadoras y tabletas sincronizados correctamente.");

        } catch (Exception ex) {
            System.out.println("Error al importar: " + ex.getMessage());
        }
        
        return lista;
    }
}