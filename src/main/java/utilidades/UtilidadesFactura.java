package utilidades;

import modelos.*;

import java.time.LocalDate;
import java.util.List;

public class UtilidadesFactura {

    public static boolean esFacturaVencida(Factura factura) {
        LocalDate fechaVencimiento = factura.getFechaVencimiento();
        LocalDate fechaActual = LocalDate.now();
        return fechaVencimiento.equals(fechaActual) || fechaVencimiento.isAfter(fechaActual);
    }

    public static double calcularBaseFactura(Factura factura) {
        return factura.getLineaFacturaList().stream()
                .mapToDouble(lineaFactura -> lineaFactura.getCantidad()*lineaFactura.getProducto().getPrecio())
                .sum();
    }

    public static double calcularTotalAPagar(Factura factura) {
        return (calcularBaseFactura(factura) - factura.getDescuento())*(1 + factura.getIva());
    }

    public static Double gastoTotalCliente(List<Factura> facturas, Cliente cliente) {
        return facturas.stream()
                .filter(factura -> factura.getCliente().equals(cliente))
                .mapToDouble(UtilidadesFactura::calcularTotalAPagar)
                .sum();
    }

}
