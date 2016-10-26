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
public class VariedadPizza {
    private String ingredientes;
    private String nombre;

    /**
     * Constructor por defecto de la clase VariedadPizza.
     */
    public VariedadPizza() {
    }
    
    /**
     * Constructor con todos los atributos de la clase VariedadPizza.
     * @param ingredientes
     * @param nombre 
     */
    public VariedadPizza(String ingredientes, String nombre) {
        this.ingredientes = ingredientes;
        this.nombre = nombre;
    }

    // A continuación se listan todos los métodos de seteo
    // de cada atributo de la clase
    
    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}
