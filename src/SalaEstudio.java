public class SalaEstudio extends Sala {
    private int numMesas;

    public SalaEstudio(String nombre, int aforoMaximo, int numMesas) {
        super(nombre, aforoMaximo, "Estudio");
        this.numMesas = numMesas;
    }

    public int getNumMesas() { return numMesas; }
    public void setNumMesas(int numMesas) { this.numMesas = numMesas; }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("  Mesas: " + numMesas);
    }
}
