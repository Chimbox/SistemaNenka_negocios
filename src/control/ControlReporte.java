/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import fdatos.IDatos;
import java.io.IOException;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Daniel Ornelas
 */
public class ControlReporte {

    private IDatos datos;

    public ControlReporte(IDatos datos) {
        this.datos = datos;
    }

    public boolean generarReporte(Date fechaInicio, Date fechaFin) {
        try {
            Connection conn = datos.getConnnection();

            String currentPath = new java.io.File(".").getCanonicalPath() + "\\src\\reportes\\reporteVentas.jasper";
            
            JasperReport reporte = null;

            reporte = (JasperReport) JRLoader.loadObjectFromFile(currentPath);

            HashMap<String, Object> parametros = new HashMap<>();
            parametros.put("fechaI", fechaInicio.getTime());
            parametros.put("fechaF", fechaFin.getTime());
            
            System.out.println(fechaFin.getTime() + " " + fechaInicio.getTime());
            
            
            JasperPrint jPrint = JasperFillManager.fillReport(reporte, parametros, conn);

            JasperViewer view = new JasperViewer(jPrint, false);

            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            view.setVisible(true);

            return true;

        } catch (JRException ex) {
            
            System.out.println(ex.getMessage());
            return false;
        } catch (IOException ex) {
            Logger.getLogger(ControlReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
