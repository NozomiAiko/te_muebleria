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
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, Integer> telefonoUsu;
    public static volatile ListAttribute<Usuario, Venta> ventaList;
    public static volatile SingularAttribute<Usuario, Integer> idUsuario;
    public static volatile SingularAttribute<Usuario, String> correo;
    public static volatile SingularAttribute<Usuario, String> direccion;
    public static volatile ListAttribute<Usuario, Pedido> pedidoList;
<<<<<<< HEAD
    public static volatile SingularAttribute<Usuario, String> rol;
=======
>>>>>>> 6de98de038e78f12fc33a55da64efc7007d73909
    public static volatile SingularAttribute<Usuario, String> nombreUsu;
    public static volatile SingularAttribute<Usuario, String> contraseña;

}