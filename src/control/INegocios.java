package control;

import dominio.Producto;
import dominio.Venta;

/**
 *
 * @author Alfonso Felix
 */
public interface INegocios {
    public boolean validarDisponibilidad(Producto producto);
    public void eliminarVenta(Venta venta);
    public Venta guardarVenta(Venta venta);
}
