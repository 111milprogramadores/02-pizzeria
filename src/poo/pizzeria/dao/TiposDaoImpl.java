/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.pizzeria.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import poo.pizzeria.TipoPizza;

/**
 *
 * @author joaquinleonelrobles
 */
public class TiposDaoImpl implements TiposDao {
    
    private final List<TipoPizza> tipos;

    public TiposDaoImpl() {
        this.tipos = new ArrayList<>();
        
        // Creamos los distintos Tipo de pizzas de esta pizzería.
        this.tipos.add(new TipoPizza("Horno", "Pizza cocinada en horno industrial."));
        this.tipos.add(new TipoPizza("Parrilla", "Pizza cocinada en parrilla."));
    }

    @Override
    public TipoPizza buscarPorNombre(String nombre) {
        TipoPizza retorno = null;
        
        Iterator<TipoPizza> iter = tipos.iterator();
        while (iter.hasNext()) {
            TipoPizza actual = iter.next();
            
            if (actual.getNombre().equals(nombre)) {
                retorno = actual;
                break;
            }
        }
        
        return retorno;
    }
    
}
