package tec.entregables;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author salaz
 */
public class Cliente {
    private String nombre;
    private int idCliente;
    private String telefono;
    private String correo;
    private String sexo;
    private String nivel; // normal, plata, oro
    private Casillero casillero;
    private List<Articulo> articulosRecibidos;
    private List<Articulo> articulosEntregados;
    private List<Articulo> articulosPendientes;
    
    /**
     * Constructor que inicializa los atributos del cliente.
     *  
     * @param nombre del cliente.
     * @param idCliente del cliente.
     * @param telefono del cliente.
     * @param correo del cliente.
     * @param sexo del cliente.
     * @param casillero asignado al cliente.
     * @param nivel del cliente.
     */

    public Cliente(String nombre, int idCliente, String telefono, String correo, String sexo, Casillero casillero, String nivel) {
        this.nombre = nombre;
        this.idCliente = idCliente;
        this.telefono = telefono;
        this.correo = correo;
        this.sexo = sexo;
        this.casillero = casillero;
        this.nivel = nivel; // nivel inicial
        this.articulosRecibidos = new ArrayList<>();
        this.articulosEntregados = new ArrayList<>();
        this.articulosPendientes = new ArrayList<>();
    }
    /**
     * 
     * Consulta el estado del casillero.
     *
     * @param casillero.
     * @return Estado del casillero.
     */   
    public String consultarCasilleroNum(Casillero casillero) {
        return casillero.estadoCasillero(casillero);
    }
    /**
     * 
     * Consulta el estado del casillero por ID del cliente.
     *
     * @param idCliente.
     * @return Estado del casillero.
     */    
    public String consultarCasilleroId(int idCliente) {
        return casillero.estadoId(idCliente);
    }
    /**
     * 
     * Sube el nivel del cliente dependiendo de la cantidad de artículos recibidos.
     * 
     * Si tiene 5 o más artículos, sube a "Plata". Si tiene 10 o más, sube a "Oro".
     *
     * @return Nivel actual del cliente.
     */
    public String subirNivel() {
        if (articulosRecibidos.size() >= 5) {
            this.setNivel("Plata");
        }
        if (articulosRecibidos.size() >= 10) {
            this.nivel = "Oro";
        }
        return nivel;
    }
      
    // Métodos para gestionar artículos específicos del cliente
    /**
     * 
     * Agrega un artículo a la lista de artículos recibidos.
     *
     * @param articulo.
     */
    public void agregarArticuloRecibido(Articulo articulo) {
        articulosRecibidos.add(articulo);
    }
    /**
     * 
     * Agrega un artículo a la lista de artículos pendientes.
     *
     * @param articulo.
     */
    public void agregarArticuloPendiente(Articulo articulo) {
        articulosPendientes.add(articulo);
    }
    /**
     * 
     * Agrega un artículo a la lista de artículos entregados.
     * 
     * Elimina el artículo de la lista de artículos pendientes.
     *
     * @param articulo.
     */
    public void agregarArticuloEntregado(Articulo articulo) {
        articulosEntregados.add(articulo);
        articulosPendientes.remove(articulo); // Quitar de pendientes si fue entregado
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
    
    public String getNombre() {
        return nombre;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getNivel() {
        return nivel;
    }

    public void setCasillero(Casillero casillero) {
        this.casillero = casillero;
    }
    
    public Casillero getCasillero() {
        return casillero;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    @Override
    public String toString() {
        return nombre + ", ID " + idCliente + ", teléfono " + telefono + ", correo " + correo;
    }
}
