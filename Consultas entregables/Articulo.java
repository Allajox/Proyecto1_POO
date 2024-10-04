package tec.entregables;

import java.util.Date;

/**
 *
 * @author allaj
 */
public class Articulo {
    private String nombre;
    private String estadoArticulo;
    private Date fechaRecibido;
    private Date fechaEntregado;
    private Date fechaPendiente;
    private double montoCobrado;

    public Articulo(String nombre) {
        this.nombre = nombre;
        this.estadoArticulo = "Pendiente";
    }

    public String getNombre() {
        return nombre;
    }

    public String getEstadoArticulo() {
        return estadoArticulo;
    }

    public Date getFechaRecibido() {
        return fechaRecibido;
    }

    public void setFechaRecibido(Date fechaRecibido) {
        this.fechaRecibido = fechaRecibido;
        this.estadoArticulo = "Recibido";
    }

    public Date getFechaEntregado() {
        return fechaEntregado;
    }

    public void setFechaEntregado(Date fechaEntregado) {
        this.fechaEntregado = fechaEntregado;
        this.estadoArticulo = "Entregado";
    }

    public Date getFechaPendiente() {
        return fechaPendiente;
    }

    public void setFechaPendiente(Date fechaPendiente) {
        this.fechaPendiente = fechaPendiente;
        this.estadoArticulo = "Pendiente";
    }

    public double getMontoCobrado() {
        return montoCobrado;
    }

    public void setMontoCobrado(double montoCobrado) {
        this.montoCobrado = montoCobrado;
    }
    
    
}
