/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.pizzeria.controller;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.Work;
import poo.pizzeria.ui.PantallaGenerarReporte;

/**
 *
 * @author joaquinleonelrobles
 */
public class GestorReporte {
    
    private final SessionFactory sessionFactory;
    
    private PantallaGenerarReporte pantalla;

    public GestorReporte(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public void run () {
        this.pantalla = new PantallaGenerarReporte(this);
        this.pantalla.setVisible(true);
    }

    /**
     * Generamos un reporte en pantalla usando la librería de JasperReports,
     * recibimos como entrada los valores ingresados en pantalla y compilamos
     * el reporte en formato XML para mostrarlo con el componente visual
     * JasperViewer.
     * 
     * @param txtFechaDesde
     * @param txtFechaHasta 
     */
    public void generarReporte(String txtFechaDesde, String txtFechaHasta) {
        // inicializamos el formato de las fechas
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        // intentamos generar las fechas
        try {
            Date fechaDesde = sdf.parse(txtFechaDesde);
            Date fechaHasta = sdf.parse(txtFechaHasta);
            
            // si la fecha desde no es anterior a hasta
            if (!fechaDesde.before(fechaHasta)) {
                JOptionPane.showMessageDialog(pantalla,
                    "La fecha hasta debe ser posterior a desde",
                    "Fechas incorrectas",
                    JOptionPane.ERROR_MESSAGE);
            }
            else
            // si la fecha hasta no es anterior a hoy
            if (!fechaHasta.before(new Date())) {
                JOptionPane.showMessageDialog(pantalla,
                    "La fecha hasta debe ser anterior a hoy",
                    "Fechas incorrectas",
                    JOptionPane.ERROR_MESSAGE);
            }
            else {
                // abrimos una sesion de hibernate
                Session session = sessionFactory.openSession();

                // utilizamos la sesion de hibernate para acceder a la conexion JDBC
                session.doWork(new Work() {
                    @Override
                    public void execute(Connection conexion) throws SQLException {
                        try {
                            // armamos el modelo de parametros
                            Map<String, Object> parametros = new HashMap<>();
                            parametros.put("fechaDesde", fechaDesde);
                            parametros.put("fechaHasta", fechaHasta);

                            // creamos el reporte
                            InputStream design = getClass().getResourceAsStream("/resources/reportes/variedades-mas-vendidas.jrxml");
                            JasperDesign jasperDesing = JRXmlLoader.load(design);
                            JasperReport reporte = JasperCompileManager.compileReport(jasperDesing);

                            // imprimimos el reporte con los parametros
                            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametros, conexion);

                            // visualizamos el reporte en pantalla
                            JasperViewer.viewReport(jasperPrint, false);
                        }
                        catch (JRException ex) {
                            System.out.println("Error al generar el reporte: " + ex.getMessage());
                        }
                    }
                });

                // cerramos la sesion
                session.close();
            }
        }
        catch (ParseException ex) {
            JOptionPane.showMessageDialog(pantalla,
                    "El formato de fechas debe ser dd/mm/aaaa",
                    "Formato de fechas incorrecto",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
