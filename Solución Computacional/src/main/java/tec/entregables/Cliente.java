package tec.entregables;

import java.util.Date;

/**
 *
 * @author salaz
 */
public class Cliente {
    private String nombre;
    private int idCliente;
    private String telefono;
    private String correo;
    private boolean sexo;
    private Date fechaNac;
    private String nivel; // normal, plata, oro;
    
    /**
     * Constructor que inicializa los atributos del cliente.
     *  
     * @param nombre del cliente.
     * @param idCliente del cliente.
     * @param telefono del cliente.
     * @param correo del cliente.
     * @param sexo del cliente.
     */

    public Cliente(String nombre, int idCliente, String telefono, String correo, boolean sexo, Date fechaNac) {
        this.nombre = nombre;
        this.idCliente = idCliente;
        this.telefono = telefono;
        this.correo = correo;
        this.sexo = sexo;
        this.fechaNac = fechaNac;
        this.nivel = "Normal"; // nivel inicial
    }
    
    /**
     * 
     * Sube el nivel del cliente dependiendo de la cantidad de artículos recibidos.
     * 
     * Si tiene 5 o más artículos, sube a "Plata". Si tiene 10 o más, sube a "Oro".
     *
     * @return Nivel actual del cliente.
     */
//    public String subirNivel() {
//        if (articulosRecibidos.size() >= 5) {
//            this.setNivel("Plata");
//        }
//        if (articulosRecibidos.size() >= 10) {
//            this.nivel = "Oro";
//        }
//        return nivel;
//    }
    
    public String getNombre() {
        return nombre;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getNivel() {
        return nivel;
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

    public boolean getSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    @Override
    public String toString() {
        return  "Nombre = " + nombre + "\n" +
                ", idCliente = " + idCliente + "\n" + 
                ", telefono = " + telefono + "\n" +
                ", correo =" + correo + "\n" + 
                ", sexo = " + sexo + "\n" +
                ", fechaNac = " + fechaNac + "\n" +
                ", nivel = " + nivel + '}' + "\n";
    } 
}
