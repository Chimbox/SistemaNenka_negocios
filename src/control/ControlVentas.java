/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dominio.DetalleVenta;
import dominio.Producto;
import dominio.Venta;
import fdatos.IDatos;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author laura
 */
class ControlVentas extends Administrar<Venta>{
    
    private ArrayList<DetalleVenta> productos;
    private Venta venta;
    
    /**
     * Método constructor que se encarga de inicializar los productos que ingresaran
     * a la venta.
     */
    public ControlVentas(IDatos datos){
        super(datos);
        productos = new ArrayList<>();
    }
    
    /**
     * Método que se encarga de ingresar los productos a la venta
     * @param producto Producto que se va a ingresar a la venta
     * @param cantidad Cantidad del producto
     */
    public void ingresarProducto(Producto producto, int cantidad){
        float precioUnitario = producto.getPrecio();
        float importe = cantidad * precioUnitario;
        DetalleVenta ventaUnitaria = new DetalleVenta(cantidad, precioUnitario, importe, producto);
        productos.add(ventaUnitaria);
        
        //Conexion con bd
       datos.guardarProducto(producto);
        
    }
    
    /**
     * Método que calcula el total de la venta en base a cada producto y su importe 
     * dentro de la venta
     * @return total de la venta
     */
    public float calcularTotal(){
        float total = 0;
        for (DetalleVenta producto : productos) {
            total = total + producto.getImporte();
        }
        return total;
    }
    
    /**
     * Método que se encarga de mostrar las ventas realizas con base en las fechas 
     * determinadas.
     * @param fechaInicio Fecha de inicio
     * @param fechaFin Fecha fin
     * @return Ventas realizadas
     */
    public ArrayList<Venta> consultarVentas(Date fechaInicio, Date fechaFin){
        ArrayList<Venta> ventas = null;
        
        //Conexion bd
        
        return ventas;
    }
    
    public Venta crearNuevaVenta(){
        productos=new ArrayList<>();
        venta=new Venta();
        return venta;
    }

    @Override
    public void agregar(Venta entidad) {
        this.venta = entidad;
        this.venta.setDetallesVentas(productos);
        venta.setTotal(calcularTotal());
        datos.guardarVenta(venta);
        
        ControlProducto cp = new ControlProducto(datos);
        for (DetalleVenta producto : venta.getDetallesVentas()) {
            Producto p = producto.getProducto();
            p.setStock(p.getStock()-producto.getCantidad());
            cp.eliminar(p);
        }
    }

    @Override
    public void eliminar(Venta entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(Venta entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
