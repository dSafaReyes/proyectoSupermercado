package tests;

import modelos.*;
import org.junit.Assert;
import org.junit.Test;
import utilidades.UtilidadesCliente;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestUnitario {

    @Test
    public void testEsDniValido() {

        Cliente cliente1 = new Cliente(1, "30278527Q", "Daniel", "Gavilán", "Calle 8", TipoCliente.PARTICULAR);
        boolean result= UtilidadesCliente.esDniValido(cliente1);
        Assert.assertTrue(result);

    }

}
