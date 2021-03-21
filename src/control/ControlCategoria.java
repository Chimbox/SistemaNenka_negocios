/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dominio.Categoria;
import dominio.Producto;

/**
 *
 * @author laura
 */
public class ControlCategoria extends Administrar<Categoria>{
    
    public ControlCategoria(){
        
    }
    
    /**
     * Método que se encarga de crear una nueva categoria para el producto
     * @param entidad Categoria a crear
     */
    @Override
    public void agregar(Categoria entidad) {
        //Conexión bd
    }

    /**
     * Método que se encarga de eliminar una categoria
     * @param entidad Categoria a eliminar
     */
    @Override
    public void eliminar(Categoria entidad) {
        //Conexion bd
    }
    
    /**
     * Método que se encarga de modificar o actualizar la categoria
     * @param entidad Categoria a modificar
     */
    @Override
    public void modificar(Categoria entidad) {
        //Conexion bd
    }
}
