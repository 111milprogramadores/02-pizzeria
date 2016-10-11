/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.pizzeria;

import java.math.BigDecimal;

/**
 *
 * @author Candelaria
 */
public class Pizza {
    private String nombre;
    private BigDecimal precio;
    private TipoPizza tipoPizza;
    private VariedadPizza variedad;
    private TamanioPizza tamanio;

    /**
     * Constructor por Defecto.
     */
    public Pizza() {
    }
    
    /**
     * Constructor sin atributos referenciales de la clase Pizza.
     * @param nombre
     * @param precio 
     */
    public Pizza(String nombre, BigDecimal precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    
    /**
     * Constructor con todos los atributos de la clase Pizza.
     * @param nombre
     * @param precio
     * @param tipoPizza
     * @param variedad
     * @param tamanio 
     */
    public Pizza(String nombre, BigDecimal precio, TipoPizza tipoPizza, VariedadPizza variedad, TamanioPizza tamanio) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipoPizza = tipoPizza;
        this.variedad = variedad;
        this.tamanio = tamanio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public TipoPizza getTipoPizza() {
        return tipoPizza;
    }

    public void setTipoPizza(TipoPizza tipoPizza) {
        this.tipoPizza = tipoPizza;
    }

    public VariedadPizza getVariedad() {
        return variedad;
    }

    public void setVariedad(VariedadPizza variedad) {
        this.variedad = variedad;
    }

    public TamanioPizza getTamanio() {
        return tamanio;
    }

    public void setTamanio(TamanioPizza tamanio) {
        this.tamanio = tamanio;
    }    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pizza \n - Nombre: ").append(nombre).append("\n - Precio: $ ").append(precio).append("\n - Tipo: ").append(tipoPizza.getNombre()).append("\n - Variedad: ").append(variedad.getNombre()).append("\n - Tamaño: ").append(tamanio.getNombre()).append(" : ").append(tamanio.getCantPorciones()).append(" porc.");
        return sb.toString();
    }
    
    
}
