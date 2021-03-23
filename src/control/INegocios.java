package control;

import dominio.Cliente;
import dominio.Empleado;
import dominio.Producto;
import dominio.Venta;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alfonso Felix
 */
public interface INegocios {
    public boolean validarDisponibilidad(Producto producto);
    public void eliminarVenta(Venta venta);
    public void guardarVenta(Venta venta);
    public void agregarProductoCarrito(Producto producto, int cantidad);
    public List<Producto> obtenerProductos();
    public List<Cliente> obtenerClientes();
    public List<Empleado> obtenerEmpleados();
    public Venta nuevaVenta();
}
