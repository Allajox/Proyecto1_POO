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
    private String cliente;
    private Casillero casillero;
    private int cantidadCasilleros;
    private List<Casillero> casilleros;
    private List<Cliente> clientes;
    private List<Articulo> articulosRecibidos;
    private List<Articulo> articulosEntregados;
    private List<Articulo> articulosPendientes;
    /**
     * Constructor que inicializa los atributos del contador.
     *
     * @param nombre del contador.
     * @param direccion del contador.
     * @param cantidadCasilleros a crear.
     */
    public Counter(String nombre, String direccion, int cantidadCasilleros, String Cedula) {
        this.nombre = nombre;
        this.casillero = casillero;
        this.direccion = direccion;
        this.cantidadCasilleros = cantidadCasilleros;
        this.casilleros = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.articulosRecibidos = new ArrayList<>();
        this.articulosEntregados = new ArrayList<>();
        this.articulosPendientes = new ArrayList<>();
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
     * @param casillero asignado al cliente.
     * @param nivel del cliente.
     * @return true si el cliente fue registrado exitosamente, false si hubo errores.
     * @throws Exception si ocurre un error en el registro.
     */
    public boolean registrarCliente(String nombre, int idCliente, String telefono, String correo, String sexo, Casillero casillero, String nivel) throws Exception {
        if (!Validaciones.validarTelefono(telefono) || !Validaciones.validarCorreo(correo)) {
            return false;
        }
        Cliente cliente = new Cliente(nombre, idCliente, telefono, correo, sexo, nivel);
        clientes.add(cliente);
        return true;
    }
    
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
    
    // LOS 2 SIGUIENTES MÉTODOS SE CORREGIRÁN DESPUÉS DE PREGUNTARLE A LA PROFE --------------------------------------------
    
    /**
     * Retorna el estado del casillero de un cliente por su ID.
     * 
     * @param idCliente del cliente.
     * @return Estado de los artículos del cliente (recibidos, entregados y pendientes).
     */
//    public String estadoId(int idCliente) {
//        for (Cliente cliente : clientes) {
//            if (cliente.getIdCliente() == idCliente) {
//                return "El cliente " + idCliente + " tiene " 
//                + cliente.getArticulosRecibidos().size() + " artículos recibidos, " 
//                + cliente.getArticulosEntregados().size() + " artículos entregados y " 
//                + cliente.getArticulosPendientes().size() + " artículos pendientes.";
//            }
//        }
//    return "Cliente no encontrado";
//    }
    
    /**
     * Retorna el estado del casillero.
     * 
     * @param casillero a consultar.
     * @return Estado del casillero (artículos recibidos, entregados y pendientes).
     */
//    public String estadoCasillero(Casillero casillero) {
//        for (Cliente cliente2 : clientes) {
//            if (cliente2.getCasillero() == casillero) {
//                return "El casillero " + casillero.getNumero() + " tiene " 
//                + cliente2.getArticulosRecibidos().size() + " artículos recibidos, " 
//                + cliente2.getArticulosEntregados().size() + " artículos entregados y " 
//                + cliente2.getArticulosPendientes().size() + " artículos pendientes.";
//            }
//        }
//    return "Casillero no encontrado";
//    }
    // ------------------------------------------------------------------------------------------------------
    
    /**
     * Método que consulta el estado de un casillero por el ID del cliente.
     *
     * @param idCliente del cliente.
     * @return el estado del casillero del cliente o un mensaje de error.
     */
//    public String consultarEstadoCasilleroPorCliente(int idCliente) {
//        for (Cliente cliente : clientes) {
//            if (cliente.getIdCliente() == idCliente) {
//                return "Casillero del cliente " + idCliente + ": " + cliente.getCasillero().getNumero();
//            }
//        }
//        return "Cliente no encontrado";
//    }

    /**
     * Consulta los clientes que tienen artículos pendientes en el casillero.
     * 
     * @param counter que contiene la lista de clientes.
     * @return Lista de clientes con artículos pendientes.
     */
    public String clientesPaquetesPendientes(Counter counter) {
    StringBuilder resultado = new StringBuilder();
    
    for (Cliente cliente : counter.getClientes()) {  // Obtener los clientes desde el counter
        Casillero casilleroCliente = counter.getCasillero();  // Obtener el casillero del cliente
        
        if (casilleroCliente != null) {
            List<Articulo> articulosPendientes = counter.getArticulosPendientes();
            
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
    public void agregarArticuloPendiente(Counter counter, Articulo articulo, String estadoArticulo) {
        counter.agregarArticuloPendiente(articulo);
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
    public void agregarArticuloRecibido(Counter counter, Articulo articulo, String estadoArticulo) {
        counter.agregarArticuloRecibido(articulo);  
        counter.agregarArticuloPendiente(articulo); // Actualiza también en la lista de pendientes del cliente
        articulo.setEstadoArticulo(estadoArticulo);

    }
    /**
     * Agrega un artículo entregado al casillero y lo remueve de pendientes.
     * 
     * @param cliente que recibe el artículo.
     * @param articulo entregado.
     * @param estadoArticulo del artículo.
     */
    public void agregarArticuloEntregado(Counter counter, Articulo articulo, String estadoArticulo) {
        counter.agregarArticuloEntregado(articulo);  // Actualiza en cliente
        this.articulosEntregados.add(articulo);      // Actualiza en casillero
        this.articulosPendientes.remove(articulo);   // Quita el artículo de pendientes en casillero
        articulo.setEstadoArticulo(estadoArticulo);
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
    
    //------------------------------------------------------------------------------------------------------------------------
    
    
//    public void notificarClienteRecepcion(Cliente cliente, Entregable entregable) {
//        // Simulación de notificación por correo
//        System.out.println("Notificación enviada a " + cliente.getCorreo() + " sobre el entregable " + entregable.getNumeroReferencia());
//    }
    
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
        articulosPendientes.remove(articulo);
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

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Casillero getCasillero() {
        return casillero;
    }

    public void setCasillero(Casillero casillero) {
        this.casillero = casillero;
    }

    public int getCantidadCasilleros() {
        return cantidadCasilleros;
    }

    public void setCantidadCasilleros(int cantidadCasilleros) {
        this.cantidadCasilleros = cantidadCasilleros;
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

