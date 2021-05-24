package sistemanenka_negocio;

import control.FabricaNegocios;
import control.INegocios;

/**

 *
 * @author laura
 */
public class SistemaNenka_Negocio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        INegocios negocios=FabricaNegocios.getFachada();
        
        negocios.generarReporteVenta();
        
       
        //negocios.guardarVenta(venta);
    }
    
}
