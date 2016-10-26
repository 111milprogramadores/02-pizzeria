/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.pizzeria;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author Candelaria
 */
public class DetallePedido {
    
    private int cantidad;
    private BigDecimal precio;
    private Pizza pizza;
    private EstadoPedido estado;
    
    /**
     * Constructor por defecto de la clase DetallePedido.
     */
    public DetallePedido() {
    }
    
    /**
     * Constructor sin atributos referenciales de la clase DetallePedido.
     * @param cantidad
     * @param precio 
     */
    public DetallePedido(int cantidad, BigDecimal precio) {
        this.cantidad = cantidad;
        this.precio = precio;
    }
       
    /**
     * Constructor con todos los atributos de la clase DetallePedido.
     * @param cantidad
     * @param precio
     * @param pizza
     * @param estado 
     */
    public DetallePedido(int cantidad, BigDecimal precio, Pizza pizza, EstadoPedido estado) {
        this.cantidad = cantidad;
        this.precio = precio;
        this.pizza = pizza;
        this.estado = estado;
    }
    
    /**
     * Método que calcula el subtotal del pedido, es decir el monto del detalle, que es igual a precio*cantidad.
     * @return BigDecimal
     */
    public BigDecimal calcTotalItem()
    {
       return precio.multiply(new BigDecimal(cantidad));        
    }
    
    // A continuación se listan todos los métodos de seteo
    // de cada atributo de la clase
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("\n Cantidad: ").append(cantidad).append("\n Precio: ").append(precio).append("Pizza: ").append(pizza.getNombre()).append("\n Estado: ").append(estado.getNombre());
        return sb.toString();
    }
    
}
