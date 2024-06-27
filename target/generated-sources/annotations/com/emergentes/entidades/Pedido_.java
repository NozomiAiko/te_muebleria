package com.emergentes.entidades;

import com.emergentes.entidades.Cliente;
import com.emergentes.entidades.DetallePedido;
import com.emergentes.entidades.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2024-06-26T19:25:04")
@StaticMetamodel(Pedido.class)
public class Pedido_ { 

    public static volatile SingularAttribute<Pedido, String> fecha;
    public static volatile ListAttribute<Pedido, DetallePedido> detallePedidoList;
    public static volatile SingularAttribute<Pedido, Double> total;
    public static volatile SingularAttribute<Pedido, Integer> estado;
    public static volatile SingularAttribute<Pedido, Usuario> codUsuario;
    public static volatile SingularAttribute<Pedido, Integer> idPedido;
    public static volatile SingularAttribute<Pedido, Cliente> codCliente;

}