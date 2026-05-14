
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
                    l = m.RegistarDis(l);
                    break;
                case 3:
                    System.out.println("Sistema en mantenimiento");
                    break;
                case 4:
                    System.out.println("Sistema en mantenimiento");
                    break;
                case 5:
                    System.out.println("Rregresando a el menu principal..");
                    bandera = false;
                    break;
                default:
                    System.out.println("Opcion no implementada");;
            }
        }
    }
    
}
