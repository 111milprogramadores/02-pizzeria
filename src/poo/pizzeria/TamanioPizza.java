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
public class TamanioPizza {
    
    private int cantPorciones;
    private String nombre;

    /**
     * Constructor por defecto de la clase TamanioPizza.
     */
    public TamanioPizza() {
    }
    
    /**
     * Constructor con todos los atributos de la clase TamanioPizza.
     * @param cantPorciones
     * @param nombre 
     */
    public TamanioPizza(int cantPorciones, String nombre) {
        this.cantPorciones = cantPorciones;
        this.nombre = nombre;
    }
    
    // A continuación se listan todos los métodos de seteo
    // de cada atributo de la clase
    
    public int getCantPorciones() {
        return cantPorciones;
    }

    public void setCantPorciones(int cantPorciones) {
        this.cantPorciones = cantPorciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String toString() {
        return "" + this.cantPorciones;
    }
}
