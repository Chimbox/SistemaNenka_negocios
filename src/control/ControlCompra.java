/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dominio.Compra;
import dominio.DetalleCompra;
import dominio.Empleado;
import dominio.Producto;
import dominio.Proveedor;
import java.util.ArrayList;
import java.util.Date;

/**
 *      
 * @author laura
 */
public class ControlCompra{
    ArrayList<DetalleCompra> productos;
    Compra compra;
    
    /**
     * Método constructor que se encarga de inicializar los productos que ingresaran
     * a la compra
     */
    public ControlCompra(){
        productos = new ArrayList<>();
    }
    
    /**
     * Método que se encarga de ingresar los productos a la compra
     * @param producto Producto que se va a ingresar a la compre
     * @param cantidad Cantidad del producto
     */
    public void ingresarProducto(Producto producto, float cantidad){
        float precioUnitario = producto.getPrecio();
        float importe = cantidad * precioUnitario;
        DetalleCompra compraUnitaria = new DetalleCompra(cantidad, precioUnitario, importe, producto);
        productos.add(compraUnitaria);
        
        //Conexion con bd
        
    }
    
    /**
     * Método que se encarga de realizar la compra en base a los productos ingresados
     * @param em Empleado que se encarga de realizar la compra
     * @param proveedor Proveedor a quien se le adquiere el producto
     */
    public void realizarCompra(Empleado em, Proveedor proveedor){
        compra = new Compra(new Date(), calcularTotal());
        compra.setDetalleCompras(productos);
        compra.setProveedor(proveedor);
        ControlProducto cp = new ControlProducto();
        for (DetalleCompra producto : compra.getDetalleCompras()) {
            for (int i = 0; i < producto.getCantidad(); i++) {
                cp.agregar(producto.getProducto());
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
        for (DetalleCompra producto : productos) {
            total = total + producto.getImporte();
        }
        return total;
    }
    
    /**
     * Método que se encarga de mostrar las compras realizas en base a las fechas 
     * determinadas.
     * @param fechaInicio Fecha de inicio
     * @param fechaFin Fecha fin
     * @return Ventas realizadas
     */
    public ArrayList<Compra> consultarVentas(Date fechaInicio, Date fechaFin){
        ArrayList<Compra> ventas = null;
        
        //Conexion bd
        
        return ventas;
    }
    
}
