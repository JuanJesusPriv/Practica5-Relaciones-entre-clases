public class main {
    public static void main(String[] args) {
        Biblioteca central = new Biblioteca("Central");

        // Crear libros
        LibroFisico l1 = new LibroFisico("Don Quijote", "Cervantes", 1605, 1023, "A3");
        LibroFisico l2 = new LibroFisico("Cien Años de Soledad", "García Márquez", 1967, 471, "B1");
        LibroDigital l3 = new LibroDigital("Aprendiendo Java", "Autor Mariano Mendez", 2020, "pdf", 5.6);

        central.addLibro(l1);
        central.addLibro(l2);
        central.addLibro(l3);

        // Crear salas
        SalaLectura salaLectura = (SalaLectura) central.crearSala("lectura", "Sala Lectura 1", 10, 0);
        SalaEstudio salaEstudio = (SalaEstudio) central.crearSala("estudio", "Sala Estudio 1", 6, 3);
        SalaInformatica salaInfo = (SalaInformatica) central.crearSala("informatica", "Sala Informática 1", 12, 8);

        // Añadir algún libro a la sala de lectura
        salaLectura.addLibro(l1);
        salaLectura.addLibro(l2);

        //Crear personas
        Usuario u1 = new Usuario("Ana", 25, "U001");
        Usuario u2 = new Usuario("Juan", 30, "U002");
        Empleado e1 = new Empleado("Pau", 40, "Bibliotecario", 1800.0);

        // Registrar visitas en la biblioteca (dependencia)
        central.registrarVisita(u1);
        central.registrarVisita(u2);
        central.registrarVisita(e1);

        // Asignar responsables a salas (asociación)
        central.asignarResponsable(salaLectura, e1);
        central.asignarResponsable(salaEstudio, e1);

        // Personas entran a salas
        salaLectura.entrarPersona(u1);
        salaLectura.entrarPersona(u2);
        salaInfo.entrarPersona(e1);

        // Préstamo: usuario u1 pide prestado l2
        u1.prestarLibro(l2);

        // Mostrar información completa
        central.mostrarInformacion();

        // Mostrar salas disponibles
        central.mostrarSalasDisponibles();

        // Mostrar información extendida de sala lectura
        System.out.println();
        System.out.println("Información detallada sala lectura:");
        salaLectura.mostrarInfo();
        salaLectura.mostrarPersonas();

        // Mostrar estado del usuario con préstamos
        System.out.println();
        u1.mostrarInfo();
    }
}
