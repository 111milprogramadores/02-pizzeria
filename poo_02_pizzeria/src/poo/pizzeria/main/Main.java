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
import poo.pizzeria.Estado;
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
         Estado pteFacturacion= new Estado("Pendiente de Facturación","La pizza se encuentra lista, sin factura creada");
         pedido.setEstado(pteFacturacion);
        
         //Creamos los detalles del pedido para luego asignarselos al pedido.
         DetallePedido detalle1 = new DetallePedido(3,precioNapo, napolitanaNormal,pteFacturacion);
         DetallePedido detalle2 = new DetallePedido(1,precioEspecial, especialGrande,pteFacturacion);
         DetallePedido detalle3 = new DetallePedido(3,precioMozza, mozzarellaMediana,pteFacturacion);       
         
         //Creamos una lista y le asignamos los detalles.
         ArrayList<DetallePedido> detallesPedido = new ArrayList<>();
         detallesPedido.add(detalle1);
         detallesPedido.add(detalle2);
         detallesPedido.add(detalle3);
         
         //Asignamos la lista de detalles al pedido.
         pedido.setDetallesPedido(detallesPedido);
         
         
         
         
    }
    
}
