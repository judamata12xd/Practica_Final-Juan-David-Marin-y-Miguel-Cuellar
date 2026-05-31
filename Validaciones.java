import java.util.LinkedList;
import java.util.Scanner;

public class Validaciones {

    public int ValidarEntero(Scanner sc) {
        while (true) {
            try {
                String entrada = sc.nextLine().trim();
                int numero = Integer.parseInt(entrada);
                return numero;
            } catch (NumberFormatException e) {
                System.out.println("Por favor ingrese un digito numerico valido.");
            }
        }
    }

    public double ValidarDecimal(Scanner sc) {

        String decimal = sc.nextLine().trim();

        if (decimal.matches("^[0-9]+([.,][0-9]+)?$")) {
            decimal = decimal.replace(",", ".");
            return Double.parseDouble(decimal);
        } else {
            System.out.println("Ingrese un numero decimal valido");
            return ValidarDecimal(sc);
        }
    }

    public int ValidarRango(int n1, int n2, int numero, Scanner sc) {
        while (numero < n1 || numero > n2) {
            System.out.println("Por favor ingrese un rango de : " + n1 + " hasta " + n2);
            numero = ValidarEntero(sc);
        }
        return numero;
    }

    public int ValidarSemestre(int n1, int n2, int numero, Scanner sc) {
        while (numero < n1 || numero > n2) {
            System.out.println("Por favor ingrese un semestre valido : " + n1 + " hasta " + n2);
            numero = ValidarEntero(sc);
        }
        return numero;
    }

    public double ValidarRangoDeci(double n1, double n2, double numero, Scanner sc) {

        while (numero < n1 || numero > n2) {
            System.out.println("Ingrese un rango entre : " + n1 + " hasta " + n2);
            numero = ValidarDecimal(sc);
        }
        return numero;
    }

    public String TextoValido(Scanner sc) {
        int limite = 30;
        while (true) {
            String texto = sc.nextLine().trim();
            if (texto.isEmpty()) {
                System.out.println("El campo no puede estar vacio. Intente de nuevo.");
            } else if (texto.length() > limite || texto.length() < 3) {
                System.out.println("El texto es muy largo Maximo " + limite + " caracteres. Intente de nuevo.");
            } else if (!texto.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                System.out.println("Solo se permiten letras (sin caracteres especiales o numeros). Intente de nuevo.");
            } else {
                return texto;
            }
        }
    }

    public String ValidarCedula(Scanner sc, LinkedList<EstudyInge> inge, LinkedList<EstudiDiseño> dis) {
        while (true) {
            System.out.println("Ingrese la cedula");
            String cedula = sc.nextLine().trim();
            if (!cedula.matches("[0-9]+")) {
                System.out.println("La cedula solo debe contener numeros y no puede tener espacios en blanco.");
                continue;
            }
            if (cedula.length() < 7 || cedula.length() > 11) {
                System.out.println("La cedula debe tener entre 7 y 11 digitos.");
                continue;
            }
            boolean cedulaRepe = false;
            for (EstudyInge ing : inge) {
                if (ing.getCedula().equals(cedula)) {
                    cedulaRepe = true;
                    break;
                }
            }
            if (!cedulaRepe) {
                for (EstudiDiseño Dis : dis) {
                    if (Dis.getCedula().equals(cedula)) {
                        cedulaRepe = true;
                        break;
                    }
                }
            }
            if (cedulaRepe) {
                System.out.println("Esta cedula ya esta registrada en el sistema. Intente de nuevo.");
            } else {
                return cedula;
            }
        }
    }

    public String ValidarTelefono(Scanner sc) {
        while (true) {
            System.out.println("Ingrese el telefono");
            String tel = sc.nextLine().trim();
            if (tel.isEmpty()) {
                System.out.println("El telefono no puede estar vacio.");
            } else if (!tel.matches("[0-9]+")) {
                System.out.println("El telefono solo debe contener numeros, sin espacios.");
            } else if (tel.length() != 10) {
                System.out.println("Un telefono valido debe tener exactamente 10 digitos.");
            } else {
                return tel;
            }
        }
    }

    public String ValidarSerial(Scanner sc, LinkedList<EstudyInge> inge, LinkedList<EstudiDiseño> dis) {
        while (true) {
            System.out.println("Ingrese el serial");
            String serial = sc.nextLine().trim().toUpperCase();

            if (serial.isEmpty()) {
                System.out.println("El serial no puede estar vacio.");
                continue;
            }
            if (!serial.matches("^[0-9]+$")) {
                System.out.println("El serial solo debe contener numeros");
                continue;
            }
            if (serial.length() < 5 || serial.length() > 15) {
                System.out.println("El serial debe tener entre 5 y 15 caracteres.");
                continue;
            }
            boolean serialRepe = false;
            for (EstudyInge ing : inge) {
                String serialIng = ing.getSerial();
                if (serialIng != null && serialIng.toUpperCase().equals(serial)) {
                    serialRepe = true;
                    break;
                }
            }
            if (!serialRepe) {
                for (EstudiDiseño dise : dis) {
                    String serialDise = String.valueOf(dise.getSerial());
                    if (serialDise.equals(serial)) {
                        serialRepe = true;
                        break;
                    }
                }
            }
            if (serialRepe) {
                System.out.println("Este serial ya se encuentra registrado en el sistema. Intente de nuevo.");
            } else {
                return serial;
            }
        }
    }

    public String Marca(Scanner sc) {
        System.out.println("Marcas Disponibles en el inventario");
        System.out.println("1. Lenovo");
        System.out.println("2. HP");
        System.out.println("3. Asus");
        System.out.println("4. Samsung");

        int opt = ValidarEntero(sc);
        opt = ValidarRango(1, 4, opt, sc);

        switch (opt) {
            case 1:
                return "Lenovo";
            case 2:
                return "HP";
            case 3:
                return "Asus";
            case 4:
                return "Samsung";
        }
        return "otra";
    }

    public String ValidarBusqueda(Scanner sc) {
        String entrada = sc.nextLine().trim();

        if (!entrada.matches("^[0-9]{5,11}$")) {
            System.out.println("El dato debe ser numerico y tener entre 5 y 11 digitos.");
            System.out.println("Ingrese la cedula o serial nuevamente:");
            return ValidarBusqueda(sc);
        }
        return entrada;
    }

}
