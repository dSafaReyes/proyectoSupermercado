package tests;

import modelos.*;
import org.junit.*;
import utilidades.UtilidadesEmpresa;

import java.util.*;

public class TestUtilidadesEmpresa {

    static Empresa empresaBBVA, empresaNNBB, empresaZZCC;
    static Contrato contrato1800I, contrato2000I, contrato1000P, contrato1500T;
    static Empleado empleadoJuan, empleadoLolo, empleadoNano, empleadoVale, empleadoPopo, empleadoNela;

    @BeforeClass
    public static void crearInstancias() {
        empresaBBVA = new Empresa(1, "34984398P", null, TipoEmpresa.PYME);
        empresaNNBB = new Empresa(2, "34984398P", null, TipoEmpresa.MULTINACIONAL);
        empresaZZCC = new Empresa(3, "34984398P", null, TipoEmpresa.PYME);
        contrato1800I = new Contrato(1, 1800.0, TipoContrato.INDEFINIDO);
        contrato2000I = new Contrato(2, 2000.0, TipoContrato.INDEFINIDO);
        contrato1000P = new Contrato(3, 1000.0, TipoContrato.PRACTICAS);
        contrato1500T = new Contrato(4, 1500.0, TipoContrato.TEMPORAL);
        empleadoJuan = new Empleado(1, "30674827Q", "Juan", "Orla", "Calle 9", "656154254", empresaBBVA, contrato1000P);
        empleadoLolo = new Empleado(2, "36244827Q", "Lolo", "Pona", "Calle 2", "657454476", empresaBBVA, contrato1500T);
        empleadoNano = new Empleado(3, "31654867Q", "Nano", "Lele", "Calle 3", "656154244", empresaBBVA, contrato1800I);
        empleadoVale = new Empleado(4, "34876547Q", "Vale", "Miel", "Calle 6", "654454756", empresaBBVA, contrato2000I);
        empleadoPopo = new Empleado(5, "30276548Q", "Popo", "Jaro", "Calle 1", "676154244", empresaNNBB, contrato1000P);
        empleadoNela = new Empleado(6, "48278624Q", "Nela", "Lara", "Calle 8", "616424456", empresaZZCC, contrato1800I);
        List<Empleado> empleadosBBVA = Arrays.asList(empleadoJuan, empleadoLolo, empleadoNano, empleadoVale);
        empresaBBVA.setEmpleados(empleadosBBVA);
        List<Empleado> empleadosNNBB = Arrays.asList(empleadoPopo);
        empresaNNBB.setEmpleados(empleadosNNBB);
        List<Empleado> empleadosZZCC = Arrays.asList(empleadoNela);
        empresaZZCC.setEmpleados(empleadosZZCC);
    }

    @Test
    public void testGetEmpleadosPorContrato() {
        List<Empleado> empleadosPorContrato = UtilidadesEmpresa.getEmpleadosPorContrato(empresaBBVA, TipoContrato.INDEFINIDO);
        List<Empleado> empleadosExpected = Arrays.asList(empleadoVale, empleadoNano);
        Assert.assertEquals(empleadosExpected, empleadosPorContrato);
    }

    @Test
    public void testGetLosMejorPagadosPorEmpresa() {
        List<Empresa> empresas = Arrays.asList(empresaBBVA, empresaNNBB, empresaZZCC);
        Map<Empresa, Empleado> losMejorPagadosPorEmpresa = UtilidadesEmpresa.getLosMejorPagadosPorEmpresa(empresas);
        System.out.println(losMejorPagadosPorEmpresa);
        Map<Empresa, Empleado> losMejorPagadosPorEmpresaExpected = new HashMap<>();
        losMejorPagadosPorEmpresaExpected.put(empresaBBVA, empleadoVale);
        losMejorPagadosPorEmpresaExpected.put(empresaNNBB, empleadoPopo);
        losMejorPagadosPorEmpresaExpected.put(empresaZZCC, empleadoNela);
        System.out.println(losMejorPagadosPorEmpresaExpected);
        Assert.assertEquals(losMejorPagadosPorEmpresaExpected, losMejorPagadosPorEmpresa);
    }
}
