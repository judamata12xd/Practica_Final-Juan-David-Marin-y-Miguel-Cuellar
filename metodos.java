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

    public LinkedList<EstudiDiseño> prestamoDis(LinkedList<EstudiDiseño> l, LinkedList<Computadora> c,
            LinkedList<Tableta> t) {

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
            if (o.getSerial() > 0) {
                System.out.println("El estudiante ya tiene equipo con el serial: " + o.getSerial());
                return l;
            }
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

        } else {
            System.out.println("Estudiante no encontrado");
        }
        return l;
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
        if (serial == null || serial.equals("")) {
            System.out.println("El estudiante no tiene ningun equipo asignado");
            return l;
        }
        boolean eliminarPC = c.removeIf(x -> x.getSerial().equals(serial));
        boolean eliminarTAB = false;

        if (!eliminarPC) {
            eliminarTAB = t.removeIf(x -> x.getSerial().equals(serial));
        }

        if (eliminarPC || eliminarTAB) {
            encontrado.setSerial("");
            System.out.println("Devolucion exitosa el equipo con serial " + serial + " fue eliminado");
        } else {
            System.out.println("El serial no existe en el inventario");
        }

        System.out.println("Que desea hacer con el registro del estudiante: ");
        System.out.println("1. Eliminar por completo a el estudiante");
        System.out.println("2. Conservar a el estudiante en la base de datos para futuros registros");
        int opt = sc.nextInt();
        if (opt == 1) {
            l.removeIf(x -> x.getCedula().equals(cedula));
        } else {
            System.out.println("El estudiante sigue en el sistema");
        }
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

        if (serial <= 0) {
            System.out.println("El estudiante no tienen ningun diapositivo asignado");
            return l;
        }

        String serial1 = String.valueOf(serial);
        boolean eliminarPC = c.removeIf(x -> x.getSerial().equals(serial1));
        boolean eliminarTAB = false;

        if (!eliminarPC) {
            eliminarTAB = t.removeIf(x -> x.getSerial().equals(serial1));
        }

        if (eliminarPC || eliminarTAB) {
            encontrado.setSerial(0);
            System.out.println("Devolucion exitosa el equipo con serial " + serial + " fue eliminado");
        } else {
            System.out.println("El serial no existe en el inventario");
        }

        System.out.println("Que desea hacer con el registro del estudiante: ");
        System.out.println("1. Eliminar por completo a el estudiante");
        System.out.println("2. Conservar a el estudiante en la base de datos para futuros registros");
        int opt = sc.nextInt();

        if (opt == 1) {
            l.removeIf(x -> x.getCedula().equals(cedula));
        } else {
            System.out.println("El estudiante sigue en el sistema");
        }
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

    public boolean BuscarEquipo(LinkedList<EstudyInge> inge, LinkedList<Computadora> c,
            LinkedList<Tableta> t, String criterio) {

        for (EstudyInge e : inge) {
            if (e.getCedula().contains(criterio)) {
                if (e.getSerial() == null || e.getSerial().equals("")) {
                    System.out.println("El estudiante: " + e.getNombre() + " " + e.getApellido()
                            + " No tiene diapositivo asisgnado");
                    return false;
                } else {
                    System.out.println("Prestamo encontrado");
                    System.out.println("El prestamo le pertene a el estudiante: " + e.getNombre() + " " +
                            e.getApellido() + " Con cedula: " + e.getCedula());
                    System.out.println("Serial equipo: " + e.getSerial());
                    MostarEquipos(c, t, e.getSerial());
                    return true;
                }
            }

            if (e.getSerial().equals(criterio) && e.getSerial() != null) {
                System.out.println("Prestamo encontrado");
                System.out.println("El prestamo le pertene a el estudiante: " + e.getNombre() + " " +
                        e.getApellido() + " Con cedula: " + e.getCedula());
                System.out.println("Serial equipo: " + e.getSerial());
                MostarEquipos(c, t, e.getSerial());
                return true;
            }
        }

        System.out.println("La cedula o serial: " + criterio + " NO existe");
        return false;
    }

    public boolean BuscarEquipoDIS(LinkedList<EstudiDiseño> dis, LinkedList<Computadora> c,
            LinkedList<Tableta> t, String cedula) {

        for (EstudiDiseño d : dis) {
            if (d.getCedula().equals(cedula)) {
                if (d.getSerial() <= 0) {
                    System.out.println("El estudiante: " + d.getNombre() + " " + d.getApellido()
                            + " No tiene diapositivo asisgnado");
                    return false;
                } else {
                    System.out.println("Prestamo encontrado");
                    System.out.println("El prestamo le pertene a el estudiante: " + d.getNombre() + " " +
                            d.getApellido() + " Con cedula: " + d.getCedula());
                    System.out.println("Serial equipo: " + d.getSerial());
                    MostarEquipos(c, t, String.valueOf(d.getSerial()));
                    return true;
                }
            }

        }
        System.out.println("La cedula : " + cedula + " NO existe");
        return false;
    }

    public boolean BuscarEquipoDIS1(LinkedList<EstudiDiseño> dis, LinkedList<Computadora> c,
            LinkedList<Tableta> t, int serial) {

        if (serial <= 0) {
            System.out.println("El serial ingresado no es valido");
            return false;
        }

        for (EstudiDiseño d : dis) {
            if (d.getSerial() == serial) {
                System.out.println("Prestamo encontrado");
                System.out.println("El prestamo le pertene a el estudiante: " + d.getNombre() + " " +
                        d.getApellido() + " Con cedula: " + d.getCedula());
                System.out.println("Serial equipo: " + d.getSerial());
                MostarEquipos(c, t, String.valueOf(d.getSerial()));
                return true;
            }
        }

        System.out.println("El serial : " + serial + " NO existe");

        return false;
    }

}
