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
     */
    public static void main(String[] args) {
        
        // Crea el counter
        Counter counter = new Counter("Central", "San José", 10, "220012");
        
        // Crea un casillero
        Casillero casillero = new Casillero(2333, "Libre");
        Casillero casillero2 = new Casillero(1203, "Libre");
        
        // Crea un cliente, lo agrega al counter y lo asigna a un casillero
        Cliente cliente1 = new Cliente("Allan", 231, "8927-1832", "allanj@gmail.com", "Hombre", casillero, "Normal");
        counter.agregarCliente(cliente1);

        Cliente cliente2 = new Cliente("Sara", 233, "2193-3123", "sara@gmail.com", "Mujer", casillero2, "Normal");
        counter.agregarCliente(cliente2);
        
        counter.asignarCasillero(cliente1);
        counter.asignarCasillero(cliente2);
        
        System.out.println("El numero de casillero es: " + casillero.getNumero() + ", el número de cliente es " + cliente1.getIdCliente());
        System.out.println("El numero de casillero es: " + casillero2.getNumero() + ", el número de cliente es " + cliente2.getIdCliente());
        
        String estadoCasilleroCliente = counter.consultarEstadoCasilleroPorCliente(cliente1.getIdCliente());
        System.out.println(estadoCasilleroCliente);
        
        // Crear un artículo y asociarlo al casillero
        Articulo articulo1 = new Articulo("Laptop", 209132, "Laptop para trabajo", "HP", 2);
        Articulo articulo2 = new Articulo("Revista", 101234, "Revista de moda", "Lbel", 1);
        Articulo articulo3 = new Articulo("Juego", 120312, "Zelda", "Nintendo", 0.5);
        Articulo articulo4 = new Articulo("Juego", 542342, "Metroid", "Nintendo", 0.5);
        Articulo articulo5 = new Articulo("Juego", 129373, "Metal Gear Solid", "Konami", 0.5);
        Articulo articulo6 = new Articulo("Juego", 982632, "Nier", "Platinum Games", 0.5);
//        System.out.println("El estado de " + articulo1.getNombre() + " es " + articulo1.getEstadoArticulo());
        

        //se repiten para ver el estado
        System.out.println(cliente2.consultarCasilleroNum(cliente2.getCasillero()));
        System.out.println(cliente1.consultarCasilleroId(cliente1.getIdCliente()) + "\n");
        
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
            articulo4.setFechaRecibido(sdf.parse("27-09-2024"));
            articulo4.setFechaPendiente(sdf.parse("27-09-2024"));
            articulo5.setFechaRecibido(sdf.parse("27-09-2024"));
            articulo5.setFechaPendiente(sdf.parse("27-09-2024"));
            articulo6.setFechaRecibido(sdf.parse("27-09-2024"));
            articulo6.setFechaPendiente(sdf.parse("27-09-2024"));
            
            casillero.agregarArticuloRecibido(cliente1, articulo1, "Recibido");
            casillero.agregarArticuloRecibido(cliente1, articulo2, "Recibido");
            casillero.agregarArticuloRecibido(cliente1, articulo3, "Recibido");
            casillero.agregarArticuloRecibido(cliente1, articulo4, "Recibido");
            casillero.agregarArticuloRecibido(cliente1, articulo5, "Recibido");
            casillero.agregarArticuloRecibido(cliente1, articulo6, "Recibido");
            System.out.println(casillero.getArticulosRecibidos().size());
            System.out.println(cliente1.subirNivel());
            
            System.out.println(cliente2.consultarCasilleroNum(cliente2.getCasillero()));
            System.out.println(cliente1.consultarCasilleroId(cliente1.getIdCliente()) + "\n");
            
            
            // Consultar los artículos recibidos en una fecha
            List<Articulo> articulosRecibidosFecha = casillero.consultarArticulosRecibidos(fechaRecibido);
            System.out.println("Artículos recibidos el " + sdf.format(fechaRecibido) + ":");
            for (Articulo articulo : articulosRecibidosFecha) {
                System.out.println(" - " + articulo.toString() + "\n");
            }
            System.out.println(casillero.clientesPaquetesPendientes(counter));
            
            System.out.println(cliente2.consultarCasilleroNum(cliente2.getCasillero()));
            System.out.println(cliente1.consultarCasilleroId(cliente1.getIdCliente()) + "\n");
            
            // Consultar los artículos entregados en una fecha
            articulo1.setFechaEntregado(sdf.parse("27-09-2024"));
            casillero.agregarArticuloEntregado(cliente1, articulo1, "Entregado");
            casillero2.agregarArticuloEntregado(cliente2, articulo3, "Entregado");
            List<Articulo> articulosEntregadosFecha = casillero.consultarArticulosEntregados(fechaRecibido);
            System.out.println("Artículos entregados el " + sdf.format(fechaRecibido) + ":");
            for (Articulo articulo : articulosEntregadosFecha) {
                System.out.println(" - " + articulo.toString() + "\n");
            }
            System.out.println(casillero.clientesPaquetesPendientes(counter));
            
            
            
            
            System.out.println(cliente2.consultarCasilleroNum(cliente2.getCasillero()));
            System.out.println(cliente1.consultarCasilleroId(cliente1.getIdCliente()) + "\n");
            
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
    }
}

