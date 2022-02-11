package modelos;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Factura {

    private int identificador;
    private String codigoFactura;
    private double importeBase;
    private double descuento;
    private double iva;
    private double totalAPagar;
    private LocalDate fechaVencimiento;
    private boolean pagada;
    private List<LineaFactura> lineaFacturaList;
    private Cliente cliente;

    public Factura() {
    }

    public Factura(Factura f) {
        this.identificador = f.getIdentificador();
        this.codigoFactura = f.getCodigoFactura();
        this.importeBase = f.getImporteBase();
        this.descuento = f.getDescuento();
        this.iva = f.getIva();
        this.totalAPagar = f.getTotalAPagar();
        this.fechaVencimiento = f.getFechaVencimiento();
        this.pagada = f.isPagada();
        this.lineaFacturaList = f.getLineaFacturaList();
        this.cliente = f.getCliente();
    }

    public Factura(int identificador, String codigoFactura, double importeBase, double descuento, double iva, double totalAPagar, LocalDate fechaVencimiento, boolean pagada, List<LineaFactura> lineaFacturaList, Cliente cliente) {
        this.identificador = identificador;
        this.codigoFactura = codigoFactura;
        this.importeBase = importeBase;
        this.descuento = descuento;
        this.iva = iva;
        this.totalAPagar = totalAPagar;
        this.fechaVencimiento = fechaVencimiento;
        this.pagada = pagada;
        this.lineaFacturaList = lineaFacturaList;
        this.cliente = cliente;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getCodigoFactura() {
        return codigoFactura;
    }

    public void setCodigoFactura(String codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public double getImporteBase() {
        return importeBase;
    }

    public void setImporteBase(double importeBase) {
        this.importeBase = importeBase;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotalAPagar() {
        return totalAPagar;
    }

    public void setTotalAPagar(double totalAPagar) {
        this.totalAPagar = totalAPagar;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public boolean isPagada() {
        return pagada;
    }

    public void setPagada(boolean pagada) {
        this.pagada = pagada;
    }

    public List<LineaFactura> getLineaFacturaList() {
        return lineaFacturaList;
    }

    public void setLineaFacturaList(List<LineaFactura> lineaFacturaList) {
        this.lineaFacturaList = lineaFacturaList;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Factura factura = (Factura) o;
        return identificador == factura.identificador && Double.compare(factura.importeBase, importeBase) == 0 && Double.compare(factura.descuento, descuento) == 0 && Double.compare(factura.iva, iva) == 0 && Double.compare(factura.totalAPagar, totalAPagar) == 0 && pagada == factura.pagada && Objects.equals(codigoFactura, factura.codigoFactura) && Objects.equals(fechaVencimiento, factura.fechaVencimiento) && Objects.equals(lineaFacturaList, factura.lineaFacturaList) && Objects.equals(cliente, factura.cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador, codigoFactura, importeBase, descuento, iva, totalAPagar, fechaVencimiento, pagada, lineaFacturaList, cliente);
    }

    @Override
    public String toString() {
        return "Factura{" +
                "identificador=" + identificador +
                ", codigoFactura='" + codigoFactura + '\'' +
                ", importeBase=" + importeBase +
                ", descuento=" + descuento +
                ", iva=" + iva +
                ", totalAPagar=" + totalAPagar +
                ", fechaVencimiento=" + fechaVencimiento +
                ", pagada=" + pagada +
                ", lineaFacturaList=" + lineaFacturaList +
                ", cliente=" + cliente +
                '}';
    }

}