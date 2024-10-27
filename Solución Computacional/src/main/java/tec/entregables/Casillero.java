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
    private Articulo articulo;
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
        this.articulo = null;
        this.articulosRecibidos = new ArrayList<>();
        this.articulosEntregados = new ArrayList<>();
        this.articulosPendientes = new ArrayList<>();
    }
    
    /**
     * Asigna un cliente al casillero, marcándolo como ocupado.
     * 
     * @param clienteAsignado
     */
    public void asignarClienteACasillero(Cliente clienteAsignado) {
        if (this.getEstado().equals("Libre")){
            this.clienteAsignado = clienteAsignado;
            this.estado = "Ocupado";
            System.out.println("Cliente " + clienteAsignado.getNombre() + " añadido al casillero " + this.getNumeroCasillero());
        }
    }
    
    /**
     * Libera el casillero, dejándolo sin cliente.
     */
    public void liberarCasillero() {
        this.clienteAsignado = null;
        this.estado = "Libre";
    }
    
    //MÉTODOS DE ARTÍCULOS---------------------------------------------------------------------------------------------------------
    
    /**
     * Agrega un artículo pendiente al casillero.
     * 
     * @param articulo pendiente.
     */
    public void agregarArticuloPendiente(Articulo articulo) {
    this.articulosPendientes.add(articulo);
    articulo.setEstadoArticulo("Pendiente");
//    System.out.println("Artículo " + articulo.getDescripcion() + " añadido al casillero " + this.numeroCasillero);
}
    
     /**
     * Agrega un artículo recibido al casillero
     * 
     * @param articulo recibido.
     */   
    public void agregarArticuloRecibido(Articulo articulo) {
        this.articulosRecibidos.add(articulo);  
        articulo.setEstadoArticulo("Recibido");
        

    }
    /**
     * Agrega un artículo entregado al casillero y lo remueve de pendientes.
     * 
     * @param articulo entregado.
     */
    public void agregarArticuloEntregado(Articulo articulo) {
        this.articulosEntregados.add(articulo);     
        this.articulosPendientes.remove(articulo);   // Quita el artículo de pendientes
        articulo.setEstadoArticulo("Entregado");
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

    @Override
    public String toString() {
        return "Casillero{" + "numeroCasillero=" + numeroCasillero + ", estado=" + estado + ", clienteAsignado=" + clienteAsignado + ", articulosRecibidos=" + articulosRecibidos + ", articulosEntregados=" + articulosEntregados + ", articulosPendientes=" + articulosPendientes + '}';
    }
    
    
}
