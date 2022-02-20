package pruebas;

import modelos.*;

import java.time.LocalDate;

public class PruebaV1 {

    public static void main(String[] args) {

        Almacen almacen1 = new Almacen(1, "Almacen1", 10);
        System.out.println(almacen1);
        Producto producto1 = new Producto(1, "C001", "BBB", LocalDate.of(2001, 12, 25), TipoProducto.DROGUERIA, almacen1, 10.0);
        System.out.println(producto1);
        Cliente clienteJuan = new Cliente(1, "70674837Q", "Juan", "Orla", "Calle 9", TipoCliente.EMPRESA);
        System.out.println(clienteJuan);

    }

}
