package utilidades;

import modelos.*;

import java.util.List;

public class UtilidadesProducto {

    public static List<Producto> getPorTipo(List<Producto> productos, TipoProducto tipo) {
        return productos.stream()
                .filter(producto -> producto.getTipoProducto().equals(tipo))
                .toList();
    }

    public static List<Producto> getPorAlmacen(List<Producto> productos, Almacen almacen) {
        return productos.stream()
                .filter(producto -> producto.getAlmacen().equals(almacen))
                .toList();
    }

}
