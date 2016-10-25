/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.pizzeria.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import poo.pizzeria.VariedadPizza;

/**
 *
 * @author joaquinleonelrobles
 */
public class VariedadesDaoImpl implements VariedadesDao {
    
    private final List<VariedadPizza> variedades;

    public VariedadesDaoImpl() {
        this.variedades = new ArrayList<>();
        
        // Creamos las distintas variedades de pizzas.
        this.variedades.add(new VariedadPizza("muzarella, salsa, tomates, aceitunas, oregano, ajo","Napolitana"));
        this.variedades.add(new VariedadPizza("mozzarella, salsa, jamón cocido, morrón, aceitunas, oregano","Especial"));
        this.variedades.add(new VariedadPizza("mozzarella, salsa, aceitunas, oregano,","Mozzarella"));
    }

    @Override
    public VariedadPizza buscarPorNombre(String nombre) {
        VariedadPizza retorno = null;
        
        Iterator<VariedadPizza> iter = variedades.iterator();
        while (iter.hasNext()) {
            VariedadPizza actual = iter.next();
            
            if (actual.getNombre().equals(nombre)) {
                retorno = actual;
                break;
            }
        }
        
        return retorno;
    }
    
}
