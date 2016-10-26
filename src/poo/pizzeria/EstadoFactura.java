/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.pizzeria;

/**
 *
 * @author Candelaria
 */
public class EstadoFactura {
    
    private String nombre;
    private String descripcion;
    
    /**
     * Constructor por defecto de la clase Estado.
     */
    public EstadoFactura() {
    }
    
    /**
     * Constructor con todos los atributos de la clase Estado.
     * @param nombre
     * @param descripcion 
     */
    public EstadoFactura(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    /**
     * Método que devuelve true si el estado es Generada, sino devuelve false, El estado generada es de la factura.
     * @return 
     */
    public boolean esGenerada() {
        return nombre.equals("Generada");
    }
    
    
    // A continuación se listan todos los métodos de seteo
    // de cada atributo de la clase
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
