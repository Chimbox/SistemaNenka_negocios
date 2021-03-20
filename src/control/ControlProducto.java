/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dominio.Producto;

/**
 *
 * @author laura
 */
public class ControlProducto extends INegocio<Producto>{

    public ControlProducto(){
        
    }
    
    /**
     * Método que se encarga de agregar al inventario un nuevo producto
     * @param entidad Producto que se va a agregar al inventario
     */
    @Override
    public void agregar(Producto entidad) {
        //Conexión bd
    }

    /**
     * Método que se encarga de eliminar un producto del inventario, dependiento de 
     * la venta realizada.
     * @param entidad Producto que se va a eliminar del inventario
     */
    @Override
    public void eliminar(Producto entidad) {
        //Conexion bd
    }
    
    /**
     * Método que se encarga de buscar un producto en base al nombre.
     * @param nombre Nombre del producto.
     * @return Producto encontrado en el inventario
     */
    public Producto buscarProducto(String nombre){
        Producto producto = null;
        
        //Conexión bd
        
        return producto;
    }
}
