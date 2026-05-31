import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

public class ImportarDis {

    public LinkedList<EstudiDiseño> ImportarArchivoDIS(LinkedList<Computadora> pcs, LinkedList<Tableta> tabletas) {
        String rutaArchivo = "EstudiantesDiseño.txt";
        LinkedList<EstudiDiseño> lista = new LinkedList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            
            EstudiDiseño estudianteTemp = new EstudiDiseño();
            Computadora pcTemp = null; 
            Tableta tabTemp = null; 

            while ((linea = br.readLine()) != null) {
                
                if (linea.startsWith("---")) {
                    lista.add(estudianteTemp);
                    
                    if (pcTemp != null) pcs.add(pcTemp);
                    if (tabTemp != null) tabletas.add(tabTemp);
                    
                    estudianteTemp = new EstudiDiseño();
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
                    
                // Atributos exclusivos de Diseño
                } else if (linea.startsWith("Modalidad:")) {
                    estudianteTemp.setModalidad(linea.substring(10).trim());
                } else if (linea.startsWith("Asignaturas:")) {
                    estudianteTemp.setCantidadAsignaturas(Integer.parseInt(linea.substring(12).trim()));
                    
                } else if (linea.startsWith("Serial:")) {
                    int serialImportado = Integer.parseInt(linea.substring(7).trim());
                    estudianteTemp.setSerial(serialImportado);
                    
                } else if (linea.startsWith("TipoEquipo:")) {
                    String tipo = linea.substring(11).trim();
                    // Al asignarle el serial al equipo, lo convertimos de vuelta a String
                    String serialStr = String.valueOf(estudianteTemp.getSerial());
                    
                    if (tipo.equals("PC")) {
                        pcTemp = new Computadora();
                        pcTemp.setSerial(serialStr); 
                    } else if (tipo.equals("Tableta")) {
                        tabTemp = new Tableta();
                        tabTemp.setSerial(serialStr); 
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
            
            System.out.println("Archivo de Diseño, computadoras y tabletas sincronizados correctamente.");

        } catch (Exception ex) {
            System.out.println("Error al importar: " + ex.getMessage());
        }
        
        return lista;
    }
}