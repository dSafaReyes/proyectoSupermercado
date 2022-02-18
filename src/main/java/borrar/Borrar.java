package borrar;

import modelos.*;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Borrar {

    public static void main(String[] args) {

        Empresa empresaBBVA = new Empresa(1, "34984398P", new ArrayList<>(), TipoEmpresa.PYME);
        Empresa empresaNNBB = new Empresa(2, "34984398P", new ArrayList<>(), TipoEmpresa.PYME);
        Empresa empresaZZCC = new Empresa(3, "34984398P", new ArrayList<>(), TipoEmpresa.PYME);

        Contrato contrato1800I = new Contrato(1, 1800.0, TipoContrato.INDEFINIDO);
        Contrato contrato2000I = new Contrato(2, 2000.0, TipoContrato.INDEFINIDO);
        Contrato contrato1000P = new Contrato(3, 1000, TipoContrato.PRACTICAS);
        Contrato contrato1500T = new Contrato(4, 1500, TipoContrato.TEMPORAL);

        Empleado empleadoJuan = new Empleado(1, "30674827Q", "Juan", "Orla", "Calle 9", "656154254", empresaBBVA, contrato1000P);
        Empleado empleadoLolo = new Empleado(2, "36244827Q", "Lolo", "Pona", "Calle 2", "657454476", empresaBBVA, contrato1500T);
        Empleado empleadoNano = new Empleado(3, "31654867Q", "Nano", "Lele", "Calle 3", "656154244", empresaBBVA, contrato1800I);
        Empleado empleadoVale = new Empleado(4, "34876547Q", "Vale", "Miel", "Calle 6", "654454756", empresaBBVA, contrato2000I);
        Empleado empleadoPopo = new Empleado(5, "30276548Q", "Popo", "Jaro", "Calle 1", "676154244", empresaNNBB, contrato1000P);
        Empleado empleadoNela = new Empleado(6, "48278624Q", "Nela", "Lara", "Calle 8", "616424456", empresaZZCC, contrato1800I);

        List<Empleado> empleadosBBVA = Arrays.asList(empleadoJuan, empleadoLolo, empleadoNano, empleadoVale);
        empresaBBVA.setEmpleados(empleadosBBVA);
        empleadosBBVA.forEach(System.out::println);
        List<Empleado> empleadosNNBB = Arrays.asList(empleadoPopo);
        empresaNNBB.setEmpleados(empleadosNNBB);
        empleadosNNBB.forEach(System.out::println);
        List<Empleado> empleadosZZCC = Arrays.asList(empleadoNela);
        empresaZZCC.setEmpleados(empleadosZZCC);
        empleadosZZCC.forEach(System.out::println);

        Cliente clienteJuan = new Cliente(1, "70674837Q", "Juan", "Orla", "Calle 9", TipoCliente.EMPRESA);
        Cliente clienteLolo = new Cliente(2, "76244837Q", "Lolo", "Pona", "Calle 2", TipoCliente.EMPRESA);
        Cliente clienteNano = new Cliente(3, "71654837Q", "Nano", "Lele", "Calle 3", TipoCliente.EMPRESA);
        Cliente clienteVale = new Cliente(4, "74876537Q", "Vale", "Miel", "Calle 6", TipoCliente.EMPRESA);
        Cliente clientePopo = new Cliente(5, "70276538Q", "Popo", "Jaro", "Calle 1", TipoCliente.PARTICULAR);
        Cliente clienteNela = new Cliente(6, "78278634Q", "Nela", "Lara", "Calle 8", TipoCliente.PARTICULAR);

        Almacen almacen1 = new Almacen(1, "Almacen1", 10);
        Almacen almacen2 = new Almacen(2, "Almacen2", 20);
        Almacen almacen3 = new Almacen(3, "Almacen3", 30);

        Producto producto1 = new Producto(1, "C001", "BBB", LocalDate.of(2001, 12, 25), TipoProducto.DROGUERIA, almacen1, 10.0);
        Producto producto2 = new Producto(2, "C002", "AAA", LocalDate.of(2011, 11, 10), TipoProducto.DROGUERIA, almacen1, 10.0);
        Producto producto3 = new Producto(3, "C003", "CCC", LocalDate.of(2007, 11, 21), TipoProducto.BEBIDA, almacen1, 10.0);
        Producto producto4 = new Producto(4, "C004", "CCC", LocalDate.of(2004, 10, 30), TipoProducto.ALIMENTACION, almacen1, 10.0);
        Producto producto5 = new Producto(5, "C005", "CCC", LocalDate.of(2021, 10, 20), TipoProducto.ALIMENTACION, almacen1, 10.0);

        public Factura(int identificador, String codigoFactura, double importeBase, double descuento, double iva, double totalAPagar, LocalDate fechaVencimiento, boolean pagada, List<LineaFactura> lineaFacturaList, Cliente cliente) {
        Factura factura1 = new Factura(1, "F001", 100.0, )

    }

}
