/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.pizzeria.ui;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import poo.pizzeria.Pedido;

/**
 *
 * @author Candelaria
 */
public final class TablaPedidosModel extends AbstractTableModel {

    private static final String[] COLUMNAS = { "Número", "Fecha", "Hora", "Cliente" };
    
    private List<Pedido> pedidos;
    private final SimpleDateFormat formatoFecha;
    private final SimpleDateFormat formatoHora;

    public TablaPedidosModel (List<Pedido> pedidos) {
        super();
        this.formatoHora  = new SimpleDateFormat("HH:mm");
        this.formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        this.pedidos = pedidos;
    }

    @Override
    public int getRowCount() {
        return pedidos.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Object retorno = null;
        Pedido pedido = pedidos.get(fila);
        
        // según la columna deseada obtenemos el valor a mostrar
        switch (columna) {
            case 0:
                retorno = pedido.getNumero();
                break;
            case 1:
                retorno = formatoFecha.format(pedido.getFechaHoraCreacion());
                break;
            case 2:
                retorno = formatoHora.format(pedido.getFechaHoraCreacion());
                break;
            case 3:
                retorno = pedido.getNombreCliente();
                break;
        }
        
        return retorno;
    }
    
    @Override
    public String getColumnName(int index) {
        return COLUMNAS[index];
    }
    
    public Pedido obtenerPedidoEn (int fila) {
        return pedidos.get(fila);
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    
}
