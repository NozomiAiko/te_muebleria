<%@page import="java.util.List"%>
<%@page import="com.emergentes.entidades.Venta"%>
<%@page import="com.emergentes.entidades.Cliente"%>
<%@page import="com.emergentes.entidades.Usuario"%>
<%@page import="com.emergentes.entidades.Producto"%>
<%
    List<Venta> ventas = (List<Venta>) request.getAttribute("ventas");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
<<<<<<< HEAD
        <meta charset="UTF-8">
=======
       <meta charset="UTF-8">
>>>>>>> 6de98de038e78f12fc33a55da64efc7007d73909
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>R&B Muebleria - Inicio</title>
        <!-- link iconos -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
        <!-- link font family -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Nunito:ital,wght@0,200;0,400;1,300;1,400&display=swap" rel="stylesheet">
        <!-- link bootstrap -->
<<<<<<< HEAD
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <!-- AOS -->
        <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
        <!-- link para insertar hoja de estilo -->
=======
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <!-- AOS -->
        <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
        <!--link para insertar hoja de estilo-->
>>>>>>> 6de98de038e78f12fc33a55da64efc7007d73909
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <!-- logo en mi titulo -->
        <link rel="shortcut icon" href="assets/images/logotitulo.png">
        <meta name="description" content="Es una empresa que ofrece muebles de madera para el hogar, tiene diseños exclusivos y muebles hechos a medida.">
        <meta name="keywords" content="muebles, madera, diseños, hogar, armarios, roperos, alacenas, estantes, ofertas, chile, inicio">
<<<<<<< HEAD
        <link href="https://cdn.jsdelivr.net/npm/daisyui@4.12.8/dist/full.min.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <div>
            <jsp:include page="WEB-INF/menu_2.jsp"></jsp:include>
            <br >
            <div class="container mx-auto p-4">
                <a href="datos.jsp" role="button" class="btn btn-active btn-ghost"> <  VOLVER A INICIO</a>

                    <h1 class="text-3xl font-bold text-center mb-4">LISTADO DE VENTAS</h1>
                    <a href="VentaServlet?action=add" id="btnAdd" class="btn btn-warning">Nueva Libro</a><br>
                    <div class="overflow-x-auto">
                        <table class="table">
                            <th>CODIGO</th>
                            <th>CLIENTE</th>
                            <th>VENDEDOR</th>
                            <th>TOTAL</th>
                            <th>FECHA DE VENTA</th>
                            <th>PRODUCTO</th>
                            <th colspan="2">OPCIONES</th>
                            </tr>
                        <%
                            for (Venta item : ventas) {
                        %>
                        <tr>
                            <td><%= item.getIdVenta()%></td>
                            <td><%= (item.getIdCliente() != null) ? item.getIdCliente().getNombreCli() : "Sin categoría"%></td>
                            <td><%= (item.getIdUsuario() != null) ? item.getIdUsuario().getNombreUsu() : "Sin categoría"%></td>
                            <td><%= item.getTotal()%></td>
                            <td><%= item.getFechaVenta()%></td>
                            <td><%= (item.getCd1Producto() != null) ? item.getCd1Producto().getNombrePro() : "Sin categoría"%></td>
                            <td><a id="btnEdit" href="VentaServlet?action=edit&id=<%= item.getIdVenta()%>" class="btn btn-info">EDITAR</a></td>
                            <td><a id="btnDelete" href="VentaServlet?action=delete&id=<%= item.getIdVenta()%>" onclick="return confirm('SEGURO QUE DESEA ELIMINAR ESTE REGISTRO?')" class="btn btn-error">ELIMINAR</a></td>
                        </tr>
                        <%
                            }
                        %>
                    </table>
        </div>
    </body>
    <script src="https://cdn.tailwindcss.com"></script>
</html>
=======
  
    </head>
    <body>
       
    <div>
        <jsp:include page="WEB-INF/menu.jsp"></jsp:include>
        <a href="datos.jsp">VOLVER A INICIO</a>
        <center>
        <h1>LISTADO DE VENTAS</h1>
         <a href="VentaServlet?action=add" id="btnAdd"> Nuevo Libro</a><br>
        <table border = "">
            <br>
                <tr id="cabecera">
                    <th>CODIGO</th>
                    <th>CLIENTE</th>
                    <th>VENDEDOR</th>
                    <th>TOTAL</th>
                    <th>FECHA DE VENTA</th>
                    <th>PRODUCTO</th>
                    <th colspan="2">OPCIONES</th>
                </tr>
                <%
               for (Venta item: ventas){
                %>
                    <tr>
                        <td><%= item.getIdVenta()%></td>
                        <td><%= (item.getIdCliente()!= null) ? item.getIdCliente().getNombreCli(): "Sin categoría" %></td>
                        <td><%= (item.getIdUsuario()!= null) ? item.getIdUsuario().getNombreUsu(): "Sin categoría" %></td>
                        <td><%= item.getTotal()%></td>
                        <td><%= item.getFechaVenta()%></td>  
                        <td><%= (item.getCd1Producto()!= null) ? item.getCd1Producto().getNombrePro(): "Sin categoría" %></td>
                        <td><a id="btnEdit" href="VentaServlet?action=edit&id=<%= item.getIdVenta()%>">EDITAR</a></td>
                        <td><a id="btnDelete" href="VentaServlet?action=delete&id=<%= item.getIdVenta()%>" onclick="return(confirm('SEGURO QUE DESEA ELIMINAR ESTE REGISTRO?'))">ELIMINAR</a></td>
                    </tr>
                <%
                    }
                %>
        </table>
        </center>
    </div>
    </body>
</html>

>>>>>>> 6de98de038e78f12fc33a55da64efc7007d73909
