package WebService;

// Clase que representa la respuesta del tipo de cambio
public class Respuesta {
    private String tipoDeCambio;
    private String fecha;

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
