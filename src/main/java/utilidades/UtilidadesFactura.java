package utilidades;

import modelos.*;

import java.time.LocalDate;
import java.util.List;

public class UtilidadesFactura {

    // Es vencido debe ser para fechas posteriores a la fecha actual
    public boolean esFacturaVencida(Factura factura) {
        LocalDate fechaVencimiento = factura.getFechaVencimiento();
        LocalDate fechaActual = LocalDate.now();

        if (fechaVencimiento.equals(fechaActual)) {
            return true;
        }
        else if (fechaVencimiento.isAfter(fechaActual)) {
            return true;
        }
        return false;
    }

    public static double calcularBaseFactura(Factura factura) {
        return factura.getLineaFacturaList().stream().mapToDouble(lineaFactura -> lineaFactura.getCantidad()*lineaFactura.getProducto().getPrecio()).sum();
//        List<LineaFactura> lineaFacturaList = factura.getLineaFacturaList();
//        double importeTotal = 0;
//        for (LineaFactura lineaFactura:lineaFacturaList) {
//            Producto producto = lineaFactura.getProducto();
//            importeTotal += lineaFactura.getCantidad() * producto.getPrecio();
//        }
//        return importeTotal;
    }

    public static double calcularTotalAPagar(Factura factura) {
        return (calcularBaseFactura(factura) - factura.getDescuento())*factura.getIva();
    }

    public static void main(String[] args) {
        Cliente cliente1 = new Cliente(1, "30278456X", "Marcos", "Ruiz Bellido", "Calle Onza nº 10", TipoCliente.PARTICULAR);
        Factura factura1 = new Factura(1, "001", 110.0, 10.0, 1.21,0.0, LocalDate.of(2001, 12, 25), true, null, cliente1);
        UtilidadesFactura uf = new UtilidadesFactura();
        System.out.println(uf.esFacturaVencida(factura1));
    }
}
