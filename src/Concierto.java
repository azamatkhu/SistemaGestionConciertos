public class Concierto {
    private int id;
    private int artista;
    private String fecha;
    private String lugar;
    private int precioEntrada;

    public Concierto(int id, int artista, String fecha, String lugar, int precioEntrada) {
        this.id = id;
        this.artista = artista;
        this.fecha = fecha;
        this.lugar = lugar;
        this.precioEntrada = precioEntrada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArtista() {
        return artista;
    }

    public void setArtista(int artista) {
        this.artista = artista;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public int getPrecioEntrada() {
        return precioEntrada;
    }

    public void setPrecioEntrada(int precioEntrada) {
        this.precioEntrada = precioEntrada;
    }

    @Override
    public String toString() {
        return "ID: " + id + " - Artista: " + artista + " - Fecha: " + fecha + " - Lugar: " + lugar + " - Precio Entrada: " + precioEntrada;
    }
}
