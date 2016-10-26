/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.pizzeria.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import poo.pizzeria.Estado;

/**
 *
 * @author joaquinleonelrobles
 */
public class EstadosDaoImpl implements EstadosDao {
    
    private final List<Estado> estados;

    public EstadosDaoImpl() {
        this.estados = new ArrayList<>();
        
        // agregamos los estados iniciales
        this.estados.add(new Estado("Pendiente de Facturación", "El Pedido se encuentra listo sin Factura generada"));
    }

    @Override
    public Estado buscarPorNombre(String nombre) {
        Estado retorno = null;
        
        Iterator<Estado> iter = estados.iterator();
        while (iter.hasNext()) {
            Estado actual = iter.next();
            
            if (actual.getNombre().equals(nombre)) {
                retorno = actual;
                break;
            }
        }
        
        return retorno;
    }
    
}
