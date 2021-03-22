/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dominio.Corte;
import dominio.Venta;
import enums.TipoCorte;
import fdatos.IDatos;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author laura
 */
class ControlCorte extends Administrar<Corte>{

    private ControlVentas ventas;
    private Corte corte;

    public ControlCorte(IDatos datos) {
        super(datos);
        ventas = new ControlVentas(datos);
    }

    /**
     * Método que se encarga de realizar el corte de caja
     *
     * @param tipo tipo de corte apertura/cierre
     * @return Dinero sobrante
     */
    public float realizarCorte(TipoCorte tipo) {
        float totalVenta = 0;
        if (tipo == TipoCorte.CORTE) {
            ArrayList<Venta> ventasDiarias = ventas.consultarVentas(new Date(), new Date());
            for (Venta venta : ventasDiarias) {
                totalVenta = totalVenta + venta.getTotal();
            }
            corte = new Corte(totalVenta+500, new Date(), TipoCorte.CORTE);
            return totalVenta;
            
            //Generar documento
        }
        corte = new Corte(500, new Date(), TipoCorte.APERTURA);
        return 0;
    }

    @Override
    public void agregar(Corte entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Corte entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(Corte entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
