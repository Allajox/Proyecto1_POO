package WebService;

public class Main {
    public static void main(String[] args) {
        try {
            // Solicitud de venta
            Solicitud requestVenta = new Solicitud(
                    "317",           // Indicador tipo de cambio venta
                    "21/09/2024",    // Fecha de inicio
                    "21/09/2024",    // Fecha final
                    "ajimenezrivera2203@gmail.com", // Correo electrónico
                    "PLENG9P9CI"       // Token de autenticación
            );
            // Solicitud de compra
            Solicitud requestCompra = new Solicitud(
                    "318",           
                    "21/09/2024",    
                    "21/09/2024",    
                    "ajimenezrivera2203@gmail.com", 
                    "PLENG9P9CI"      
            );

            // Crear el cliente y enviar la solicitud
            HTTPPost client = new HTTPPost();
            
            // Solicitud tipo de cambio de venta-------------------------------------------------------------------------------
            Respuesta responseVenta = client.enviarSolicitud(requestVenta);
            String tipoDeCambioVenta =responseVenta.getTipoDeCambio();
            String fechaVenta = responseVenta.getFecha();
            
            System.out.println("Tipo de Cambio Venta: " + tipoDeCambioVenta);
            System.out.println("Fecha: " + fechaVenta);
            
            
            // CÁLCULOS VENTA--------------------------------------------------------------------------------------------------
            
            double valorDolares = 100.0; // dólares para convertir
            
            // Comprobar con tipo de cambio de venta
            double tipoDeCambioVentaNum = Double.parseDouble(tipoDeCambioVenta); // Convertir el tipo de cambio a número
            double valorColonesVenta = valorDolares * tipoDeCambioVentaNum;
            System.out.println("100 USD equivale a: " + valorColonesVenta + " en colones." + "\n");
            
            
            // Solicitud tipo de cambio de compra------------------------------------------------------------------------------
            Respuesta responseCompra = client.enviarSolicitud(requestCompra);
            String tipoDeCambioCompra =responseCompra.getTipoDeCambio();
            String fechaCompra = responseCompra.getFecha();
            
            System.out.println("Tipo de Cambio Compra: " + tipoDeCambioCompra);
            System.out.println("Fecha: " + fechaCompra);
            
            // CÁLCULOS COMPRA-------------------------------------------------------------------------------------------------
            
            // Comprobar con tipo de cambio de compra
            double tipoDeCambioCompraNum = Double.parseDouble(tipoDeCambioCompra); // Convertir el tipo de cambio a número
            double valorColonesCompra = valorDolares * tipoDeCambioCompraNum;
            System.out.println("100 USD equivale a: " + valorColonesCompra + " en colones.");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

