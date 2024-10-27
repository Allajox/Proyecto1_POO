package tec.entregables;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
//        for (Casillero casillero : miCounter.getCasilleros()) {
//            if (casillero.getClienteAsignado() != null){
//            System.out.println(casillero.getClienteAsignado());
//            }
//        }
//        System.out.println(miCounter.estadoId(1234));
//        System.out.println(miCounter.estadoId(1213));
//        System.out.println(miCounter.estadoCasillero(1));
//        System.out.println(miCounter.estadoCasillero(2));
        Articulo articulo1 = new Articulo("Laptop", 209132, "Laptop para trabajo", "HP", 2);
        Articulo articulo2 = new Articulo("Revista", 101234, "Revista de moda", "Lbel", 1);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
        articulo1.setFechaRecibido(sdf.parse("27-09-2024"));
        articulo1.setFechaPendiente(sdf.parse("27-09-2024"));
        
        Scanner num = new Scanner(System.in);
        System.out.println("Digite el numero de casillero al que quiere agregar: ");
        int numCasillero = num.nextInt();
        
        miCounter.asignarArticuloPendienteACasillero(numCasillero, articulo1); 
        miCounter.asignarArticuloRecibidoACasillero(numCasillero, articulo1);
        miCounter.asignarArticuloPendienteACasillero(numCasillero, articulo2); 

        System.out.println(miCounter.clientesPaquetesPendientes(miCounter.getCasilleros()));
        System.out.println(miCounter.getCasilleros().size());

    }
}

        
        /*
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
        try {
            // Fecha de hoy
            Date fechaRecibido = sdf.parse("27-09-2024");
            
            articulo1.setFechaRecibido(sdf.parse("27-09-2024"));
            articulo1.setFechaRecibido(sdf.parse("27-09-2024"));
            articulo2.setFechaRecibido(sdf.parse("27-09-2024"));
            articulo2.setFechaPendiente(sdf.parse("27-09-2024"));
            articulo3.setFechaPendiente(sdf.parse("27-09-2024"));
            articulo3.setFechaPendiente(sdf.parse("27-09-2024"));
            
            casillero.agregarArticuloRecibido(cliente1, articulo1, "Recibido");
            casillero.agregarArticuloRecibido(cliente1, articulo2, "Recibido");
            casillero.agregarArticuloRecibido(cliente1, articulo3, "Recibido");

            
            
            // Consultar los artículos recibidos en una fecha
            List<Articulo> articulosRecibidosFecha = casillero.consultarArticulosRecibidos(fechaRecibido);
            System.out.println("Artículos recibidos el " + sdf.format(fechaRecibido) + ":");
            for (Articulo articulo : articulosRecibidosFecha) {
                System.out.println(" - " + articulo.toString() + "\n");
            }
            
            // Consultar los artículos entregados en una fecha
            articulo1.setFechaEntregado(sdf.parse("27-09-2024"));
            casillero.agregarArticuloEntregado(cliente1, articulo1, "Entregado");
            casillero2.agregarArticuloEntregado(cliente2, articulo3, "Entregado");
            List<Articulo> articulosEntregadosFecha = casillero.consultarArticulosEntregados(fechaRecibido);
            System.out.println("Artículos entregados el " + sdf.format(fechaRecibido) + ":");
            for (Articulo articulo : articulosEntregadosFecha) {
                System.out.println(" - " + articulo.toString() + "\n");
            }


            // Consultar los artículos pendientes en una fecha
            List<Articulo> articulosPendientesFecha = casillero.consultarArticulosPendientes(fechaRecibido);
            System.out.println("Artículos pendientes el " + sdf.format(fechaRecibido) + ":");
            for (Articulo articulo : articulosPendientesFecha) {
                System.out.println(" - " + articulo.toString() + "\n");
            }
            
            System.out.println(cliente1.getNivel());
            
            System.out.println(casillero.clientesPaquetesPendientes(counter));
            
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
