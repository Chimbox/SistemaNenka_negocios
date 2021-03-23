package sistemanenka_negocio;

import control.FabricaNegocios;
import control.INegocios;
import dominio.Categoria;
import dominio.Cliente;
import dominio.Direccion;
import dominio.Empleado;
import dominio.Producto;
import dominio.Venta;
import java.util.Date;
import java.util.List;

/**

 *
 * @author laura
 */
public class SistemaNenka_Negocio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        INegocios negocios=FabricaNegocios.getFachada();
        
        List<Cliente> clientes=negocios.obtenerClientes();
        
        for (Cliente cliente : clientes) {
            System.out.println(cliente.getNombre());
        }
        Categoria categoria=new Categoria();
        categoria.setNombre("Bebidas");
        categoria.setDescripcion("Aqui van las bebidas");
        categoria.setId(1);
        
        
        Producto producto=new Producto();
        producto.setId(1);
        producto.setPrecio(15);
        producto.setCodigo(123);
        producto.setNombre("Coca 600ml");
        producto.setCategoria(categoria);
        
        List<Empleado> empleados=negocios.obtenerEmpleados();
        
        Venta venta=negocios.nuevaVenta();
        negocios.agregarProductoCarrito(producto, 3);
        venta.setFecha(new Date());
        venta.setEmpleado(empleados.get(0));
        venta.setCliente(clientes.get(0));
        
        negocios.guardarVenta(venta);
    }
    
}
