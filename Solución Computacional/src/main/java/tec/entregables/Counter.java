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
    /**
     * Constructor que inicializa los atributos del contador.
     *
     * @param nombre del contador.
     * @param direccion del contador.
     * @param cantidadCasilleros a crear.
     */
    public Counter(String nombre, String direccion, int cantidadCasilleros, String Cedula) {
        this.nombre = nombre;
//        this.casillero = casillero;
        this.direccion = direccion;
        this.cantidadCasilleros = cantidadCasilleros;
        this.casilleros = new ArrayList<>();
        this.clientes = new ArrayList<>();
        crearCasilleros();
    }
    /**
     * Método que crea los casilleros disponibles en el contador.
     */
    private void crearCasilleros() {
        for (int i = 1001; i < 1001 + cantidadCasilleros; i++) {
            casilleros.add(new Casillero(i, "Libre"));
        }
    }
    /**
     * Método que registra un nuevo cliente.
     *
     * @param nombre del cliente.
     * @param idCliente del cliente.
     * @param telefono del cliente.
     * @param correo del cliente.
     * @param sexo del cliente.
     * @param casillero asignado al cliente.
     * @param nivel del cliente.
     * @return true si el cliente fue registrado exitosamente, false si hubo errores.
     * @throws Exception si ocurre un error en el registro.
     */
    public boolean registrarCliente(String nombre, int idCliente, String telefono, String correo, String sexo, Casillero casillero, String nivel) throws Exception {
        if (!Validaciones.validarTelefono(telefono) || !Validaciones.validarCorreo(correo)) {
            return false;
        }

//        Casillero casillero = casillero.asignarCliente();
        Cliente cliente = new Cliente(nombre, idCliente, telefono, correo, sexo, casillero, nivel);
        clientes.add(cliente);
        return true;
    }
    /**
     * Método que asigna un casillero disponible a un cliente.
     *
     * @param cliente a asignar.
     * @return el casillero asignado o null si no hay casilleros disponibles.
     */
    public Casillero asignarCasillero(Cliente cliente) {
        for (Casillero casi : casilleros) {
            if (casi.getEstado().equals("Libre")) {
                casi.asignarCliente(cliente);
                cliente.setCasillero(casi);
                System.out.println("Se ha asignado el casillero " + casi.getNumero() + " al cliente " + cliente.getNombre());
                return casi;
            }
        }
        System.out.println("No hay casilleros disponibles para asignar al cliente " + cliente.getNombre());
        return null; // Si no hay casis disponibles
    }
    /**
     * Método que libera un casillero por su número.
     *
     * @param numero del casillero a liberar.
     */
    public void liberarCasillero(int numero) {
        for (Casillero casi : casilleros) {
            if (casi.getNumero() == numero) {
                casi.liberarCasillero();
                break;
            }
        }
    }
    /**
     * Método que busca un casillero disponible.
     *
     * @return el casillero disponible o null si no hay.
     */
    public Casillero buscarCasilleroDisponible() {
        for (Casillero casi : casilleros) {
            if (casi.getEstado().equals("Libre")) {
                return casi;
            }
        }
        return null;
    }
    /**
     * Método que consulta el estado de un casillero por el ID del cliente.
     *
     * @param idCliente del cliente.
     * @return el estado del casillero del cliente o un mensaje de error.
     */
    public String consultarEstadoCasilleroPorCliente(int idCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.getIdCliente() == idCliente) {
                return "Casillero del cliente " + idCliente + ": " + cliente.getCasillero().getNumero();
            }
        }
        return "Cliente no encontrado";
    }
    /**
     * Método que consulta el estado de un casillero por su número.
     *
     * @param casiNumero del casillero.
     * @return el estado del casillero o un mensaje de error.
     */
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

