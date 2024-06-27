package com.emergentes.entidades;

import com.emergentes.entidades.Pedido;
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
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, Integer> idCliente;
    public static volatile SingularAttribute<Cliente, String> nombreCli;
    public static volatile ListAttribute<Cliente, Venta> ventaList;
    public static volatile ListAttribute<Cliente, Pedido> pedidoList;
    public static volatile SingularAttribute<Cliente, Integer> telefono;
    public static volatile SingularAttribute<Cliente, String> email;
    public static volatile SingularAttribute<Cliente, String> direccionCli;

}