package tec.entregables;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author allaj
 */
public class Casillero {
    private int numero;
    private String estado;
    private Cliente cliente;
    private List<Cliente> clientes;
    private List<Articulo> articulosRecibidos;
    private List<Articulo> articulosEntregados;
    private List<Articulo> articulosPendientes;
    /**
     * Constructor para inicializar un casillero.
     * 
     * @param numero del casillero.
     * @param estado inicial del casillero (libre/ocupado).
     */
    public Casillero(int numero, String estado) {
        this.numero = numero;
        this.estado = estado;
        this.cliente = cliente;
        this.clientes = new ArrayList<>();
        this.articulosRecibidos = new ArrayList<>();
        this.articulosEntregados = new ArrayList<>();
        this.articulosPendientes = new ArrayList<>();
        
    }
    /**
     * Retorna el estado del casillero de un cliente por su ID.
     * 
     * @param idCliente del cliente.
     * @return Estado de los artículos del cliente (recibidos, entregados y pendientes).
     */
    public String estadoId(int idCliente) {
    for (Cliente cliente1 : clientes) {
        if (cliente1.getIdCliente() == idCliente) {
            return "El cliente " + idCliente + " tiene " 
            + cliente1.getArticulosRecibidos().size() + " artículos recibidos, " 
            + cliente1.getArticulosEntregados().size() + " artículos entregados y " 
            + cliente1.getArticulosPendientes().size() + " artículos pendientes.";
        }
    }
    return "Cliente no encontrado";
}
    /**
     * Retorna el estado del casillero.
     * 
     * @param casillero a consultar.
     * @return Estado del casillero (artículos recibidos, entregados y pendientes).
     */
public String estadoCasillero(Casillero casillero) {
    for (Cliente cliente2 : clientes) {
        if (cliente2.getCasillero() == casillero) {
            return "El casillero " + casillero.getNumero() + " tiene " 
            + cliente2.getArticulosRecibidos().size() + " artículos recibidos, " 
            + cliente2.getArticulosEntregados().size() + " artículos entregados y " 
            + cliente2.getArticulosPendientes().size() + " artículos pendientes.";
        }
    }
    return "Casillero no encontrado";
}
    /**
     * Asigna un cliente al casillero, marcándolo como ocupado.
     * 
     * @param cliente a asignar.
     */
    public void asignarCliente(Cliente cliente) {
        this.cliente = cliente;
        this.estado = "Ocupado";
        clientes.add(cliente);
        System.out.println("Cliente " + cliente.getNombre() + " añadido al casillero. Total clientes: " + clientes.size());
    }
    /**
     * Libera el casillero, dejándolo sin cliente.
     */
    public void liberarCasillero() {
        this.cliente = null;
        this.estado = "Libre";
    }
    
    
    //*********************************************************************************************
    /**
     * Consulta los clientes que tienen artículos pendientes en el casillero.
     * 
     * @param counter que contiene la lista de clientes.
     * @return Lista de clientes con artículos pendientes.
     */
    public String clientesPaquetesPendientes(Counter counter) {
    StringBuilder resultado = new StringBuilder();
    
    for (Cliente cliente : counter.getClientes()) {  // Obtener los clientes desde el counter
        Casillero casilleroCliente = cliente.getCasillero();  // Obtener el casillero del cliente
        
        if (casilleroCliente != null) {
            List<Articulo> articulosPendientes = cliente.getArticulosPendientes();
            
            if (!articulosPendientes.isEmpty()) {
                resultado.append("El cliente ")
                         .append(cliente.toString())
                         .append(" tiene ")
                         .append(articulosPendientes.size())
                         .append(" artículo(s) pendiente(s).\n");
            }
        } else {
            System.out.println("El cliente " + cliente.getNombre() + " no tiene casillero asignado.");
        }
    }
    
    if (resultado.length() == 0) {
        return "No hay clientes con artículos pendientes.";
    }
    
    return resultado.toString();
    }

