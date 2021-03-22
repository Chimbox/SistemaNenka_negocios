package control;

import fdatos.IDatos;

/**
 *
 * @author laura
 */
abstract class Administrar <T>{
    protected IDatos datos;
    public abstract void agregar(T entidad);
    public abstract void eliminar(T entidad);
    public abstract void modificar(T entidad);

    public Administrar(IDatos datos) {
        this.datos = datos;
    }
}