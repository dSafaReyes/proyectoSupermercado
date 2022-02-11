package utilidades;

import modelos.*;

import java.util.*;
import java.util.stream.Collectors;

public class UtilidadesEmpresa {

    public List<Empleado> getEmpleadosPorContrato(Empresa empresa, TipoContrato tipoContrato) {
        return empresa.getEmpleados().stream().filter(e -> e.getContrato().equals(tipoContrato)).toList();
    }

    public List<Empleado> getMileuristasOrdenadosPorSalario(Empresa empresa) {
        return empresa.getEmpleados().stream().filter(e -> e.getContrato().getSalarioBase() >= 1000).sorted().toList();
    }

    public double fondoSalarialEmpresa(Empresa empresa) {
        List<Empleado> empleados = empresa.getEmpleados();
        return empresa.getEmpleados().stream().mapToDouble(e -> e.getContrato().getSalarioBase()).sum();
    }

    public Empleado getMejorPagado(List<Empresa> empresas) {
        Comparator<Empleado> bySueldoAsc = (Empleado e1, Empleado e2) -> Double.compare(e1.getContrato().getSalarioBase(), e2.getContrato().getSalarioBase());
        return empresas.stream().map(empresa -> empresa.getEmpleados().stream().sorted(Comparator.comparing(bySueldoAsc)));
    }


    public Map<TipoContrato, List<Empleado>> getEmpleadosPorTipoContrato(Empresa empresa) {

        Map<TipoContrato, List<Empleado>> empleadosPorTipoContrato = new HashMap<>();

        for (TipoContrato tipoContrato:TipoContrato.values()) {
            List<Empleado> empleadosPorContrato = getEmpleadosPorContrato(empresa, tipoContrato);
            empleadosPorTipoContrato.put(tipoContrato, empleadosPorContrato);
        }

        return empresa.getEmpleados().stream().collect(Collectors.groupingBy(e-> e.getContrato().getTipoContrato()));

    }

    public Map<Empresa, Map<TipoContrato, List<Empleado>>> getEmpleadosPorTipoContrato(List<Empresa> empresas) {

        Map<Empresa, Map<TipoContrato, List<Empleado>>> empleadosPorTipoContrato = new HashMap<>();
        for (Empresa empresa:empresas) {
            empleadosPorTipoContrato.put(empresa, getEmpleadosPorTipoContrato(empresa));
        }
        return empleadosPorTipoContrato;

//        return getEmpleadosPorTipoContrato(empresas.stream().map(e -> e))
//        return empresas.stream().collect(Collectors.groupingBy(e -> getEmpleadosPorTipoContrato(e)));

    }







}
