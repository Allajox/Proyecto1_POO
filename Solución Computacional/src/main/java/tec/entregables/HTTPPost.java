package tec.entregables;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;


// Clase que maneja la comunicación con el web service
public class HTTPPost {
    private final String SERVICE_URL = "https://gee.bccr.fi.cr/Indicadores/Suscripciones/WS/wsindicadoreseconomicos.asmx/ObtenerIndicadoresEconomicos";

    /**
     * Método para enviar la solicitud y recibir la respuesta.
     *
     * @param request la solicitud que se va a enviar.
     * @return la respuesta del servicio.
     * @throws Exception si ocurre un error durante la comunicación o el procesamiento.
     */
    public Respuesta enviarSolicitud(Solicitud request) throws Exception {
        
        // Crea la conexión HTTP
        URL endpoint = new URL(SERVICE_URL);
        HttpURLConnection connection = (HttpURLConnection) endpoint.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        // Obtiene los parámetros de la solicitud
        String urlParameters = request.getURLParameters();
        connection.setRequestProperty("Content-Length", String.valueOf(urlParameters.length()));

        // Envía los datos
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = urlParameters.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        // Lee la respuesta
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
        StringBuilder response = new StringBuilder();
        String responseLine;
        while ((responseLine = br.readLine()) != null) {
            response.append(responseLine.trim());
        }

        // Parsea la respuesta XML
        return parseResponse(response.toString());
    }

    /**
     * Método para parsear la respuesta XML.
     *
     * @param xmlResponse la respuesta XML a parsear.
     * @return un objeto Respuesta que contiene el tipo de cambio y la fecha.
     * @throws Exception si ocurre un error durante el análisis del XML.
     */
    private Respuesta parseResponse(String xmlResponse) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new InputSource(new StringReader(xmlResponse)));

        // Extrae el tipo de cambio (NUM_VALOR)
        NodeList numValorNodeList = document.getElementsByTagName("NUM_VALOR");
        String tipoDeCambio = numValorNodeList.getLength() > 0 ? numValorNodeList.item(0).getTextContent() : "No disponible";

        // Extrae la fecha (DES_FECHA)
        NodeList desFechaNodeList = document.getElementsByTagName("DES_FECHA");
        String fecha = desFechaNodeList.getLength() > 0 ? desFechaNodeList.item(0).getTextContent() : "No disponible";

        // Crea y devuelve la respuesta
        return new Respuesta(tipoDeCambio, fecha);
    }
}
