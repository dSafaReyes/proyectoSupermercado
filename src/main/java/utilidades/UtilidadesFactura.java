package utilidades;

import modelos.*;

import java.time.LocalDate;
import java.util.List;

public class UtilidadesFactura {

    public boolean esFacturaVencida(Factura factura) {
        LocalDate fechaVencimiento = factura.getFechaVencimiento();
        LocalDate fechaActual = LocalDate.now();
        return fechaVencimiento.equals(fechaActual) || fechaVencimiento.isAfter(fechaActual);
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
        return (calcularBaseFactura(factura) - factura.getDescuento())*(1 + factura.getIva());
    }

    public Double gasoTotalCliente(List<Factura> facturas, Cliente cliente) {
        return facturas.stream().mapToDouble(UtilidadesFactura::calcularTotalAPagar).sum();
    }

    public static void main(String[] args) {
//        Cliente cliente1 = new Cliente(1, "30278456X", "Marcos", "Ruiz Bellido", "Calle Onza nº 10", TipoCliente.PARTICULAR);
        Factura factura1 = new Factura(1, "001", 110.0, 10.0, 0.21,0.0, LocalDate.of(2023, 2, 11), true, null, null);
        UtilidadesFactura uf = new UtilidadesFactura();
        System.out.println("Fecha de vencimiento: " + factura1.getFechaVencimiento());
        System.out.println("Fecha actual: " + LocalDate.now());
        System.out.println(uf.esFacturaVencida(factura1));
    }
}
