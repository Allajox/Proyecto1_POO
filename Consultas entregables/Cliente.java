package tec.entregables;       

public class Cliente {
    private String nombre;
    private int idCliente;
    private String nivel; // normal, plata, oro
    private Casillero casillero;

    public Cliente(String nombre, int idCliente, Casillero casillero) {
        this.nombre = nombre;
        this.idCliente = idCliente;
        this.casillero = casillero;
        this.nivel = "normal"; // nivel inicial
    }

    // Método para obtener estado del casillero

    public String consultarCasilleroNum(Casillero casillero) {
        return casillero.estadoCasillero(casillero);
    }
    
    public String consultarCasilleroId(int idCliente) {
        return casillero.estadoId(idCliente);
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
    
    
    
    @Override
    public String toString() {
        return "Cliente: " + nombre + " (ID: " + idCliente + "), Nivel: " + nivel;
    }
}
