package tests;

import modelos.*;
import org.junit.*;
import utilidades.UtilidadesProducto;

import java.time.LocalDate;
import java.util.*;

public class TestUtilidadesProducto {

    static Almacen almacen1, almacen2;
    static Producto producto1, producto2, producto3, producto4, producto5;
    static List<Producto> listaTodosLosProductos;

    @BeforeClass
    public static void crearInstancias() {
        almacen1 = new Almacen(1, "Almacen1", 10);
        almacen2 = new Almacen(2, "Almacen2", 20);
        producto1 = new Producto(1, "C001", "BBB", LocalDate.of(2001, 12, 25), TipoProducto.DROGUERIA, almacen1, 10.0);
        producto2 = new Producto(2, "C002", "AAA", LocalDate.of(2011, 11, 10), TipoProducto.DROGUERIA, almacen1, 10.0);
        producto3 = new Producto(3, "C003", "CCC", LocalDate.of(2007, 11, 21), TipoProducto.BEBIDA, almacen1, 10.0);
        producto4 = new Producto(4, "C004", "CCC", LocalDate.of(2004, 10, 30), TipoProducto.ALIMENTACION, almacen1, 10.0);
        producto5 = new Producto(5, "C005", "CCC", LocalDate.of(2021, 10, 20), TipoProducto.ALIMENTACION, almacen2, 10.0);
        listaTodosLosProductos = Arrays.asList(producto1, producto2, producto3, producto4, producto5);
    }

    @Test
    public void testGetPorTipo() {
        List<Producto> productosDelTipoAlimentacion = UtilidadesProducto.getPorTipo(listaTodosLosProductos, TipoProducto.ALIMENTACION);
        List<Producto> productosExpected = Arrays.asList(producto4, producto5);
        Assert.assertEquals(productosExpected, productosDelTipoAlimentacion);
    }

    @Test
    public void testGetPorAlmacen() {
        List<Producto> productosDelAlmacen1 = UtilidadesProducto.getPorAlmacen(listaTodosLosProductos, almacen1);
        List<Producto> productosExpected = Arrays.asList(producto1,producto2, producto3, producto4);
        Assert.assertEquals(productosExpected, productosDelAlmacen1);
    }
}
