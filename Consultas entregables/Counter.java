package tec.entregables;

/**
 *
 * @author danielasuarez
 */
import java.util.ArrayList;
import java.util.List;

public class Counter {
    private String nombre;
    private String direccion;
//    private Casillero casillero;
    private int cantidadCasilleros;
    private List<Casillero> casilleros;
    private List<Cliente> clientes;

    public Counter(String nombre, String direccion, int cantidadCasilleros) {
        this.nombre = nombre;
//        this.casillero = casillero;
        this.direccion = direccion;
        this.cantidadCasilleros = cantidadCasilleros;
        this.casilleros = new ArrayList<>();
        this.clientes = new ArrayList<>();
        crearCasilleros();
    }

    private void crearCasilleros() {
        for (int i = 1000; i < 1000 + cantidadCasilleros; i++) {
            casilleros.add(new Casillero(i, "Libre"));
        }
    }

    public Casillero asignarCasillero(Cliente cliente) {
        for (Casillero casi : casilleros) {
            if (casi.getEstado().equals("Libre")) {
                casi.asignarCliente(cliente);
                cliente.setCasillero(casi);
                return casi;
            }
        }
        return null; // Si no hay casis disponibles
    }

    public void liberarCasillero(int numero) {
        for (Casillero casi : casilleros) {
            if (casi.getNumero() == numero) {
                casi.liberarCasillero();
                break;
            }
        }
    }

    public Casillero buscarCasilleroDisponible() {
        for (Casillero casi : casilleros) {
            if (casi.getEstado().equals("Libre")) {
                return casi;
            }
        }
        return null;
    }

    public String consultarEstadoCasilleroPorCliente(int idCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.getIdCliente() == idCliente) {
                return "Casillero del cliente " + idCliente + ": " + cliente.getCasillero().getNumero();
            }
        }
        return "Cliente no encontrado";
    }

    public String consultarEstadoCasilleroPorNumero(int casiNumero) {
        for (Casillero casi : casilleros) {
            if (casi.getNumero() == casiNumero) {
                return "Casillero número " + casiNumero + " está " + casi.getEstado();
            }
        }
        return "Casillero no encontrado";
    }

//    public void notificarClienteRecepcion(Cliente cliente, Entregable entregable) {
//        // Simulación de notificación por correo
//        System.out.println("Notificación enviada a " + cliente.getCorreo() + " sobre el entregable " + entregable.getNumeroReferencia());
//    }
    
    public List<Casillero> getCasilleros() {
        return casilleros;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void agregarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }
}

