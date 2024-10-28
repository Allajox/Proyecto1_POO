package tec.entregables;

import java.util.Date;

/**
 *
 * @author allaj
 * 
 */
public class Articulo {
    private String nombre;
    private String estadoArticulo;
    private int numeroReferencia;
    private String descripcion;
    private String remitente;
    private Date fechaRecibido;
    private Date fechaEntregado;
    private Date fechaPendiente;
    private double peso;
    private double impuesto;
    private double montoCobrado;

    
/**
 * Metodo que crea una instancia de artículo
 * 
 * @param nombre
 * @param numeroReferencia
 * @param descripcion
 * @param remitente
 * @param peso 
 */
    public Articulo(String nombre, int numeroReferencia, String descripcion, String remitente, double peso) {
        this.nombre = nombre;
        this.numeroReferencia = numeroReferencia;
        this.descripcion = descripcion;
        this.remitente = remitente;
        this.peso = peso;
        this.estadoArticulo = null;
        this.fechaRecibido = new Date();
        this.fechaEntregado = null;
        this.fechaPendiente = new Date();
        this.impuesto = 0;
        this.montoCobrado = 0;
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

    public int getNumeroReferencia() {
        return numeroReferencia;
    }

    public void setNumeroReferencia(int numeroReferencia) {
        this.numeroReferencia = numeroReferencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEstadoArticulo(String estadoArticulo) {
        this.estadoArticulo = estadoArticulo;
    }

    @Override
    public String toString() {
        return "Articulo{" + "nombre=" + nombre + " NumeroReferencia=" + numeroReferencia;
    }
}
