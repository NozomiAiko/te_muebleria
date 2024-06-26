<%@page import="java.util.List"%>
<%@page import="com.emergentes.entidades.Producto"%>
<%@page import="com.emergentes.entidades.Categoria"%>
<%
    List<Producto> producto = (List<Producto>) request.getAttribute("productos");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>R&B Muebleria - Inicio</title>
        <!-- link iconos -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
        <!-- link font family -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Nunito:ital,wght@0,200;0,400;1,300;1,400&display=swap" rel="stylesheet">
        <!-- link bootstrap -->
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <!-- AOS -->
        <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
        <!--link para insertar hoja de estilo-->
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <!-- logo en mi titulo -->
        <link rel="shortcut icon" href="assets/images/logotitulo.png">
        <meta name="description" content="Es una empresa que ofrece muebles de madera para el hogar, tiene diseños exclusivos y muebles hechos a medida.">
        <meta name="keywords" content="muebles, madera, diseños, hogar, armarios, roperos, alacenas, estantes, ofertas, chile, inicio">
  
    </head>
    <body>
          <jsp:include page="WEB-INF/menu.jsp"></jsp:include>
      
    <div >
        <br>
       <a href="datos.jsp">VOLVER A INICIO</a>
       <center>
        <h1>LISTADO DE PRODUCTOS</h1>
         <a href="ProductoServlet?action=add" id="btnAdd"> Nuevo Libro</a><br>
        <table border = "1">
            <br>
                <tr id="cabecera">
                    <th>CODIGO</th>
                    <th>PRODUCTO</th>
                    <th>DESCRIPCION</th>
                    <th>CATEGORIA</th>
                    <th colspan="2">OPCIONES</th>
                </tr>
                <%
               for (Producto item: producto){
                %>
                    <tr>
                        <td><%= item.getIdProducto()%></td>
                        <td><%= item.getNombrePro()%></td>
                        <td><%= item.getDescripcionPro()%></td>
                        <td><%= (item.getIdCategoria()!= null) ? item.getIdCategoria().getNombreCat(): "Sin categoría" %></td>
                        <td><a id="btnEdit" href="ProductoServlet?action=edit&id=<%= item.getIdProducto()%>">EDITAR</a></td>
                        <td><a id="btnDelete" href="ProductoServlet?action=delete&id=<%= item.getIdProducto()%>" onclick="return(confirm('SEGURO QUE DESEA ELIMINAR ESTE REGISTRO?'))">ELIMINAR</a></td>
                    </tr>
                <%
                    }
                %>
        </table>
        </center>
    </div>
    </body>
</html>
