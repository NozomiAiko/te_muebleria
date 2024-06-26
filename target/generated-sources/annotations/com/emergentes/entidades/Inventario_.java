package com.emergentes.entidades;

import com.emergentes.entidades.DetalleInventario;
import com.emergentes.entidades.Producto;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2024-06-26T10:54:33")
@StaticMetamodel(Inventario.class)
public class Inventario_ { 

    public static volatile SingularAttribute<Inventario, String> fecha;
    public static volatile ListAttribute<Inventario, DetalleInventario> detalleInventarioList;
    public static volatile SingularAttribute<Inventario, Integer> cantidad;
    public static volatile SingularAttribute<Inventario, Producto> idProducto;
    public static volatile SingularAttribute<Inventario, Integer> idInventario;

}