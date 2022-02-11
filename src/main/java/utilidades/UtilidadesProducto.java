package utilidades;

import modelos.Almacen;
import modelos.Producto;
import modelos.TipoProducto;

import java.util.ArrayList;
import java.util.List;

public class UtilidadesProducto {

    public List<Producto> getPorTipo(List<Producto> productos, TipoProducto tipo) {
        return productos.stream().filter(producto -> producto.getTipoProducto().equals(tipo)).toList();
    }

    public List<Producto> getPorAlmacen(List<Producto> productos, Almacen almacen) {
        return productos.stream().filter(producto -> producto.getAlmacen().equals(almacen)).toList();
    }

}
