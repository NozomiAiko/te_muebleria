<%@page import="com.emergentes.entidades.Usuario"%>
<%
    Usuario usuario = (Usuario) request.getAttribute("usuario");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FORMULARIO</title>
    </head>
    <body>
        <br><br><br>
        <h1>REGISTRO DE USUARIOS</h1>
        
        <form action="UsuarioServlet" method="post">
            
            <div >
                <input type="hidden" name="idUsuario" value="<%= usuario.getIdUsuario() %>">
            </div>   
            <div  >
                <label  >Nombre del usuario:</label><br><br>
                <input type="text"  value="<%= usuario.getNombreUsu() %>" name="nombre">
            </div>
            <div  >
                <label  >Contraseña:</label><br><br>
                <input type="password"  value="<%= usuario.getContraseña() %>" name="contraseña">
            </div>
            <div  >
                <label  >Direccion de correo:</label><br><br>
                <input type="email"  value="<%= usuario.getCorreo() %>" name="correo">
            </div>
             <div  >
                <label  >Direccion de vivienda:</label><br><br>
                <input type="text"  value="<%= usuario.getDireccion() %>" name="direccion">
            </div>
            <div  >
             
                <label  >Numero de celular:</label><br><br>
                <input type="number"  value="<%= usuario.getTelefonoUsu() %>" name="telefono">
            </div>
            </div><br><br>
            <button type="submit" id="btnSave">GUARDAR</button>
        </form>
        
    </body>
</html>

