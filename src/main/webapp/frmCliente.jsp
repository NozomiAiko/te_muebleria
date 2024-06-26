<%@page import="com.emergentes.entidades.Cliente"%>
<%
    Cliente cliente = (Cliente) request.getAttribute("cliente");
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
        <h1>REGISTRO DE CLIENTES</h1>
        
        <form action="ClienteServlet" method="post">
            
            <div >
                <input type="hidden" name="idCliente" value="<%= cliente.getIdCliente() %>">
            </div>   
            <div  >
                <label  >Nombre del cliente:</label><br><br>
                <input type="text"  value="<%= cliente.getNombreCli() %>" name="nombre">
            </div>
            <div  >
                <label  >Correo electronico:</label><br><br>
                <input type="email"  value="<%= cliente.getEmail() %>" name="email">
            </div>
            <div  >
                <label  >Direccion de vivienda:</label><br><br>
                <input type="text"  value="<%= cliente.getDireccionCli() %>" name="direccion">
            </div>
            <div  >
                <label  >Numero de celular:</label><br><br>
                <input type="number"  value="<%= cliente.getTelefono() %>" name="telefono">
            </div>
            </div><br><br>
            <button type="submit" id="btnSave">GUARDAR</button>
        </form>
        
    </body>
</html>

