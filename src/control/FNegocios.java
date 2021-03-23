package control;

import dominio.Producto;
import dominio.Venta;
import fdatos.IDatos;

/**
 *
 * @author Alfonso Felix
 */
class FNegocios implements INegocios{
    
    private static IDatos datos;
    private static ControlCategoria ctrlCategorias;
    private static ControlClientes ctrlClientes;
    private static ControlCompra ctrlCompras;
    private static ControlCorte ctrlCortes;
    private static ControlEmpleados ctrlEmpleados;
    private static ControlProducto ctrlProductos;
    private static ControlProveedores ctrlProveedores;
    private static ControlVentas ctrlVentas;
    

    public FNegocios(IDatos datos) {
        FNegocios.datos = datos;
    }


    public static ControlCategoria getCtrlCategorias() {
        if(ctrlCategorias==null){
            ctrlCategorias=new ControlCategoria(datos);
        }
        return ctrlCategorias;
    }

    public static ControlClientes getCtrlClientes() {
        if(ctrlClientes==null){
            ctrlClientes=new ControlClientes(datos);
        }
        return ctrlClientes;
    }

    public static ControlCompra getCtrlCompras() {
        if(ctrlCompras==null){
            ctrlCompras=new ControlCompra(datos);
        }
        return ctrlCompras;
    }

    public static ControlCorte getCtrlCortes() {
        if(ctrlCortes==null){
            ctrlCortes=new ControlCorte(datos);
        }
        return ctrlCortes;
    }

    public static ControlEmpleados getCtrlEmpleados() {
        if(ctrlEmpleados==null){
            ctrlEmpleados=new ControlEmpleados(datos);
        }
        return ctrlEmpleados;
    }

    public static ControlProducto getCtrlProductos() {
        if(ctrlProductos==null){
            ctrlProductos=new ControlProducto(datos);
        }
        return ctrlProductos;
    }

    public static ControlProveedores getCtrlProveedores() {
        if(ctrlProveedores==null){
            ctrlProveedores=new ControlProveedores(datos);
        }
        return ctrlProveedores;
    }

    public static ControlVentas getCtrlVentas() {
        if(ctrlVentas==null){
            ctrlVentas=new ControlVentas(datos);
        }
        return ctrlVentas;
    }

    @Override
    public boolean validarDisponibilidad(Producto producto) {
        return getCtrlProductos().buscarProducto(producto.getNombre()).getStock() > 0;
    }

    @Override
    public void eliminarVenta(Venta venta) {
        getCtrlVentas().eliminar(venta);
    }

    @Override
    public void guardarVenta(Venta venta) {
        getCtrlVentas().agregar(venta);
    }
    
    @Override
    public void agregarProducto(Producto producto, int cantidad){
        getCtrlVentas().ingresarProducto(producto, cantidad);
    }
}
