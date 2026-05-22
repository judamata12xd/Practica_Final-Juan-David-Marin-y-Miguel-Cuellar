import java.util.LinkedList;
import java.util.Scanner;

public class metodos {

    Scanner sc = new Scanner(System.in);

    public LinkedList<EstudyInge> RegistarIng(LinkedList<EstudyInge> l, LinkedList<Tableta> t,
            LinkedList<Computadora> c) {
        boolean pedir = true;

        while (pedir) {
            System.out.println("\n Ingresar estudiante");
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
            System.out.println("Que desea prestar?");
            System.out.println("1. Computador");
            System.out.println("2. Tablet");
            int pres = sc.nextInt();

            switch (pres) {
                case 1:
                    System.out.println("Ingrese el serial");
                    String serialPC = sc.next();
                    Computadora pc = RegistroPC(serialPC);
                    c.add(pc);
                    o.setSerial(pc.getSerial());
                    System.out.println("Prestamo realizado");
                    break;
                case 2:
                    System.out.println("Ingrese el serial");
                    String serialTAB = sc.next();
                    Tableta tab = RegistarTab(serialTAB);
                    t.add(tab);
                    o.setSerial(tab.getSerial());
                    System.out.println("Prestamo realizado ");
                    break;
            }
            l.add(o);
            System.out.println("Desea seguir agregando estudiantes 1 si 2 no");
            int opt = sc.nextInt();
            if (opt == 2) {
                pedir = false;
            }
        }
        return l;
    }

