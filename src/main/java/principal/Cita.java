package principal;

public class Cita {
    private int id;
    private String descripcion;
    private String factura; 

    public Cita(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
        this.factura = null;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    @Override
    public String toString() {
        return "Cita{" +
               "Cedula"
                + "=" + id +
               ", descripcion='" + descripcion + '\'' +
               (factura != null ? ", factura='" + factura + '\'' : "") +
               '}';
    }
}