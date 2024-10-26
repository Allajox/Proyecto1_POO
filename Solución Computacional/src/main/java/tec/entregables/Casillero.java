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
    private int numeroCasillero;
    private String estado;
    private Cliente clienteAsignado;
    private List<Articulo> articulosRecibidos;
    private List<Articulo> articulosEntregados;
    private List<Articulo> articulosPendientes;
    /**
     * Constructor para inicializar un casillero.
     * 
     * @param numeroCasillero
     * @param estado inicial del casillero (libre/ocupado).
     */
    public Casillero(int numeroCasillero, String estado) {
        this.numeroCasillero = numeroCasillero;
        this.estado = estado;
        this.clienteAsignado = null;
        this.articulosRecibidos = new ArrayList<>();
        this.articulosEntregados = new ArrayList<>();
        this.articulosPendientes = new ArrayList<>();
    }
    
    
    /**
     * Asigna un cliente al casillero, marcándolo como ocupado.
     * 
     * @param cliente a asignar.
     */
//    public void asignarCliente(Cliente cliente) {
//        this.cliente = cliente;
//        this.estado = "Ocupado";
//        clientes.add(cliente);
//        System.out.println("Cliente " + cliente.getNombre() + " añadido al casillero. Total clientes: " + clientes.size());
//    }
//    /**
//     * Libera el casillero, dejándolo sin cliente.
//     */
//    public void liberarCasillero() {
//        this.cliente = null;
//        this.estado = "Libre";
//    }
    
    
    
    //MÉTODOS DE ARTÍCULOS---------------------------------------------------------------------------------------------------------
    /**
     * Agrega un artículo pendiente al casillero.
     * 
     * @param articulo pendiente.
     * @param estadoArticulo del artículo.
     */
    public void agregarArticuloPendiente(Articulo articulo, String estadoArticulo) {
        this.articulosPendientes.add(articulo);
        articulo.setEstadoArticulo("Pendiente");
    }
    
     /**
     * Agrega un artículo recibido al casillero y lo marca como pendiente.
     * 
     * @param articulo recibido.
     * @param estadoArticulo del artículo.
     */   
    public void agregarArticuloRecibido(Articulo articulo, String estadoArticulo) {
        this.articulosRecibidos.add(articulo);  
        articulo.setEstadoArticulo("Recibido");

    }
    /**
     * Agrega un artículo entregado al casillero y lo remueve de pendientes.
     * 
     * @param articulo entregado.
     * @param estadoArticulo del artículo.
     */
    public void agregarArticuloEntregado(Articulo articulo, String estadoArticulo) {
        this.articulosEntregados.add(articulo);      // Actualiza en casillero
        this.articulosPendientes.remove(articulo);   // Quita el artículo de pendientes en casillero
        articulo.setEstadoArticulo("Entregado");
    }
    
    
    
    // CONSULTAS POR FECHA ------------------------------------------------------------------------------------------------------------
    
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
    
    public int getNumeroCasillero() {
        return numeroCasillero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getClienteAsignado() {
        return clienteAsignado;
    }
    
    public List<Articulo> getArticulosRecibidos() {
        return articulosRecibidos;
    }

    public List<Articulo> getArticulosEntregados() {
        return articulosEntregados;
    }

    public List<Articulo> getArticulosPendientes() {
        return articulosPendientes;
    }
    
    
}
