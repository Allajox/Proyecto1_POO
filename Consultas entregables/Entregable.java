package tec.entregables;

/**
 *
 * @author danielasuarez
 */
public class Entregable {
    private String numeroReferencia;
    private String descripcion;
    private String remitente;
    private double peso;
    private double impuesto;

    public Entregable(String numeroReferencia, String descripcion, String remitente) {
        this.numeroReferencia = numeroReferencia;
        this.descripcion = descripcion;
        this.remitente = remitente;
    }

    public String getNumeroReferencia() {
        return numeroReferencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getRemitente() {
        return remitente;
    }
}
