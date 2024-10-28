package tec.entregables;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author allaj
 */
public class main {
    /**
     * Método principal que ejecuta el programa.
     *
     * @param args Argumentos de línea de comandos (no utilizados en este contexto).
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        
        // Crea el counter
        Counter miCounter = new Counter("Central", "San José", 5, "220012");
        System.out.println(miCounter.buscarCasilleroDisponible());
        miCounter.registrarClienteEnCounter("Allan", 1234, "89399320", "allan@gmail.com", true);
        System.out.println(miCounter.buscarCasilleroDisponible());
        miCounter.registrarClienteEnCounter("Pedro", 1213, "82322323", "pedro@gmail.com", true);
//        System.out.println(miCounter.estadoId(1234));
//        System.out.println(miCounter.estadoId(1213));
//        System.out.println(miCounter.estadoCasillero(1000));
//        System.out.println(miCounter.estadoCasillero(1001));
        Articulo articulo1 = new Articulo("Laptop", 209132, "Laptop para trabajo", "HP", 2);
        Articulo articulo2 = new Articulo("Revista", 101234, "Revista de moda", "Lbel", 1);
        Articulo articulo3 = new Articulo("Documento", 101314, "Tesis", "TEC", 1);
   
        miCounter.recibirArticulo(1000, articulo1); 
        miCounter.recibirArticulo(1000, articulo2); 
        
        miCounter.recibirArticulo(1001, articulo3);

        
        System.out.println(miCounter.clientesPaquetesPendientes(miCounter.getCasilleros()));
        
        System.out.println("Los artículos recibidos de hoy son: " + miCounter.consultarArticulosRecibidos(new Date()));
        System.out.println("Los artículos pendientes de hoy son: " + miCounter.consultarArticulosPendientes(new Date()));
        System.out.println("Los artículos entregados de hoy son: " + miCounter.consultarArticulosEntregados(new Date()));
        
        System.out.println(articulo1.getFechaPendiente() + " y " + articulo1.getFechaRecibido() + " y " + articulo1.getFechaEntregado());

        miCounter.retirarArticulo(1000, articulo1);
        System.out.println("Los artículos entregados de hoy son: " + miCounter.consultarArticulosEntregados(new Date()));
        
        System.out.println(miCounter.estadoId(1213));
        System.out.println(miCounter.estadoCasillero(1000));
    }
}

        
        /*
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
        try {
            
//             Solicitud del web service ******************************************************************************************
            
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
            
            System.out.println("El nivel del cliente " + cliente1.getNombre() + " es " + cliente1.getNivel());
            
        } catch (Exception e) {
            e.printStackTrace();

        }
    }*/
//}
