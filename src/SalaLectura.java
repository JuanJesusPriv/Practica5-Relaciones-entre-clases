import java.util.ArrayList;
import java.util.List;

public class SalaLectura extends Sala {
    private List<Libro> listaLibros;

    public SalaLectura(String nombre, int aforoMaximo) {
        super(nombre, aforoMaximo, "Lectura");
        this.listaLibros = new ArrayList<>();
    }

    public void addLibro(Libro l) {
        listaLibros.add(l);
    }

    public void mostrarInfoExtendida() {
        mostrarInfo();
        System.out.println("  Libros en sala de lectura:");
        if (listaLibros.isEmpty()) System.out.println("    Ninguno");
        else {
            for (Libro l : listaLibros) l.mostrarInfo();
        }
    }
}
