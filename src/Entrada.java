public class Entrada {
    private int id;
    private int concierto;
    private String comprador;
    private int cantidad;
    private String fechaCompra;

    public Entrada(int id, int concierto, String comprador, int cantidad, String fechaCompra) {
        this.id = id;
        this.concierto = concierto;
        this.comprador = comprador;
        this.cantidad = cantidad;
        this.fechaCompra = fechaCompra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getConcierto() {
        return concierto;
    }

    public void setConcierto(int concierto) {
        this.concierto = concierto;
    }

    public String getComprador() {
        return comprador;
    }

    public void setComprador(String comprador) {
        this.comprador = comprador;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
}
