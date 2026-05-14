import java.util.LinkedList;
import java.util.Scanner;

public class metodos {

    Scanner sc = new Scanner(System.in);

    public LinkedList<EstudyInge> RegistarIng(LinkedList<EstudyInge> l) {
        boolean pedir = true;

        while (pedir) {
            EstudyInge o = new EstudyInge();
            System.out.println("Ingrese la cedula");
            o.setCedula(sc.next());
            System.out.println("Ingrese el nombre");
            o.setNombre(sc.next());
            System.out.println("Ingrese el apellido");
            o.setApellido(sc.next());
            System.out.println("Ingrese el telefono");
            o.setTelefono(sc.next());
            System.out.println("Ingrese el numero de semestre");
            o.setNumeroSemestre(sc.nextInt());
            System.out.println("Ingrese el promedio");
            o.setPromedio(sc.nextDouble());
            o.setSerial("");
            l.add(o);
            System.out.println("Desea seguir agregando estudiantes 1 si 2 no");
            int opt = sc.nextInt();
            if (opt == 2) {
                pedir = false;
            }
        }
        return l;
    }

    public LinkedList<EstudiDiseño> RegistarDis(LinkedList<EstudiDiseño> l) {
        boolean pedir = true;

        while (pedir) {
            EstudiDiseño o = new EstudiDiseño();
            System.out.println("Ingrese la cedula");
            o.setCedula(sc.next());
            System.out.println("Ingrese el nombre");
            o.setNombre(sc.next());
            System.out.println("Ingrese el apellido");
            o.setApellido(sc.next());
            System.out.println("Ingrese el telefono");
            o.setTelefono(sc.next());
            System.out.println("Ingrese modalidad 1 presencial 2 virtual");
            int mod = sc.nextInt();
            switch (mod) {
                case 1:
                    o.setModalidad("Presencial");
                    break;
                case 2:
                    o.setModalidad("Virtual");
                    break;
            }
            System.out.println("ingrese la cantidad de asignaturas");
            o.setCantidadAsignaturas(sc.nextInt());
            o.setSerial(0);
            l.add(o);
            System.out.println("Desea seguir agregando estudiantes 1 si 2 no");
            int opt = sc.nextInt();
            if (opt == 2) {
                pedir = false;
            }
        }
        return l;
    }

    public LinkedList<EstudyInge> PrestamoING(LinkedList<Tableta> t, LinkedList<Computadora> c,
            LinkedList<EstudyInge> l) {

        if (l.isEmpty()) {
            System.out.println("No hay estudiantes registrados");
            return l;
        }

        System.out.println("Ingrese la cedula del estudiante:");
        String cedula = sc.next();
        EstudyInge o = null;
        for (EstudyInge temp : l) {
            if (temp.getCedula().equals(cedula)) {
                o = temp;
                break;
            }
        }
        if (o != null) {
            if (o.getSerial() != null && !o.getSerial().equals("")) {
                System.out.println("El estudiante ya tiene equipo con el serial: " + o.getSerial());
                return l;
            }
            System.out.println("Que desea prestar?");
            System.out.println("1. Computador");
            System.out.println("2. Tablet");
            int pres = sc.nextInt();

            switch (pres) {
                case 1:
                    Computadora pc = new Computadora();
                    System.out.println("Ingrese el serial");
                    pc.setSerial(sc.next());
                    System.out.println("Ingrese la marca");
                    pc.setMargca(sc.next());
                    System.out.println("Ingrese tamaño");
                    pc.setTamaño(sc.nextDouble());
                    System.out.println("Ingrese el precio");
                    pc.setPrecio(sc.nextDouble());
                    System.out.println("Seleccione el sistema operativo");
                    System.out.println("1. Windows 7");
                    System.out.println("2. Windows 10");
                    System.out.println("3. Windows 11");
                    int sis = sc.nextInt();
                    switch (sis) {
                        case 1:
                            pc.setSistemaOperativo("Windows 7");
                            break;
                        case 2:
                            pc.setSistemaOperativo("Windows 10");
                            break;
                        case 3:
                            pc.setSistemaOperativo("Windows 11");
                            break;
                    }
                    System.out.println("Seleccione procesador");
                    System.out.println("1.AMD Ryzen");
                    System.out.println("2. Intel Core i5");
                    int pro = sc.nextInt();
                    switch (pro) {
                        case 1:
                            pc.setProcesador("AMD Ryzen");
                            break;
                        case 2:
                            pc.setProcesador("Intel Core i5");
                            break;
                    }
                    c.add(pc);
                    o.setSerial(pc.getSerial());
                    System.out.println("Prestamo realizado");
                    break;
                case 2:
                    Tableta tab = new Tableta();
                    System.out.println("Ingrese el serial");
                    tab.setSerial(sc.next());
                    System.out.println("Ingrese la marca");
                    tab.setMarca(sc.next());
                    System.out.println("Ingrese tamaño");
                    tab.setTamaño(sc.nextDouble());
                    System.out.println("Ingrese el precio");
                    tab.setPrecio(sc.nextDouble());
                    System.out.println("Seleccione el almacenamiento");
                    System.out.println("1. 256 GB");
                    System.out.println("2. 512 GB");
                    System.out.println("3. 1 TB");
                    int alm = sc.nextInt();
                    switch (alm) {
                        case 1:
                            tab.setAlmacenamiento("256 GB");
                            break;
                        case 2:
                            tab.setAlmacenamiento("512 GB");
                            break;
                        case 3:
                            tab.setAlmacenamiento("1 TB");
                            break;
                    }
                    System.out.println("Ingrese el peso");
                    tab.setPeso(sc.nextDouble());
                    t.add(tab);
                    o.setSerial(tab.getSerial());
                    System.out.println("Prestamo realizado ");
                    break;
            }

        } else {
            System.out.println("Estudiante no encontrado");
        }
        return l;
    }

