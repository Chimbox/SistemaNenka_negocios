/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dominio.Proveedor;
import fdatos.IDatos;

/**
 *
 * @author laura
 */
class ControlProveedores extends Administrar<Proveedor>{

    public ControlProveedores(IDatos datos) {
        super(datos);
    }
    
    
    /**
     * Método que se encarga de agregar proveedores a la base de datos.
     * @param entidad proveedor
     */
    @Override
    public void agregar(Proveedor entidad) {
        //Conexion bd
    }

    /**
     * Método que se encarga de eliminar proveedores de la base de datos.
     * @param entidad proveedor
     */
    @Override
    public void eliminar(Proveedor entidad) {
        //Conexion bd
    }

    /**
     * Método que se encarga de modificar o actualizar al proveedor
     * @param entidad proveedor
     */
    @Override
    public void modificar(Proveedor entidad) {
        //Conexion bd
    }
    
}
