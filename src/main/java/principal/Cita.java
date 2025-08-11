package principal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Cita {
    private int cedula;
    private String nombrePaciente;
    private String descripcion;
    private LocalDate fecha;
    private double costo;
    private String factura;

    public Cita(int cedula,
                String nombrePaciente,
                String descripcion,
                LocalDate fecha,
                double costo) {
        this.cedula         = cedula;
        this.nombrePaciente = nombrePaciente;
        this.descripcion    = descripcion;
        this.fecha          = fecha;
        this.costo          = costo;
        this.factura        = null;
    }

    public int getCedula() {
        return cedula;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public double getCosto() {
        return costo;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    @Override
    public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String base = "Cita{" +
                      "Cedula=" + cedula +
                      ", Nombre='" + nombrePaciente + '\'' +
                      ", Descripcion='" + descripcion + '\'' +
                      ", Fecha=" + fecha.format(formato) +
                      ", Costo=" + costo + " Colones";
        if (factura != null) {
            base += ", factura='" + factura + '\'';
        }
        return base + '}';
    }
}