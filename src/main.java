public class main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca("Central");

        // Agregar libros
        biblioteca.addLibro(new Libro("Don Quijote", "Cervantes", 1605));
        biblioteca.addLibro(new Libro("Cien Años de Soledad", "García Márquez", 1967));

        // Agregar salas
        Sala sala1 = new Sala("Lectura", 2);
        Sala sala2 = new Sala("Estudio", 3);
        biblioteca.addSala(sala1);
        biblioteca.addSala(sala2);

        // Personas
        Persona p1 = new Persona("Juan", 19);
        Persona p2 = new Persona("Jesus", 21);

        sala1.entrarPersona(p1);
        sala1.entrarPersona(p2);

        biblioteca.mostrarBiblioteca();
        biblioteca.mostrarSalasDisponibles();
    }
}
