<%@page import="java.util.List"%>
<%@page import="com.emergentes.entidades.Usuario"%>
<%
    List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
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
<<<<<<< HEAD
        <link href="https://cdn.jsdelivr.net/npm/daisyui@4.12.8/dist/full.min.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <jsp:include page="WEB-INF/menu_2.jsp"></jsp:include>
            <br>
            <div class="container mx-auto p-4" >
                <a href="datos.jsp" role="button" class="btn btn-active btn-ghost"> <  VOLVER A INICIO</a>
   
                    <h1 class="text-3xl font-bold text-center mb-4">LISTADO DE USUARIOS</h1>
                    <a href="UsuarioServlet?action=add" id="btnAdd" class="btn btn-warning"> Nueva Usuario</a><br>
                    <div class="overflow-x-auto">
                        <table class="table">
                            <th>ID</th>
                            <th>NOMBRE</th>
                            <th>CONTRASEÑA</th>
                            <th>CORREO ELECTRONICO</th>
                            <th>DIRECCION</th>
                            <th>TELEFONO</th>
                            <th>ROL</th>
                            <th colspan="2">OPCIONES</th>
                            </tr>
                        <%
                            for (Usuario item : usuarios) {
                        %>
                        <tr>
                            <td><%= item.getIdUsuario()%></td>
                            <td><%= item.getNombreUsu()%></td>
                            <td><%= item.getContraseña()%></td>
                            <td><%= item.getCorreo()%></td>
                            <td><%= item.getDireccion()%></td>
                            <td><%= item.getTelefonoUsu()%></td>
                            <td> <%= item.getRol()%> </td>
                            <td><a id="btnEdit" href="UsuarioServlet?action=edit&id=<%= item.getIdUsuario()%>" class="btn btn-info" >EDITAR</a></td>
                            <td><a id="btnDelete" href="UsuarioServlet?action=delete&id=<%= item.getIdUsuario()%>" onclick="return(confirm('SEGURO QUE DESEA ELIMINAR ESTE REGISTRO?'))" class="btn btn-error">ELIMINAR</a></td>
                        </tr>
                        <%
                            }
                        %>
                    </table>
        </div>
    </body>
    <script src="https://cdn.tailwindcss.com"></script>
=======
  
    </head>
    <body>
        <jsp:include page="WEB-INF/menu.jsp"></jsp:include>
        <br>
        <div >
            <a href="datos.jsp">VOLVER A INICIO</a>
            <center>
            <h1>LISTADO DE USUARIOS</h1>
            <a href="UsuarioServlet?action=add" id="btnAdd"> Nueva Usuario</a><br>
            <table border = "1">
                <tr id="cabecera">
                    <th>ID</th>
                    <th>NOMBRE</th>
                    <th>CONTRASEÑA</th>
                    <th>CORREO ELECTRONICO</th>
                    <th>DIRECCION</th>
                    <th>TELEFONO</th>
                    <th colspan="2">OPCIONES</th>
                </tr>
                <%
               for (Usuario item: usuarios){
                %>
                <tr>
                    <td><%= item.getIdUsuario()%></td>
                    <td><%= item.getNombreUsu()%></td>
                    <td><%= item.getContraseña()%></td>
                    <td><%= item.getCorreo()%></td>
                    <td><%= item.getDireccion()%></td>
                    <td><%= item.getTelefonoUsu() %></td>
                    <td><a id="btnEdit" href="UsuarioServlet?action=edit&id=<%= item.getIdUsuario()%>">EDITAR</a></td>
                    <td><a id="btnDelete" href="UsuarioServlet?action=delete&id=<%= item.getIdUsuario()%>" onclick="return(confirm('SEGURO QUE DESEA ELIMINAR ESTE REGISTRO?'))">ELIMINAR</a></td>
                </tr>
                <%
                    }
                %>
            </table>
            </center>
        </div>
    </body>
>>>>>>> 6de98de038e78f12fc33a55da64efc7007d73909
</html>
