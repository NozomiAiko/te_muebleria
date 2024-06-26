<%@page import="java.util.List"%>
<%@page import="com.emergentes.entidades.DetalleInventario"%>
<%
    List<DetalleInventario> detalleInventarios = (List<DetalleInventario>) request.getAttribute("detalleInventarios");
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
        <h1>DETALLE DE INVENTARIO</h1>
         <a href="DetalleInventarioServlet?action=add" id="btnAdd"> Nuevo Registro</a><br>
        <table border = "1">
            <br>
                <tr id="cabecera">
                    <th>CODIGO</th>
                    <th>CODIGO DE INVENTARIO</th>                    
                    <th>CANTIDAD</th>
                    <th>PRODUCTO</th>
                    <th colspan="2">OPCIONES</th>
                </tr>
                <%
               for (DetalleInventario item: detalleInventarios){
                %>
                    <tr>
                        <td><%= item.getIdDetalle()%></td>
                        <td><%= item.getIdInventario().getIdInventario() %></td>
                        <td><%= (item.getCdProducto()!= null) ? item.getCdProducto().getNombrePro(): "SIN PRODUCTO" %></td>
                        <td><%= item.getCantidad()%></td>
                        <td><%= item.getFechaDet() %></td>
                        
                         <td><a id="btnEdit" href="DetalleInventarioServlet?action=edit&id=<%= item.getIdDetalle()%>">EDITAR</a></td>
                        <td><a id="btnDelete" href="DetalleInventarioServlet?action=delete&id=<%= item.getIdDetalle()%>" onclick="return(confirm('SEGURO QUE DESEA ELIMINAR ESTE REGISTRO?'))">ELIMINAR</a></td>
                    </tr>
                <%
                    }
                %>
        </table>
    </div>
    </body>
</html>

