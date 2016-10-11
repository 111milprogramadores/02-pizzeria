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
public class Estado {
    private String nombre;
    private String descripcion;
    
    /**
     * Constructor por defecto de la clase Estado.
     */
    public Estado() {
    }
    
    /**
     * Constructor con todos los atributos de la clase Estado.
     * @param nombre
     * @param descripcion 
     */
    public Estado(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    /**
     * Método que devuelve true si el estado es Pendiente de Facturación, El estado Pendiente de facturación es del pedido.
     * @return 
     */
    public boolean esPteFacturacion(){
        //El método compareTo devuelve 0 cuando se cumple la igualdad. 
        return nombre.compareTo("Pendiente de Facturación")==0;
    }
    /**
     * Método que devuelve true si el estado es Facturado, sino devuelve false, El estado facturado es del pedido. 
     * @return 
     */
    public boolean esFacturado(){
        //El método compareTo devuelve 0 cuando se cumple la igualdad. 
        return nombre.compareTo("Facturado")==0;
    }
    
    /**
     * Método que devuelve true si el estado es Generada, sino devuelve false, El estado generada es de la factura.
     * @return 
     */
    public boolean esGenerada(){
        //El método compareTo devuelve 0 cuando se cumple la igualdad. 
        return nombre.compareTo("Generada")==0;
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
