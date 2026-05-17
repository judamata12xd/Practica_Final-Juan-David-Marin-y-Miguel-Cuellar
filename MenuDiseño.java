
import java.util.LinkedList;
import java.util.Scanner;

public class MenuDiseño {

    public void Menudis(LinkedList<EstudiDiseño> l, LinkedList<Computadora> c,LinkedList<Tableta> t){
        Scanner sc = new Scanner(System.in);
        metodos m = new metodos();
        boolean bandera = true;

          while (bandera) {
            System.out.println("Bienvenido a el menu de diseño");
            System.out.println("Que desea realizar");
            System.out.println("1. Registrar Prestamo");
            System.out.println("2. Modificar prestamo");
            System.out.println("3. Devolucion de equipo");
            System.out.println("4. Buscar equipo");
            System.out.println("5. Volver a el menu principal");
            int opt = sc.nextInt();

            switch (opt) {
                case 1:
                    l = m.prestamoDis(l, c, t);
                    break;
                case 2:
                    System.out.println("¿Como desea buscar a el estudiante?");
                    System.out.println("1. cedula");
                    System.out.println("2. Serial");
                    int bus = sc.nextInt();
                    if(bus == 1){
                        System.out.println("Ingrese la cedula");
                        String cedu = sc.next();
                        l = m.ModificarDIS(l, cedu);
                    } else {
                        System.out.println("Ingrese el serial");
                        int seri = sc.nextInt();
                        l = m.ModificarDIS1(l, seri);
                    } 
                    break;
                case 3:
                    l = m.DevolucionDIS(l, c, t);
                    break;
                case 4:
                    System.out.println("Como desea buscar 1. cedula 2.serial");
                    int de = sc.nextInt();
                    if(de== 1){
                        String cedula = sc.next();
                        m.BuscarEquipoDIS(l, c, t, cedula);
                    } else {
                        int serial = sc.nextInt();
                        m.BuscarEquipoDIS1(l, c, t, serial);
                    }
                    break;
                case 5:
                    System.out.println("Rregresando a el menu principal..");
                    bandera = false;
                    break;
                default:
                     l = m.RegistarDis(l);
            }
        }
    }
    
}
