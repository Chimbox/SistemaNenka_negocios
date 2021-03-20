/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dominio.Empleado;

/**
 *
 * @author laura
 */
public class ControlEmpleados extends INegocio<Empleado>{

    public ControlEmpleados(){
        
    }
    
    /**
     * Método que se encarga de agregar empleados a la base de datos.
     * @param entidad Empleado
     */
    @Override
    public void agregar(Empleado entidad) {
        //Conexion bd
    }

    /**
     * Método que se encarga de eliminar empleados de la base de datos.
     * @param entidad Empleado
     */
    @Override
    public void eliminar(Empleado entidad) {
        //Conexion bd
    } 
}
