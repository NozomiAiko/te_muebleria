package com.emergentes.entidades;

import com.emergentes.entidades.Pedido;
import com.emergentes.entidades.Producto;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2024-06-26T19:25:04")
=======
@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2024-06-26T10:54:33")
>>>>>>> 6de98de038e78f12fc33a55da64efc7007d73909
@StaticMetamodel(DetallePedido.class)
public class DetallePedido_ { 

    public static volatile SingularAttribute<DetallePedido, Producto> codProducto;
    public static volatile SingularAttribute<DetallePedido, Integer> cantidad;
    public static volatile SingularAttribute<DetallePedido, Pedido> idPedido;
    public static volatile SingularAttribute<DetallePedido, Integer> idDetallePedido;

}