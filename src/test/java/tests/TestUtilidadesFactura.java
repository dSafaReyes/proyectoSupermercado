package tests;

import modelos.*;
import org.junit.*;
import utilidades.UtilidadesFactura;

import java.time.LocalDate;
import java.util.*;

public class TestUtilidadesFactura {

    static Factura facturaJuan1, facturaJuan2, facturaNull;
    static Producto producto1, producto2;
    static LineaFactura lineaFactura1, lineaFactura2, lineaFactura3;
    static Cliente clienteJuan, clienteOtro;

    @BeforeClass
    public static void crearInstancias() {
        clienteJuan = new Cliente(1, "70674837Q", "Juan", "Orla", "Calle 9", TipoCliente.EMPRESA);
        clienteOtro = new Cliente(2, "30458392W", "Manu", "Polos", "Calle 3", TipoCliente.EMPRESA);
        producto1 = new Producto(1, "C001", "BBB", LocalDate.of(2050, 12, 25), TipoProducto.DROGUERIA, null, 10.0);
        producto2 = new Producto(2, "C002", "AAA", LocalDate.of(2030, 11, 10), TipoProducto.DROGUERIA, null, 20.0);
        lineaFactura1 = new LineaFactura(1, null, producto1, 50);
        lineaFactura2 = new LineaFactura(2, null, producto1, 20);
        lineaFactura3 = new LineaFactura(3, null, producto2, 20);
        List<LineaFactura> listLineaFacturaJuan1 = Arrays.asList(lineaFactura1, lineaFactura2, lineaFactura3);
        List<LineaFactura> listLineaFacturaJuan2 = Arrays.asList(lineaFactura1, lineaFactura2, lineaFactura3);
        facturaJuan1 = new Factura(1, "F001", 0.0, 100.0, 0.21, 0.0, LocalDate.of(2018, 7,10), LocalDate.of(2023, 8,11), false, listLineaFacturaJuan1, clienteJuan);
        facturaJuan2 = new Factura(2, "F002", 0.0, 100.0, 0.21, 0.0, LocalDate.of(2017, 7,10), LocalDate.of(2021, 8,11), true, listLineaFacturaJuan2, clienteJuan);
        facturaNull = new Factura(3, "F003", 0.0, 100.0, 0.21, 0.0, null, null, false, null, clienteOtro);
    }

    @Test
    public void testEsFacturaVencidaTrue() {
        boolean esFacturaVencida = UtilidadesFactura.esFacturaVencida(facturaJuan1);
        Assert.assertTrue(esFacturaVencida);
    }

    @Test
    public void testEsFacturaVencidaFalse() {
        boolean esFacturaVencida = UtilidadesFactura.esFacturaVencida(facturaJuan2);
        Assert.assertFalse(esFacturaVencida);
    }

    @Test(expected = NullPointerException.class)
    public void testEsFacturaVencidaNull() {
        boolean esFacturaVencida = UtilidadesFactura.esFacturaVencida(facturaNull);
        Assert.assertFalse(esFacturaVencida);
    }

    @Test
    public void testCalcularBaseFactura() {
        double baseFactura = UtilidadesFactura.calcularBaseFactura(facturaJuan1);
        Assert.assertEquals(1100.0, baseFactura, 0.01);
    }

    @Test
    public void testCalcularTotalAPagar() {
        double totalAPagar = UtilidadesFactura.calcularTotalAPagar(facturaJuan1);
        Assert.assertEquals(1210.0, totalAPagar, 0.01);
    }

    @Test
    public void testGastoTotalCliente() {
        double gastoTotalJuan = UtilidadesFactura.gastoTotalCliente(Arrays.asList(facturaJuan1, facturaJuan2, facturaNull), clienteJuan);
        Assert.assertEquals(2420.0, gastoTotalJuan, 0.01);
    }
}
