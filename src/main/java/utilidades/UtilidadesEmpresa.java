package utilidades;

import modelos.*;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UtilidadesEmpresa {

    public List<Empleado> getEmpleadosPorContrato(Empresa empresa, TipoContrato tipoContrato) {
        return empresa.getEmpleados().stream()
                .filter(e -> e.getContrato().getTipoContrato().equals(tipoContrato))
                .toList();
    }

    public List<Empleado> getMileuristasOrdenadosPorSalario(Empresa empresa) {
        Comparator<Empleado> bySueldoAsc = Comparator.comparingDouble((Empleado e) -> e.getContrato().getSalarioBase());
        return empresa.getEmpleados().stream()
                .filter(e -> e.getContrato().getSalarioBase() >= 1000)
                .sorted(Comparator.comparingDouble((Empleado e) -> e.getContrato().getSalarioBase()))
                .toList();
    }

    public double fondoSalarialEmpresa(Empresa empresa) {
        return empresa.getEmpleados().stream()
                .mapToDouble(e -> e.getContrato().getSalarioBase())
                .sum();
    }

    public Empleado getMejorPagado(List<Empresa> empresas) {
        Comparator<Empleado> bySueldoAsc = (Empleado e1, Empleado e2) -> Double.compare(e1.getContrato().getSalarioBase(), e2.getContrato().getSalarioBase());
        return empresas.stream()
                .map(Empresa::getEmpleados)
                .flatMap(List::stream).toList()
                .stream().max(bySueldoAsc).orElseThrow(NoSuchElementException::new);
    }

    public static Map<TipoContrato, List<Empleado>> getEmpleadosPorTipoContrato(Empresa empresa) {
        return empresa.getEmpleados().stream().collect(Collectors.groupingBy(e-> e.getContrato().getTipoContrato()));
    }

    public Map<Empresa, Map<TipoContrato, List<Empleado>>> getEmpleadosPorTipoContrato(List<Empresa> empresas) {

        Map<Empresa, Map<TipoContrato, List<Empleado>>> empleadosPorTipoContrato = new HashMap<>();
        for (Empresa empresa:empresas) {
            empleadosPorTipoContrato.put(empresa, getEmpleadosPorTipoContrato(empresa));
        }
        Map<Empresa, Map<Empresa, Map<TipoContrato, List<Empleado>>>> map = empresas.stream()
                .collect(Collectors.toMap(Function.identity(), getEmpleadosPorTipoContrato((Empresa) Function.identity())));
        return null;

//        return empleadosPorTipoContrato;

//        return getEmpleadosPorTipoContrato(empresas.stream().map(e -> e))
//        return empresas.stream().collect(Collectors.groupingBy(e -> getEmpleadosPorTipoContrato(e)));

    }

    public List<Empleado> getEmpleadosPymePracticas(List<Empresa> empresas) {
        return  empresas.stream()
                .filter(empresa -> empresa.getTipoEmpresa().equals(TipoEmpresa.PYME))
                .map(Empresa::getEmpleados)
                .flatMap(List::stream).toList()
                .stream()
                .filter(empleado -> empleado.getContrato().getTipoContrato().equals(TipoContrato.PRACTICAS))
                .toList();
    }

    public Map<Empresa, Empleado> getLosMejorPagadosPorEmpresa(List<Empresa> empresas) {
//        return empresas.stream().collect(Collectors.toMap(Function.identity(), UtilidadesEmpresa::getMejorPagado(empresa)));
//        Comparator<Empleado> bySueldoAsc = (Empleado e1, Empleado e2) -> Double.compare(e1.getContrato().getSalarioBase(), e2.getContrato().getSalarioBase());
//        return empresas.stream()
//                .map(Empresa::getEmpleados)
//                .flatMap(List::stream).toList().stream().max(Comparator.comparingDouble((Empleado e) -> e.getContrato().getSalarioBase())).orElseThrow(NoSuchElementException::new);
        return null;
    }

}
