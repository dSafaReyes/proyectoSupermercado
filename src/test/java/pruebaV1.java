//import modelos.*;
//import utilidades.UtilidadesFactura;
//import utilidades.UtilidadesProducto;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//import static utilidades.UtilidadesFactura.calcularTotalAPagar;
//
//public class pruebaV1 {
//
//    public static void main(String[] args) {
//
//        private int identificador;
//        private String codigoEmpresa;
//        private List<Empleado> empleados;
//        private TipoEmpresa tipoEmpresa;
//
//        Empresa empresa1 = new Empresa(1, "01", null, TipoEmpresa.MULTINACIONAL);
//        Empresa empresa2 = new Empresa(2, "02", null, TipoEmpresa.MULTINACIONAL);
//        Empresa empresa3 = new Empresa(2, "03", null, TipoEmpresa.NACIONAL);
//
//        Almacen almacen1 = new Almacen(1, "Almacen1", 10);
//        Almacen almacen2 = new Almacen(2, "Almacen2", 20);
//        Almacen almacen3 = new Almacen(3, "Almacen3", 30);
//
//        Cliente cliente1 = new Cliente(1, "30278456X", "Marcos", "Ruiz", "Calle 1", TipoCliente.PARTICULAR);
//        Cliente cliente2 = new Cliente(2, "30278457X", "Carlos", "Polo", "Calle 2", TipoCliente.PARTICULAR);
//        Cliente cliente3 = new Cliente(3, "30278458X", "Selena", "Jaco", "Calle 3", TipoCliente.EMPRESA);
//
//        Contrato contrato1 = new Contrato(1, 1000.0, TipoContrato.INDEFINIDO);
//        Contrato contrato2 = new Contrato(2, 2000.0, TipoContrato.INDEFINIDO);
//        Contrato contrato3 = new Contrato(3, 3000.0, TipoContrato.OBRAYSERVICIO);
//
//        Empleado empleado1 = new Empleado(1, "1X", "Lolo","Ruiz", "Calle 1", "954", empresa1, contrato1);
//        Empleado empleado2 = new Empleado(2, "2X", "Lola","Lozo", "Calle 2", "955", empresa1, contrato2);
//        Empleado empleado3 = new Empleado(3, "3X", "Lele","Pios", "Calle 3", "956", empresa2, contrato3);
//
//        List<Empleado> listaEmpleadosEmpresa1 = new ArrayList<>();
//        listaEmpleadosEmpresa1.add(empleado1);
//        listaEmpleadosEmpresa1.add(empleado2);
//        List<Empleado> listaEmpleadosEmpresa2 = new ArrayList<>();
//        listaEmpleadosEmpresa2.add(empleado3);
//        empresa1.setEmpleados(new );
//
//        UtilidadesProducto metodoProducto = new UtilidadesProducto();
//        UtilidadesFactura metodoFactura = new UtilidadesFactura();
//
//        Almacen almacen1 = new Almacen(1, "El Santuario", 2345);
//
//        Factura factura1 = new Factura(1, "001", 110.0, 10.0, 1.21,0.0, LocalDate.of(2001, 12, 25), true, null, cliente1);
//        factura1.setTotalAPagar(calcularTotalAPagar(factura1));
//
//        Producto producto1 = new Producto(1, "0001", "Bueno, bonito y barato", LocalDate.of(2001, 12, 25), TipoProducto.DROGUERIA, almacen1, 10.0);
//        Producto producto2 = new Producto(2, "0002", "Bonito y barato", LocalDate.of(2001, 11, 20), TipoProducto.ALIMENTACION, almacen1, 10.0);
//        Producto producto3 = new Producto(3, "0003", "Bonito y barato", LocalDate.of(2001, 11, 20), TipoProducto.ALIMENTACION, almacen1, 10.0);
//
//        List<LineaFactura> listLineaFactura = new ArrayList<>();
//        LineaFactura lf1 = new LineaFactura(1, factura1, producto1, 1);
//        LineaFactura lf2 = new LineaFactura(2, factura1, producto2, 1);
//        LineaFactura lf3 = new LineaFactura(3, factura1, producto3, 1);
//        listLineaFactura.add(lf1);
//        listLineaFactura.add(lf2);
//        listLineaFactura.add(lf3);
//        factura1.setLineaFacturaList(listLineaFactura);
//
//        List<Producto> listProductos = new ArrayList<>();
//        listProductos.add(producto1);
//        listProductos.add(producto2);
//        listProductos.add(producto3);
//
//        List<Producto> productosFiltradosPorTipo = metodoProducto.getPorTipo(listProductos, TipoProducto.ALIMENTACION);
//        List<Producto> productosFiltradosPorAlmacen = metodoProducto.getPorAlmacen(listProductos, almacen1);
//
//        System.out.println(productosFiltradosPorTipo);
//        System.out.println(productosFiltradosPorAlmacen);
//        System.out.println(factura1);
//
//    }
//
//}
