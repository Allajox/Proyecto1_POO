package tec.entregables;

/**
 *
 * @author danielasuarez
 */
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Counter {
    private String nombre;
    private String direccion;
    private int cantidadCasilleros;
    private String cedulaJuridica;
    private Cliente cliente;
    private Casillero casillero;
    private List<Casillero> casilleros;
    private List<Cliente> clientes;
    private List<Articulo> articulos;
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
        this.articulos = new ArrayList<>();
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
    public Cliente registrarClienteEnCounter(String nombre, int idCliente, String telefono, String correo, boolean sexo, Date fechaNac) throws Exception {
        if (!Validaciones.validarTelefono(telefono) || !Validaciones.validarCorreo(correo)) {
            return null;
        }
        Cliente cliente1 = new Cliente(nombre, idCliente, telefono, correo, sexo, fechaNac);
        if (cliente1 != null) {
            clientes.add(cliente1);
            System.out.println("El cliente " + cliente1.getNombre() + " fue registrado.");
        }

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
    
    /**
     * Libera el casillero, dejándolo sin cliente.
     * @param idCliente
     */
    public void eliminarCliente(int idCliente) {
    Iterator<Cliente> iterador = clientes.iterator(); // se utiliza un iterador porque eliminar algo de un arraylist durante un for da error
        while (iterador.hasNext()) {
            Cliente cliente = iterador.next();
            if (cliente.getIdCliente() == idCliente) {
                iterador.remove();
                System.out.println("El cliente " + cliente.getNombre() + " fue eliminado.");
                return;
            }
        }
        System.out.println("Cliente no encontrado.");
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
                                "Fecha de Nacimiento: " + formatearFecha(cliente1.getFechaNac()) + "\n" + 
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
                                "Fecha de Nacimiento: " + formatearFecha(clienteAsignado.getFechaNac()) + "\n" + 
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
     * Método que retira un articulo de un casillero
     * @param numeroCasillero 
     * @param numeroReferencia 
     */
    public void retirarArticulo(int numeroCasillero, int numeroReferencia) {
    for (Casillero casillero : casilleros) {
        if (casillero.getNumeroCasillero() == numeroCasillero) {
            for (Articulo articulo: articulos) {
                if (numeroReferencia == articulo.getNumeroReferencia()) {
                    casillero.agregarArticuloEntregado(articulo); // delega el control a Casillero
                    articulo.setFechaEntregado(new Date());
                    System.out.println("Artículo retirado: " + articulo);
                    return;
                }
            }
            
        }
    }
    System.out.println("No se encontró el casillero con número: " + numeroCasillero);
    }
    
    /**
     * Método que asigna un artículo como recibido y pendiente
     * @param numeroCasillero 
     * @param nombre 
     * @param numeroReferencia 
     * @param descripcion 
     * @param remitente 
     * @param peso 
     */
    public void recibirArticulo(int numeroCasillero, String nombre, int numeroReferencia, String descripcion, String remitente, double peso) {
        Articulo articulo = new Articulo(nombre, numeroReferencia, descripcion, remitente, peso);
        articulos.add(articulo);
        for (Casillero casillero : casilleros) {
            if (casillero.getNumeroCasillero() == numeroCasillero && casillero.getEstado().equals("Ocupado")) {// agrega el artículo solo si el casillero está ocupado
                casillero.agregarArticuloRecibido(articulo); // delega el control a Casillero
                casillero.agregarArticuloPendiente(articulo); // delega el control a Casillero
                return;
            }
        }
        System.out.println("No se encontró el casillero con número: " + numeroCasillero);
    }
    
    
    // CONSULTAS POR FECHA ------------------------------------------------------------------------------------------------------------
    
    /**
     * Consulta los artículos del casillero por fecha.
     * 
     * @param articulos lista de artículos.
     * @param fecha a comparar.
     * @param estado (recibido, entregado o pendiente)
     * @return Lista de artículos encontrados en la fecha dada.
     */      
    public List<Articulo> consultarArticulosPorFecha(List<Articulo> articulos, Date fecha, String estado) {
    List<Articulo> articulosFecha = new ArrayList<>();
    
    for (Articulo articulo : articulos) {
        boolean coincide = false;
        String fechaArticulo = "";
        switch (estado) {
            case "Recibido":
                fechaArticulo = formatearFecha(articulo.getFechaRecibido());
                coincide = fechaArticulo.equals(formatearFecha(fecha));
                break;
            case "Entregado":
                fechaArticulo = formatearFecha(articulo.getFechaEntregado());
                coincide = fechaArticulo.equals(formatearFecha(fecha));
                break;
            case "Pendiente":
                fechaArticulo = formatearFecha(articulo.getFechaPendiente());
                coincide = fechaArticulo.equals(formatearFecha(fecha));
                break;
        }
        if (coincide) {
            articulosFecha.add(articulo);
        }
    }
    return articulosFecha;
    }
    
    /**
     * 
     * @param fecha la fecha en la que se quiere consultar
     * @return todos los artículos recibidos en la fecha consultada
     */
    public List<Articulo> consultarArticulosRecibidos(Date fecha) {
        List<Articulo> articulosRecibidos = new ArrayList<>(); // crea una nueva lista para agregar todos los artículos 
        for (Casillero casillero : casilleros) {
            articulosRecibidos.addAll(consultarArticulosPorFecha(casillero.getArticulosRecibidos(), fecha, "Recibido"));
        }
        return articulosRecibidos;
    }

    /**
     * 
     * @param fecha la fecha en la que se quiere consultar
     * @return todos los artículos entregados en la fecha consultada
     */
    public List<Articulo> consultarArticulosEntregados(Date fecha) {
        List<Articulo> articulosEntregados = new ArrayList<>(); // crea una nueva lista para agregar todos los artículos 
        for (Casillero casillero : casilleros) {
            articulosEntregados.addAll(consultarArticulosPorFecha(casillero.getArticulosEntregados(), fecha, "Entregado"));
        }
        return articulosEntregados;
    }

    /**
     * 
     * @param fecha la fecha en la que se quiere consultar
     * @return todos los artículos pendientes en la fecha consultada
     */
    public List<Articulo> consultarArticulosPendientes(Date fecha) {
        List<Articulo> articulosPendientes = new ArrayList<>(); // crea una nueva lista para agregar todos los artículos 
        for (Casillero casillero : casilleros) {
            articulosPendientes.addAll(consultarArticulosPorFecha(casillero.getArticulosPendientes(), fecha, "Pendiente"));
        }
        return articulosPendientes;
    }
    
    public static String formatearFecha(Date unaFecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(unaFecha);
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

