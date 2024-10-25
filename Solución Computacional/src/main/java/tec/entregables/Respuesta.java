package tec.entregables;

// Clase que representa la respuesta del tipo de cambio
public class Respuesta {
    private String tipoDeCambio;
    private String fecha;
    /**
     * Constructor que inicializa los atributos de la respuesta.
     *
     * @param tipoDeCambio el valor del tipo de cambio.
     * @param fecha la fecha asociada al tipo de cambio.
     */
    public Respuesta(String tipoDeCambio, String fecha) {
        this.tipoDeCambio = tipoDeCambio;
        this.fecha = fecha;
    }

    public String getTipoDeCambio() {
        return tipoDeCambio;
    }

    public String getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "Tipo de Cambio: " + tipoDeCambio + ", Fecha: " + fecha;
    }
}

