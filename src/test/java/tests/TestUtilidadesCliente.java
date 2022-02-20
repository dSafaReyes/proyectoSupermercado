package tests;

import modelos.Cliente;
import modelos.TipoCliente;
import org.junit.*;
import utilidades.UtilidadesCliente;

public class TestUtilidadesCliente {

    static Cliente clienteDniValido, clienteDniNoValido, clienteNull, clienteDniNull, clienteDniTooShort;

    @BeforeClass
    public static void crearInstancias() {
        clienteDniValido = new Cliente(1, "70674837Q", "Juan", "Orla", "Calle 9", TipoCliente.EMPRESA);
        clienteDniNoValido = new Cliente(2, "34651a4M", "Lolo", "Maldo", "Calle 3", TipoCliente.PARTICULAR);
        clienteDniNull = new Cliente(3, null, "Lola", "Polda", "Calle 1", TipoCliente.EMPRESA);
        clienteDniTooShort = new Cliente(4, "341232Q", "Manu", "Galdo", "Calle 2", TipoCliente.EMPRESA);
    }

    @Test
    public void testEsDniValidoTrue() {
        boolean esDniValido = UtilidadesCliente.esDniValido(clienteDniValido);
        Assert.assertTrue(esDniValido);
    }

    @Test
    public void testEsDniValidoFalse() {
        boolean esDniValido = UtilidadesCliente.esDniValido(clienteDniNoValido);
        Assert.assertFalse(esDniValido);
    }

    @Test
    public void testEsDniValidoShort() {
        boolean esDniValido = UtilidadesCliente.esDniValido(clienteDniTooShort);
        Assert.assertFalse(esDniValido);
    }

    @Test(expected = NullPointerException.class)
    public void testEsDniValidoDniNull() {
        boolean esDniValido = UtilidadesCliente.esDniValido(clienteDniNull);
        Assert.assertTrue(esDniValido);
    }

    @Test(expected = NullPointerException.class)
    public void testEsDniValidoNull() {
        boolean esDniValido = UtilidadesCliente.esDniValido(clienteNull);
        Assert.assertTrue(esDniValido);
    }

}
