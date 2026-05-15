import java.util.LinkedList;
import java.util.Scanner;

public class MenuIngenieria {

    public void MenuIng(LinkedList<EstudyInge> l, LinkedList<Computadora> c, LinkedList<Tableta> t) {
        metodos m = new metodos();
        Scanner sc = new Scanner(System.in);
        boolean bandera = true;

        while (bandera) {
            System.out.println("Bienvenido a el menu de ingenieria");
            System.out.println("Que desea realizar");
            System.out.println("1. Registrar Prestamo");
            System.out.println("2. Modificar prestamo");
            System.out.println("3. Devolucion de equipo");
            System.out.println("4. Buscar equipo");
            System.out.println("5. Volver a el menu principal");
            int opt = sc.nextInt();

            switch (opt) {
                case 1:
                    l = m.PrestamoING(t, c, l);
                    break;
                case 2:
                    System.out.println("Ingrese la cedula o el serial del estudiante que quiera moficar");
                    String modi = sc.next();
                    l = m.ModificarING(l, modi);
                    break;
                case 3:
                    l = m.RegistarIng(l);
                    break;
                case 4:
                    System.out.println("Sistema en mantenimiento");
                    break;
                case 5:
                    System.out.println("Rregresando a el menu principal..");
                    bandera = false;
                    break;
                default:
                    System.out.println("Opcion no implementada");
            }
        }
    }

}
