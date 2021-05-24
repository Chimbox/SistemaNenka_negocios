/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import fdatos.IDatos;
import java.sql.Connection;
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

    public boolean generarReporte() {
        try {
            Connection conn = datos.getConnnection();

            JasperReport reporte = null;
            String path = "C:\\Users\\Daniel Ornelas\\Documents\\ESCUELA\\ITSON\\INTEGRADOR\\Proyecto\\Negocios\\src\\reportes\\reporteVentas.jasper";

            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);

            JasperPrint jPrint = JasperFillManager.fillReport(reporte, null, conn);

            JasperViewer view = new JasperViewer(jPrint, false);

            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            view.setVisible(true);

            return true;

        } catch (JRException ex) {
            return false;
        }
    }

}
