public class LibroFisico extends Libro {
    private int numPaginas;
    private String ubicacion;

    public LibroFisico(String titulo, String autor, int anio, int numPaginas, String ubicacion) {
        super(titulo, autor, anio);
        this.numPaginas = numPaginas;
        this.ubicacion = ubicacion;
    }

    public int getNumPaginas() { return numPaginas; }
    public void setNumPaginas(int numPaginas) { this.numPaginas = numPaginas; }
    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }

    @Override
    public void mostrarInfo() {
        System.out.println("Libro Físico: " + getTitulo() + " - " + getAutor() + " (" + getAnioPublicacion() + ")"
            + " Paginas: " + numPaginas + " Ubicación: " + ubicacion);
    }
}
