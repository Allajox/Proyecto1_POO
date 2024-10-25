package tec.entregables;

// Clase que representa la solicitud de tipo de cambio
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Solicitud {
    private String indicador;
    private String fechaInicio;
    private String fechaFinal;
    private String correo;
    private String token;
    /**
     * Constructor que inicializa los atributos de la solicitud.
     *
     * @param indicador el indicador solicitado.
     * @param fechaInicio la fecha de inicio de la solicitud.
     * @param fechaFinal la fecha final de la solicitud.
     * @param correo el correo electrónico del solicitante.
     * @param token el token de autorización.
     */
    public Solicitud(String indicador, String fechaInicio, String fechaFinal, String correo, String token) {
        this.indicador = indicador;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.correo = correo;
        this.token = token;
    }
    
    /**
     * Método que genera los parámetros de la solicitud en formato URL.
     *
     * @return un string con los parámetros codificados en formato URL.
     * @throws UnsupportedEncodingException si el tipo de codificación no es soportado.
     */
    public String getURLParameters() throws UnsupportedEncodingException {
        String subNiveles = "N";
        String nombre = "Allan Jiménez";

        return "Indicador=" + URLEncoder.encode(indicador, "UTF-8")
                + "&FechaInicio=" + URLEncoder.encode(fechaInicio, "UTF-8")
                + "&FechaFinal=" + URLEncoder.encode(fechaFinal, "UTF-8")
                + "&Nombre=" + URLEncoder.encode(nombre, "UTF-8")
                + "&SubNiveles=" + URLEncoder.encode(subNiveles, "UTF-8")
                + "&CorreoElectronico=" + URLEncoder.encode(correo, "UTF-8")
                + "&Token=" + URLEncoder.encode(token, "UTF-8");
    }
}
