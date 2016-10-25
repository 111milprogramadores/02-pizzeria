/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.pizzeria.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import poo.pizzeria.TamanioPizza;

/**
 *
 * @author joaquinleonelrobles
 */
public class TamaniosDaoImpl implements TamaniosDao {
    
    private final List<TamanioPizza> tamanios;

    public TamaniosDaoImpl() {
        this.tamanios = new ArrayList<>();
        
        // Creamos los distintos tamaños de pizzas posibles.
        this.tamanios.add(new TamanioPizza(8,"Normal"));
        this.tamanios.add(new TamanioPizza(12,"Grande"));
        this.tamanios.add(new TamanioPizza(10,"Mediana"));
    }

    @Override
    public TamanioPizza buscarPorNombre(String nombre) {
        TamanioPizza retorno = null;
        
        Iterator<TamanioPizza> iter = tamanios.iterator();
        while (iter.hasNext()) {
            TamanioPizza actual = iter.next();
            
            if (actual.getNombre().equals(nombre)) {
                retorno = actual;
                break;
            }
        }
        
        return retorno;
    }
    
}
