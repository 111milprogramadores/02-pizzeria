/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.pizzeria.ui;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import poo.pizzeria.DetallePedido;

/**
 *
 * @author joaquinleonelrobles
 */
class TablaDetallePedidoModel extends AbstractTableModel {
    
    private static final String[] COLUMNAS = { "Cant.", "Pizza", "Tipo", "Variedad", "Tamaño", "Precio", "Subtotal" };
    
    private List<DetallePedido> detalles;

    public TablaDetallePedidoModel() {
    }

    public TablaDetallePedidoModel(List<DetallePedido> detalles) {
        this.detalles = detalles;
    }

    @Override
    public int getRowCount() {
        return detalles == null ? 0 : detalles.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Object retorno = null;
        DetallePedido detalle = detalles.get(fila);
        
        // según la columna deseada obtenemos el valor a mostrar
        switch (columna) {
            case 0:
                retorno = detalle.getCantidad();
                break;
            case 1:
                retorno = detalle.getPizza().getNombre();
                break;
            case 2:
                retorno = detalle.getPizza().getTipoPizza();
                break;
            case 3:
                retorno = detalle.getPizza().getVariedad();
                break;
            case 4:
                retorno = detalle.getPizza().getTamanio();
                break;
            case 5:
                retorno = "$" + detalle.getPrecio();
                break;
            case 6:
                retorno = "$" + detalle.calcTotalItem();
                break;
        }
        
        return retorno;
    }
    
    @Override
    public String getColumnName(int index) {
        return COLUMNAS[index];
    }

    public void setDetalles(List<DetallePedido> detalles) {
        this.detalles = detalles;
    }
    
}
