package tec.entregables;

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

    public Casillero(int numero, String estado) {
        this.numero = numero;
        this.estado = estado;
        this.cliente = cliente;
        this.clientes = new ArrayList<>();
        this.articulosRecibidos = new ArrayList<>();
        this.articulosEntregados = new ArrayList<>();
        this.articulosPendientes = new ArrayList<>();
        
    }

    public String estadoId(int idCliente) {
        for (Cliente cliente1 : clientes) {
            if (cliente1.getIdCliente() == idCliente) {
                return "El cliente " + idCliente + " tiene " + articulosRecibidos.size() + " artículos recibidos, " 
                + articulosEntregados.size() + " artículos entregados y " 
                + articulosPendientes.size() + " artículos pendientes.";
            }
        }      
        return "Cliente no encontrado";
    }
    
    public String estadoCasillero(Casillero casillero) {
        for (Cliente cliente2 : clientes) {
            if (cliente2.getCasillero() == casillero) {
                return "El casillero " + casillero.getNumero() + " tiene " + articulosRecibidos.size() + " artículos recibidos, " 
                + articulosEntregados.size() + " artículos entregados y " 
                + articulosPendientes.size() + " artículos pendientes.";
            }
        }      
        return "Casillero no encontrado";
    }

    public void asignarCliente(Cliente cliente) {
        this.cliente = cliente;
        this.estado = "Ocupado";
    }

    public void liberarCasillero() {
        this.cliente = null;
        this.estado = "Libre";
    }
    
    // Métodos para agregar artículos recibidos, pendientes, y entregados.
    public void agregarArticuloRecibido(Articulo articulo) {
        articulosRecibidos.add(articulo);
        articulosPendientes.add(articulo);
    }
    
    // al entregar un artículo, se elimina de recibidos y pendientes
    public void agregarArticuloEntregado(Articulo articulo) {
        articulosEntregados.add(articulo);
        articulosRecibidos.remove(articulo);
        articulosPendientes.remove(articulo);
        
    }
    
    public void agregarCliente(Cliente idCliente) {
        clientes.add(idCliente);
    }
    
    public List<Articulo> consultarArticulosPorFecha(List<Articulo> articulos, Date fecha, String tipo) {
    List<Articulo> articulosFecha = new ArrayList<>();
    if (articulosPendientes.size() >= 1) {
        System.out.println("Tiene artículos pendientes de retirar");
        
    }
    for (Articulo articulo : articulos) {
        boolean coincide = false;
        switch (tipo) {
            case "recibido":
                coincide = articulo.getFechaRecibido().equals(fecha);
                break;
            case "entregado":
                coincide = articulo.getFechaEntregado().equals(fecha);
                break;
            case "pendiente":
                coincide = articulo.getFechaPendiente().equals(fecha);
                break;
        }
        if (coincide) {
            articulosFecha.add(articulo);
        }
    }
    return articulosFecha;
}

    
    public List<Articulo> consultarArticulosRecibidos(Date fecha) {
        return consultarArticulosPorFecha(articulosRecibidos, fecha, "recibido");
    }

    public List<Articulo> consultarArticulosEntregados(Date fecha) {
        return consultarArticulosPorFecha(articulosEntregados, fecha, "entregado");
    }

    public List<Articulo> consultarArticulosPendientes(Date fecha) {
        //System.out.println("Tiene artículos pendientes de retirar");
        return consultarArticulosPorFecha(articulosPendientes, fecha, "pendiente");
    }

    public int getNumero() {
        return numero;
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
