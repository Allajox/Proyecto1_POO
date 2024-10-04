package tec.entregables;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author allaj
 */
public class main {
    public static void main(String[] args) {
        
        // Crear el counter
        Counter counter = new Counter("Central", "San José", 10);
        
        // Crear un casillero
        Casillero casillero = new Casillero(2233, "Libre");
        
        // Crea un cliente y lo asigna a un casillero
        Cliente cliente1 = new Cliente("Allan", 231, casillero);
        casillero.agregarCliente(cliente1);
                
        // Crear un cliente y asociarlo al casillero
        
        System.out.println("El numero de casillero es: " + casillero.getNumero() + ", el número de cliente es " + cliente1.getIdCliente());
        
//        Casillero casilleroAsignado = counter.asignarCasillero(cliente1);
//        if (casilleroAsignado != null) {
//            System.out.println("Casillero asignado al cliente " + cliente1.getNombre() + ": Número " + casilleroAsignado.getNumero());
//        } else {
//            System.out.println("No hay casilleros disponibles para asignar.");
//        }
        
        String estadoCasilleroCliente = counter.consultarEstadoCasilleroPorCliente(cliente1.getIdCliente());
        System.out.println(estadoCasilleroCliente);
        
        // Crear un artículo y asociarlo al casillero
        Articulo articulo1 = new Articulo("Laptop");
        Articulo articulo2 = new Articulo("Revista");
        System.out.println("El estado de " + articulo1.getNombre() + " es " + articulo1.getEstadoArticulo());
        System.out.println(cliente1.consultarCasilleroNum(cliente1.getCasillero()));
        System.out.println(cliente1.consultarCasilleroId(cliente1.getIdCliente()) + "\n");
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
        try {
            // Fecha de hoy
            Date fechaRecibido = sdf.parse("27-09-2024");
            articulo1.setFechaRecibido(sdf.parse("27-09-2024"));
            articulo2.setFechaRecibido(sdf.parse("27-09-2024"));
            articulo1.setFechaPendiente(sdf.parse("27-09-2024"));
            articulo2.setFechaPendiente(sdf.parse("27-09-2024"));
            casillero.agregarArticuloRecibido(articulo1);
            casillero.agregarArticuloRecibido(articulo2);
            
            System.out.println(cliente1.consultarCasilleroNum(cliente1.getCasillero()));
            System.out.println(cliente1.consultarCasilleroId(cliente1.getIdCliente()) + "\n");
            
            // Consultar los artículos recibidos en una fecha
            List<Articulo> articulosRecibidosFecha = casillero.consultarArticulosRecibidos(fechaRecibido);
            System.out.println("Artículos recibidos el " + sdf.format(fechaRecibido) + ":");
            for (Articulo articulo : articulosRecibidosFecha) {
                System.out.println(" - " + articulo.getNombre() + "\n");
            }
            
            System.out.println(cliente1.consultarCasilleroNum(cliente1.getCasillero()));
            System.out.println(cliente1.consultarCasilleroId(cliente1.getIdCliente()) + "\n");
            
            // Consultar los artículos entregados en una fecha
            articulo1.setFechaEntregado(sdf.parse("27-09-2024"));
            casillero.agregarArticuloEntregado(articulo1);
            List<Articulo> articulosEntregadosFecha = casillero.consultarArticulosEntregados(fechaRecibido);
            System.out.println("Artículos entregados el " + sdf.format(fechaRecibido) + ":");
            for (Articulo articulo : articulosEntregadosFecha) {
                System.out.println(" - " + articulo.getNombre() + "\n");
            }
            
            System.out.println(cliente1.consultarCasilleroNum(cliente1.getCasillero()));
            System.out.println(cliente1.consultarCasilleroId(cliente1.getIdCliente()) + "\n");
            
            // Consultar los artículos pendientes en una fecha
            List<Articulo> articulosPendientesFecha = casillero.consultarArticulosPendientes(fechaRecibido);
            System.out.println("Artículos pendientes el " + sdf.format(fechaRecibido) + ":");
            for (Articulo articulo : articulosPendientesFecha) {
                System.out.println(" - " + articulo.getNombre() + "\n");
            }
            
            System.out.println("El nivel del cliente " + cliente1.getNombre() + " es " + cliente1.getNivel());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

