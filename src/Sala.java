

import java.util.ArrayList;
import java.util.List;

public class Sala {
    private String nombre;
    private int capacidad;
    private List<Persona> personas;

    public Sala(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.personas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void entrarPersona(Persona p) {
        if (personas.size() < capacidad) {
            personas.add(p);
            System.out.println(p.getNombre() + " ha entrado en la sala " + nombre);
        } else {
            System.out.println("La sala " + nombre + " está llena.");
        }
    }

    public void salirPersona(Persona p) {
        if (personas.remove(p)) {
            System.out.println(p.getNombre() + " ha salido de la sala " + nombre);
        } else {
            System.out.println("La persona no está en la sala.");
        }
    }

    public void mostrarPersonas() {
        System.out.println("Personas en la sala " + nombre + ":");
        if (personas.isEmpty()) {
            System.out.println("  No hay personas en la sala.");
        } else {
            for (Persona p : personas) {
                p.mostrarInfo();
            }
        }
    }

    public int getNumeroPersonas() {
        return personas.size();
    }

    public void mostrarInfo() {
        System.out.println("Sala: " + nombre + " (Capacidad: " + capacidad + ", Ocupación: " + personas.size() + ")");
    }
}
