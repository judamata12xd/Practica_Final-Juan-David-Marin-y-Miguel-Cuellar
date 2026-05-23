import java.util.LinkedList;
import java.util.Scanner;

public class Validaciones {

    public int ValidarEntero(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("Por favor Ingrese un digito Numérico");
            sc.nextLine();
        }
        return sc.nextInt();
    }

    public Double ValidarDecimal(Scanner sc) {
        while (!sc.hasNextDouble()) {
            System.out.println("Por favor digite un numero");
            sc.nextLine();
        }
        return sc.nextDouble();
    }

    public int ValidarRango(int n1, int n2, int numero, Scanner sc) {
        Validaciones m = new Validaciones();
        while (numero < n1 || numero > n2) {
            System.out.println("Por favor ingrese un rango de :" + n1 + " hasta " + n2);
            numero = m.ValidarEntero(sc);
        }
        return numero;
    }

    public String TextoValido(Scanner sc) {
        String texto = sc.nextLine().trim();
        int limite = 30;
        if (texto.isEmpty()) {
            System.out.println("El campo no puede estar vacio. Intente de nuevo.");
            return TextoValido(sc);
        } else if (texto.length() > limite) {
            System.out.println("El texto es muy largo Maximo " + limite + " caracteres. Intente de nuevo.");
            return TextoValido(sc);
        } else if (!texto.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
            System.out.println("Solo se permiten letras (sin caracteres especiales o numeros). Intente de nuevo.");
            return TextoValido(sc);
        } else {
            return texto;
        }
    }

    public String ValidarCedula(Scanner sc, LinkedList<EstudyInge> inge, LinkedList<EstudiDiseño> dis) {
        System.out.println("Ingrese la cedula");
        String cedula = sc.nextLine().trim();

        if (!cedula.matches("[0-9]+")) {
            System.out.println("La cedula solo debe contener numeros y no puede tener espacios en blanco.");
            return ValidarCedula(sc, inge, dis);
        }

        if (cedula.length() < 7 || cedula.length() > 11) {
            System.out.println("La cedula debe tener entre 7 y 11 digitos.");
            return ValidarCedula(sc, inge, dis);
        }

        boolean cedulaRepe = false;

        for (EstudyInge ing : inge) {
            if (ing.getCedula().equals(cedula)) {
                cedulaRepe = true;
                break;
            }
        }
        for (EstudiDiseño Dis : dis) {
            if (Dis.getCedula().equals(cedula)) {
                cedulaRepe = true;
                break;
            }
        }
        if (cedulaRepe) {
            System.out.println("Esta cedula ya esta registrada en el sistema. Intente de nuevo.");
            return ValidarCedula(sc, inge, dis);
        }
        return cedula;
    }

    public String ValidarTelefono(Scanner sc) {
        System.out.println("Ingrese el telefono");
        String tel = sc.nextLine().trim();

        if (tel.isEmpty()) {
            System.out.println("El telefono no puede estar vacio.");
            return ValidarTelefono(sc);
        }
        if (!tel.matches("[0-9]+")) {
            System.out.println("El telefono solo debe contener numeros, sin espacios.");
            return ValidarTelefono(sc); 
        }
        if (tel.length() != 10) {
            System.out.println("Un telefono valido debe tener exactamente 10 digitos.");
            return ValidarTelefono(sc); 
        }
        return tel;
    }

}