    /**
     * Agrega un artículo pendiente al casillero y al cliente.
     * 
     * @param cliente que tiene el artículo pendiente.
     * @param articulo pendiente.
     * @param estadoArticulo del artículo.
     */
    public void agregarArticuloPendiente(Cliente cliente, Articulo articulo, String estadoArticulo) {
    cliente.agregarArticuloPendiente(articulo);
    this.articulosPendientes.add(articulo);
    articulo.setEstadoArticulo(estadoArticulo);
}
     /**
     * Agrega un artículo recibido al casillero y lo marca como pendiente.
     * 
     * @param cliente que recibe el artículo.
     * @param articulo recibido.
     * @param estadoArticulo del artículo.
     */   
    public void agregarArticuloRecibido(Cliente cliente, Articulo articulo, String estadoArticulo) {
    cliente.agregarArticuloRecibido(articulo);  // Actualiza en cliente
    this.articulosRecibidos.add(articulo);      // Actualiza en casillero
    cliente.agregarArticuloPendiente(articulo); // Actualiza también en la lista de pendientes del cliente
    this.articulosPendientes.add(articulo);     // Se considera pendiente hasta ser entregado
    articulo.setEstadoArticulo(estadoArticulo);

}
    /**
     * Agrega un artículo entregado al casillero y lo remueve de pendientes.
     * 
     * @param cliente que recibe el artículo.
     * @param articulo entregado.
     * @param estadoArticulo del artículo.
     */
public void agregarArticuloEntregado(Cliente cliente, Articulo articulo, String estadoArticulo) {
    cliente.agregarArticuloEntregado(articulo);  // Actualiza en cliente
    this.articulosEntregados.add(articulo);      // Actualiza en casillero
    this.articulosPendientes.remove(articulo);   // Quita el artículo de pendientes en casillero
    articulo.setEstadoArticulo(estadoArticulo);
    
    
}
     /**
     * Consulta los artículos del casillero por fecha.
     * 
     * @param articulos lista de artículos.
     * @param fecha a comparar.
     * @param tipo de artículo a buscar (recibido, entregado, pendiente).
     * @return Lista de artículos encontrados en la fecha dada.
     */      
    public List<Articulo> consultarArticulosPorFecha(List<Articulo> articulos, Date fecha, String tipo) {
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    List<Articulo> articulosFecha = new ArrayList<>();
    
    for (Articulo articulo : articulos) {
        boolean coincide = false;
        String fechaArticulo = "";
        switch (tipo) {
            case "recibido":
                fechaArticulo = sdf.format(articulo.getFechaRecibido());
                coincide = fechaArticulo.equals(sdf.format(fecha));
                break;
            case "entregado":
                fechaArticulo = sdf.format(articulo.getFechaEntregado());
                coincide = fechaArticulo.equals(sdf.format(fecha));
                break;
            case "pendiente":
                fechaArticulo = sdf.format(articulo.getFechaPendiente());
                coincide = fechaArticulo.equals(sdf.format(fecha));
                break;
        }
        if (coincide) {
            articulosFecha.add(articulo);
        }
    }
    return articulosFecha;
    }

     /**
     * Consulta los artículos recibidos en una fecha específica.
     * 
     * @param fecha a comparar.
     * @return Lista de artículos recibidos en la fecha dada.
     */   
    public List<Articulo> consultarArticulosRecibidos(Date fecha) {
        return consultarArticulosPorFecha(articulosRecibidos, fecha, "Recibido");
    }
    /**
     * Consulta los artículos entregados en una fecha específica.
     * 
     * @param fecha a comparar.
     * @return Lista de artículos entregados en la fecha dada.
     */
    public List<Articulo> consultarArticulosEntregados(Date fecha) {
        return consultarArticulosPorFecha(articulosEntregados, fecha, "Entregado");
    }
    /**
     * Consulta los artículos pendientes en una fecha específica.
     * 
     * @param fecha a comparar.
     * @return Lista de artículos pendientes en la fecha dada.
     */
    public List<Articulo> consultarArticulosPendientes(Date fecha) {
        return consultarArticulosPorFecha(articulosPendientes, fecha, "Pendiente");
    }

    public int getNumero() {
        return numero;
    }

    public List<Articulo> getArticulosRecibidos() {
        return articulosRecibidos;
    }

    public void setArticulosRecibidos(List<Articulo> articulosRecibidos) {
        this.articulosRecibidos = articulosRecibidos;
    }

    public List<Articulo> getArticulosPendientes() {
        return articulosPendientes;
    }

    public void setArticulosPendientes(List<Articulo> articulosPendientes) {
        this.articulosPendientes = articulosPendientes;
    }
    
    public List<Articulo> getArticulosEntregados() {
        return articulosEntregados;
    }

    public void setArticulosEntregados(List<Articulo> articulosEntregados) {
        this.articulosEntregados = articulosEntregados;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
}
