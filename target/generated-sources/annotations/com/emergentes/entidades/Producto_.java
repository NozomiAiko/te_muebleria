package com.emergentes.entidades;

import com.emergentes.entidades.Categoria;
import com.emergentes.entidades.DetalleInventario;
import com.emergentes.entidades.DetallePedido;
import com.emergentes.entidades.Inventario;
import com.emergentes.entidades.Venta;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2024-06-26T19:25:04")
=======
@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2024-06-26T10:54:33")
>>>>>>> 6de98de038e78f12fc33a55da64efc7007d73909
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, String> descripcionPro;
    public static volatile ListAttribute<Producto, DetallePedido> detallePedidoList;
    public static volatile ListAttribute<Producto, DetalleInventario> detalleInventarioList;
    public static volatile SingularAttribute<Producto, Double> precioUnitario;
    public static volatile SingularAttribute<Producto, String> nombrePro;
    public static volatile ListAttribute<Producto, Venta> ventaList;
    public static volatile ListAttribute<Producto, Inventario> inventarioList;
    public static volatile SingularAttribute<Producto, Integer> idProducto;
    public static volatile SingularAttribute<Producto, Categoria> idCategoria;

}