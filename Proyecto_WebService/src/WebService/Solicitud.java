package WebService;

// Clase que representa la solicitud de tipo de cambio
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Solicitud {
    private String indicador;
    private String fechaInicio;
    private String fechaFinal;
    private String correo;
    private String token;

    public Solicitud(String indicador, String fechaInicio, String fechaFinal, String correo, String token) {
        this.indicador = indicador;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.correo = correo;
        this.token = token;
    }
    
    

    // Genera la cadena de parámetros para la solicitud
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