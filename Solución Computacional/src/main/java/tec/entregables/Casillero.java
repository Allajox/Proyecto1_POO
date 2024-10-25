package tec.entregables;

/**
 *
 * @author allaj
 */
public class Casillero {
    private int numero;
    private String estado;
    /**
     * Constructor para inicializar un casillero.
     * 
     * @param numero del casillero.
     * @param estado inicial del casillero (libre/ocupado).
     */
    public Casillero(int numero, String estado) {
        this.numero = numero;
        this.estado = estado;
        
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
    
    
    //*********************************************************************************************
    

    public int getNumero() {
        return numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