    public void MostarIng(LinkedList<EstudyInge> l, LinkedList<Computadora> c, LinkedList<Tableta> t) {
        for (EstudyInge o : l) {
            System.out.println("\n ESTUDIANTE INGIENIERIA");
            System.out.println("Cedula: " + o.getCedula());
            System.out.println("Nombre " + o.getNombre());
            System.out.println("Apellido" + o.getApellido());
            System.out.println("Telefono " + o.getTelefono());
            System.out.println("Numero semestre " + o.getNumeroSemestre());
            System.out.println("Promedio " + o.getPromedio());
            System.out.println();

            if (o.getSerial() == null || o.getSerial().equals("")) {
                System.out.println("El estudiante no tiene un equipo asignado");
            } else {
                System.out.println("Equipo asignado, serial: " + o.getSerial());
            }

            boolean encontrado = false;

            for (Computadora pc : c) {
                if (o.getSerial().equals(pc.getSerial())) {
                    System.out.println("Computador");
                    System.out.println("Marca: " + pc.getMarca());
                    System.out.println("Tamaño " + pc.getTamaño());
                    System.out.println("Precio " + pc.getPrecio());
                    System.out.println("Sistema operativo " + pc.getSistemaOperativo());
                    System.out.println("Procesador: " + pc.getProcesador());
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                for (Tableta tab : t) {
                    if (o.getSerial().equals(tab.getSerial())) {

                        System.out.println("Tableta");
                        System.out.println("Serial: " + tab.getSerial());
                        System.out.println("Marca: " + tab.getMarca());
                        System.out.println("Tamaño " + tab.getTamaño());
                        System.out.println("Precio " + tab.getPrecio());
                        System.out.println("Almacenamiento " + tab.getAlmacenamiento());
                        System.out.println("Peso " + tab.getPeso());
                        encontrado = true;
                        break;
                    }
                }
            }

        }
        System.out.println("-------------------------------------------------");
    }

    public LinkedList<EstudiDiseño> prestamoDis(LinkedList<EstudiDiseño> l,LinkedList<Computadora> c, LinkedList<Tableta> t){

        if (l.isEmpty()) {
            System.out.println("No hay estudiantes registrados");
            return l;
        }
        System.out.println("Ingrese la cedula del estudiante:");
        String cedula = sc.next();
        EstudiDiseño o = null;
        for (EstudiDiseño temp : l) {
            if (temp.getCedula().equals(cedula)) {
                o = temp;
                break;
            }
        }
        if (o != null) {
            if(o.getSerial() > 0){
                System.out.println("El estudiante ya tiene equipo con el serial: " + o.getSerial());
                return l;
            }
            System.out.println("Que desea prestar?");
            System.out.println("1. Computador");
            System.out.println("2. Tablet");
            int pres = sc.nextInt();

            switch (pres) {
                case 1:
                    Computadora pc = new Computadora();
                    System.out.println("Ingrese el serial");
                    int serialPC = sc.nextInt();
                    pc.setSerial(String.valueOf(serialPC));
                    System.out.println("Ingrese la marca");
                    pc.setMargca(sc.next());
                    System.out.println("Ingrese tamaño");
                    pc.setTamaño(sc.nextDouble());
                    System.out.println("Ingrese el precio");
                    pc.setPrecio(sc.nextDouble());
                    System.out.println("Seleccione el sistema operativo");
                    System.out.println("1. Windows 7");
                    System.out.println("2. Windows 10");
                    System.out.println("3. Windows 11");
                    int sis = sc.nextInt();
                    switch (sis) {
                        case 1:
                            pc.setSistemaOperativo("Windows 7");
                            break;
                        case 2:
                            pc.setSistemaOperativo("Windows 10");
                            break;
                        case 3:
                            pc.setSistemaOperativo("Windows 11");
                            break;
                    }
                    System.out.println("Seleccione procesador");
                    System.out.println("1.AMD Ryzen");
                    System.out.println("2. Intel Core i5");
                    int pro = sc.nextInt();
                    switch (pro) {
                        case 1:
                            pc.setProcesador("AMD Ryzen");
                            break;
                        case 2:
                            pc.setProcesador("Intel Core i5");
                            break;
                    }
                    c.add(pc);
                    o.setSerial(serialPC);
                    System.out.println("Prestamo realizado");
                    break;
                case 2:
                    Tableta tab = new Tableta();
                    System.out.println("Ingrese el serial");
                    int serialTab = sc.nextInt();
                    tab.setSerial(String.valueOf(serialTab));
                    System.out.println("Ingrese la marca");
                    tab.setMarca(sc.next());
                    System.out.println("Ingrese tamaño");
                    tab.setTamaño(sc.nextDouble());
                    System.out.println("Ingrese el precio");
                    tab.setPrecio(sc.nextDouble());
                    System.out.println("Seleccione el almacenamiento");
                    System.out.println("1. 256 GB");
                    System.out.println("2. 512 GB");
                    System.out.println("3. 1 TB");
                    int alm = sc.nextInt();
                    switch (alm) {
                        case 1:
                            tab.setAlmacenamiento("256 GB");
                            break;
                        case 2:
                            tab.setAlmacenamiento("512 GB");
                            break;
                        case 3:
                            tab.setAlmacenamiento("1 TB");
                            break;
                    }
                    System.out.println("Ingrese el peso");
                    tab.setPeso(sc.nextDouble());
                    t.add(tab);
                    o.setSerial(serialTab);
                    System.out.println("Prestamo realizado ");
                    break;
            }

        } else {
            System.out.println("Estudiante no encontrado");
        }
        return l;
    }

    public void MostarDIS(LinkedList<EstudiDiseño> l,LinkedList<Computadora> c, LinkedList<Tableta> t){
        if(l.isEmpty()){
            System.out.println("No hay estudiantes registrados");
        }

         for (EstudiDiseño o : l) {
            System.out.println("---------------------------------------------");
            System.out.println("\n ESTUDIANTE DISEÑO");
            System.out.println("Cedula: " + o.getCedula());
            System.out.println("Nombre " + o.getNombre());
            System.out.println("Apellido" + o.getApellido());
            System.out.println("Telefono " + o.getTelefono());
            System.out.println("Modalidad: " + o.getModalidad());
            System.out.println("Cantidad de asignaturas: " + o.getCantidadAsignaturas());
            System.out.println();

            if (o.getSerial() <= 0) {
                System.out.println("El estudiante no tiene un equipo asignado");
            } else {
                System.out.println("Equipo asignado, serial: " + o.getSerial());
            }

            boolean encontrado = false;
            String serial = String.valueOf(o.getSerial());

            for (Computadora pc : c) {
                if (pc.getSerial().equals(serial)) {
                    System.out.println("Computador");
                    System.out.println("Marca: " + pc.getMarca());
                    System.out.println("Tamaño " + pc.getTamaño());
                    System.out.println("Precio " + pc.getPrecio());
                    System.out.println("Sistema operativo " + pc.getSistemaOperativo());
                    System.out.println("Procesador: " + pc.getProcesador());
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                for (Tableta tab : t) {
                    if (tab.getSerial().equals(serial)) {
                        System.out.println("Tableta");
                        System.out.println("Serial: " + tab.getSerial());
                        System.out.println("Marca: " + tab.getMarca());
                        System.out.println("Tamaño " + tab.getTamaño());
                        System.out.println("Precio " + tab.getPrecio());
                        System.out.println("Almacenamiento " + tab.getAlmacenamiento());
                        System.out.println("Peso " + tab.getPeso());
                        encontrado = true;
                        break;
                    }
                }
            }

        }
        System.out.println("-------------------------------------------------");

    }


}
