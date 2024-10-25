/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tec.entregables;

public class CalculadoraImpuestos {

    /**
     * Calcula el impuesto sobre envíos aéreos o documentos.
     * 
     * @param isAereo      Indica si el artículo es un envío aéreo.
     * @param isDocumento  Indica si el artículo es un documento.
     * @return El impuesto calculado según las condiciones.
     */
    public static double calcularImpuestoSobre(boolean isAereo,boolean isDocumento) {
        if (isAereo) {
            if (isDocumento){
                return 0.0;
            }
            return 1.0;
        } 
        if (isDocumento){
            return 1.0;
        }
        return 2.0;
    }
    /**
     * Calcula el impuesto sobre paquetes basado en el peso, si es electrónico o frágil.
     * 
     * @param peso          Peso del paquete en kilogramos.
     * @param esElectronico Indica si el paquete contiene un artículo electrónico.
     * @param esFragil      Indica si el paquete contiene un artículo frágil.
     * @return El impuesto calculado basado en los factores del paquete.
     */
    public static double calcularImpuestoPaquete(double peso, boolean esElectronico, boolean esFragil) {
        double impuesto = peso * 0.02;
        if (esElectronico) {
            impuesto += 2.0;
        }
        if (esFragil) {
            impuesto += 2.0;
        }
        return impuesto;
    }
    /**
     * Calcula el impuesto sobre revistas, diferenciando si es un catálogo.
     * 
     * @param esCatalogo  Indica si la revista es un catálogo.
     * @return El impuesto calculado (0.0 si es un catálogo, 1.0 si no lo es).
     */
    public static double calcularImpuestoRevista(boolean esCatalogo) {
        if (esCatalogo) {
            return 0.0; 
        } else {
            return 1.0;
        }
    }
}