/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.pizzeria.dao;

import poo.pizzeria.Estado;

/**
 *
 * @author joaquinleonelrobles
 */
public interface EstadosDao {
    
    public Estado buscarPorNombre (String nombre);
    
}
