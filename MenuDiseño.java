
import java.util.LinkedList;
import java.util.Scanner;

public class MenuDiseño {

    public void Menudis(LinkedList<EstudiDiseño> l, LinkedList<Computadora> c,LinkedList<Tableta> t,
        LinkedList<EstudyInge> inge){
        Scanner sc = new Scanner(System.in);
        metodos m = new metodos();
        Validaciones v = new Validaciones();
        boolean bandera = true;

          while (bandera) {
            System.out.println("Bienvenido a el menu de diseño");
            System.out.println("Que desea realizar");
            System.out.println("1. Registrar Prestamo y estudiante ");
            System.out.println("2. Modificar prestamo");
            System.out.println("3. Devolucion de equipo");
            System.out.println("4. Buscar equipo");
            System.out.println("5. Volver a el menu principal");
            int opt = v.ValidarEntero(sc);
            opt = v.ValidarRango(1, 5, opt, sc);

            switch (opt) {
                case 1:
                    l = m.RegistarDis(l, c, t,inge);
                    break;
                case 2:
                    System.out.println("¿Como desea buscar a el estudiante?");
                    System.out.println("1. cedula");
                    System.out.println("2. Serial");
                    int bus = v.ValidarEntero(sc);
                    bus = v.ValidarRango(1, 2, bus, sc);
                    if(bus == 1){
                        System.out.println("Ingrese la cedula");
                        String cedu = v.ValidarBusqueda(sc);
                        l = m.ModificarDIS(l, cedu);
                    } else {
                        System.out.println("Ingrese el serial");
                        int seri = v.ValidarEntero(sc);
                        l = m.ModificarDIS1(l, seri);
                    } 
                    break;
                case 3:
                    l = m.DevolucionDIS(l, c, t);
                    break;
                case 4:
                    System.out.println("Como desea buscar 1. cedula 2.serial");
                    int de = v.ValidarEntero(sc);
                    de = v.ValidarRango(1, 2, de, sc);
                    if(de== 1){
                        System.out.println("Ingrese la cedula");
                        String cedula = v.ValidarBusqueda(sc);
                        m.BuscarEquipoDIS(l, c, t, cedula);
                    } else {
                        System.out.println("Ingrese el serial");
                        int serial = v.ValidarEntero(sc);
                        m.BuscarEquipoDIS1(l, c, t, serial);
                    }
                    break;
                case 5:
                    System.out.println("Rregresando a el menu principal..");
                    bandera = false;
                    break;
                default:
                     
            }
        }
    }
    
}
