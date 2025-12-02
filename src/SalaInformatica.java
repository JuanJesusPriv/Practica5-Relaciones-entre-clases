public class SalaInformatica extends Sala {
    private int numEquipos;

    public SalaInformatica(String nombre, int aforoMaximo, int numEquipos) {
        super(nombre, aforoMaximo, "Informática");
        this.numEquipos = numEquipos;
    }

    public int getNumEquipos() { return numEquipos; }
    public void setNumEquipos(int numEquipos) { this.numEquipos = numEquipos; }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("  Equipos: " + numEquipos);
    }
}
