/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.pizzeria.ui;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import poo.pizzeria.Pedido;

/**
 *
 * @author joaquinleonelrobles
 */
public class PedidosTableModelListener implements ListSelectionListener {
    
    private final PantallaFacturacion pantallaFacturacion;

    public PedidosTableModelListener(PantallaFacturacion pantallaFacturacion) {
        this.pantallaFacturacion = pantallaFacturacion;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        // obtenemos el pedido seleccionado
        Pedido seleccionado = pantallaFacturacion.obtenerPedidoSeleccionado();

        // actualizamos el detalle del pedido
        if (seleccionado != null) {
            pantallaFacturacion.getTablaDetallePedidoModel().setDetalles(seleccionado.getDetallesPedido());
            pantallaFacturacion.getTablaDetallePedidoModel().fireTableDataChanged();

            // actualizamos el total del pedido
            pantallaFacturacion.getTxtTotalPedido().setText("$" + seleccionado.calcTotalPedido());
        }
    }
    
}
