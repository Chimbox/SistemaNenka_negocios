/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dominio.Producto;
import fdatos.IDatos;
import java.util.List;

/**
 *
 * @author laura
 */
class ControlProducto extends Administrar<Producto>{

    public ControlProducto(IDatos datos) {
        super(datos);
    }
    
    /**
     * Método que se encarga de agregar al inventario un nuevo producto
     * @param entidad Producto que se va a agregar al inventario
     */
    @Override
    public void agregar(Producto entidad) {
        //Conexion bd
    }

    /**
     * Método que se encarga de eliminar un producto del inventario, dependiento de 
     * la venta realizada.
     * @param entidad Producto que se va a eliminar del inventario
     */
    @Override
    public void eliminar(Producto entidad) {
        datos.guardarProducto(entidad);
    }
    
    /**
     * Método que se encarga de buscar un producto en base al nombre.
     * @param nombre Nombre del producto.
     * @return Producto encontrado en el inventario
     *
    public Producto buscarProducto(String nombre){
        List<Producto> productos = datos.obtenerProductos();
        for (Producto producto : productos) {
            if(producto.getNombre().equalsIgnoreCase(nombre)){
                return producto;
            }
            
        }
        return null;
        
    }*/
    
    
    public List<Producto> buscarProducto(String parametro){
        return datos.buscarProductos(parametro);
    }
    
     boolean validarDisponibilidad(Producto producto, double cantidadDeseada){
        return datos.buscarProducto(producto.getId()).getStock()>=cantidadDeseada;
    }
    
    /**
     * Método que se encarga de modificar o actualizar el producto de la base de datos. 
     * @param entidad Producto actualizado
     */
    @Override
    public void modificar(Producto entidad) {
        datos.guardarProducto(entidad);
    }
    
    public Producto buscarProducto(int id){
        return datos.buscarProducto(id);
    }
    
    public List<Producto> obtenerProductos(){
        return datos.obtenerProductos();
    }
}
