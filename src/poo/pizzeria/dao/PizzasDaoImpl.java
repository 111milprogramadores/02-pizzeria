/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.pizzeria.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import poo.pizzeria.Pizza;
import poo.pizzeria.TamanioPizza;
import poo.pizzeria.TipoPizza;
import poo.pizzeria.VariedadPizza;

/**
 *
 * @author joaquinleonelrobles
 */
public class PizzasDaoImpl implements PizzasDao {
    
    private final List<Pizza> pizzas;

    public PizzasDaoImpl(TiposDao tiposDao, VariedadesDao variedadesDao, TamaniosDao tamaniosDao) {
        this.pizzas = new ArrayList<>();
        
        // obtenemos los objetos relacionados
        TipoPizza parrilla = tiposDao.buscarPorNombre("Parrilla");
        TipoPizza horno    = tiposDao.buscarPorNombre("Horno");
        
        VariedadPizza napolitana = variedadesDao.buscarPorNombre("Napolitana");
        VariedadPizza especial   = variedadesDao.buscarPorNombre("Especial");
        VariedadPizza mozzarella = variedadesDao.buscarPorNombre("Mozzarella");
        
        TamanioPizza normal  = tamaniosDao.buscarPorNombre("Normal");
        TamanioPizza mediana = tamaniosDao.buscarPorNombre("Mediana");
        TamanioPizza grande  = tamaniosDao.buscarPorNombre("Grande");
        
        // Creamos una pizza Napolitana de 8 porciones
        this.pizzas.add(new Pizza("Napolitana Normal", new BigDecimal(125.00), parrilla, napolitana, normal));
         
        // Creamos una pizza Especial de 12 porciones 
        this.pizzas.add(new Pizza("Especial Grande", new BigDecimal(165.00), horno, especial, grande));
         
        // Creamos una pizza Mozzarella de 10 porciones
        this.pizzas.add(new Pizza("Mozzarella Mediana", new BigDecimal(120.00), parrilla, mozzarella, mediana));
    }
    
    @Override
    public Pizza buscarPorNombre(String nombre) {
        Pizza retorno = null;
        
        Iterator<Pizza> iter = pizzas.iterator();
        while (iter.hasNext()) {
            Pizza actual = iter.next();
            
            if (actual.getNombre().equals(nombre)) {
                retorno = actual;
                break;
            }
        }
        
        return retorno;
    }
    
}
