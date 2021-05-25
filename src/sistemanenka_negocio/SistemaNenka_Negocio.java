package sistemanenka_negocio;

import control.FabricaNegocios;
import control.INegocios;
import java.io.IOException;

/**

 *
 * @author laura
 */
public class SistemaNenka_Negocio {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        String currentPath = new java.io.File(".").getCanonicalPath();
        System.out.println("Current dir:" + currentPath);
        
        SistemaNenka_Negocio j = new SistemaNenka_Negocio();
        j.hfgfjg();
    }
    
    public void hfgfjg(){
        System.out.println(this.getClass().getProtectionDomain().getCodeSource().getLocation());
        
    }
    
}
