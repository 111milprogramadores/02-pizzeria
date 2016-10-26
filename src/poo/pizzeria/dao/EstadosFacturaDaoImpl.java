/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.pizzeria.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import poo.pizzeria.EstadoFactura;

/**
 *
 * @author joaquinleonelrobles
 */
public class EstadosFacturaDaoImpl implements EstadosFacturaDao {
    
    private final List<EstadoFactura> estados;

    public EstadosFacturaDaoImpl() {
        this.estados = new ArrayList<>();
        
        // agregamos los estados iniciales
        this.estados.add(new EstadoFactura("Generada", "La Factura se encuentra generada"));
    }

    @Override
    public EstadoFactura buscarPorNombre(String nombre) {
        EstadoFactura retorno = null;
        
        Iterator<EstadoFactura> iter = estados.iterator();
        while (iter.hasNext()) {
            EstadoFactura actual = iter.next();
            
            if (actual.getNombre().equals(nombre)) {
                retorno = actual;
                break;
            }
        }
        
        return retorno;
    }
    
}
