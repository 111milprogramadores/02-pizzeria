/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.pizzeria.ui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JFrame;
import poo.pizzeria.Pedido;
import poo.pizzeria.ui.PantallaFacturacion;

/**
 *
 * @author Candelaria
 */
public class GestorFacturacion 
{
    private PantallaFacturacion pantalla;
    private ArrayList<Pedido> pedidos;

    /**
     * Constructor por defecto.
     */
    public GestorFacturacion() {
        pantalla= new PantallaFacturacion();
        pantalla.setVisible(true);
        pedidos= new ArrayList<>();        
    }
    
    public void  nuevaFactura(){
           System.out.println("entro al metodo del gestor");
        pantalla.mostrarPedidosPtesFacturacion(this.buscarPedidosPtesFacturacion());
    }
    
    public ArrayList<Pedido> buscarPedidosPtesFacturacion(){
         ArrayList<Pedido> pedidosPtes=new ArrayList<>();
         Iterator it = pedidos.iterator();
         while(it.hasNext()){
             Pedido p = (Pedido)it.next();
             if(p.esPteFacturacion())
                 pedidosPtes.add(p);
         }
         return pedidosPtes;
     }

    public PantallaFacturacion getPantalla() {
        return pantalla;
    }

    public void setPantalla(PantallaFacturacion pantalla) {
        this.pantalla = pantalla;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
     
    public void run () {
        
    }
         
}
