
import java.util.LinkedList;
import java.util.Scanner;

public class MenuPrincipal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean seguir = true;
        MenuIngenieria mening = new MenuIngenieria();
        MenuDiseño mendis = new MenuDiseño();
        metodos m = new metodos();
        Validaciones v  = new Validaciones();
        ImportarIng ImpoIng = new ImportarIng();
        ImportarDis Impodis = new ImportarDis();
        LinkedList<EstudyInge> inge = new LinkedList<>();
        LinkedList<EstudiDiseño> dis = new LinkedList<>();
        LinkedList<Computadora> c = new LinkedList<>();
        LinkedList<Tableta> t = new LinkedList<>();
        inge = ImpoIng.ImportarArchivoING(c, t);
        dis = Impodis.ImportarArchivoDIS(c, t);

        while (seguir) {
            System.out.println();
            System.out.println("----------------------Bienvenido a el sistema de prestamos ITM :D----------------------");
            System.out.println(" ");
            System.out.println("1. Menu estudiantes ingenieria");
            System.out.println("2. Menu estudiantes diseño");
            System.out.println("3. Inventario total");
            System.out.println("4. salir");
            int opt = v.ValidarEntero(sc);
            opt = v.ValidarRango(1, 4, opt, sc);
            switch (opt) {
                case 1:
                    mening.MenuIng(inge,c,t,dis);
                    break;
                case 2:
                    mendis.Menudis(dis,c,t,inge);
                    break;
                case 3:
                    m.MostarIng(inge, c, t);
                    m.MostarDIS(dis, c, t);
                    break;
                case 4:
                    seguir = false;
                    ExportarIng Exing = new ExportarIng();
                    Exing.exportarArchivoING(inge, c, t);
                    ExportarDis Exdis = new ExportarDis();
                    Exdis.exportarArchivoDIS(dis, c, t);
                    System.out.println();
                    System.out.println("Gracias por utilizar el sistema buelva pronto");
                    break;
                default:
                    System.out.println("Opcion no implementada");
            }
        }
    }

}
