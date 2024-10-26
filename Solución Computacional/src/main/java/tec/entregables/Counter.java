package tec.entregables;

/**
 *
 * @author danielasuarez
 */
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Counter {
    private String nombre;
    private String direccion;
    private int cantidadCasilleros;
    private String cedulaJuridica;
    private Cliente cliente;
    private Casillero casillero;
    private List<Casillero> casilleros;
    private List<Cliente> clientes;
    /**
     * Constructor que inicializa los atributos del contador.
     *
     * @param nombre del contador.
     * @param direccion del contador.
     * @param cantidadCasilleros a crear.
     * @param cedulaJuridica
     */
    public Counter(String nombre, String direccion, int cantidadCasilleros, String cedulaJuridica) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.cantidadCasilleros = cantidadCasilleros;
        this.cedulaJuridica = cedulaJuridica;
        this.cliente = null;
        this.casillero = null;
        this.casilleros = new ArrayList<>();
        this.clientes = new ArrayList<>();
        crearCasilleros();
    }
    /**
     * Método que crea los casilleros disponibles en el contador.
     */
    private void crearCasilleros() { // REVISAR --------------------------------
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
     * @param nivel del cliente.
     * @return true si el cliente fue registrado exitosamente, false si hubo errores.
     * @throws Exception si ocurre un error en el registro.
     */
    public boolean registrarCliente(String nombre, int idCliente, String telefono, String correo, String sexo, String nivel) throws Exception {
        if (!Validaciones.validarTelefono(telefono) || !Validaciones.validarCorreo(correo)) {
            return false;
        }
        Cliente cliente = new Cliente(nombre, idCliente, telefono, correo, sexo, nivel);
        clientes.add(cliente);
        return true;
    }
    
    
    //PROBABLEMENTE SERÁ ELIMINADO ---------------------------------------------------------------------------------------------------------
    
    /**
     * Método que asigna un casillero disponible a un cliente.
     *
     * @param cliente a asignar.
     * @return el casillero asignado o null si no hay casilleros disponibles.
     */
//    public Casillero asignarCasillero(Cliente cliente) {
//        for (Casillero casi : casilleros) {
//            if (casi.getEstado().equals("Libre")) {
//
//                cliente.setCasillero(casi);
//                System.out.println("Se ha asignado el casillero " + casi.getNumero() + " al cliente " + cliente.getNombre());
//                return casi;
//            }
//        }
//        System.out.println("No hay casilleros disponibles para asignar al cliente " + cliente.getNombre());
//        return null; // Si no hay casilleros disponibles
//    }
    
    
    //PROBABLEMENTE SERÁ MOVIDO ---------------------------------------------------------------------------------------------------------
    
    /**
     * Método que libera un casillero por su número.
     *
     * @param numero del casillero a liberar.
     */
//    public void liberarCasillero(int numero) {
//        for (Casillero casi : casilleros) {
//            if (casi.getNumero() == numero) {
//                this.cliente = null;
//                this.estado = "Libre";
//                break;
//            }
//        }
//    }
    
    // CONSULTAS --------------------------------------------------
    
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
    
    // MÉTODOS DE ESTADO ------------------------------------------------------------------------------------------------------------------------------------
    
    /**
     * Retorna el estado del casillero de un cliente por su ID.
     * 
     * @param idCliente del cliente.
     * @return Estado de los artículos del cliente (recibidos, entregados y pendientes).
     */
    public String estadoId(int idCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.getIdCliente() == idCliente) {
                return "El casillero " + casillero.getNumeroCasillero() + " tiene asignado al cliente: " + cliente.getNombre() + 
                " id:" + cliente.getIdCliente() + " teléfono: " + cliente.getTelefono() +
                " correo: " + cliente.getCorreo() + " sexo: " + cliente.getSexo() + " nivel " + cliente.getNivel() +                        
                " tiene " + casillero.getArticulosRecibidos().size() + " artículos recibidos, " 
                + casillero.getArticulosEntregados().size() + " artículos entregados y " 
                + casillero.getArticulosPendientes().size() + " artículos pendientes.";
            }
        }
    return "Cliente no encontrado";
    }
    
    /**
     * Retorna el estado del casillero.
     * 
     * @param numeroCasillero
     * @return Estado del casillero (artículos recibidos, entregados y pendientes).
     */
    public String estadoCasillero(int numeroCasillero) {
        for (Casillero casillero : casilleros) {
            if (casillero.getNumeroCasillero() == numeroCasillero) {
                return "El casillero " + casillero.getNumeroCasillero() + " tiene asignado al cliente: " + cliente.getNombre() + 
                " id:" + cliente.getIdCliente() + " teléfono: " + cliente.getTelefono() +
                " correo: " + cliente.getCorreo() + " sexo: " + cliente.getSexo() + " nivel " + cliente.getNivel() +                        
                " tiene " + casillero.getArticulosRecibidos().size() + " artículos recibidos, " 
                + casillero.getArticulosEntregados().size() + " artículos entregados y " 
                + casillero.getArticulosPendientes().size() + " artículos pendientes.";
            }
        }
    return "Casillero no encontrado";
    }

    
    //POR MODIFICAR ---------------------------------------------------------------------------------------------------------
    /**
     * Consulta los clientes que tienen artículos pendientes en el casillero.
     * 
     * @return Lista de clientes con artículos pendientes.
     */
//    public String clientesPaquetesPendientes(Counter counter) {
//    StringBuilder resultado = new StringBuilder();
//    
//    for (Cliente cliente : counter.getClientes()) {  // Obtener los clientes desde el counter
//        Casillero casilleroCliente = counter.getCasillero();  // Obtener el casillero del cliente
//        
//        if (casilleroCliente != null) {
//            List<Articulo> articulosPendientes = counter.getArticulosPendientes();
//            
//            if (!articulosPendientes.isEmpty()) {
//                resultado.append("El cliente ")
//                         .append(cliente.toString())
//                         .append(" tiene ")
//                         .append(articulosPendientes.size())
//                         .append(" artículo(s) pendiente(s).\n");
//            }
//        } else {
//            System.out.println("El cliente " + cliente.getNombre() + " no tiene casillero asignado.");
//        }
//    }
//    
//    if (resultado.length() == 0) {
//        return "No hay clientes con artículos pendientes.";
//    }
//    
//    return resultado.toString();
//    }
    
    public List<Casillero> getCasilleros() {
        return casilleros;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getCantidadCasilleros() {
        return cantidadCasilleros;
    }

    public void setCantidadCasilleros(int cantidadCasilleros) {
        this.cantidadCasilleros = cantidadCasilleros;
    }

}

