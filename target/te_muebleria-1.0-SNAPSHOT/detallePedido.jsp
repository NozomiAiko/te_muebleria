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
    <link href="https://cdn.jsdelivr.net/npm/daisyui@4.12.8/dist/full.min.css" rel="stylesheet" type="text/css" />
    <body>
        <jsp:include page="WEB-INF/menu_2.jsp"></jsp:include>
        <br>
        <div class="container mx-auto p-4">
            <a href="datos.jsp"role="button" class="btn btn-active btn-ghost"> <  VOLVER A INICIO</a>
            <h1 class="text-3xl font-bold text-center mb-4">DETALLE DE PEDIDO</h1>
            <a href="DetallePedidoServlet?action=add" id="btnAdd" class="btn btn-warning"> Nuevo Registro</a><br>
            <div class="overflow-x-auto">
                <table class="table">
                    <th>CODIGO</th>
                    <th>CODIGO PEDIDO</th>
                    <th>PRODUCTO</th>
                    <th>CANTIDAD</th>
                    <th colspan="2">OPCIONES</th>
                    </tr>
                    <%
                        for (DetallePedido item : detallePedidos) {
                    %>
                    <tr>
                        <td><%= item.getIdDetallePedido()%></td>
                        <td><%= item.getIdPedido().getIdPedido()%></td>
                        <td><%= (item.getCodProducto() != null) ? item.getCodProducto().getNombrePro() : "SIN PRODUCTO"%></td>
                        <td><%= item.getCantidad()%></td>

                        <td><a id="btnEdit" href="DetallePedidoServlet?action=edit&id=<%= item.getIdDetallePedido()%>" class="btn btn-info">EDITAR</a></td>
                        <td><a id="btnDelete" href="DetallePedidoServlet?action=delete&id=<%= item.getIdDetallePedido()%>" onclick="return(confirm('SEGURO QUE DESEA ELIMINAR ESTE REGISTRO?'))" class="btn btn-error">ELIMINAR</a></td>
                    </tr>
                    <%
                        }
                    %>
                </table>
            </div>
        </div>
    </body>
    <script src="https://cdn.tailwindcss.com"></script>
</html>
