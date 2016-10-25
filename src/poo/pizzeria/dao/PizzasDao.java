/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.pizzeria.dao;

import poo.pizzeria.Pizza;

/**
 *
 * @author joaquinleonelrobles
 */
public interface PizzasDao {
    
    public Pizza buscarPorNombre (String nombre);
    
}
