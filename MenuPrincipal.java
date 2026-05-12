
import java.util.Scanner;

public class MenuPrincipal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean seguir = true;
        MenuIngenieria mening = new MenuIngenieria();
        MenuDiseño mendis = new MenuDiseño();

        while (seguir) {
            System.out.println("Bienvenido a el sistema de prestamos ITM :D");
            System.out.println("1. Menu estudiantes ingenieria");
            System.out.println("2. Menu estudiantes diseño");
            System.out.println("3. Inventario total");
            System.out.println("4. salir");

            int opt = sc.nextInt();

            switch (opt) {
                case 1:
                    mening.MenuIng();
                    break;
                case 2:
                    mendis.Menudis();
                    break;
                case 3:
                    System.out.println("Sistema en mantenimiento");
                    break;
                case 4:
                    seguir = false;
                    System.out.println("Gracias por utilizar el sistema buelva pronto");
                    break;
                default:
                    System.out.println("Opcion no implementada");
            }
        }
    }

}
