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
    <link href="https://cdn.jsdelivr.net/npm/daisyui@4.12.8/dist/full.min.css" rel="stylesheet" type="text/css" />
    <body>
        <jsp:include page="WEB-INF/menu_2.jsp"></jsp:include>
            <br>
            <div class="container mx-auto p-4">
                <a href="datos.jsp" role="button" class="btn btn-active btn-ghost"> <  VOLVER A INICIO</a>
                <h1 class="text-3xl font-bold text-center mb-4">DETALLE DE INVENTARIO</h1>
                <a href="DetalleInventarioServlet?action=add" id="btnAdd" class="btn btn-warning"> Nuevo Registro</a><br>
                <div class="overflow-x-auto">
                    <table class="table">
                        <th>CODIGO</th>
                        <th>CODIGO DE INVENTARIO</th>                    
                        <th>CANTIDAD</th>
                        <th>PRODUCTO</th>
                        <th colspan="2">OPCIONES</th>
                        </tr>
                    <%
                        for (DetalleInventario item : detalleInventarios) {
                    %>
                    <tr>
                        <td><%= item.getIdDetalle()%></td>
                        <td><%= item.getIdInventario().getIdInventario()%></td>
                        <td><%= (item.getCdProducto() != null) ? item.getCdProducto().getNombrePro() : "SIN PRODUCTO"%></td>
                        <td><%= item.getCantidad()%></td>
                        <td><%= item.getFechaDet()%></td>

                        <td><a id="btnEdit" href="DetalleInventarioServlet?action=edit&id=<%= item.getIdDetalle()%>" class="btn btn-info">EDITAR</a></td>
                        <td><a id="btnDelete" href="DetalleInventarioServlet?action=delete&id=<%= item.getIdDetalle()%>" onclick="return(confirm('SEGURO QUE DESEA ELIMINAR ESTE REGISTRO?'))" class="btn btn-error">ELIMINAR</a></td>
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

