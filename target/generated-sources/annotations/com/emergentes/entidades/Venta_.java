package com.emergentes.entidades;

import com.emergentes.entidades.Cliente;
import com.emergentes.entidades.Producto;
import com.emergentes.entidades.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2024-06-26T10:54:33")
@StaticMetamodel(Venta.class)
public class Venta_ { 

    public static volatile SingularAttribute<Venta, Producto> cd1Producto;
    public static volatile SingularAttribute<Venta, Double> total;
    public static volatile SingularAttribute<Venta, Cliente> idCliente;
    public static volatile SingularAttribute<Venta, Usuario> idUsuario;
    public static volatile SingularAttribute<Venta, Integer> idVenta;
    public static volatile SingularAttribute<Venta, String> fechaVenta;

}