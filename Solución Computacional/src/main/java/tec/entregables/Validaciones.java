package tec.entregables;

import java.util.regex.Pattern;

/**
 *
 * @author salaz
 */
public class Validaciones {
    private static final String validacionTelefono = "\\d{8}";
    private static final String validacionCedula = "\\d{9}";
    private static final String validacionCorreo = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    /**
     * Valida un número de teléfono.
     *
     * @param telefono el número de teléfono a validar.
     * @return true si el número de teléfono es válido, false en caso contrario.
     */
    public static boolean validarTelefono(String telefono) {
        return Pattern.matches(validacionTelefono, telefono);
    }
    /**
     * Valida un correo electrónico.
     *
     * @param correo el correo electrónico a validar.
     * @return true si el correo electrónico es válido, false en caso contrario.
     */
    public static boolean validarCorreo(String correo) {
        return Pattern.matches(validacionCorreo, correo);
    }
    /**
     * Valida una cédula.
     *
     * @param cedula la cédula a validar.
     * @return true si la cédula es válida, false en caso contrario.
     */
    public static boolean validarCedula(String cedula) {
        return Pattern.matches(validacionCedula, cedula);
    }
}