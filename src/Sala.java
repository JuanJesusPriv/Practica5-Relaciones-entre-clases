import java.util.ArrayList;
import java.util.List;

public class Sala {
    private String nombre;
    private int aforoMaximo;
    private List<Persona> personas;
    private String tipo; 
    private Persona responsable; // asociación Sala -> Persona

    public Sala(String nombre, int aforoMaximo, String tipo) {
        this.nombre = nombre;
        this.aforoMaximo = aforoMaximo;
        this.tipo = tipo;
        this.personas = new ArrayList<>();
        this.responsable = null;
    }

    // getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getAforoMaximo() { return aforoMaximo; }
    public void setAforoMaximo(int aforoMaximo) { this.aforoMaximo = aforoMaximo; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public Persona getResponsable() { return responsable; }
    public void setResponsable(Persona responsable) { this.responsable = responsable; }

    // Métodos para entrar/salir personas
    public boolean entrarPersona(Persona p) {
        if (personas.size() < aforoMaximo) {
            personas.add(p);
            System.out.println(p.getNombre() + " ha entrado en la sala " + nombre);
            return true;
        } else {
            System.out.println("No se puede entrar: la sala " + nombre + " está llena.");
            return false;
        }
    }

    public boolean salirPersona(Persona p) {
        if (personas.remove(p)) {
            System.out.println(p.getNombre() + " ha salido de la sala " + nombre);
            return true;
        } else {
            System.out.println("La persona no está en la sala " + nombre);
            return false;
        }
    }

    public void mostrarPersonas() {
        System.out.println("Personas en sala " + nombre + " (" + personas.size() + "/" + aforoMaximo + "):");
        if (personas.isEmpty()) {
            System.out.println("  Ninguna");
        } else {
            for (Persona p : personas) p.mostrarInfo();
        }
    }

    public int getNumeroPersonas() { return personas.size(); }

    public void mostrarInfo() {
        System.out.println("Sala: " + nombre + " | Tipo: " + tipo + " | Aforo: " + aforoMaximo
            + " | Ocupación: " + personas.size());
        if (responsable != null) {
            System.out.println("  Responsable: " + responsable.getNombre());
        }
    }
}
