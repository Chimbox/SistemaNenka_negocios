/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dominio.Empleado;
import fdatos.IDatos;
import java.util.List;

/**
 *
 * @author laura
 */
class ControlEmpleados extends Administrar<Empleado>{

    public ControlEmpleados(IDatos datos) {
        super(datos);
    }

    
    
    public boolean iniciarSeson(String usuario, String contrasenia){
        //Conexion bd
        return true;
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

    /**
     * Método que se encarga de modificar o actualizar al empleado
     * @param entidad empleado act
     */
    @Override
    public void modificar(Empleado entidad) {
        //Conexion bd
    }
    
    public List<Empleado> buscarEmpleados(){
        return datos.obtenerEmpleados();
    }
}
