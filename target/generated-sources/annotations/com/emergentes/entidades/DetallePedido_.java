package com.emergentes.entidades;

import com.emergentes.entidades.Pedido;
import com.emergentes.entidades.Producto;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2024-06-26T19:25:04")
@StaticMetamodel(DetallePedido.class)
public class DetallePedido_ { 

    public static volatile SingularAttribute<DetallePedido, Producto> codProducto;
    public static volatile SingularAttribute<DetallePedido, Integer> cantidad;
    public static volatile SingularAttribute<DetallePedido, Pedido> idPedido;
    public static volatile SingularAttribute<DetallePedido, Integer> idDetallePedido;

}