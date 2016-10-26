/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;
import poo.pizzeria.Factura;

/**
 *
 * @author joaquinleonelrobles
 */
public class FacturasDaoImpl implements FacturasDao {
    
    private final List<Factura> facturas;

    public FacturasDaoImpl() {
        this.facturas = new ArrayList<>();
    }

    @Override
    public int obtenerProximoNumero() {
        return this.facturas.size() + 1;
    }

    @Override
    public void guardar(Factura factura) {
        this.facturas.add(factura);
    }
    
}
