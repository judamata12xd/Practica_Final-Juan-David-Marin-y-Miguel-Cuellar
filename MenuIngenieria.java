import java.util.LinkedList;
import java.util.Scanner;

public class MenuIngenieria {

    public void MenuIng(LinkedList<EstudyInge> l, LinkedList<Computadora> c, LinkedList<Tableta> t,
        LinkedList<EstudiDiseño> dis) {
        metodos m = new metodos();
        Validaciones v = new Validaciones();
        Scanner sc = new Scanner(System.in);
        boolean bandera = true;

        while (bandera) {
            System.out.println(" ");
            System.out.println("----------------------Bienvenido a el menu de ingenieria----------------------");
            System.out.println(" ");
            System.out.println("¿Que desea realizar?");
            System.out.println("1. Registrar Prestamo");
            System.out.println("2. Modificar prestamo");
            System.out.println("3. Devolucion de equipo");
            System.out.println("4. Buscar equipo");
            System.out.println("5. Volver a el menu principal");
            int opt = v.ValidarEntero(sc);
            opt = v.ValidarRango(1, 5, opt, sc);

            switch (opt) {
                case 1:
                    l = m.RegistarIng(l, t, c, dis);
                    break;
                case 2:
                    System.out.println();
                    System.out.println("Ingrese la cedula o el serial del estudiante que quiera moficar");
                    String modi = v.ValidarBusqueda(sc);
                    l = m.ModificarING(l, modi);
                    break;
                case 3:
                        l = m.DevolucionING(l, c, t);
                    break;
                case 4:
                    System.out.println();
                    System.out.println("Ingrese Cedula o serial del equipo que desea buscar");
                    String criterio = v.ValidarBusqueda(sc);
                    m.BuscarEquipo(l, c, t, criterio);
                    break;
                case 5:
                    System.out.println();
                    System.out.println("Rregresando a el menu principal...\n");
                    bandera = false;
                    break;
                default:
                    System.out.println("No implementada");
            }
        }
}

}
