/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.pizzeria.ui;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import poo.pizzeria.Pedido;

/**
 *
 * @author Candelaria
 */
public final class TablaPedidoModel extends DefaultTableModel {

    private final String[] nombresColumnas={"Número", "Fecha y Hora", "Cliente"};
    private final ArrayList<Pedido> pedidosObjetos;
    private final Object[][] pedidos;

    public TablaPedidoModel(ArrayList<Pedido> pedidosObjetos) {
        this.pedidosObjetos = pedidosObjetos;
        pedidos= new Object[getColumnCount()][pedidosObjetos.size()];
        Iterator it = pedidosObjetos.iterator();
        int contCol=0;
        int contFila=0;
        while(it.hasNext())
        {
            Pedido p = (Pedido)it.next();
            pedidos[contFila][contCol]= p.getNumero();
            pedidos[contFila][contCol+1]= p.getFechaHoraCreacion();
            pedidos[contFila][contCol+2]= p.getNombreCliente();
            contFila++;            
        }
        
    }

    
    @Override
    public int getRowCount() {
        return pedidos.length;
    }

    @Override
    public int getColumnCount() {
        return nombresColumnas.length;
    }

    @Override
    public Object getValueAt(int filaIndex, int columnaIndex) {
         return pedidos[filaIndex][columnaIndex];
    }
    
}
