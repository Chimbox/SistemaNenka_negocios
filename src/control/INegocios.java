package control;

import dominio.Cliente;
import dominio.DetalleVenta;
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
    public boolean validarDisponibilidad(Producto producto, double cantidadDeseada);
    public double obtenerTotalVenta();
    public boolean completarVenta(double recibido);
    public boolean agregarProductoCarrito(Producto producto, double cantidad);
    public List<DetalleVenta> eliminarProductoCarrito(Producto producto, double cantidad);
    public List<DetalleVenta> eliminarProductoCarrito(Producto producto);
    public List<Producto> buscarProducto(String parametro);
    public List<Producto> obtenerProductos();
    public List<Cliente> obtenerClientes();
    public List<Empleado> obtenerEmpleados();
    public Venta nuevaVenta();
    public List<DetalleVenta> obtenerDetallesVenta();
    public double obtenerCambio(double recibido);
    public boolean editarDetalleVenta(Producto producto, double nuevaCantidad);
}
