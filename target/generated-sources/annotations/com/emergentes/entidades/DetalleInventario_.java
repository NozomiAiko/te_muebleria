package com.emergentes.entidades;

import com.emergentes.entidades.Inventario;
import com.emergentes.entidades.Producto;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2024-06-26T19:25:04")
=======
@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2024-06-26T10:54:33")
>>>>>>> 6de98de038e78f12fc33a55da64efc7007d73909
@StaticMetamodel(DetalleInventario.class)
public class DetalleInventario_ { 

    public static volatile SingularAttribute<DetalleInventario, Integer> idDetalle;
    public static volatile SingularAttribute<DetalleInventario, String> fechaDet;
    public static volatile SingularAttribute<DetalleInventario, Producto> cdProducto;
    public static volatile SingularAttribute<DetalleInventario, Integer> cantidad;
    public static volatile SingularAttribute<DetalleInventario, Inventario> idInventario;

}