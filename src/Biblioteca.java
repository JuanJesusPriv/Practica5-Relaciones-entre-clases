import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private String nombre;

    private List<Sala> salas;
    private List<Libro> libros;
    private List<Persona> personas;

    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.salas = new ArrayList<>();
        this.libros = new ArrayList<>();
        this.personas = new ArrayList<>();
    }

    public String getNombre() { return nombre; }


    public void registrarVisita(Persona p) {
        personas.add(p);
        System.out.println("Registro: " + p.getNombre() + " ha entrado en la biblioteca " + nombre);
    }

    // Gestión de libros (agregación)
    public void addLibro(Libro l) {
        libros.add(l);
        System.out.println("Libro añadido a colección: " + l.getTitulo());
    }

    public void removeLibro(Libro l) {
        libros.remove(l);
    }

    public Libro buscarLibroPorTitulo(String titulo) {
        for (Libro l : libros) {
            if (l.getTitulo().equalsIgnoreCase(titulo)) return l;
        }
        return null;
    }

    public void mostrarLibros() {
        System.out.println("Libros en la colección de " + nombre + ":");
        if (libros.isEmpty()) System.out.println("  Ninguno");
        else {
            for (Libro l : libros) l.mostrarInfo();
        }
    }

    // Método para crear salas desde la biblioteca (composición)
    public Sala crearSala(String tipo, String nombreSala, int aforo, int extra) {
        Sala nueva;
        switch (tipo.toLowerCase()) {
            case "lectura":
                nueva = new SalaLectura(nombreSala, aforo);
                break;
            case "estudio":
                nueva = new SalaEstudio(nombreSala, aforo, extra);
                break;
            case "informatica":
                nueva = new SalaInformatica(nombreSala, aforo, extra); 
                break;
            default:
                nueva = new Sala(nombreSala, aforo, "Genérica");
                break;
        }
        salas.add(nueva);
        System.out.println("Sala creada y añadida: " + nombreSala + " (tipo " + tipo + ")");
        return nueva;
    }

    public void addSala(Sala s) {
        salas.add(s);
        System.out.println("Sala añadida: " + s.getNombre());
    }

    public void removeSala(Sala s) {
        salas.remove(s);
    }

    public void mostrarSalas() {
        System.out.println("Salas de la biblioteca " + nombre + ":");
        if (salas.isEmpty()) System.out.println("  Ninguna");
        else {
            for (Sala s : salas) s.mostrarInfo();
        }
    }

    public void mostrarSalasDisponibles() {
        System.out.println("Salas disponibles (0 personas):");
        boolean hay = false;
        for (Sala s : salas) {
            if (s.getNumeroPersonas() == 0) {
                s.mostrarInfo();
                hay = true;
            }
        }
        if (!hay) System.out.println("  Ninguna sala está vacía.");
    }

    public int contarPersonasTotales() {
        int total = 0;
        for (Sala s : salas) total += s.getNumeroPersonas();
        return total;
    }

    // Asignar responsable (asociación Sala -> Persona)
    public void asignarResponsable(Sala s, Persona p) {
        if (salas.contains(s)) {
            s.setResponsable(p);
            System.out.println("Asignado responsable " + p.getNombre() + " a la sala " + s.getNombre());
        } else {
            System.out.println("La sala " + s.getNombre() + " no pertenece a esta biblioteca.");
        }
    }

    // Mostrar la información completa actualizada
    public void mostrarInformacion() {
        System.out.println("=== Biblioteca: " + nombre + " ===");
        System.out.println("-- Personas registradas (" + personas.size() + "):");
        if (personas.isEmpty()) System.out.println("  Ninguna");
        else for (Persona p : personas) p.mostrarInfo();

        System.out.println();
        mostrarLibros();
        System.out.println();
        mostrarSalas();
        System.out.println("Personas en todas las salas: " + contarPersonasTotales());
    }
}
