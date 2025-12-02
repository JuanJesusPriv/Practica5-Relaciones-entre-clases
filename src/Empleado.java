public class Empleado extends Persona {
    private String puesto;
    private double sueldo;

    public Empleado(String nombre, int edad, String puesto, double sueldo) {
        super(nombre, edad);
        this.puesto = puesto;
        this.sueldo = sueldo;
    }

    public String getPuesto() { return puesto; }
    public void setPuesto(String puesto) { this.puesto = puesto; }
    public double getSueldo() { return sueldo; }
    public void setSueldo(double sueldo) { this.sueldo = sueldo; }

    @Override
    public void mostrarInfo() {
        System.out.println("Empleado: " + getNombre() + " (puesto: " + puesto + ", sueldo: " + sueldo + ")");
    }
}
