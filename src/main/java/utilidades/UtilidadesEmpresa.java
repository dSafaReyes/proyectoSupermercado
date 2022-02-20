package utilidades;

import modelos.*;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UtilidadesEmpresa {

    public static List<Empleado> getEmpleadosPorContrato(Empresa empresa, TipoContrato tipoContrato) {
        return empresa.getEmpleados().stream()
                .filter(e -> e.getContrato().getTipoContrato().equals(tipoContrato))
                .toList();
    }

    public static List<Empleado> getMileuristasOrdenadosPorSalario(Empresa empresa) {
        Comparator<Empleado> bySueldoAsc = (Empleado empleado1, Empleado empleado2) -> Double.compare(empleado1.getContrato().getSalarioBase(), empleado2.getContrato().getSalarioBase());
        return empresa.getEmpleados().stream()
                .filter(e -> e.getContrato().getSalarioBase() >= 1000.0)
                .sorted(Comparator.comparingDouble(e -> e.getContrato().getSalarioBase()))
                .toList();
    }

    public static double fondoSalarialEmpresa(Empresa empresa) {
        return empresa.getEmpleados().stream()
                .mapToDouble(e -> e.getContrato().getSalarioBase())
                .sum();
    }
    
    public static Empleado getMejorPagado(List<Empresa> empresas) {
        return empresas.stream()
                .map(Empresa::getEmpleados)
                .flatMap(List::stream).toList()
                .stream().max(Comparator.comparingDouble((Empleado e) -> e.getContrato().getSalarioBase())).orElseThrow(NoSuchElementException::new);
    }

    public static Map<TipoContrato, List<Empleado>> getEmpleadosPorTipoContrato(Empresa empresa) {
        return empresa.getEmpleados().stream()
                .collect(Collectors.groupingBy(e-> e.getContrato().getTipoContrato()));
    }

    public static Map<Empresa, Map<TipoContrato, List<Empleado>>> getEmpleadosPorTipoContrato(List<Empresa> empresas) {
        return empresas.stream()
                .collect(Collectors.toMap(Function.identity(), UtilidadesEmpresa::getEmpleadosPorTipoContrato));
    }

    public static List<Empleado> getEmpleadosPymePracticas(List<Empresa> empresas) {
        return  empresas.stream()
                .filter(empresa -> empresa.getTipoEmpresa().equals(TipoEmpresa.PYME))
                .map(Empresa::getEmpleados)
                .flatMap(List::stream).toList()
                .stream()
                .filter(empleado -> empleado.getContrato().getTipoContrato().equals(TipoContrato.PRACTICAS))
                .toList();
    }

    public static Empleado getMejorPagadoDeLaEmpresa(Empresa empresa) {
        return empresa.getEmpleados().stream()
                .max(Comparator.comparingDouble((Empleado e) -> e.getContrato().getSalarioBase())).orElseThrow(NoSuchElementException::new);
    }
    
    public static Map<Empresa, Empleado> getLosMejorPagadosPorEmpresa(List<Empresa> empresas) {
        return empresas.stream()
                .collect(Collectors.toMap(Function.identity(), UtilidadesEmpresa::getMejorPagadoDeLaEmpresa));
    }

}
