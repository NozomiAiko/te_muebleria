<%@page import="java.util.List"%>
<%@page import="com.emergentes.entidades.DetallePedido"%>
<%@page import="com.emergentes.entidades.DetallePedido"%>
<%
    List<DetallePedido> detallePedidos = (List<DetallePedido>) request.getAttribute("detallePedidos");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <br><br>
    <div >
       <a href="index.html">VOLVER A INICIO</a>
        <h1>DETALLE DE PEDIDO</h1>
         <a href="DetallePedidoServlet?action=add" id="btnAdd"> Nuevo Registro</a><br>
        <table border = "1">
            <br>
                <tr id="cabecera">
                    <th>CODIGO</th>
                    <th>CODIGO PEDIDO</th>
                    <th>PRODUCTO</th>
                    <th>CANTIDAD</th>
                    <th colspan="2">OPCIONES</th>
                </tr>
                <%
               for (DetallePedido item: detallePedidos){
                %>
                    <tr>
                        <td><%= item.getIdDetallePedido()%></td>
                        <td><%= item.getIdPedido().getIdPedido() %></td>
                        <td><%= (item.getCodProducto()!= null) ? item.getCodProducto().getNombrePro(): "SIN PRODUCTO" %></td>
                        <td><%= item.getCantidad()%></td>
                        
                         <td><a id="btnEdit" href="DetallePedidoServlet?action=edit&id=<%= item.getIdDetallePedido()%>">EDITAR</a></td>
                        <td><a id="btnDelete" href="DetallePedidoServlet?action=delete&id=<%= item.getIdDetallePedido()%>" onclick="return(confirm('SEGURO QUE DESEA ELIMINAR ESTE REGISTRO?'))">ELIMINAR</a></td>
                    </tr>
                <%
                    }
                %>
        </table>
    </div>
    </body>
</html>
