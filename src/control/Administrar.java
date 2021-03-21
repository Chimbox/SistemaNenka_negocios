/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 *
 * @author laura
 */
public abstract class Administrar <T>{
    public abstract void agregar(T entidad);
    public abstract void eliminar(T entidad);
    public abstract void modificar(T entidad);
}