    public LinkedList<EstudiDiseño> RegistarDis(LinkedList<EstudiDiseño> l, LinkedList<Computadora> c,
            LinkedList<Tableta> t) {
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
            System.out.println("Que desea prestar?");
            System.out.println("1. Computador");
            System.out.println("2. Tablet");
            int pres = sc.nextInt();

            switch (pres) {
                case 1:
                    System.out.println("Ingrese el serial");
                    int serialPC = sc.nextInt();
                    Computadora pc = RegistroPC(String.valueOf(serialPC));
                    c.add(pc);
                    o.setSerial(serialPC);
                    System.out.println("Prestamo realizado");
                    break;
                case 2:
                    System.out.println("Ingrese el serial");
                    int serialTab = sc.nextInt();
                    Tableta tab = RegistarTab(String.valueOf(serialTab));
                    t.add(tab);
                    o.setSerial(serialTab);
                    System.out.println("Prestamo realizado ");
                    break;
            }
            l.add(o);
            System.out.println("Desea seguir agregando estudiantes 1 si 2 no");
            int opt = sc.nextInt();
            if (opt == 2) {
                pedir = false;
            }
        }
        return l;
    }

    public Computadora RegistroPC(String Serial) {
        Computadora pc = new Computadora();
        pc.setSerial(Serial);
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
        return pc;
    }

    public Tableta RegistarTab(String serial) {
        Tableta tab = new Tableta();
        tab.setSerial(serial);
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
        return tab;
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

    public void MostarDIS(LinkedList<EstudiDiseño> l, LinkedList<Computadora> c, LinkedList<Tableta> t) {
        if (l.isEmpty()) {
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

    public LinkedList<EstudyInge> ModificarING(LinkedList<EstudyInge> l, String modificar) {
        boolean encontrado = false;
        for (EstudyInge o : l) {
            if (o.getCedula().equals(modificar) || o.getSerial().equals(modificar)) {
                encontrado = true;
                System.out.println("\n Modificando estudiante: " + o.getNombre() + " " + o.getApellido());
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
                System.out.println("Datos actualizados con exito");
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se a encontrado estudiante con registro: " + modificar);
        }
        return l;
    }

    public LinkedList<EstudiDiseño> ModificarDIS(LinkedList<EstudiDiseño> l, String modificar) {
        boolean encontrado = false;
        for (EstudiDiseño o : l) {
            if (o.getCedula().equals(modificar)) {
                encontrado = true;
                System.out.println("\n Modificando estudiante: " + o.getNombre() + " " + o.getApellido());
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
            }
        }
        if (!encontrado) {
            System.out.println("No se a encontrado estudiante con registro: " + modificar);
        }
        return l;
    }

    public LinkedList<EstudiDiseño> ModificarDIS1(LinkedList<EstudiDiseño> l, int modificar) {
        boolean encontrado = false;
        for (EstudiDiseño o : l) {
            if (o.getSerial() == modificar) {
                encontrado = true;
                System.out.println("\n Modificando estudiante: " + o.getNombre() + " " + o.getApellido());
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
            }
        }
        if (!encontrado) {
            System.out.println("No se a encontrado estudiante con registro: " + modificar);
        }
        return l;
    }

    public LinkedList<EstudyInge> DevolucionING(LinkedList<EstudyInge> l, LinkedList<Computadora> c,
            LinkedList<Tableta> t) {
        System.out.println("Ingrese la cedula del estudiante");
        String cedula = sc.next();

        EstudyInge encontrado = null;
        for (EstudyInge o : l) {
            if (o.getCedula().equals(cedula)) {
                encontrado = o;
                break;
            }
        }
        if (encontrado == null) {
            System.out.println("El estudiante con cedula " + cedula + " No esta registrado");
            return l;
        }

        String serial = encontrado.getSerial();
        if (serial != null && !serial.equals("")) {
            boolean eliminarPC = c.removeIf(x -> x.getSerial().equals(serial));
            if (!eliminarPC) {
                t.removeIf(x -> x.getSerial().equals(serial));
            }
            System.out.println("Devolucion exitosa del equipo con serial: " + serial);
        } else {
            System.out.println("El estudiante no tiene ningun equipo asignado");
        }
        l.removeIf(x -> x.getCedula().equals(cedula));
        System.out.println("El registro del estudiante a salido de la base de datos");
        return l;
    }

    public LinkedList<EstudiDiseño> DevolucionDIS(LinkedList<EstudiDiseño> l, LinkedList<Computadora> c,
            LinkedList<Tableta> t) {

        System.out.println("Ingrese la cedula del estudiante");
        String cedula = sc.next();

        EstudiDiseño encontrado = null;
        for (EstudiDiseño o : l) {
            if (o.getCedula().equals(cedula)) {
                encontrado = o;
                break;
            }
        }
        if (encontrado == null) {
            System.out.println("El estudiante con cedula " + cedula + " No esta registrado");
            return l;
        }

        int serial = encontrado.getSerial();

        if (serial != 0) {
            String serial1 = String.valueOf(serial);
            boolean eliminarPC = c.removeIf(x -> x.getSerial().equals(serial1));
            if(!eliminarPC){
                t.removeIf(x -> x.getSerial().equals(serial1));
            }
            System.out.println("Devolucion exitosa del equipo con serial: " + serial1);
        } else {
            System.out.println("El estudiante no tienen ningun diapositivo asignado");
        }
        l.removeIf(x -> x.getCedula().equals(cedula));
        System.out.println("El registro del estudiante a salido de la base de datos");
    return l;
    }

    public void MostarEquipos(LinkedList<Computadora> c, LinkedList<Tableta> t, String serial) {
        for (Computadora pc : c) {
            if (pc.getSerial().equals(serial)) {
                System.out.println("----------Computadora----------");
                System.out.println("Marca: " + pc.getMarca());
                System.out.println("Tamaño: " + pc.getTamaño());
                System.out.println("Precio: " + pc.getPrecio());
                System.out.println("Sistema operativo: " + pc.getSistemaOperativo());
                System.out.println("Procedador: " + pc.getProcesador());
                return;
            }
        }

        for (Tableta tab : t) {
            if (tab.getSerial().equals(serial)) {
                System.out.println("Marca: " + tab.getMarca());
                System.out.println("Tamaño: " + tab.getTamaño());
                System.out.println("Precio: " + tab.getPrecio());
                System.out.println("Almacenamiento: " + tab.getAlmacenamiento());
                System.out.println("Peso: " + tab.getPeso());
                return;
            }
        }
    }

    public LinkedList<EstudyInge> BuscarEquipo(LinkedList<EstudyInge> inge, LinkedList<Computadora> c,
            LinkedList<Tableta> t, String criterio) {

        for (EstudyInge e : inge) {
            if (e.getCedula().contains(criterio)) {
                if (e.getSerial() == null || e.getSerial().equals("")) {
                    System.out.println("El estudiante: " + e.getNombre() + " " + e.getApellido()
                            + " No tiene diapositivo asisgnado");
                    return inge;
                } else {
                    System.out.println("Prestamo encontrado");
                    System.out.println("El prestamo le pertene a el estudiante: " + e.getNombre() + " " +
                            e.getApellido() + " Con cedula: " + e.getCedula());
                    System.out.println("Serial equipo: " + e.getSerial());
                    MostarEquipos(c, t, e.getSerial());
                    return inge;
                }
            }

            if (e.getSerial().equals(criterio) && e.getSerial() != null) {
                System.out.println("Prestamo encontrado");
                System.out.println("El prestamo le pertene a el estudiante: " + e.getNombre() + " " +
                        e.getApellido() + " Con cedula: " + e.getCedula());
                System.out.println("Serial equipo: " + e.getSerial());
                MostarEquipos(c, t, e.getSerial());
                return inge;
            }
        }

        System.out.println("La cedula o serial: " + criterio + " NO existe");
        return inge;
    }

    public LinkedList<EstudiDiseño> BuscarEquipoDIS(LinkedList<EstudiDiseño> dis, LinkedList<Computadora> c,
            LinkedList<Tableta> t, String cedula) {

        for (EstudiDiseño d : dis) {
            if (d.getCedula().equals(cedula)) {
                if (d.getSerial() <= 0) {
                    System.out.println("El estudiante: " + d.getNombre() + " " + d.getApellido()
                            + " No tiene diapositivo asisgnado");
                    return dis;
                } else {
                    System.out.println("Prestamo encontrado");
                    System.out.println("El prestamo le pertene a el estudiante: " + d.getNombre() + " " +
                            d.getApellido() + " Con cedula: " + d.getCedula());
                    System.out.println("Serial equipo: " + d.getSerial());
                    MostarEquipos(c, t, String.valueOf(d.getSerial()));
                    return dis;
                }
            }

        }
        System.out.println("La cedula : " + cedula + " NO existe");
        return dis;
    }

    public LinkedList<EstudiDiseño> BuscarEquipoDIS1(LinkedList<EstudiDiseño> dis, LinkedList<Computadora> c,
            LinkedList<Tableta> t, int serial) {

        if (serial <= 0) {
            System.out.println("El serial ingresado no es valido");
            return dis;
        }

        for (EstudiDiseño d : dis) {
            if (d.getSerial() == serial) {
                System.out.println("Prestamo encontrado");
                System.out.println("El prestamo le pertene a el estudiante: " + d.getNombre() + " " +
                        d.getApellido() + " Con cedula: " + d.getCedula());
                System.out.println("Serial equipo: " + d.getSerial());
                MostarEquipos(c, t, String.valueOf(d.getSerial()));
                return dis;
            }
        }

        System.out.println("El serial : " + serial + " NO existe");

        return dis;
    }

}
