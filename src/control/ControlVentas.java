/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dominio.Cliente;
import dominio.DetalleVenta;
import dominio.Empleado;
import dominio.Producto;
import dominio.Venta;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author laura
 */
public class ControlVentas {
    
    ArrayList<DetalleVenta> productos;
    Venta venta;
    
    /**
     * Método constructor que se encarga de inicializar los productos que ingresaran
     * a la venta.
     */
    public ControlVentas(){
        productos = new ArrayList<>();
    }
    
    /**
     * Método que se encarga de ingresar los productos a la venta
     * @param producto Producto que se va a ingresar a la venta
     * @param cantidad Cantidad del producto
     */
    public void ingresarProducto(Producto producto, float cantidad){
        float precioUnitario = producto.getPrecio();
        float importe = cantidad * precioUnitario;
        DetalleVenta ventaUnitaria = new DetalleVenta(cantidad, precioUnitario, importe, producto);
        productos.add(ventaUnitaria);
        
        //Conexion con bd
        
    }
    
    /**
     * Método que se encarga de realizar la venta en base a los productos ingresados
     * @param em Empleado que se encarga de realizar la venta
     * @param c Cliente que realiza la compra
     */
    public void realizarVenta(Empleado em, Cliente c){
        venta = new Venta(new Date(), calcularTotal(), em, c);
        venta.setDetallesVentas(productos);
        ControlProducto cp = new ControlProducto();
        for (DetalleVenta producto : venta.getDetallesVentas()) {
            for (int i = 0; i < producto.getCantidad(); i++) {
                cp.eliminar(producto.getProducto());
            }
        }
        
        //Conexion bd
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
     * Método que se encarga de mostrar las ventas realizas en base a las fechas 
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
    
}
