/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.pizzeria.dao;

import poo.pizzeria.Factura;

/**
 *
 * @author joaquinleonelrobles
 */
public interface FacturasDao {
    
    public int obtenerProximoNumero ();
    public void guardar (Factura factura);
    
}
