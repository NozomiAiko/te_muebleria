package com.emergentes.entidades;

import com.emergentes.entidades.Inventario;
import com.emergentes.entidades.Producto;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2024-06-26T10:54:33")
@StaticMetamodel(DetalleInventario.class)
public class DetalleInventario_ { 

    public static volatile SingularAttribute<DetalleInventario, Integer> idDetalle;
    public static volatile SingularAttribute<DetalleInventario, String> fechaDet;
    public static volatile SingularAttribute<DetalleInventario, Producto> cdProducto;
    public static volatile SingularAttribute<DetalleInventario, Integer> cantidad;
    public static volatile SingularAttribute<DetalleInventario, Inventario> idInventario;

}