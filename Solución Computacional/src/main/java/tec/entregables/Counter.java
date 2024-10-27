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
    private void crearCasilleros() { 
    for (int i = 0; i < cantidadCasilleros; i++) {
        casilleros.add(new Casillero(1000 + i, "Libre")); // crea los casilleros a partir de 1000
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
     * @return true si el cliente fue registrado exitosamente, false si hubo errores.
     * @throws Exception si ocurre un error en el registro.
     */
    public Cliente registrarClienteEnCounter(String nombre, int idCliente, String telefono, String correo, boolean sexo) throws Exception {
        if (!Validaciones.validarTelefono(telefono) || !Validaciones.validarCorreo(correo)) {
            return null;
        }
        Cliente cliente1 = new Cliente(nombre, idCliente, telefono, correo, sexo);
        clientes.add(cliente1);
        System.out.println("El cliente " + cliente1.getNombre() + " fue registrado.");
    
        // Busca un casillero libre
        for (Casillero casillero1 : casilleros) {
            if (casillero1.getEstado().equals("Libre")) {
                casillero1.asignarClienteACasillero(cliente1);
                return cliente1;
            }
    }
    
    System.out.println("No hay casilleros disponibles para asignar.");
    return cliente1;
}
    
    // CONSULTAS --------------------------------------------------
    
    /**
     * Método que busca un casillero disponible.
     *
     * @return el casillero disponible o null si no hay.
     */
    public String buscarCasilleroDisponible() {
        for (Casillero casillero : casilleros) {
            if (casillero.getEstado().equals("Libre")) {
                return "El casillero " + casillero.getNumeroCasillero() + " está libre.";
            }
        }
        return "No hay casilleros disponibles.";
    }
    
    // MÉTODOS DE ESTADO ------------------------------------------------------------------------------------------------------------------------------------
    
    /**
     * Retorna el estado del casillero de un cliente por su ID.
     * 
     * @param idCliente del cliente.
     * @return Estado de los artículos del cliente (recibidos, entregados y pendientes).
     */
    public String estadoId(int idCliente) {
        for (Cliente cliente1 : clientes) { // doble for para revisar primero si encuentra al cliente y luego buscar su casillero
            if (cliente1.getIdCliente() == idCliente) {
                for (Casillero casillero : casilleros) {
                    if (casillero.getClienteAsignado() != null && casillero.getClienteAsignado().getIdCliente() == idCliente) { // si encuentra el cliente, retorna el estado
                        return "Datos del casillero " + casillero.getNumeroCasillero() + "\n" +
                                "Cliente: " + cliente1.getNombre() + "\n" +
                                "Id:" + cliente1.getIdCliente() + "\n" + 
                                "Teléfono: " + cliente1.getTelefono() + "\n" +
                                "Correo: " + cliente1.getCorreo() + "\n" + 
                                "Sexo: " + cliente1.getSexo() + "\n" + 
                                "Nivel: " + cliente1.getNivel() + "\n" +
                                "Tiene " + casillero.getArticulosRecibidos().size() + " artículos recibidos, " + "\n" +
                                casillero.getArticulosEntregados().size() + " artículos entregados y " + "\n" +
                                casillero.getArticulosPendientes().size() + " artículos pendientes.\n" ;
                    }
                }
                return "No se encontró un casillero asignado para el cliente con ID " + idCliente;
            }
        }
    return "Cliente no encontrado";
    }
    
    /**
     * Retorna el estado del casillero por medio de su número asignado.
     * 
     * @param numeroCasillero
     * @return Todos los datos del casillero y su cliente asociado.
     */
    public String estadoCasillero(int numeroCasillero) {
        for (Casillero casillero1 : casilleros) { // este no necesita doble for, ya que el casillero ya tiene al cliente asignado
            if (casillero1.getNumeroCasillero() == numeroCasillero) {
                Cliente clienteAsignado = casillero1.getClienteAsignado();
                if (clienteAsignado != null) {
                    return "Datos del casillero " + casillero1.getNumeroCasillero() + "\n" + 
                                "Cliente: " + clienteAsignado.getNombre() + "\n" +
                                "Id:" + clienteAsignado.getIdCliente() + "\n" + 
                                "Teléfono: " + clienteAsignado.getTelefono() + "\n" +
                                "Correo: " + clienteAsignado.getCorreo() + "\n" + 
                                "Sexo: " + clienteAsignado.getSexo() + "\n" + 
                                "Nivel: " + clienteAsignado.getNivel() + "\n" +
                                "Tiene " + casillero1.getArticulosRecibidos().size() + " artículos recibidos, " + "\n" +
                                casillero1.getArticulosEntregados().size() + " artículos entregados y " + "\n" +
                                casillero1.getArticulosPendientes().size() + " artículos pendientes.\n";
                } else {
                    return "El casillero " + numeroCasillero + " está libre.";
                }
            }
        }
    return "Casillero no encontrado";
    }
    

    /**
     * 
     * Método que retorna todos los clientes que tengan artículos pendientes de retirar
     * 
     * @param casilleros
     * @return la cantidad de clientes con paquetes pendientes
     */
    public String clientesPaquetesPendientes(List<Casillero> casilleros) {
        StringBuilder resultado = new StringBuilder();
        for (Casillero casillero : casilleros) {
            if (!casillero.getArticulosPendientes().isEmpty()) { // el ! es un "no", entonces si no está vacía hace lo siguiente
              resultado.append("El cliente ")
                     .append(casillero.getClienteAsignado())
                     .append(" tiene ")
                     .append(casillero.getArticulosPendientes().size())
                     .append(" artículo(s) pendiente(s).\n");  
           }
        }
        if (resultado.length() == 0) {
            return "No hay clientes con artículos pendientes.";
        }
        return resultado.toString();
    }
    
    
    // MÉTODOS PARA ASIGNAR ARTÍCULOS A UN CASILLERO ----------------------------------------------------------------
    
    
    /**
     * Método que asigna un artículo como pendiente
     * @param numeroCasillero
     * @param articulo 
     */
    public void asignarArticuloPendienteACasillero(int numeroCasillero, Articulo articulo) {
    for (Casillero casillero : casilleros) {
        if (casillero.getNumeroCasillero() == numeroCasillero && casillero.getEstado().equals("Ocupado")) {
            casillero.agregarArticuloPendiente(articulo); // delega el control a Casillero
            System.out.println("Artículo asignado como pendiente en el casillero " + numeroCasillero);
            return;
        }
    }
    System.out.println("No se encontró el casillero con número: " + numeroCasillero);
    }
    
    /**
     * Método que asigna un artículo como entregado
     * @param numeroCasillero
     * @param articulo 
     */
    public void asignarArticuloEntregadoACasillero(int numeroCasillero, Articulo articulo) {
    for (Casillero casillero : casilleros) {
        if (casillero.getNumeroCasillero() == numeroCasillero && casillero.getEstado().equals("Ocupado")) {
            casillero.agregarArticuloEntregado(articulo); // delega el control a Casillero
            System.out.println("Artículo asignado como entregado en el casillero " + numeroCasillero);
            return;
        }
    }
    System.out.println("No se encontró el casillero con número: " + numeroCasillero);
    }
    
    /**
     * Método que asigna un artículo como recibido
     * @param numeroCasillero
     * @param articulo 
     */
    public void asignarArticuloRecibidoACasillero(int numeroCasillero, Articulo articulo) {
    for (Casillero casillero : casilleros) {
        if (casillero.getNumeroCasillero() == numeroCasillero && casillero.getEstado().equals("Ocupado")) {
            casillero.agregarArticuloRecibido(articulo); // delega el control a Casillero
            System.out.println("Artículo asignado como recibido en el casillero " + numeroCasillero);
            return;
        }
    }
    System.out.println("No se encontró el casillero con número: " + numeroCasillero);
    }
    
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

    public String getCedulaJuridica() {
        return cedulaJuridica;
    }

    public void setCedulaJuridica(String cedulaJuridica) {
        this.cedulaJuridica = cedulaJuridica;
    }

    public Casillero getCasillero() {
        return casillero;
    }

    public void setCasillero(Casillero casillero) {
        this.casillero = casillero;
    }
    
    

    @Override
    public String toString() {
        return "Counter{" + "nombre=" + nombre + ", direccion=" + direccion + ", cantidadCasilleros=" + cantidadCasilleros + ", cedulaJuridica=" + cedulaJuridica + '}';
    }

    
}

