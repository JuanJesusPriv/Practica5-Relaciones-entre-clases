public class LibroDigital extends Libro {
    private String formato; // pdf, epub...
    private double tamanoMB;

    public LibroDigital(String titulo, String autor, int anio, String formato, double tamanoMB) {
        super(titulo, autor, anio);
        this.formato = formato;
        this.tamanoMB = tamanoMB;
    }

    public String getFormato() { return formato; }
    public void setFormato(String formato) { this.formato = formato; }
    public double getTamanoMB() { return tamanoMB; }
    public void setTamanoMB(double tamanoMB) { this.tamanoMB = tamanoMB; }

    @Override
    public void mostrarInfo() {
        System.out.println("Libro Digital: " + getTitulo() + " - " + getAutor() + " (" + getAnioPublicacion() + ")"
            + " Formato: " + formato + " Tamaño: " + tamanoMB + "MB");
    }
}
