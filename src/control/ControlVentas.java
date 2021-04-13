/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dominio.DetalleVenta;
import dominio.Producto;
import dominio.Venta;
import fdatos.IDatos;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author laura
 */
class ControlVentas {

    private ArrayList<DetalleVenta> productos;
    private ControlProducto ctrlProductos;
    private Venta venta;
    private IDatos datos;

    /**
     * Método constructor que se encarga de inicializar los productos que
     * ingresaran a la venta.
     */
    public ControlVentas(IDatos datos, ControlProducto ctrlProductos) {
        this.datos = datos;
        productos = new ArrayList<>();
        this.ctrlProductos = ctrlProductos;
    }

    /**
     * Método que se encarga de ingresar los productos a la venta
     *
     * @param producto Producto que se va a ingresar a la venta
     * @param cantidad Cantidad del producto
     */
    public boolean ingresarProducto(Producto producto, double cantidad) {

        boolean yaExiste = false;
        DetalleVenta ventaUnitaria = null;

        for (DetalleVenta detalle : productos) {
            if (detalle.getProducto().equals(producto)) {
                yaExiste = true;
                ventaUnitaria = detalle;
                break;
            }
        }

        if (yaExiste && ventaUnitaria != null) {
            cantidad = ventaUnitaria.getCantidad() + cantidad;
        }

        if (ctrlProductos.validarDisponibilidad(producto, cantidad)) {

            double precioUnitario = producto.getPrecio();
            double importe = cantidad * precioUnitario;

            ventaUnitaria = new DetalleVenta(cantidad, precioUnitario, importe, producto);

            if (yaExiste) {
                productos.set(productos.indexOf(ventaUnitaria), ventaUnitaria);
            } else {
                productos.add(ventaUnitaria);
            }

            calcularTotal();
            return true;
        }

        return false;
    }

    public boolean editarDetalleVenta(Producto producto, double cantidad) {
        producto=ctrlProductos.buscarProducto(producto.getId());
        boolean yaExiste = false;
        DetalleVenta ventaUnitaria = null;

        for (DetalleVenta detalle : productos) {
            if (detalle.getProducto().equals(producto)) {
                yaExiste = true;
                ventaUnitaria = detalle;
                break;
            }
        }

        if (yaExiste&&ctrlProductos.validarDisponibilidad(producto, cantidad)) {
            
            double precioUnitario = producto.getPrecio();
            double importe = cantidad * precioUnitario;

            ventaUnitaria.setImporte(importe);
            ventaUnitaria.setCantidad(cantidad);

            productos.set(productos.indexOf(ventaUnitaria), ventaUnitaria);

            for (DetalleVenta producto1 : productos) {
                System.out.println(producto1);
            }
            
            calcularTotal();
            return true;
        }

        return false;
    }

    /**
     * Método que calcula el total de la venta con base en cada producto y su
     * importe dentro de la venta
     *
     * @return total de la venta
     */
    public double calcularTotal() {
        double total = 0;
        for (DetalleVenta producto : productos) {
            total = total + producto.getImporte();
        }
        venta.setTotal(total);
        return total;
    }

    public double obtenerTotal() {
        return venta.getTotal();
    }

    /**
     * Método que se encarga de mostrar las ventas realizas con base en las
     * fechas determinadas.
     *
     * @param fechaInicio Fecha de inicio
     * @param fechaFin Fecha fin
     * @return Ventas realizadas
     */
    public ArrayList<Venta> consultarVentas(Date fechaInicio, Date fechaFin) {
        ArrayList<Venta> ventas = null;

        //Conexion bd
        return ventas;
    }

    public Venta crearNuevaVenta() {
        productos = new ArrayList<>();
        venta = new Venta();
        venta.setFecha(new Date());
        return venta;
    }

    public boolean completarVenta(double recibido) {
        venta.setTotal(calcularTotal());

        if (recibido < venta.getTotal()) {
            return false;
        }

        venta.setDetallesVentas(productos);

        datos.guardarVenta(venta);
        for (DetalleVenta producto : venta.getDetallesVentas()) {
            Producto p = producto.getProducto();
            p.setStock(p.getStock() - producto.getCantidad());
            ctrlProductos.modificar(p);
            //ctrlProductos.eliminar(p);
        }

        crearNuevaVenta();

        return true;
    }

    public List<DetalleVenta> obtenerDetallesVenta() {
        return productos;
    }

    public double obtenerCambio(double recibido) {
        return recibido - this.venta.getTotal();
    }
}
