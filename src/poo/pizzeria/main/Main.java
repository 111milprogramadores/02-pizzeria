/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.pizzeria.main;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import poo.pizzeria.DetallePedido;
import poo.pizzeria.EstadoPedido;
import poo.pizzeria.ui.GestorFacturacion;
import poo.pizzeria.Pedido;
import poo.pizzeria.Pizza;
import poo.pizzeria.TamanioPizza;
import poo.pizzeria.TipoPizza;
import poo.pizzeria.VariedadPizza;

/**
 *
 * @author Candelaria
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Calendar ahora = Calendar.getInstance();
         
         //Creamos los distintos tamaños de pizzas posibles.
         TamanioPizza normal= new TamanioPizza(8,"Normal");
         TamanioPizza grande= new TamanioPizza(12,"Grande");
         TamanioPizza mediana= new TamanioPizza(10,"Mediana");
         
         //Creamos las distintas variedades de pizzas.
         VariedadPizza napolitana= new VariedadPizza("muzarella, salsa, tomates, aceitunas, oregano, ajo","Napolitana");
         VariedadPizza especial= new VariedadPizza("mozzarella, salsa, jamón cocido, morrón, aceitunas, oregano","Especial");
         VariedadPizza mozzarella= new VariedadPizza("mozzarella, salsa, aceitunas, oregano,","Mozzarella");
        
         //Creamos los distintos Tipo de pizzas de esta pizzería.
         TipoPizza horno = new TipoPizza("Horno","Pizza cocinada en horno industrial.");
         TipoPizza parrilla = new TipoPizza("Parrilla","Pizza cocinada en parrilla.");
        
         //Creamos una pizza Napolitana de 8 porciones
         Pizza napolitanaNormal;
         BigDecimal precioNapo= new BigDecimal(125.00);
         napolitanaNormal = new Pizza("Napolitana Normal",precioNapo,parrilla,napolitana,normal);
         
         //Creamos una pizza Especial de 12 porciones
         Pizza especialGrande;
         BigDecimal precioEspecial= new BigDecimal(165.00);
         especialGrande = new Pizza("Especial Grande",precioEspecial,horno,especial,grande);
         
         //Creamos una pizza Mozzarella de 10 porciones
         Pizza mozzarellaMediana;
         BigDecimal precioMozza= new BigDecimal(120.00);
         mozzarellaMediana = new Pizza("Mozzarella Mediana",precioMozza,parrilla,mozzarella,mediana);
                  
         //Creamos un pedido que todavía no ha sido facturado.
         Pedido pedido= new Pedido();
         pedido.setFechaHoraCreacion(ahora.getTime());
         ahora.add(Calendar.MINUTE, 45);  
         pedido.setFechaHoraEntrega(ahora.getTime());
         pedido.setNombreCliente("María Cortez");
         pedido.setNumero(1);
         //Creamos el estado del pedido Pendiente de Facturación.
         EstadoPedido pteFacturacion= new EstadoPedido("Pendiente de Facturación","La pizza se encuentra lista, sin factura creada");
         pedido.setEstado(pteFacturacion);
        
         //Creamos los detalles del pedido para luego asignarselos al pedido.
         DetallePedido pDetalle1 = new DetallePedido(3,precioNapo, napolitanaNormal,pteFacturacion);
         DetallePedido pDetalle2 = new DetallePedido(1,precioEspecial, especialGrande,pteFacturacion);
         DetallePedido pDetalle3 = new DetallePedido(3,precioMozza, mozzarellaMediana,pteFacturacion);       
         
         //Creamos una lista y le asignamos los detalles.
         ArrayList<DetallePedido> detallesPedido = new ArrayList<>();
         detallesPedido.add(pDetalle1);
         detallesPedido.add(pDetalle2);
         detallesPedido.add(pDetalle3);
         
        //Asignamos la lista de detalles al pedido.
         pedido.setDetallesPedido(detallesPedido);
         
         //Creamos otro pedido que todavía no ha sido facturado.
         Pedido pedido2= new Pedido();
         pedido2.setFechaHoraCreacion(ahora.getTime());
         ahora.add(Calendar.MINUTE, 55);  
         pedido2.setFechaHoraEntrega(ahora.getTime());
         pedido2.setNombreCliente("Carmen López");
         pedido2.setNumero(2);
         pedido2.setEstado(pteFacturacion);
        
         //Creamos los detalles del pedido para luego asignarselos al pedido.
         DetallePedido p2Detalle1 = new DetallePedido(2,precioNapo, napolitanaNormal,pteFacturacion);
         DetallePedido p2Detalle2 = new DetallePedido(3,precioEspecial, especialGrande,pteFacturacion);
         DetallePedido p2Detalle3 = new DetallePedido(1,precioMozza, mozzarellaMediana,pteFacturacion);       
         
         //Creamos una lista y le asignamos los detalles.
         ArrayList<DetallePedido> detallesPedido2 = new ArrayList<>();
         detallesPedido2.add(p2Detalle1);
         detallesPedido2.add(p2Detalle2);
         detallesPedido2.add(p2Detalle3);
         
         //Asignamos la lista de detalles al pedido.
         pedido2.setDetallesPedido(detallesPedido2);
         
         //Creamos otro pedido que todavía no ha sido facturado.
         Pedido pedido3= new Pedido();
         pedido3.setFechaHoraCreacion(ahora.getTime());
         ahora.add(Calendar.MINUTE, 55);  
         pedido3.setFechaHoraEntrega(ahora.getTime());
         pedido3.setNombreCliente("Juan Ferreyra");
         pedido3.setNumero(3);
         pedido3.setEstado(pteFacturacion);
        
         //Creamos los detalles del pedido para luego asignarselos al pedido.
         DetallePedido p3Detalle1 = new DetallePedido(1,precioNapo, napolitanaNormal,pteFacturacion);
         DetallePedido p3Detalle2 = new DetallePedido(1,precioEspecial, especialGrande,pteFacturacion);     
         
         //Creamos una lista y le asignamos los detalles.
         ArrayList<DetallePedido> detallesPedido3 = new ArrayList<>();
         detallesPedido3.add(p3Detalle1);
         detallesPedido3.add(p3Detalle2);
         
         //Asignamos la lista de detalles al pedido.
         pedido3.setDetallesPedido(detallesPedido3);
         
         //Creamos el gestor y llamamos a los métodos descriptos en el Diagrama de Secuencia del CU: Generar Factura
         GestorFacturacion gestor = new GestorFacturacion();
         
         //Armamos una lista con todos los pedidos.
         ArrayList<Pedido> pedidos= new ArrayList<>();
         pedidos.add(pedido);
         pedidos.add(pedido2);
         pedidos.add(pedido3);
    }
    
}
