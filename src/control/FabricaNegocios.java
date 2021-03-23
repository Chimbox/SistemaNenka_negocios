package control;

import fdatos.FabricaDatos;

/**
 *
 * @author Alfonso Felix
 */
public class FabricaNegocios {
    private static FNegocios fachada;

    public static INegocios getFachada() {
        if(fachada==null){
            fachada=new FNegocios(FabricaDatos.getFachada());
        }
        return fachada;
    }
}
