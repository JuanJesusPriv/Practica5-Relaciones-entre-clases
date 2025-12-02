import java.util.ArrayList;
import java.util.List;

public class Usuario extends Persona {
    private String numSocio;
    private List<Libro> listaLibrosPrestados;

    public Usuario(String nombre, int edad, String numSocio) {
        super(nombre, edad);
        this.numSocio = numSocio;
        this.listaLibrosPrestados = new ArrayList<>();
    }

    public String getNumSocio() { return numSocio; }
    public void setNumSocio(String numSocio) { this.numSocio = numSocio; }

    public List<Libro> getListaLibrosPrestados() { return listaLibrosPrestados; }

    public void prestarLibro(Libro l) {
        if (l != null) {
            listaLibrosPrestados.add(l);
            System.out.println(getNombre() + " ha prestado el libro: " + l.getTitulo());
        }
    }

    public void devolverLibro(Libro l) {
        if (listaLibrosPrestados.remove(l)) {
            System.out.println(getNombre() + " ha devuelto el libro: " + l.getTitulo());
        } else {
            System.out.println(getNombre() + " no tenía prestado ese libro.");
        }
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Usuario: " + getNombre() + " (Socio: " + numSocio + ", edad: " + getEdad() + ")");
        System.out.println("  Libros prestados:");
        if (listaLibrosPrestados.isEmpty()) {
            System.out.println("    Ninguno");
        } else {
            for (Libro l : listaLibrosPrestados) {
                System.out.println("    - " + l.getTitulo());
            }
        }
    }
}

